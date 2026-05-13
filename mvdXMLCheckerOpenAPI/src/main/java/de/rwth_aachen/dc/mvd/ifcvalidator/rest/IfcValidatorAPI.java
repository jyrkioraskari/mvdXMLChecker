package de.rwth_aachen.dc.mvd.ifcvalidator.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataParam;

import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.checker.MvdXMLChecker;
import de.rwth_aachen.dc.mvd.checker.MvdXMLCheckerFactory;
import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.MvdXMLCheckerResultsReportBean;

@Path("/")
public class IfcValidatorAPI {

    static java.nio.file.Path tempDir;
    static {
	try {
	    tempDir = Files.createTempDirectory("ifcValidator");
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Checks the validity the validity of the given IFC Step file content against
     * the referred mvdXML. Provides a JSON result.
     * 
     * Supported mvdXML versions are V1.1. V1-1 and v1.2 draft 3.
     * 
     * @param mvdXMLfile The mvdXML file
     * @param ifcFile    The IFC STEP file
     * @return the JSON result of the validation
     */
    @POST
    @Path("/check_plain")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public MvdXMLCheckerResultsReportBean check_plain(@FormDataParam("mvdXMLfile") InputStream mvdXMLfile, @FormDataParam("ifcFile") InputStream ifcFile) {
	MvdXMLCheckerResultsReportBean issueReportBean = new MvdXMLCheckerResultsReportBean();
	try {
	    File tempIfcFile = File.createTempFile("ifcChecker-", ".ifc");
	    tempIfcFile.deleteOnExit();

	    Files.copy(ifcFile, tempIfcFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    IOUtils.closeQuietly(ifcFile);

	    File tempMvdxmlFile = File.createTempFile("ifcChecker-", ".mvdxml");
	    tempMvdxmlFile.deleteOnExit();

	    Files.copy(mvdXMLfile, tempMvdxmlFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    IOUtils.closeQuietly(mvdXMLfile);

	    execute_check(issueReportBean, tempIfcFile, tempMvdxmlFile);

	} catch (Exception e) {
	    e.printStackTrace();
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	}

	return issueReportBean;
    }

    private void execute_check(MvdXMLCheckerResultsReportBean issueReportBean, File tempIfcFile, File tempMvdxmlFile) throws Exception {
	MvdXMLChecker checker = MvdXMLCheckerFactory.forFile(tempMvdxmlFile.toPath());
	issueReportBean.setMessage(messageForVersion(checker.getMvdXMLVersion()));

	IssueReport issueReport = checker.check(tempIfcFile.toPath(), tempMvdxmlFile.toPath());
	if (issueReport != null) {
	    issueReportBean.getIssues().addAll(issueReport.getIssues());
	    issueReportBean.getElement_check_results().addAll(issueReport.getElementCheckResults());
	    issueReportBean.getGeneral_comments().addAll(issueReport.getGeneral_comments());
	}
    }

    /**
     * Checks the validity the validity of the given IFC Step file content against
     * the referred mvdXMLdefinition. Provides a BCF file as result.
     * 
     * Supported mvdXML versions are V1.1. V1-1 and v1.2 draft 3.
     *
     * @param mvdXMLfile The mvdXML file
     * @param ifcFile    The IFC STEP file
     * @return the BCF ZIP file result of the validation
     */
    @POST
    @Path("/check")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response check(@FormDataParam("mvdXMLfile") InputStream mvdXMLfile, @FormDataParam("ifcFile") InputStream ifcFile) {
	MvdXMLCheckerResultsReportBean issueReportBean = new MvdXMLCheckerResultsReportBean();
	File tempBCFZipFile = null;
	try {
	    File tempIfcFile = File.createTempFile("ifcChecker-", ".ifc");
	    tempIfcFile.deleteOnExit();

	    Files.copy(ifcFile, tempIfcFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    IOUtils.closeQuietly(ifcFile);

	    File tempMvdxmlFile = File.createTempFile("ifcChecker-", ".mvdxml");
	    tempMvdxmlFile.deleteOnExit();

	    Files.copy(mvdXMLfile, tempMvdxmlFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    IOUtils.closeQuietly(mvdXMLfile);

	    try {

		tempBCFZipFile = execute_check(tempBCFZipFile, tempIfcFile, tempMvdxmlFile);
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	    final File final_BCFZipFile = tempBCFZipFile;
	    /*
	     * StreamingOutput fileStream = new StreamingOutput() {
	     * 
	     * @Override public void write(java.io.OutputStream output) throws IOException,
	     * WebApplicationException { try { byte[] data =
	     * Files.readAllBytes(final_BCFZipFile.toPath()); output.write(data);
	     * output.flush(); } catch (Exception e) { throw new
	     * WebApplicationException("File Not Found !!"); } } };
	     */

	    ResponseBuilder response = Response.ok((Object) final_BCFZipFile);
	    response.header("Content-Disposition", "attachment; filename=\"result.bcfzip\"");
	    return response.build();
	} catch (Exception e) {
	    e.printStackTrace();
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	}

	return Response.noContent().build();
    }

    private File execute_check(File tempBCFZipFile, File tempIfcFile, File tempMvdxmlFile) throws Exception {
	MvdXMLChecker checker = MvdXMLCheckerFactory.forFile(tempMvdxmlFile.toPath());
	IssueReport issuereport = checker.check(tempIfcFile.toPath(), tempMvdxmlFile.toPath());
	if (issuereport != null) {
	    tempBCFZipFile = File.createTempFile("mvdXMLCheckResult", ".bcfzip");
	    tempBCFZipFile.deleteOnExit();
	    issuereport.writeReport(tempBCFZipFile.getAbsolutePath().toString());
	}
	return tempBCFZipFile;
    }

    private String messageForVersion(String version) {
	if ("1.1".equals(version))
	    return "a valid mvdXML 1.1 file";
	if ("1.2".equals(version))
	    return "a mvdXML 1.2 file";
	if ("1_1".equals(version))
	    return "a mvdXML 1_1 file";
	return "Error: Unknown mvdXML version";
    }

}
