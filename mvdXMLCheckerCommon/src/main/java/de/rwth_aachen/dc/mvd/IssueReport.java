package de.rwth_aachen.dc.mvd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.ModelMetaData;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.ifcopenshell.IfcOpenShellEngine;
import org.opensource_bimserver.bcf.Bcf;
import org.opensource_bimserver.bcf.BcfException;
import org.opensource_bimserver.v1_40.plugins.renderengine.IndexFormat;
import org.opensource_bimserver.v1_40.plugins.renderengine.Precision;
import org.opensource_bimserver.v1_40.plugins.renderengine.RenderEngineException;
import org.opensource_bimserver.v1_40.plugins.renderengine.RenderEngineModel;
import org.opensource_bimserver.v1_40.plugins.renderengine.RenderEngineSettings;

import de.rwth_aachen.dc.mvd.bcf.TempGeometry;
import de.rwth_aachen.dc.mvd.beans.Issue;

public class IssueReport {
    private String ifcProjectGuid;
    private String ifcHeaderFilename;
    private Date ifcHeaderTimeStamp;

    private Set<Long> roids;
    private RenderEngineModel renderEngineModel;
    private final TempGeometry tempGeometry = new TempGeometry();

    private List<Issue> issues = new ArrayList<>();
    private final Bcf bcf = new Bcf();

    public IssueReport(IfcModelInterface ifcModel,File ifcfile) throws DeserializeException, IOException, RenderEngineException {
	ModelMetaData mmd = ifcModel.getModelMetaData();
	IfcHeader ifcHeader = mmd.getIfcHeader();
	System.out.println("ifcHeader schema: " + ifcHeader.getIfcSchemaVersion());
	ifcHeaderFilename = ifcHeader.getFilename();
	ifcHeaderTimeStamp = ifcHeader.getTimeStamp();

	if (ifcHeader.getIfcSchemaVersion().equals("IFC2X3")) {
	    System.out.println("IFC2X3");
	    List<org.bimserver.models.ifc2x3tc1.IfcProject> projects2x3 = ifcModel.getAll(org.bimserver.models.ifc2x3tc1.IfcProject.class);
	    if (projects2x3.size() > 0) {
		if (projects2x3.size() != 1)
		    throw new RuntimeException("The IFC2x3 model should have only one IfcProject");
		else {
		    ifcProjectGuid = projects2x3.get(0).getGlobalId();
		    return;
		}
	    }
	} else if (ifcHeader.getIfcSchemaVersion().equals("IFC4")) {
	    System.out.println("IFC4");
	    List<org.bimserver.models.ifc4.IfcProject> projects4 = ifcModel.getAll(org.bimserver.models.ifc4.IfcProject.class);
	    if (projects4.size() > 0) {
		if (projects4.size() != 1)
		    throw new RuntimeException("The IFC4 model should have only one IfcProject");
		else {
		    ifcProjectGuid = projects4.get(0).getGlobalId();
		}
	    }
	} else
	    throw new RuntimeException("Not a supported IFC version");

	    renderEngineModel = getRenderEngineModel(ifcfile);
    }

    public RenderEngineModel getRenderEngineModel(File ifcFile) throws RenderEngineException, IOException {
	// TODO no static .exe reference
	IfcOpenShellEngine ifcOpenShellEngine = new IfcOpenShellEngine("exe/64/win/IfcGeomServer.exe");
	RenderEngineModel model = ifcOpenShellEngine.openModel(ifcFile);
	RenderEngineSettings settings = new RenderEngineSettings();
	settings.setPrecision(Precision.SINGLE);
	settings.setIndexFormat(IndexFormat.AUTO_DETECT);
	settings.setGenerateNormals(false);
	settings.setGenerateTriangles(true);
	settings.setGenerateWireFrame(false);
	model.setSettings(settings);
	model.generateGeneralGeometry();
	return model;
    }

    private void addMarkup(String ifcSpatialStructureElement, org.bimserver.models.ifc2x3tc1.IfcRoot ifcRoot, String comment, String topicGuid) {
	System.out.println("addMarkup:");
	System.out.println("ifcSpatialStructureElement: " + ifcSpatialStructureElement + ", ifcRoot: " + ifcRoot + ", Comment: " + comment + ", Topic guid: " + topicGuid);
	System.out.println();
    }

    private void addMarkup(String ifcSpatialStructureElement, org.bimserver.models.ifc4.IfcRoot ifcRoot, String comment, String topicGuid) {
	System.out.println("addMarkup:");
	System.out.println("ifcSpatialStructureElement: " + ifcSpatialStructureElement + ", ifcRoot: " + ifcRoot + ", Comment: " + comment + ", Topic guid: " + topicGuid);
	System.out.println();
    }

    public void addIssue(String ifcSpatialStructureElement, org.bimserver.models.ifc2x3tc1.IfcRoot ifcRoot, String comment) {
	issues.add(new Issue(ifcSpatialStructureElement, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), comment));
	// System.out.println("addIssue:");
	// System.out.println("ifcRoot: " + ifcRoot.getGlobalId() + ", Comment: " +
	// comment );
	// System.out.println();
    }

    public void addIssue(String ifcSpatialStructureElement, org.bimserver.models.ifc4.IfcRoot ifcRoot, String comment) {
	issues.add(new Issue(ifcSpatialStructureElement, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), comment));
	// System.out.println("addIssue:");
	// System.out.println("ifcRoot: " + ifcRoot.getGlobalId() + ", Comment: " +
	// comment );
	// System.out.println();
    }

    public void addIssue(String elementClass, String comment) {
	issues.add(new Issue(null, elementClass, "", "", comment));
	// System.out.println("addIssue:");
	// System.out.println("ifcRoot: " + ifcRoot.getGlobalId() + ", Comment: " +
	// comment );
	// System.out.println();
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

    public String getIfcProjectGuid() {
	return ifcProjectGuid;
    }

    public void setIfcProjectGuid(String ifcProjectGuid) {
	this.ifcProjectGuid = ifcProjectGuid;
    }

    public String getIfcHeaderFilename() {
	return ifcHeaderFilename;
    }

    public void setIfcHeaderFilename(String ifcHeaderFilename) {
	this.ifcHeaderFilename = ifcHeaderFilename;
    }

    public Date getIfcHeaderTimeStamp() {
	return ifcHeaderTimeStamp;
    }

    public void setIfcHeaderTimeStamp(Date ifcHeaderTimeStamp) {
	this.ifcHeaderTimeStamp = ifcHeaderTimeStamp;
    }

    public List<Issue> getIssues() {
	return issues;
    }

    public void setIssues(List<Issue> issues) {
	this.issues = issues;
    }

}