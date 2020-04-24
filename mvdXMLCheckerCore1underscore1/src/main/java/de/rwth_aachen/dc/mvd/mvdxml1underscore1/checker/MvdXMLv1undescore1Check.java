package de.rwth_aachen.dc.mvd.mvdxml1underscore1.checker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.deserializers.DeserializeException;

import de.rwth_aachen.dc.ifc.IfcModelInstance;
import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.beans.IssueBean;
import nl.tue.ddss.ifc_check.IfcMVDConstraintChecker;
import nl.tue.ddss.mvdparser.MVDConstraint;
import nl.tue.ddss.mvdparser.MvdXMLParser;

public class MvdXMLv1undescore1Check {

    public static List<IssueBean> check(Path ifcFile, String mvdXMLFile) throws JAXBException, DeserializeException, IOException, URISyntaxException, org.opensource_bimserver.v1_40.plugins.renderengine.RenderEngineException {
	List<IssueBean> issues = new ArrayList<>();
	
	MvdXMLParser mvdXMLParser = new MvdXMLParser(mvdXMLFile);
	
	IfcModelInstance model = new IfcModelInstance();
	IfcModelInterface bimserver_ifcModel = model.readModel(ifcFile, Paths.get("."));
	
	List<MVDConstraint> constraints = mvdXMLParser.getMVDConstraints();

	if (model.getIfcversion().isPresent()) {
	    IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints, model.getIfcversion().get());
	    IssueReport issuereport = ifcChecker.checkModel(bimserver_ifcModel,ifcFile.toFile());
	    issues.addAll(issuereport.getIssues());
	}
	
	return issues;
    }


}
