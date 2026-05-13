package de.rwth_aachen.dc.mvd.checker;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class MvdXMLVersionDetector {
	private static final int HEADER_LINES_TO_SCAN = 20;

	private MvdXMLVersionDetector() {
	}

	public static MvdXMLVersion detect(Path mvdXMLFile) throws IOException {
		try (BufferedReader reader = Files.newBufferedReader(mvdXMLFile)) {
			for (int i = 0; i < HEADER_LINES_TO_SCAN; i++) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}

				for (MvdXMLVersion version : MvdXMLVersion.values()) {
					if (version.getNamespace() != null && containsNamespace(line, version.getNamespace())) {
						return version;
					}
				}
			}
		}

		return MvdXMLVersion.UNKNOWN;
	}

	public static String detectLabel(Path mvdXMLFile) throws IOException {
		return detect(mvdXMLFile).getLabel();
	}

	private static boolean containsNamespace(String line, String namespace) {
		return line.contains("\"" + namespace + "\"") || line.contains("'" + namespace + "'");
	}
}
