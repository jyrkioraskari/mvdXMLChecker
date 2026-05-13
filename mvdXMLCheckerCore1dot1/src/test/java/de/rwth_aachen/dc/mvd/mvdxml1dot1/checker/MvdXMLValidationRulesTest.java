package de.rwth_aachen.dc.mvd.mvdxml1dot1.checker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import de.rwth_aachen.dc.mvd.checker.MvdXMLRules;
import generated.buildingsmart_tech.mvd_xml_1dot1.ConceptTemplate;
import generated.buildingsmart_tech.mvd_xml_1dot1.ModelView;

public class MvdXMLValidationRulesTest {
	private static final String MVDXML_1_1_NAMESPACE = "http://buildingsmart-tech.org/mvd/XML/1.1";
	private static final String MVDXML_1_2_NAMESPACE = "http://buildingsmart-tech.org/mvd/XML/1.2";

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void parsesModelViewsTemplatesAndConceptConstraints() throws Exception {
		File mvdXmlFile = writeMvdXmlFile(validMvdXml(MVDXML_1_1_NAMESPACE));

		MvdXMLValidationRules rules = new MvdXMLValidationRules("test", mvdXmlFile.getAbsolutePath());
		MvdXMLRules<ModelView, ConceptTemplate, MVDConceptConstraintRootSet> sharedRules = rules;

		assertTrue(sharedRules.isValid());
		assertEquals(1, sharedRules.getModelViews().size());
		assertEquals(2, sharedRules.getAllTemplates().size());

		List<MVDConceptConstraintRootSet> constraints = sharedRules.getMVDConstraints();
		assertEquals(1, constraints.size());
		assertEquals("IfcWall", constraints.get(0).getApplicableIfcElement());
		assertEquals("and", constraints.get(0).getApplicability_operator());
		assertEquals(1, constraints.get(0).getConcept_constraints().size());
		assertEquals(1, constraints.get(0).getConcept_constraints().get(0).getConcept_attributeRules().size());
	}

	@Test
	public void rejectsMvdXmlWithWrongNamespace() throws Exception {
		File mvdXmlFile = writeMvdXmlFile(validMvdXml(MVDXML_1_2_NAMESPACE));

		MvdXMLValidationRules rules = new MvdXMLValidationRules("test", mvdXmlFile.getAbsolutePath());

		assertFalse(rules.isValid());
	}

	private File writeMvdXmlFile(String content) throws Exception {
		File file = temporaryFolder.newFile("view.mvdxml");
		Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8));
		return file;
	}

	private String validMvdXml(String namespace) {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
				+ "<mvdXML xmlns=\"" + namespace + "\" uuid=\"mvd-1\" name=\"Test View\">\n"
				+ "  <Templates>\n"
				+ "    <ConceptTemplate uuid=\"template-parent\" name=\"Parent Template\" applicableSchema=\"IFC4\" applicableEntity=\"IfcRoot\">\n"
				+ "      <SubTemplates>\n"
				+ "        <ConceptTemplate uuid=\"template-concept\" name=\"Concept Template\" applicableSchema=\"IFC4\" applicableEntity=\"IfcWall\">\n"
				+ "          <Rules>\n"
				+ "            <AttributeRule AttributeName=\"Name\" />\n"
				+ "          </Rules>\n"
				+ "        </ConceptTemplate>\n"
				+ "      </SubTemplates>\n"
				+ "    </ConceptTemplate>\n"
				+ "  </Templates>\n"
				+ "  <Views>\n"
				+ "    <ModelView uuid=\"view-1\" name=\"Test Model View\" applicableSchema=\"IFC4\">\n"
				+ "      <Roots>\n"
				+ "        <ConceptRoot uuid=\"root-1\" name=\"Wall Root\" applicableRootEntity=\"IfcWall\">\n"
				+ "          <Concepts>\n"
				+ "            <Concept uuid=\"concept-1\" name=\"Wall Concept\">\n"
				+ "              <Template ref=\"template-concept\" />\n"
				+ "              <TemplateRules operator=\"and\" />\n"
				+ "            </Concept>\n"
				+ "          </Concepts>\n"
				+ "        </ConceptRoot>\n"
				+ "      </Roots>\n"
				+ "    </ModelView>\n"
				+ "  </Views>\n"
				+ "</mvdXML>\n";
	}
}
