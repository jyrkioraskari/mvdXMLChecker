package de.rwth_aachen.dc.mvd.ifcvalidator.rest.checkers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.serializers.SerializerException;
import org.xml.sax.SAXException;

import de.rwth_aachen.dc.mvd.IfcModelHelper;
import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.IssueReportBean;
import nl.tue.ddss.ifc_check.IfcMVDConstraintChecker;
import nl.tue.ddss.mvdparser.MVDConstraint;
import nl.tue.ddss.mvdparser.MvdXMLParser;

public class MvdXMLv1undescore1Check {

    public static void check(String ifcFileName, String mvdXMLFile,IssueReportBean issueReportBean) {
	try {
	    MvdXMLParser mvdXMLParser = new MvdXMLParser(mvdXMLFile);
	    Path ifcFile = Paths.get(ifcFileName);
	    IfcModelInterface ifcModel = IfcModelHelper.readModel(ifcFile, Paths.get("."));
	    List<MVDConstraint> constraints = mvdXMLParser.getMVDConstraints();

	    IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints);
	    
	    IssueReport issuereport = ifcChecker.checkModel(ifcModel);
	    issueReportBean.getIssues().addAll(issuereport.getIssues());
	
	} catch (JAXBException e) {
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	    e.printStackTrace();
	} catch (RenderEngineException e) {
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	    e.printStackTrace();
	} catch (DeserializeException e) {
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	    e.printStackTrace();
	} catch (ParserConfigurationException e) {
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	    e.printStackTrace();
	} catch (SAXException e) {
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	    e.printStackTrace();
	} catch (SerializerException e) {
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	    e.printStackTrace();
	} catch (IOException e) {
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	    e.printStackTrace();
	} catch (URISyntaxException e) {
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	    e.printStackTrace();
	}
    }

}
