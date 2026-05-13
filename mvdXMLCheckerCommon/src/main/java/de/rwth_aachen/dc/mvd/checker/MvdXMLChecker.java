package de.rwth_aachen.dc.mvd.checker;

import java.nio.file.Path;

import de.rwth_aachen.dc.mvd.IssueReport;

public interface MvdXMLChecker {
	String getMvdXMLVersion();

	IssueReport check(Path ifcFile, Path mvdXMLFile) throws Exception;

	IssueReport check(String id, Path ifcFile, Path mvdXMLFile) throws Exception;
}
