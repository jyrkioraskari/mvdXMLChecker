package nl.tue.ddss.ifc_check;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bimserver.emf.IfcModelInterface;

import de.rwth_aachen.dc.ifc.IfcModelInstance;
import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.beans.Issue;
import nl.tue.ddss.mvdparser.MVDConstraint;
import nl.tue.ddss.mvdparser.MvdXMLParser;

public class MVDCheckerTest {

    public MVDCheckerTest(String ifcFileName, String mvdXMLFile) throws Exception {
	MvdXMLParser mvdXMLParser = new MvdXMLParser(mvdXMLFile);
	try {
	    Path ifcFile = Paths.get(ifcFileName);
	    IfcModelInstance model = new IfcModelInstance();
            IfcModelInterface bimserver_ifcModel = model.readModel(ifcFile, Paths.get("."));
		
	    List<MVDConstraint> constraints = mvdXMLParser.getMVDConstraints();

	    if (model.getIfcversion().isPresent()) {
		IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints,model.getIfcversion().get());
		IssueReport issuereport=ifcChecker.checkModel(bimserver_ifcModel,ifcFile.toFile());
		for(Issue i: issuereport.getIssues())
		    System.out.println("Issue: "+i.getComment());
	    }

	} catch (JAXBException e) {
	    e.printStackTrace();
	}

    }

    public static void main(String[] args) throws Exception {
	/*
	 * Three arguments for the main function The first one is the IFC file path The
	 * second one is the mvdXML file path The third one is the output folder of BCF
	 * files
	 */
	//new MVDCheckerTest("example/Duplex_A_20110505_modified.ifc", "example/Demo.mvdxml", "report/");
	new MVDCheckerTest("example/Duplex_A_20110505_modified.ifc", "C:\\jo\\BIM4Ren\\technical\\mvd-ld\\DoorHasProperties.xml");
    }
}