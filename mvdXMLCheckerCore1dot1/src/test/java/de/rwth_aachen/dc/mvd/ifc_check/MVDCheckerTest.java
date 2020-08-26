package de.rwth_aachen.dc.mvd.ifc_check;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.bimserver.emf.IfcModelInterface;

import de.rwth_aachen.dc.ifc.IfcModelInstance;
import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.beans.IssueBean;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MVDConceptConstraint;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MvdXMLValidationRules;
import nl.tue.ddss.mvdxml1dot1.ifc_check.IfcMVDConstraintChecker;

public class MVDCheckerTest {

    public MVDCheckerTest(String ifcFileName, String mvdXMLFile) {
	try {
	    MvdXMLValidationRules mvdXML = new MvdXMLValidationRules(mvdXMLFile);
	    Path ifcFile = Paths.get(ifcFileName);
	    IfcModelInstance model = new IfcModelInstance();
	    IfcModelInterface bimserver_ifcModel = model.readModel(ifcFile, Paths.get("."));
	    bimserver_ifcModel.fixInverseMismatches();
	    List<MVDConceptConstraint> constraints = mvdXML.getMVDConstraints();
	    System.out.println(constraints.size());

	    if (model.getIfcversion().isPresent()) {
		IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints, model.getIfcversion().get());
		IssueReport issuereport = ifcChecker.checkModel(bimserver_ifcModel, ifcFile.toFile());
		for (IssueBean i : issuereport.getIssues())
		    System.out.println("Issue: "+ i.getComment());
		String outputFolder = "c:\\temp\\1\\";
		new File(outputFolder).mkdir();
		issuereport.writeReport(outputFolder + "checking_result" + ".bcfzip");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    public static void main(String[] args) throws Exception {

	new MVDCheckerTest("c:\\test\\noemi10\\BUW_HC-Gebäude-Wartung (1).ifc", "c:\\test\\noemi10\\ILC_Anlagenverzeichnis Wartung erstellen (2).mvdxml");

	//new MVDCheckerTest("c:\\test\\noemi9\\BUW_HC-Gebäude-Reinigung - Fenster_optimized.ifc", "c:\\test\\noemi9\\ILC_Flächenverzeichnis für Reinigung erstellen.mvdxml");
	//new MVDCheckerTest("c:\\test\\noemi8\\BUW_HC-Gebäude-Wartung.ifc", "c:\\test\\noemi8\\ILC_Anlagenverzeichnis Wartung erstellen.mvdxml");

	//new MVDCheckerTest("c:\\test\\noemi7\\BUW_HC-Gebäude-Aufzug - Aufzugsanlage.ifc", "c:\\test\\noemi7\\ILC_Wartungs-LV erstellen.mvdxml");

	//new MVDCheckerTest("c:\\temp\\1\\BUW_HC-elevator.ifc", "c:\\temp\\1\\ILC_Anlagenverzeichnis Wartung erstellen.mvdxml");
	
	//new MVDCheckerTest("c:\\test\\noemi4\\BUW_HC-Gebäude-Aufzug.ifc", "c:\\test\\noemi4\\ILC_Textdatei_richtig.mvdxml");
	//new MVDCheckerTest("c:\\temp\\A.ifc", "c:\\temp\\A.mvdxml");
	//new MVDCheckerTest("c:\\test\\noemi2\\BUW_HC-elevator.ifc", "c:\\test\\noemi2\\Vorlage - Kopie (2).mvdxml");
	//new MVDCheckerTest("c:\\test\\noemi\\BUW_HC-Gebaude.ifc", "c:\\test\\noemi\\BUW_IfcTransportelement.mvdxml");
	//new MVDCheckerTest("c:\\ifc\\Duplex_A_20110505.ifc", "c:\\test\\noemi\\Vorlage2.mvdxml");
	//new MVDCheckerTest("c:\\ifc\\Duplex_A_20110505.ifc", "c:\\test\\Simple.mvdxml");
	//new MVDCheckerTest("c:\\ifc\\Duplex_A_20110505.ifc", "C:\\jo\\BIM4Ren\\Technical\\mvdXML1.1Test\\Simple.mvdxml");
        //new MVDCheckerTest("c:\\ifc\\Duplex_A_20110505.ifc","C:\\jo\\BIM4Ren\\Technical\\mvdXML1.1Test\\Vorlage.mvdxml");

    }
}