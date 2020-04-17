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

import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.IssueReportBean;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.IfcModelInstance;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MVDConstraint;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MvdXMLValidationRules;
import nl.tue.ddss.mvdxml1dot1.ifc_check.IfcMVDConstraintChecker;

public class MvdXMLv1dot1Check {

    static public void check(Path ifcFile , String mvdXMLFile,IssueReportBean issueReportBean) {
	 try {
	        MvdXMLValidationRules mvdXML = new MvdXMLValidationRules(mvdXMLFile);
	     
		IfcModelInstance model = new IfcModelInstance();
		IfcModelInterface bimserver_ifcModel = model.readModel(ifcFile, Paths.get("."));
		List<MVDConstraint> constraints = mvdXML.getMVDConstraints();
		System.out.println(constraints.size());

		if (model.getIfcversion().isPresent()) {
		    IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints, model.getIfcversion().get());
		    IssueReport issuereport = ifcChecker.checkModel(bimserver_ifcModel);
		    issueReportBean.getIssues().addAll(issuereport.getIssues());
		}

	    } catch (JAXBException e) {
		issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		issueReportBean.setMessage("Error: " + e.getMessage());
		e.printStackTrace();
	    } catch (DeserializeException e) {
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
	    } catch (RenderEngineException e) {
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
	    }
    }

}
