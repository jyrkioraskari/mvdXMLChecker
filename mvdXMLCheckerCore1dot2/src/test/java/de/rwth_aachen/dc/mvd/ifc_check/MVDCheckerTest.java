package de.rwth_aachen.dc.mvd.ifc_check;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.bimserver.emf.IfcModelInterface;

import de.rwth_aachen.dc.ifc.IfcModelInstance;
import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.beans.IssueBean;
import de.rwth_aachen.dc.mvd.mvdxml1dot2.checker.MVDConceptConstraint;
import de.rwth_aachen.dc.mvd.mvdxml1dot2.checker.MVDConceptConstraintRootSet;
import de.rwth_aachen.dc.mvd.mvdxml1dot2.checker.MvdXMLValidationRules;
import nl.tue.ddss.mvdxml1dot2.ifc_check.IfcMVDConstraintChecker;

public class MVDCheckerTest {

    public MVDCheckerTest(String ifcFileName, String mvdXMLFile) {
	try {
	    MvdXMLValidationRules mvdXML = new MvdXMLValidationRules(".",mvdXMLFile);
	    Path ifcFile = Paths.get(ifcFileName);
	    IfcModelInstance model = new IfcModelInstance();
	    IfcModelInterface bimserver_ifcModel = model.readModel(".",ifcFile, Paths.get("."));
	    bimserver_ifcModel.fixInverseMismatches();
	    List<MVDConceptConstraintRootSet> constraints = mvdXML.getMVDConstraints();
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
    	new MVDCheckerTest("C:\\jo\\2022_06_mvdChecker_bug\\Duplex_A_20110907.ifc", "C:\\jo\\2022_06_mvdChecker_bug\\ReferenceView_V1-2.mvdxml.xml");


    }
}