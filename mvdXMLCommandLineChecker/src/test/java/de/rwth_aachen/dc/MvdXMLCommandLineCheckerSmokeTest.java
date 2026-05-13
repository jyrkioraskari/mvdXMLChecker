package de.rwth_aachen.dc;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

import de.rwth_aachen.dc.mvd.checker.MvdXMLVersionDetector;

public class MvdXMLCommandLineCheckerSmokeTest {
	@Test
	public void detectsBundledMvdXmlSampleVersion() throws IOException {
		assertEquals("1_1", MvdXMLCommandLineChecker.detectMvdXMLVersion(
				"../mvdXMLCheckerCore1underscore1/example/Demo.mvdxml"));
	}

	@Test
	public void detectsSupportedNamespaces() throws IOException {
		assertEquals("1_1", MvdXMLVersionDetector.detectLabel(mvdXmlWithNamespace(
				"http://buildingsmart-tech.org/mvdXML/mvdXML1-1")));
		assertEquals("1.1", MvdXMLVersionDetector.detectLabel(mvdXmlWithNamespace(
				"http://buildingsmart-tech.org/mvd/XML/1.1")));
		assertEquals("1.2", MvdXMLVersionDetector.detectLabel(mvdXmlWithNamespace(
				"http://buildingsmart-tech.org/mvd/XML/1.2")));
	}

	private Path mvdXmlWithNamespace(String namespace) throws IOException {
		Path file = Files.createTempFile("mvdxml-version", ".mvdxml");
		Files.write(file, ("<?xml version=\"1.0\"?>\n<mvdXML xmlns=\"" + namespace + "\"></mvdXML>\n").getBytes());
		return file;
	}
}
