package de.rwth_aachen.dc.mvd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.ModelMetaData;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.ifcopenshell.IfcOpenShellEngine;
import org.ifcopenshell.IfcOpenShellModel;
import org.opensource_bimserver.bcf.Bcf;
import org.opensource_bimserver.bcf.BcfException;
import org.opensource_bimserver.bcf.Issue;

import de.rwth_aachen.dc.OperatingSystemCopyOf_IfcGeomServer;
import de.rwth_aachen.dc.mvd.bcf.TempGeometry;
import de.rwth_aachen.dc.mvd.beans.ElementCheckResultBean;
import de.rwth_aachen.dc.mvd.beans.IssueBean;
import de.rwth_aachen.dc.mvd.events.CheckerErrorEvent;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;
import generated.buildingsmart.bcf.markup.Comment;
import generated.buildingsmart.bcf.markup.Header;
import generated.buildingsmart.bcf.markup.Markup;
import generated.buildingsmart.bcf.markup.Topic;
import generated.buildingsmart.bcf.markup.ViewPoint;
import generated.buildingsmart.bcf.visinfo.Component;
import generated.buildingsmart.bcf.visinfo.ComponentSelection;
import generated.buildingsmart.bcf.visinfo.ComponentVisibility;
import generated.buildingsmart.bcf.visinfo.Components;
import generated.buildingsmart.bcf.visinfo.Direction;
import generated.buildingsmart.bcf.visinfo.PerspectiveCamera;
import generated.buildingsmart.bcf.visinfo.Point;
import generated.buildingsmart.bcf.visinfo.VisualizationInfo;

public class IssueReport {
    private EventBusCommunication communication = EventBusCommunication.getInstance();
    private final String ifcProjectGuid;
    private final String ifcHeaderFilename;
    private final Date ifcHeaderTimeStamp;

    private final IfcOpenShellModel renderEngineModel;

    private final List<ElementCheckResultBean> element_check_results = new ArrayList<>();
    private final List<IssueBean> issues = new ArrayList<>();
    private final List<String> general_comments = new ArrayList<>();
    private final Bcf bcf = new Bcf();

    public IssueReport(IfcModelInterface ifcModel, File ifcFile) throws DeserializeException, IOException, RenderEngineException {
	this.renderEngineModel = getRenderEngineModel(ifcFile);
	ModelMetaData mmd = ifcModel.getModelMetaData();
	IfcHeader ifcHeader = mmd.getIfcHeader();
	ifcHeaderFilename = ifcFile.getName();
	ifcHeaderTimeStamp = ifcHeader.getTimeStamp();

	if (ifcHeader.getIfcSchemaVersion().equals("IFC2X3")) {
	    List<org.bimserver.models.ifc2x3tc1.IfcProject> projects2x3 = ifcModel.getAll(org.bimserver.models.ifc2x3tc1.IfcProject.class);
	    if (projects2x3.size() != 1) {
		ifcProjectGuid = null;
		throw new RuntimeException("The IFC2x3 model should have one IfcProject");
	    } else {
		ifcProjectGuid = projects2x3.get(0).getGlobalId();
		this.bcf.setProject_guid(ifcProjectGuid);
		return;
	    }
	} else if (ifcHeader.getIfcSchemaVersion().equals("IFC4")) {
	    List<org.bimserver.models.ifc4.IfcProject> projects4 = ifcModel.getAll(org.bimserver.models.ifc4.IfcProject.class);
	    if (projects4.size() != 1) {
		ifcProjectGuid = null;
		throw new RuntimeException("The IFC4 model should have one IfcProject");
	    } else {
		ifcProjectGuid = projects4.get(0).getGlobalId();
		this.bcf.setProject_guid(ifcProjectGuid);
	    }

	} else {
	    ifcProjectGuid = null;
	    throw new RuntimeException("Not a supported IFC version");
	}
    }
    
    Set<String> general_comments_set =new HashSet<>();

