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
import java.util.List;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.ModelMetaData;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.renderengine.IndexFormat;
import org.bimserver.plugins.renderengine.Precision;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEngineModel;
import org.bimserver.plugins.renderengine.RenderEngineSettings;
import org.ifcopenshell.IfcOpenShellEngine;
import org.opensource_bimserver.bcf.Bcf;
import org.opensource_bimserver.bcf.BcfException;
import org.opensource_bimserver.bcf.Issue;
import org.opensource_bimserver.bcf.markup.Comment;
import org.opensource_bimserver.bcf.markup.CommentStatus;
import org.opensource_bimserver.bcf.markup.Header;
import org.opensource_bimserver.bcf.markup.Markup;
import org.opensource_bimserver.bcf.markup.Topic;
import org.opensource_bimserver.bcf.visinfo.Component;
import org.opensource_bimserver.bcf.visinfo.Direction;
import org.opensource_bimserver.bcf.visinfo.PerspectiveCamera;
import org.opensource_bimserver.bcf.visinfo.Point;
import org.opensource_bimserver.bcf.visinfo.VisualizationInfo;

import de.rwth_aachen.dc.OperatingSystemCopyOf_IfcGeomServer;
import de.rwth_aachen.dc.mvd.bcf.TempGeometry;
import de.rwth_aachen.dc.mvd.beans.IssueBean;

public class IssueReport {
    private final String ifcProjectGuid;
    private final String ifcHeaderFilename;
    private final Date ifcHeaderTimeStamp;

    private final RenderEngineModel renderEngineModel;

    private final List<IssueBean> issues = new ArrayList<>();
    private final Bcf bcf = new Bcf();

    public IssueReport(IfcModelInterface ifcModel, File ifcFile) throws DeserializeException, IOException, RenderEngineException {
	this.renderEngineModel = getRenderEngineModel(ifcFile);
	ModelMetaData mmd = ifcModel.getModelMetaData();
	IfcHeader ifcHeader = mmd.getIfcHeader();
	System.out.println("ifcHeader schema: " + ifcHeader.getIfcSchemaVersion());
	ifcHeaderFilename = ifcHeader.getFilename();
	ifcHeaderTimeStamp = ifcHeader.getTimeStamp();

	if (ifcHeader.getIfcSchemaVersion().equals("IFC2X3")) {
	    System.out.println("IFC2X3");
	    List<org.bimserver.models.ifc2x3tc1.IfcProject> projects2x3 = ifcModel.getAll(org.bimserver.models.ifc2x3tc1.IfcProject.class);
	    if (projects2x3.size() != 1) {
		ifcProjectGuid = null;
		throw new RuntimeException("The IFC2x3 model should have one IfcProject");
	    } else {
		ifcProjectGuid = projects2x3.get(0).getGlobalId();
		return;
	    }
	} else if (ifcHeader.getIfcSchemaVersion().equals("IFC4")) {
	    System.out.println("IFC4");
	    List<org.bimserver.models.ifc4.IfcProject> projects4 = ifcModel.getAll(org.bimserver.models.ifc4.IfcProject.class);
	    if (projects4.size() != 1) {
		ifcProjectGuid = null;
		throw new RuntimeException("The IFC4 model should have one IfcProject");
	    } else {
		ifcProjectGuid = projects4.get(0).getGlobalId();
	    }

	} else {
	    ifcProjectGuid = null;
	    throw new RuntimeException("Not a supported IFC version");
	}
	
    }

    public void addIssue(String ifcSpatialStructureElement, org.bimserver.models.ifc2x3tc1.IfcRoot ifcRoot, String comment) {
	issues.add(new IssueBean(ifcSpatialStructureElement, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), comment));

