package de.rwth_aachen.dc.mvd.mvdxml1dot2.checker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.bimserver.emf.IfcModelInterface;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.renderengine.RenderEngineException;

import de.rwth_aachen.dc.ifc.IfcModelInstance;
import de.rwth_aachen.dc.mvd.IssueReport;
import nl.tue.ddss.mvdxml1dot2.ifc_check.IfcMVDConstraintChecker;

public class MvdXMLv1dot2Check {

	public static IssueReport check(Path ifcFile, String mvdXMLFile)
			throws JAXBException, DeserializeException, IOException, URISyntaxException, RenderEngineException {
		MvdXMLValidationRules mvdXML = new MvdXMLValidationRules(".", mvdXMLFile);

		IfcModelInstance model = new IfcModelInstance();
		IfcModelInterface bimserver_ifcModel = model.readModel(".", ifcFile, Paths.get("."));
		if (bimserver_ifcModel == null) // IFC2x2 causes this to return null
			return null;
		bimserver_ifcModel.fixInverseMismatches();
		List<MVDConceptConstraintRootSet> constraints = mvdXML.getMVDConstraints(); // JO 2022_02

		if (model.getIfcversion().isPresent()) {
			IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(constraints, model.getIfcversion().get());
			IssueReport issuereport = ifcChecker.checkModel(bimserver_ifcModel, ifcFile.toFile());
			return issuereport;
		}

		return null;
	}

	public static IssueReport check(String id, Path ifcFile, String mvdXMLFile)
			throws JAXBException, DeserializeException, IOException, URISyntaxException, RenderEngineException {
		MvdXMLValidationRules mvdXML = new MvdXMLValidationRules(id, mvdXMLFile);

		IfcModelInstance model = new IfcModelInstance();
		IfcModelInterface bimserver_ifcModel = model.readModel(id, ifcFile, Paths.get("."));
		if (bimserver_ifcModel == null) // IFC2x2 causes this to return null
			return null;
		bimserver_ifcModel.fixInverseMismatches();
		List<MVDConceptConstraintRootSet> constraints = mvdXML.getMVDConstraints();

		if (model.getIfcversion().isPresent()) {
			IfcMVDConstraintChecker ifcChecker = new IfcMVDConstraintChecker(id, constraints,
					model.getIfcversion().get());
			IssueReport issuereport = ifcChecker.checkModel(bimserver_ifcModel, ifcFile.toFile());
			return issuereport;
		}

		return null;
	}
}
