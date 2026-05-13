package de.rwth_aachen.dc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.beans.IssueBean;
import de.rwth_aachen.dc.mvd.checker.MvdXMLChecker;
import de.rwth_aachen.dc.mvd.checker.MvdXMLCheckerFactory;
import de.rwth_aachen.dc.mvd.checker.MvdXMLVersionDetector;

public class MvdXMLCommandLineChecker {
    static String detectMvdXMLVersion(String mvdXML) throws IOException {
	return MvdXMLVersionDetector.detectLabel(Paths.get(mvdXML));
    }

    public static void check(String mvdXML, String ifcFile) {
	try {
	    Path mvdXMLPath = Paths.get(mvdXML);
	    Path ifcPath = Paths.get(ifcFile);
	    MvdXMLChecker checker = MvdXMLCheckerFactory.forFile(mvdXMLPath);
	    System.out.println("mvdXML " + checker.getMvdXMLVersion() + ".");

	    IssueReport issuereport = checker.check(ifcPath, mvdXMLPath);
	    printReport(issuereport);
	} catch (IllegalArgumentException e) {
	    System.err.println(e.getMessage());
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    private static void printReport(IssueReport issuereport) throws Exception {
	if (issuereport == null) {
	    System.err.println("No report was produced.");
	    return;
	}

	List<IssueBean> issues = new ArrayList<>();
	issues.addAll(issuereport.getIssues());

	if (issues.size() > 0) {
	    File tempBCFZipFile = new File("mvdXMLCheckResult_" + System.currentTimeMillis() + ".bcfzip");
	    issuereport.writeReport(tempBCFZipFile.getAbsolutePath().toString());
	    System.out.println("\n\nISSUES FOUND:");
	    System.out.println("-------------------");
	    for (IssueBean i : issues)
		System.out.println("\n- issue: " + i.getComment());
	    System.out.println("\n\nBCF Zip report of the issuses are in: " + tempBCFZipFile.getAbsolutePath());
	} else {
	    System.out.println("\nNo issues found.");
	}
    }

    public static void main(String[] args) {
	Options options = new Options();
	@SuppressWarnings({ "deprecation", "static-access" })
	Option mvdXMLfile_option = OptionBuilder.withArgName("file").hasArg().isRequired().withDescription("The mvdXML (Model View Definitions with Exchange Requirements and Validation Rules) definition file for the validation.").create("mvdXML");
	options.addOption(mvdXMLfile_option);

	@SuppressWarnings({ "deprecation", "static-access" })
	Option ifcFile_option = OptionBuilder.withArgName("file").hasArg().isRequired().withDescription("The Industry Foundation Classes (IFC) file to be tested. Versions IFC2x3, and IFC4 are supported.").create("ifc");
	options.addOption(ifcFile_option);

	CommandLineParser parser = new DefaultParser();
	try {
	    CommandLine cmd = parser.parse(options, args);

	    String ifcFile = cmd.getOptionValue("ifc", null);

	    String mvdXML = cmd.getOptionValue("mvdXML", null);

	    if (mvdXML != null && ifcFile != null) {
		MvdXMLCommandLineChecker.check(mvdXML, ifcFile);
	    }

	} catch (ParseException e) {
	    System.err.println(e.getMessage());
	    HelpFormatter formatter = new HelpFormatter();
	    formatter.printHelp("MvdXMLCommandLineChecker",
		    "The mvdXML Checker is a tool for verifying IFC models. The validation rules are defined in the mvdXML schema (1). The software produces a BCF report and a list of the found issues. These BCFfiles can be opened with Solibri to review the viewpoints, and the comment of the validation issues found.\r\n"
			    + "\r\n" + "References: \r\n" + "1. Model Support Group (MSG) of buildingSMART International Ltd. \r\n" + "Specification of a standardized format to define and exchange\r\n"
			    + "Model View Definitions with Exchange Requirements and Validation Rules. Version 1.1 Final. " + "15. 02. 2016 \r\n\n",
		    options, "", true);
	}

    }

}