	UUID uuid = UUID.randomUUID();
	Markup markup = addMarkup(ifcSpatialStructureElement, ifcRoot.getGlobalId(), comment, uuid.toString());
	VisualizationInfo visInfo = null;
	if (ifcRoot instanceof org.bimserver.models.ifc2x3tc1.IfcProduct) {
	    visInfo = addVisInfo(ifcRoot.getExpressId(), ifcRoot.getGlobalId());
	}
	Issue issue = new Issue(uuid, markup, visInfo);
	bcf.addIssue(issue);

    }

    public void addIssue(String ifcSpatialStructureElement, org.bimserver.models.ifc4.IfcRoot ifcRoot, String comment) {
	issues.add(new IssueBean(ifcSpatialStructureElement, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), comment));

	UUID uuid = UUID.randomUUID();
	Markup markup = addMarkup(ifcSpatialStructureElement, ifcRoot.getGlobalId(), comment, uuid.toString());
	VisualizationInfo visInfo = null;
	if (ifcRoot instanceof org.bimserver.models.ifc4.IfcProduct) {
	    visInfo = addVisInfo(ifcRoot.getExpressId(), ifcRoot.getGlobalId());
	}
	Issue issue = new Issue(uuid, markup, visInfo);
	bcf.addIssue(issue);
    }

    // For generic comments... for the user interface.
    public void addIssue(String elementClass, String comment) {
	issues.add(new IssueBean(null, elementClass, "", "", comment));

    }

    private Markup addMarkup(String ifcSpatialStructureElement, String ifc_guid, String comment, String topicGuid) {
	Markup markup = new Markup();
	Header header = new Header();
	Header.File headerFile = new Header.File();
	headerFile.setIfcProject(ifcProjectGuid);
	headerFile.setIfcSpatialStructureElement(ifcSpatialStructureElement);
	headerFile.setFilename(this.ifcHeaderFilename);
	GregorianCalendar gregorianCalender = new GregorianCalendar();
	gregorianCalender.setTime(this.ifcHeaderTimeStamp);
	try {
	    headerFile.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalender));
	} catch (DatatypeConfigurationException e1) {
	    e1.printStackTrace();
	}
	header.getFile().add(headerFile);
	markup.setHeader(header);

	Topic topic = new Topic();
	topic.setGuid(topicGuid);
	topic.setReferenceLink("None Available"); // e.g. URL to external mvdXML
						  // file
	topic.setTitle("Issue regarding: " + ifc_guid);
	markup.setTopic(topic);

	Comment comments = new Comment();
	try {
	    comments.setDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
	} catch (DatatypeConfigurationException e1) {
	    e1.printStackTrace();
	}
	String commentGuid = UUID.randomUUID().toString();
	comments.setGuid(commentGuid);
	comments.setVerbalStatus("Open");
	comments.setStatus(CommentStatus.ERROR);
	String commentAuthor = System.getProperty("user.name");
	comments.setAuthor(commentAuthor);
	comments.setComment(comment);
	Comment.Topic commentTopic = new Comment.Topic();
	commentTopic.setGuid(topicGuid);
	comments.setTopic(commentTopic);
	markup.getComment().add(comments);
	return markup;
    }

    public void writeReport(String output) {

	FileOutputStream outputStream;
	try {
	    outputStream = new FileOutputStream(output);
	    bcf.write(outputStream);
	} catch (BcfException | IOException e) {
	    e.printStackTrace();
	}
	new File("TempGeometry.txt").delete();
    }

    private VisualizationInfo addVisInfo(long ifcProductExpressId, String ifc_guid) {
	VisualizationInfo visualizationInfo = new VisualizationInfo();
	
	TempGeometry geometry = new TempGeometry(renderEngineModel, ifcProductExpressId);
	if(geometry.getBoundingBox()==null)
	    return null;

	Component component1 = new Component();
	component1.setIfcGuid(ifc_guid);
	component1.setOriginatingSystem("BCFReportWriter");
	component1.setAuthoringToolId("BCFReportWriter");

	VisualizationInfo.Components components = new VisualizationInfo.Components();
	visualizationInfo.setComponents(components);
	components.getComponent().add(component1);

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
	visualizationInfo.setLines(new VisualizationInfo.Lines());
	visualizationInfo.setClippingPlanes(new VisualizationInfo.ClippingPlanes());

	return visualizationInfo;
    }

    private RenderEngineModel getRenderEngineModel(File ifcFile) throws RenderEngineException, IOException {
	String ifcGeomServerLocation=OperatingSystemCopyOf_IfcGeomServer.getIfcGeomServer();
	Path ifcGeomServerLocationPath=Paths.get(ifcGeomServerLocation);
	IfcOpenShellEngine ifcOpenShellEngine = new IfcOpenShellEngine(ifcGeomServerLocationPath,false,false);
	FileInputStream ifcFileInputStream = new FileInputStream(ifcFile);
	if(ifcOpenShellEngine==null)
	{
	    System.err.println("ifcOpenShellEngine not found");
	    return null;
	}
	RenderEngineModel model = ifcOpenShellEngine.openModel(ifcFileInputStream);
	System.out.println("IfcOpenShell opens ifc: "+ifcFile.getAbsolutePath());
	RenderEngineSettings settings = new RenderEngineSettings();
	settings.setPrecision(Precision.SINGLE);
	settings.setIndexFormat(IndexFormat.AUTO_DETECT);
	settings.setGenerateNormals(false);
	settings.setGenerateTriangles(true);
	settings.setGenerateWireFrame(false);
	model.setSettings(settings);
	model.generateGeneralGeometry();
	System.out.println("RenderEngineModel "+model);
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

    public List<IssueBean> getIssues() {
	return issues;
    }

}