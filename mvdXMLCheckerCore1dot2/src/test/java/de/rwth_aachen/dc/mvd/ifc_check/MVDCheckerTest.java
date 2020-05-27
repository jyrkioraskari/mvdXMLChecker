package de.rwth_aachen.dc.mvd.ifc_check;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.bimserver.emf.IfcModelInterface;

import de.rwth_aachen.dc.ifc.IfcModelInstance;
import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.beans.IssueBean;
import de.rwth_aachen.dc.mvd.mvdxml1dot2.checker.MVDConstraint;
import de.rwth_aachen.dc.mvd.mvdxml1dot2.checker.MvdXMLValidationRules;
import nl.tue.ddss.mvdxml1dot2.ifc_check.IfcMVDConstraintChecker;

public class MVDCheckerTest {

    public MVDCheckerTest(String ifcFileName, String mvdXMLFile) {
	try {
	    MvdXMLValidationRules mvdXML = new MvdXMLValidationRules(mvdXMLFile);
	    Path ifcFile = Paths.get(ifcFileName);
	    IfcModelInstance model = new IfcModelInstance();
	    IfcModelInterface bimserver_ifcModel = model.readModel(ifcFile, Paths.get("."));
	    bimserver_ifcModel.fixInverseMismatches();
	    List<MVDConstraint> constraints = mvdXML.getMVDConstraints();
	    System.out.println(constraints.size());

	    if (model.getIfcversion().isPresent()) {
		IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints, model.getIfcversion().get());
		IssueReport issuereport = ifcChecker.checkModel(bimserver_ifcModel, ifcFile.toFile());
		for (IssueBean i : issuereport.getIssues())
		    System.out.println("Issue: "+ i.getComment());
		String outputFolder = "report/";
		new File(outputFolder).mkdir();
		issuereport.writeReport(outputFolder + "checking_result" + ".bcfzip");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    public static void main(String[] args) throws Exception {

	// Error case 1 IFC4<>IFC2x3
	new MVDCheckerTest("c:\\test\\noemi2\\BUW_HC-elevator.ifc", "c:\\test\\noemi2\\Vorlage - Kopie (2).mvdxml");
	new MVDCheckerTest("c:\\test\\noemi\\BUW_HC-Gebaude.ifc", "c:\\test\\noemi\\BUW_IfcTransportelement.mvdxml");
	new MVDCheckerTest("c:\\ifc\\Duplex_A_20110505.ifc", "c:\\test\\noemi\\Vorlage2.mvdxml");
	new MVDCheckerTest("c:\\ifc\\Duplex_A_20110505.ifc", "c:\\test\\Simple.mvdxml");
	new MVDCheckerTest("c:\\ifc\\Duplex_A_20110505.ifc", "C:\\jo\\BIM4Ren\\Technical\\mvdXML1.1Test\\Simple.mvdxml");
        new MVDCheckerTest("c:\\ifc\\Duplex_A_20110505.ifc","C:\\jo\\BIM4Ren\\Technical\\mvdXML1.1Test\\Vorlage.mvdxml");

    }
}