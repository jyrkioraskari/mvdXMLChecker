package de.rwth_aachen.dc.mvd.mvdxml1underscore1.checker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.serializers.SerializerException;
import org.xml.sax.SAXException;

import de.rwth_aachen.dc.mvd.IfcModelHelper;
import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.beans.Issue;
import nl.tue.ddss.ifc_check.IfcMVDConstraintChecker;
import nl.tue.ddss.mvdparser.MVDConstraint;
import nl.tue.ddss.mvdparser.MvdXMLParser;

public class MvdXMLv1undescore1Check {

    public static List<Issue> check(Path ifcFile, String mvdXMLFile) throws JAXBException, DeserializeException, IOException, URISyntaxException, RenderEngineException, ParserConfigurationException, SAXException, SerializerException {
	List<Issue> issues = new ArrayList<>();
	
	MvdXMLParser mvdXMLParser = new MvdXMLParser(mvdXMLFile);
	IfcModelInterface ifcModel = IfcModelHelper.readModel(ifcFile, Paths.get("."));
	List<MVDConstraint> constraints = mvdXMLParser.getMVDConstraints();

	IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints);

	IssueReport issuereport = ifcChecker.checkModel(ifcModel);
	issues.addAll(issuereport.getIssues());
	return issues;
    }


}
