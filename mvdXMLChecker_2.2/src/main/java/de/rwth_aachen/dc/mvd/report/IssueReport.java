package de.rwth_aachen.dc.mvd.report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.ModelMetaData;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.store.IfcHeader;
import org.bimserver.plugins.deserializers.DeserializeException;

public class IssueReport {
    private String ifcProjectGuid;
    private String ifcHeaderFilename;
    private Date ifcHeaderTimeStamp;

    private List<Issue> issues = new ArrayList<>();

    public IssueReport(IfcModelInterface ifcModel) throws DeserializeException, IOException {
	List<IfcProject> projects = ifcModel.getAll(IfcProject.class);
	if (projects.size() != 1)
	    throw new RuntimeException("The IFC model should have only one IfcProject");
	else {
	    ifcProjectGuid = projects.get(0).getGlobalId();
	    ModelMetaData mmd = ifcModel.getModelMetaData();
	    IfcHeader ifcHeader = mmd.getIfcHeader();
	    ifcHeaderFilename = ifcHeader.getFilename();
	    ifcHeaderTimeStamp = ifcHeader.getTimeStamp();
	}
    }

    private void addMarkup(String ifcSpatialStructureElement, IfcRoot ifcRoot, String comment, String topicGuid) {
	System.out.println("addMarkup:");
	System.out.println("ifcSpatialStructureElement: " + ifcSpatialStructureElement + ", ifcRoot: " + ifcRoot + ", Comment: " + comment + ", Topic guid: " + topicGuid);
	System.out.println();
    }

    public void addIssue(String ifcSpatialStructureElement, IfcRoot ifcRoot, String comment) {
	issues.add(new Issue(ifcSpatialStructureElement, ifcRoot.getClass().getSimpleName(), ifcRoot.getGlobalId(), ifcRoot.getName(), comment));
	//System.out.println("addIssue:");
	//System.out.println("ifcRoot: " + ifcRoot.getGlobalId() + ", Comment: " + comment );
	//System.out.println();
    }

    public static String cleanString(String txt) {
	StringBuilder sb = new StringBuilder();
	char ch = '\\';
	for (int n = 0; n < txt.length(); n++) {
	    char cch = txt.charAt(n);
	    if(cch=='\t')
		cch=' ';
	    if (!Character.isWhitespace(cch)) {
		sb.append(cch);
	    } else if (cch != ch) {
		if(ch!='\n')
		  sb.append(cch);
	    }
	    ch = cch;
	}
	return sb.toString();
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