package de.rwth_aachen.dc.mvd.checker;

import java.io.IOException;
import java.nio.file.Path;

import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MvdXMLv1dot1Check;
import de.rwth_aachen.dc.mvd.mvdxml1dot2.checker.MvdXMLv1dot2Check;
import de.rwth_aachen.dc.mvd.mvdxml1underscore1.checker.MvdXMLv1undescore1Check;

public final class MvdXMLCheckerFactory {
	private MvdXMLCheckerFactory() {
	}

	public static MvdXMLChecker forFile(Path mvdXMLFile) throws IOException {
		return forVersion(MvdXMLVersionDetector.detect(mvdXMLFile));
	}

	public static MvdXMLChecker forVersion(MvdXMLVersion version) {
		switch (version) {
		case LEGACY_1_1:
			return new MvdXMLv1undescore1Check();
		case V1_1:
			return new MvdXMLv1dot1Check();
		case V1_2:
			return new MvdXMLv1dot2Check();
		default:
			throw new IllegalArgumentException("Unknown mvdXML version.");
		}
	}
}
