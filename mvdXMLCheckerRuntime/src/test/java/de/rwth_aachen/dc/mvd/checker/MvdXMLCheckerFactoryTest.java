package de.rwth_aachen.dc.mvd.checker;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MvdXMLv1dot1Check;
import de.rwth_aachen.dc.mvd.mvdxml1dot2.checker.MvdXMLv1dot2Check;
import de.rwth_aachen.dc.mvd.mvdxml1underscore1.checker.MvdXMLv1undescore1Check;

public class MvdXMLCheckerFactoryTest {
	@Test
	public void selectsConcreteCheckerForSupportedVersion() throws IOException {
		MvdXMLChecker legacy = MvdXMLCheckerFactory.forFile(mvdXmlWithNamespace(
				"http://buildingsmart-tech.org/mvdXML/mvdXML1-1"));
		MvdXMLChecker v11 = MvdXMLCheckerFactory.forFile(mvdXmlWithNamespace(
				"http://buildingsmart-tech.org/mvd/XML/1.1"));
		MvdXMLChecker v12 = MvdXMLCheckerFactory.forFile(mvdXmlWithNamespace(
				"http://buildingsmart-tech.org/mvd/XML/1.2"));

		assertTrue(legacy instanceof MvdXMLv1undescore1Check);
		assertTrue(v11 instanceof MvdXMLv1dot1Check);
		assertTrue(v12 instanceof MvdXMLv1dot2Check);
	}

	@Test(expected = IllegalArgumentException.class)
	public void rejectsUnknownVersion() throws IOException {
		MvdXMLCheckerFactory.forFile(mvdXmlWithNamespace("urn:unknown"));
	}

	private Path mvdXmlWithNamespace(String namespace) throws IOException {
		Path file = Files.createTempFile("mvdxml-version", ".mvdxml");
		Files.write(file, ("<?xml version=\"1.0\"?>\n<mvdXML xmlns=\"" + namespace + "\"></mvdXML>\n").getBytes());
		return file;
	}
}
