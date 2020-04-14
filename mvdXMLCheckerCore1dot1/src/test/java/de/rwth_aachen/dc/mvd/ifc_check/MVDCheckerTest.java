package de.rwth_aachen.dc.mvd.ifc_check;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bimserver.emf.IfcModelInterface;

import de.rwth_aachen.dc.mvd.IfcModelHelper;
import de.rwth_aachen.dc.mvdxml.checker.MVDConstraint;
import de.rwth_aachen.dc.mvdxml.checker.MvdXMLValidationRules;
import nl.tue.ddss.ifc_check.IfcMVDConstraintChecker;

public class MVDCheckerTest {

    public MVDCheckerTest(String ifcFileName, String mvdXMLFile) throws Exception {
	MvdXMLValidationRules mvdXML = new MvdXMLValidationRules(mvdXMLFile);
	try {
	    Path ifcFile = Paths.get(ifcFileName);
	    IfcModelInterface bimserver_ifcModel = IfcModelHelper.readModel(ifcFile,Paths.get("."));
	    List<MVDConstraint> constraints = mvdXML.getMVDConstraints();
	    System.out.println(constraints.size());

	    IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints);
	    ifcChecker.checkModel(bimserver_ifcModel);

	} catch (JAXBException e) {
	    e.printStackTrace();
	}

    }

    public static void main(String[] args) throws Exception {
	new MVDCheckerTest("example/Duplex_A_20110505_modified.ifc", "C:\\jo\\BIM4Ren\\Technical\\mvdXML1.1Test\\mvdXML_V1-1-Final-Documentation.xml");
    }
}