    public void addGeneralComment(String comment)
    {
	if(general_comments_set.add(comment))
	   this.general_comments.add(comment);
    }
    public void addPassedElementResult(String mvdXMLConcept,String ifcSpatialStructureElement, org.bimserver.models.ifc2x3tc1.IfcRoot ifcRoot) {
	if(general_comments_set.add(ifcRoot.getGlobalId()))
	  element_check_results.add(new ElementCheckResultBean(mvdXMLConcept,ifcSpatialStructureElement, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), true));
    }
    
    public void addPassedElementResult(String mvdXMLConcept,String ifcSpatialStructureElement, org.bimserver.models.ifc4.IfcRoot ifcRoot) {
	if(general_comments_set.add(ifcRoot.getGlobalId()))
	  element_check_results.add(new ElementCheckResultBean(mvdXMLConcept,ifcSpatialStructureElement, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), true));
    }
    
    public void addIssue(String mvdXMLConcept,String ifcSpatialStructureElement, org.bimserver.models.ifc2x3tc1.IfcRoot ifcRoot, String comment) {
	issues.add(new IssueBean(mvdXMLConcept,ifcSpatialStructureElement, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), comment));
	if(general_comments_set.add(ifcRoot.getGlobalId()))
		  element_check_results.add(new ElementCheckResultBean(mvdXMLConcept,ifcSpatialStructureElement, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), false));
    
        UUID markup_uuid = UUID.randomUUID();
        VisualizationInfo visInfo = null;
        if (ifcRoot instanceof org.bimserver.models.ifc2x3tc1.IfcProduct) {
            visInfo = addVisInfo(ifcRoot.getExpressId(), ifcRoot.getGlobalId());
        }
        UUID viewpoint_uuid = UUID.randomUUID();
        ViewPoint vp = new ViewPoint();
        vp.setGuid(viewpoint_uuid.toString());
        if (visInfo != null) {
            vp.setViewpoint("viewpoint.bcfv");
            vp.setSnapshot("snapshot.png");
            
 	    if(visInfo.getOrthogonalCamera()==null && visInfo.getPerspectiveCamera()==null)
 	 	comment+=" Element does not have a geometry.";

        }

        Markup markup = addMarkup(ifcSpatialStructureElement, ifcRoot.getGlobalId(), comment, markup_uuid.toString(),vp);
        markup.getViewpoints().add(vp);
    
        Issue issue = new Issue(markup_uuid, markup, visInfo);
    
        if (ifcRoot instanceof org.bimserver.models.ifc2x3tc1.IfcProduct) 
            issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
        else if (ifcRoot instanceof org.bimserver.models.ifc4.IfcProduct) 
            issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
        else
            issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
        bcf.addIssue(issue);
    }

    public void addIssue(org.bimserver.models.ifc2x3tc1.IfcRoot ifcRoot, String comment) {
	issues.add(new IssueBean(ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), comment));
	if(general_comments_set.add(ifcRoot.getGlobalId()))
		  element_check_results.add(new ElementCheckResultBean(null, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), false));

    
        UUID markup_uuid = UUID.randomUUID();
        VisualizationInfo visInfo = null;
        if (ifcRoot instanceof org.bimserver.models.ifc2x3tc1.IfcProduct) {
            visInfo = addVisInfo(ifcRoot.getExpressId(), ifcRoot.getGlobalId());
        }
        UUID viewpoint_uuid = UUID.randomUUID();
        ViewPoint vp = new ViewPoint();
        vp.setGuid(viewpoint_uuid.toString());
        if (visInfo != null) {
            vp.setViewpoint("viewpoint.bcfv");
            vp.setSnapshot("snapshot.png");
            
 	    if(visInfo.getOrthogonalCamera()==null && visInfo.getPerspectiveCamera()==null)
 	 	comment+=" Element does not have a geometry.";

        }

        Markup markup = addMarkup(null, ifcRoot.getGlobalId(), comment, markup_uuid.toString(),vp);
        markup.getViewpoints().add(vp);
    
        Issue issue = new Issue(markup_uuid, markup, visInfo);
    
        if (ifcRoot instanceof org.bimserver.models.ifc2x3tc1.IfcProduct) 
            issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
        else if (ifcRoot instanceof org.bimserver.models.ifc4.IfcProduct) 
            issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
        else
            issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
        bcf.addIssue(issue);
    }
   

    public void addIssue(String mvdXMLConcept,String ifcSpatialStructureElement, org.bimserver.models.ifc4.IfcRoot ifcRoot, String comment) {
	issues.add(new IssueBean(mvdXMLConcept,ifcSpatialStructureElement, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), comment));
	if(general_comments_set.add(ifcRoot.getGlobalId()))
		  element_check_results.add(new ElementCheckResultBean(mvdXMLConcept,ifcSpatialStructureElement, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), false));

	UUID markup_uuid = UUID.randomUUID();
	VisualizationInfo visInfo = null;
	if (ifcRoot instanceof org.bimserver.models.ifc4.IfcProduct) {
	    visInfo = addVisInfo(ifcRoot.getExpressId(), ifcRoot.getGlobalId());
	}
	UUID viewpoint_uuid = UUID.randomUUID();
	ViewPoint vp = new ViewPoint();
	vp.setGuid(viewpoint_uuid.toString());
	if (visInfo != null) {
	    vp.setViewpoint("viewpoint.bcfv");
	    vp.setSnapshot("snapshot.png");
	    
 	    if(visInfo.getOrthogonalCamera()==null && visInfo.getPerspectiveCamera()==null)
 	 	comment+=" Element does not have a geometry.";
	}

	Markup markup = addMarkup(ifcSpatialStructureElement, ifcRoot.getGlobalId(), comment, markup_uuid.toString(),vp);
	markup.getViewpoints().add(vp);

	Issue issue = new Issue(markup_uuid, markup, visInfo);
	 if (ifcRoot instanceof org.bimserver.models.ifc2x3tc1.IfcProduct) 
	            issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
	 else if (ifcRoot instanceof org.bimserver.models.ifc4.IfcProduct) 
	            issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
	 else
	     issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
	//System.out.println("Add Issue into BCD!!");
	bcf.addIssue(issue);
    }

    
    public void addIssue(org.bimserver.models.ifc4.IfcRoot ifcRoot, String comment) {
	issues.add(new IssueBean(ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), comment));
	if(general_comments_set.add(ifcRoot.getGlobalId()))
		  element_check_results.add(new ElementCheckResultBean(null, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), false));

 	UUID markup_uuid = UUID.randomUUID();
 	VisualizationInfo visInfo = null;
 	if (ifcRoot instanceof org.bimserver.models.ifc4.IfcProduct) {
 	    visInfo = addVisInfo(ifcRoot.getExpressId(), ifcRoot.getGlobalId());
 	}
 	UUID viewpoint_uuid = UUID.randomUUID();
 	ViewPoint vp = new ViewPoint();
 	vp.setGuid(viewpoint_uuid.toString());
 	if (visInfo != null) {
 	    vp.setViewpoint("viewpoint.bcfv");
 	    vp.setSnapshot("snapshot.png");
 	    
 	    if(visInfo.getOrthogonalCamera()==null && visInfo.getPerspectiveCamera()==null)
 	 	comment+=" Element does not have a geometry.";
 	}
 	Markup markup = addMarkup(null, ifcRoot.getGlobalId(), comment, markup_uuid.toString(),vp);
 	markup.getViewpoints().add(vp);

 	Issue issue = new Issue(markup_uuid, markup, visInfo);
 	 if (ifcRoot instanceof org.bimserver.models.ifc2x3tc1.IfcProduct) 
 	            issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
 	 else if (ifcRoot instanceof org.bimserver.models.ifc4.IfcProduct) 
 	            issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
 	 else
 	     issue.addRendering(this.renderEngineModel, ifcRoot.getGlobalId());
 	bcf.addIssue(issue);
     }

    
    public void addIssue(String comment) {
	issues.add(new IssueBean("",null, "General", "", "", comment));

 	UUID markup_uuid = UUID.randomUUID();
 	Markup markup = addMarkup(comment, markup_uuid.toString());

 	Issue issue = new Issue(markup_uuid, markup, null);
 	bcf.addIssue(issue);
     }

    private Markup addMarkup(String ifcSpatialStructureElement, String ifc_guid, String comment, String topicGuid,ViewPoint vp) {
	Markup markup = new Markup();
	Header header = new Header();
	Header.File headerFile = new Header.File();
	headerFile.setIfcProject(ifcProjectGuid);
	if(ifcSpatialStructureElement!=null)
	  headerFile.setIfcSpatialStructureElement(ifcSpatialStructureElement);
	headerFile.setFilename(this.ifcHeaderFilename);
	GregorianCalendar gregorianCalender = new GregorianCalendar();
	gregorianCalender.setTime(this.ifcHeaderTimeStamp);
	try {
	    headerFile.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalender));
	} catch (DatatypeConfigurationException e1) {
	    communication.post(new CheckerErrorEvent(this.getClass().getName(),e1.getMessage()));
	    e1.printStackTrace();
	}
	header.getFile().add(headerFile);
	markup.setHeader(header);

	Topic topic = new Topic();
	topic.setGuid(topicGuid);
	topic.setTitle("Issue regarding: " + ifc_guid);
	topic.setCreationAuthor("RWTH");
	try {
	    topic.setCreationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalender));
	} catch (DatatypeConfigurationException e1) {
	    communication.post(new CheckerErrorEvent(this.getClass().getName(),e1.getMessage()));
	    e1.printStackTrace();
	}
	topic.setDescription(comment);
	markup.setTopic(topic);

	Comment comments = new Comment();
	try {
	    comments.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
	} catch (DatatypeConfigurationException e1) {
	    communication.post(new CheckerErrorEvent(this.getClass().getName(),e1.getMessage()));
	    e1.printStackTrace();
	}
	if(vp!=null)
	{
	    Comment.Viewpoint cv=new Comment.Viewpoint();
	    cv.setGuid(vp.getGuid());
	    comments.setViewpoint(cv);
	}

	String commentGuid = UUID.randomUUID().toString();
	comments.setGuid(commentGuid);
	String commentAuthor = System.getProperty("user.name");
	comments.setAuthor(commentAuthor);
	comments.setComment(comment);

	markup.getComment().add(comments);
	return markup;
    }

    
    private Markup addMarkup(String comment, String topicGuid) {
	Markup markup = new Markup();
	Header header = new Header();
	Header.File headerFile = new Header.File();
	headerFile.setIfcProject(ifcProjectGuid);
	headerFile.setFilename(this.ifcHeaderFilename);
	GregorianCalendar gregorianCalender = new GregorianCalendar();
	gregorianCalender.setTime(this.ifcHeaderTimeStamp);
	try {
	    headerFile.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalender));
	} catch (DatatypeConfigurationException e1) {
	    communication.post(new CheckerErrorEvent(this.getClass().getName(),e1.getMessage()));
	    e1.printStackTrace();
	}
	header.getFile().add(headerFile);
	markup.setHeader(header);

	Topic topic = new Topic();
	topic.setGuid(topicGuid);
	topic.setTitle("Seneral issue");
	topic.setCreationAuthor("RWTH");
	try {
	    topic.setCreationDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalender));
	} catch (DatatypeConfigurationException e1) {
	    communication.post(new CheckerErrorEvent(this.getClass().getName(),e1.getMessage()));
	    e1.printStackTrace();
	}
	topic.setDescription(comment);
	markup.setTopic(topic);

	Comment comments = new Comment();
	try {
	    comments.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
	} catch (DatatypeConfigurationException e1) {
	    communication.post(new CheckerErrorEvent(this.getClass().getName(),e1.getMessage()));
	    e1.printStackTrace();
	}
	String commentGuid = UUID.randomUUID().toString();
	comments.setGuid(commentGuid);
	String commentAuthor = System.getProperty("user.name");
	comments.setAuthor(commentAuthor);
	comments.setComment(comment);

	markup.getComment().add(comments);
	return markup;
    }
    public void writeReport(String output) {

	FileOutputStream outputStream;
	try {
	    outputStream = new FileOutputStream(output);
	    bcf.write(outputStream);
	} catch (BcfException | IOException e) {
	    communication.post(new CheckerErrorEvent(this.getClass().getName(),e.getMessage()));
	    e.printStackTrace();
	}
    }

    private VisualizationInfo addVisInfo(long ifcProductExpressId, String ifc_guid) {
	VisualizationInfo visualizationInfo = new VisualizationInfo();

	TempGeometry geometry = new TempGeometry(renderEngineModel, ifcProductExpressId);
	
	Component component1 = new Component();
	component1.setIfcGuid(ifc_guid);
	Components components = new Components();
	visualizationInfo.setComponents(components);

	
	ComponentSelection cs=new ComponentSelection();
	cs.getComponent().add(component1);	    
	components.setSelection(cs);
	ComponentVisibility cv=new ComponentVisibility();
	cv.setDefaultVisibility(true);
	components.setVisibility(cv);
	if (geometry.getBoundingBox() == null)
	    return visualizationInfo;
	
	Direction cameraDirection = new Direction();
	cameraDirection.setX(geometry.getCameraDirectionX());
	cameraDirection.setY(geometry.getCameraDirectionY());
	cameraDirection.setZ(geometry.getCameraDirectionZ());

	Direction cameraUpVector = new Direction();
	cameraUpVector.setX(geometry.getCameraUpVectorX());
	cameraUpVector.setY(geometry.getCameraUpVectorY());
	cameraUpVector.setZ(geometry.getCameraUpVectorZ());

	Point cameraViewPoint = new Point();
	cameraViewPoint.setX(geometry.getCameraViewPointX());
	cameraViewPoint.setY(geometry.getCameraViewPointY());
	cameraViewPoint.setZ(geometry.getCameraViewPointZ());

	PerspectiveCamera perspectiveCamera = new PerspectiveCamera();
	perspectiveCamera.setFieldOfView(45.0);
	perspectiveCamera.setCameraUpVector(cameraUpVector);
	perspectiveCamera.setCameraViewPoint(cameraViewPoint);
	perspectiveCamera.setCameraDirection(cameraDirection);

	visualizationInfo.setPerspectiveCamera(perspectiveCamera);
	// visualizationInfo.setLines(new VisualizationInfo.Lines());
	// visualizationInfo.setClippingPlanes(new VisualizationInfo.ClippingPlanes());

	return visualizationInfo;
    }

    private IfcOpenShellModel getRenderEngineModel(File ifcFile) throws RenderEngineException, IOException {
	String ifcGeomServerLocation = OperatingSystemCopyOf_IfcGeomServer.getIfcGeomServer();
	Path ifcGeomServerLocationPath = Paths.get(ifcGeomServerLocation);
	IfcOpenShellEngine ifcOpenShellEngine = new IfcOpenShellEngine(ifcGeomServerLocationPath, false, false);
	ifcOpenShellEngine.init();
	
	FileInputStream ifcFileInputStream = new FileInputStream(ifcFile);

	IfcOpenShellModel model = ifcOpenShellEngine.openModel(ifcFileInputStream);
	//System.out.println("IfcOpenShell opens ifc: " + ifcFile.getAbsolutePath());
// newer IFCOpenshell
//	RenderEngineSettings settings = new RenderEngineSettings();
//	settings.setPrecision(Precision.SINGLE);
//	settings.setIndexFormat(IndexFormat.AUTO_DETECT);
//	settings.setGenerateNormals(false);
//	settings.setGenerateTriangles(true);
//	settings.setGenerateWireFrame(false);
//	model.setSettings(settings);
	model.generateGeneralGeometry();
	//System.out.println("RenderEngineModel " + model);
	return model;
    }

    // Getters
    public String getIfcProjectGuid() {
	return ifcProjectGuid;
    }

    public String getIfcHeaderFilename() {
	return ifcHeaderFilename;
    }

    public Date getIfcHeaderTimeStamp() {
	return ifcHeaderTimeStamp;
    }

    public List<ElementCheckResultBean> getElementCheckResults() {
	return element_check_results;
    }
    
    public List<IssueBean> getIssues() {
	return issues;
    }
    
    public List<String> getGeneral_comments() {
        return general_comments;
    }
    
    

}