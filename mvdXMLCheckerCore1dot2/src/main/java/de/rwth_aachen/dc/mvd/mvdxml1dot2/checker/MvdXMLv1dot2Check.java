package de.rwth_aachen.dc.mvd.mvdxml1dot2.checker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.renderengine.RenderEngineException;

import de.rwth_aachen.dc.ifc.IfcModelInstance;
import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.beans.IssueBean;
import nl.tue.ddss.mvdxml1dot2.ifc_check.IfcMVDConstraintChecker;

public class MvdXMLv1dot2Check {

    public static IssueReport check(Path ifcFile, String mvdXMLFile) throws JAXBException, DeserializeException, IOException, URISyntaxException, RenderEngineException {
	MvdXMLValidationRules mvdXML = new MvdXMLValidationRules(mvdXMLFile);

	IfcModelInstance model = new IfcModelInstance();
	IfcModelInterface bimserver_ifcModel = model.readModel(ifcFile, Paths.get("."));
	if(bimserver_ifcModel==null)  // IFC2x2 causes this to return null
	    return null;
	bimserver_ifcModel.fixInverseMismatches();
	List<MVDConstraint> constraints = mvdXML.getMVDConstraints();

	if (model.getIfcversion().isPresent()) {
	    IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints, model.getIfcversion().get());
	    IssueReport issuereport = ifcChecker.checkModel(bimserver_ifcModel, ifcFile.toFile());
	    return issuereport;
	}

	return null;
    }

    public static List<IssueBean> checkModel4Web(Path ifcFile, String mvdXMLFile) throws JAXBException, DeserializeException, IOException, URISyntaxException, RenderEngineException {
	List<IssueBean> issues = new ArrayList<>();
	MvdXMLValidationRules mvdXML = new MvdXMLValidationRules(mvdXMLFile);

	IfcModelInstance model = new IfcModelInstance();
	IfcModelInterface bimserver_ifcModel = model.readModel(ifcFile, Paths.get("."));
	bimserver_ifcModel.fixInverseMismatches();
	List<MVDConstraint> constraints = mvdXML.getMVDConstraints();

	if (model.getIfcversion().isPresent()) {
	    IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints, model.getIfcversion().get());
	    IssueReport issuereport = ifcChecker.checkModel(bimserver_ifcModel, ifcFile.toFile());
	    issues.addAll(issuereport.getIssues());
	}

	return issues;
    }
}
