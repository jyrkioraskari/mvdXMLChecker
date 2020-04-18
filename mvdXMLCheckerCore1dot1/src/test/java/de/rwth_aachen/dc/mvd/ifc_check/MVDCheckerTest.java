package de.rwth_aachen.dc.mvd.ifc_check;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bimserver.emf.IfcModelInterface;

import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.beans.Issue;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.IfcModelInstance;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MVDConstraint;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MvdXMLValidationRules;
import nl.tue.ddss.mvdxml1dot1.ifc_check.IfcMVDConstraintChecker;

public class MVDCheckerTest {

    public MVDCheckerTest(String ifcFileName, String mvdXMLFile) throws Exception {
	MvdXMLValidationRules mvdXML = new MvdXMLValidationRules(mvdXMLFile);
	try {
	    Path ifcFile = Paths.get(ifcFileName);
	    IfcModelInstance model = new IfcModelInstance();
	    IfcModelInterface bimserver_ifcModel = model.readModel(ifcFile, Paths.get("."));
	    List<MVDConstraint> constraints = mvdXML.getMVDConstraints();
	    System.out.println(constraints.size());

	    if (model.getIfcversion().isPresent()) {
		IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints,model.getIfcversion().get());
		IssueReport issuereport=ifcChecker.checkModel(bimserver_ifcModel);
		for(Issue i: issuereport.getIssues())
		    System.out.println("Issue: "+i.getComment());
	    }

	} catch (JAXBException e) {
	    e.printStackTrace();
	}

    }

    public static void main(String[] args) throws Exception {
	
	// Error case 1  IFC4<>IFC2x3
	//new MVDCheckerTest("c:\\ifc\\20160125Autodesk_Hospital_Parking Garage_2015 - IFC4.ifc", "C:\\jo\\BIM4Ren\\Technical\\mvdXML1.1Test\\Simple.mvdxml");
	new MVDCheckerTest("c:\\ifc\\Duplex_A_20110505.ifc", "C:\\jo\\BIM4Ren\\Technical\\mvdXML1.1Test\\Vorlage.mvdxml");
	
    }
}