package de.rwth_aachen.dc.mvd.ifcvalidator.rest;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.JAXBException;

import org.apache.commons.io.IOUtils;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.google.common.eventbus.Subscribe;

import de.rwth_aachen.dc.mvd.IssueReport;
import de.rwth_aachen.dc.mvd.MvdXMLVersionCheck;
import de.rwth_aachen.dc.mvd.events.CheckerErrorEvent;
import de.rwth_aachen.dc.mvd.events.CheckerInfoEvent;
import de.rwth_aachen.dc.mvd.events.CheckerNotificationEvent;
import de.rwth_aachen.dc.mvd.ifcvalidator.db.MvdXMLFileHandle;
import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.IssueReportBean;
import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.MVDCheck_BOTServiceDescriotor;
import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.MvdXMLFileHandleList;
import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.ResponseBean;
import de.rwth_aachen.dc.mvd.mvdxml1dot1.checker.MvdXMLv1dot1Check;
import de.rwth_aachen.dc.mvd.mvdxml1dot2.checker.MvdXMLv1dot2Check;
import de.rwth_aachen.dc.mvd.mvdxml1underscore1.checker.MvdXMLv1undescore1Check;
import fi.aalto.drumbeat.DrumbeatUserManager.events.EventBusCommunication;
import net.javaguides.hibernate.util.HibernateUtil;

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

//    
//    /**
//     * 
//     * 
//     * A HTTP GET interface to test the REST API connection.
//     * 
//     * @return Hello from IfcValidator! It works.
//     */
//    @GET
//    @Path("/hello")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String hello() {
//	return "Hello from IfcValidatorAPI! It works. ";
//    }
//
//    /**
//     * 
//     * 
//     * A HTTP GET Interface to return the BOT service descriptor for the service
//     * 
//     * @return Service list
//     */
//    @GET
//    @Path("/servicelist")
//    @Produces(MediaType.APPLICATION_JSON)
//    public MVDCheck_BOTServiceDescriotor servicelist() {
//
//	return new MVDCheck_BOTServiceDescriotor();
//    }
//
//    /**
//     * The Bot interface definition service list
//     * 
//     * @return human readable list of the services at the system
//     */
//    @GET
//    @Path("/servicelist")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String servicelist_plain() {
//
//	return "list";
//    }
//
//    /**
//     * Saves the mvd 1.1 definition to the server for a later usage
//     * 
//     * @param mvdXMLfile mvdXML file as a string
//     * @return Returns the Id number of the file in the system. -1 if not succeed.
//     */
//
//    @POST
//    @Path("/mvdxml")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @Produces(MediaType.APPLICATION_JSON)
//    public ResponseBean register_mvdxml__InputAsXMLFile(@FormDataParam("mvdXMLfile") InputStream mvdXMLfile) {
//	ResponseBean responseBean = new ResponseBean();
//	try {
//	    File tempMvdxmlFile = File.createTempFile("ifcChecker-", ".mvdxml");
//	    tempMvdxmlFile.deleteOnExit();
//
//	    Files.copy(mvdXMLfile, tempMvdxmlFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//	    IOUtils.closeQuietly(mvdXMLfile);
//	    MvdXMLFileHandle mvdXMLFile = new MvdXMLFileHandle(tempMvdxmlFile.getAbsolutePath());
//	    Transaction transaction = null;
//	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//		transaction = session.beginTransaction();
//		Serializable id = session.save(mvdXMLFile);
//		responseBean.setMessage("ID was:" + id.toString());
//		responseBean.setResult(id.toString());
//		transaction.commit();
//	    } catch (Exception e) {
//		if (transaction != null) {
//		    transaction.rollback();
//		}
//		e.printStackTrace();
//		responseBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//		responseBean.setMessage("Error: " + e.getMessage());
//		responseBean.setResult("-1");
//	    }
//	} catch (IOException e) {
//	    e.printStackTrace();
//	}
//	return responseBean;
//    }
//
//    /**
//     * Lists the mvd 1.1 definition files in the server
//     * 
//     * @return Retuns the mvdXML files in the server
//     */
//
//    @GET
//    @Path("/mvdxml")
//    @Produces(MediaType.APPLICATION_JSON)
//    public MvdXMLFileHandleList list_mvdxml_json() {
//	final MvdXMLFileHandleList mvdlist = new MvdXMLFileHandleList();
//	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//	    List<MvdXMLFileHandle> mvdXMLFiles = session.createQuery("from MvdXMLFileHandle", MvdXMLFileHandle.class).list();
//	    mvdXMLFiles.forEach(f -> mvdlist.append(f));
//	} catch (Exception e) {
//	    e.printStackTrace();
//	    mvdlist.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//	    mvdlist.setMessage("Error: " + e.getMessage());
//	}
//	return mvdlist;
//    }
//
//    /**
//     * Lists the mvd 1.1 definition files in the server
//     * 
//     * @return Retuns the mvdXML files in the server
//     */
//
//    @GET
//    @Path("/mvdxml")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String list_mvdxml_plain() {
//	final StringBuilder sb = new StringBuilder();
//	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//	    List<MvdXMLFileHandle> mvdXMLFiles = session.createQuery("from MvdXMLFileHandle", MvdXMLFileHandle.class).list();
//	    mvdXMLFiles.forEach(s -> sb.append(s.getFile_path() + "\n"));
//	} catch (Exception e) {
//
//	    e.printStackTrace();
//	}
//	return sb.toString();
//    }
//
//    /**
//     * Checks the validity the validity of the given IFC Step file content against
//     * the referred mvdXML. Provides a JSON result.
//     * 
//     * Supported mvdXML versions are V1.1. V1-1 and v1.2 draft 3. 
//     * 
//     * @param mvdxmlid       The reference Id for the mvdXML file that has been
//     *                       saved to the server earlier
//     * @param ifcStepContent The IFC STEP file
//     * @return JSON result of the validation
//     */
//
//    @POST
//    @Path("/check_plain/{mvdxmlid}")
//    @Consumes("application/ifc")
//    @Produces(MediaType.APPLICATION_JSON)
//    public IssueReportBean check_withsSecifiedMvcxml_inputAsApplicationIFC_resultAsJSON(@PathParam("mvdxmlid") String mvdxmlid, String ifcStepContent) {
//	IssueReportBean issueReportBean = new IssueReportBean();
//	System.out.println("ifc content: \n" + ifcStepContent);
//	try {
//	    File tempIfcFile = File.createTempFile("ifcChecker-", ".ifc");
//	    tempIfcFile.deleteOnExit();
//	    FileOutputStream fos = new FileOutputStream(tempIfcFile.getAbsolutePath());
//	    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
//	    outStream.writeUTF(ifcStepContent);
//	    outStream.close();
//
//	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//		Integer id = Integer.parseInt(mvdxmlid);
//		MvdXMLFileHandle mvdXMLFileHandle = session.get(MvdXMLFileHandle.class, id);
//
//		check(issueReportBean, tempIfcFile, new File(mvdXMLFileHandle.getFile_path()));
//
//	    } catch (Exception e) {
//		e.printStackTrace();
//		issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//		issueReportBean.setMessage("Error: " + e.getMessage());
//	    }
//	} catch (IOException e) {
//	    e.printStackTrace();
//	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//	    issueReportBean.setMessage("Error: " + e.getMessage());
//	}
//
//	return issueReportBean;
//    }

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
    public IssueReportBean check_withsSecifiedMvcxml_inputAsIFCFile_resultAsJSON(@FormDataParam("mvdXMLfile") InputStream mvdXMLfile, @FormDataParam("ifcFile") InputStream ifcFile) {
	IssueReportBean issueReportBean = new IssueReportBean();
	try {
	    File tempIfcFile = File.createTempFile("ifcChecker-", ".ifc");
	    tempIfcFile.deleteOnExit();

	    Files.copy(ifcFile, tempIfcFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    IOUtils.closeQuietly(ifcFile);

	    File tempMvdxmlFile = File.createTempFile("ifcChecker-", ".mvdxml");
	    tempMvdxmlFile.deleteOnExit();

	    Files.copy(mvdXMLfile, tempMvdxmlFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    IOUtils.closeQuietly(mvdXMLfile);

	    check(issueReportBean, tempIfcFile, tempMvdxmlFile);

	} catch (Exception e) {
	    e.printStackTrace();
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	}

	return issueReportBean;
    }

    private void check(IssueReportBean issueReportBean, File tempIfcFile, File tempMvdxmlFile) throws JAXBException, DeserializeException, IOException, URISyntaxException, RenderEngineException {
	if (MvdXMLVersionCheck.checkMvdXMLSchemaVersion(tempMvdxmlFile.getAbsolutePath(), "http://buildingsmart-tech.org/mvd/XML/1.1")) {
	    // mvdXML 1.1
	    issueReportBean.setMessage("a valid mvdXML 1.1 file");
	    IssueReport issueReport = MvdXMLv1dot1Check.check(tempIfcFile.toPath(), tempMvdxmlFile.getAbsolutePath());
	    if (issueReport != null)
	    {
		issueReportBean.getIssues().addAll(issueReport.getIssues());
		issueReportBean.getGeneral_comments().addAll(issueReport.getGeneral_comments());
	    }

	} else
	// mvdXML 1.2
	if (MvdXMLVersionCheck.checkMvdXMLSchemaVersion(tempMvdxmlFile.getAbsolutePath(), "http://buildingsmart-tech.org/mvd/XML/1.2")) {
	    issueReportBean.setMessage("a mvdXML 1.2 file");
	    IssueReport issueReport = MvdXMLv1dot2Check.check(tempIfcFile.toPath(), tempMvdxmlFile.getAbsolutePath());
	    if (issueReport != null)
	    {
		issueReportBean.getIssues().addAll(issueReport.getIssues());
		issueReportBean.getGeneral_comments().addAll(issueReport.getGeneral_comments());
	    }
	} else {
	    // mvdXML 1_1
	    if (MvdXMLVersionCheck.checkMvdXMLSchemaVersion(tempMvdxmlFile.getAbsolutePath(), "http://buildingsmart-tech.org/mvdXML/mvdXML1-1")) {
		issueReportBean.setMessage("a mvdXML 1_1 file");
		IssueReport issueReport = MvdXMLv1undescore1Check.check(tempIfcFile.toPath(), tempMvdxmlFile.getAbsolutePath());
		if (issueReport != null)
		    {
			issueReportBean.getIssues().addAll(issueReport.getIssues());
			issueReportBean.getGeneral_comments().addAll(issueReport.getGeneral_comments());
		    }
	    } else
		issueReportBean.setMessage("Error: Unknown mvdXML version");
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
    public Response check_withsSecifiedMvcxml_inputAsIFCFile_resultAsBCF(@FormDataParam("mvdXMLfile") InputStream mvdXMLfile, @FormDataParam("ifcFile") InputStream ifcFile) {
	IssueReportBean issueReportBean = new IssueReportBean();
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

		// mvdXML 1.1
		if (MvdXMLVersionCheck.checkMvdXMLSchemaVersion(tempMvdxmlFile.getAbsolutePath(), "http://buildingsmart-tech.org/mvd/XML/1.1")) {
		    IssueReport issuereport = MvdXMLv1dot1Check.check(tempIfcFile.toPath(), tempMvdxmlFile.getAbsolutePath());

		    tempBCFZipFile = File.createTempFile("mvdXMLCheckResult", ".bcfzip");
		    tempBCFZipFile.deleteOnExit();
		    issuereport.writeReport(tempBCFZipFile.getAbsolutePath().toString());

		} else
		// mvdXML 1.2
		if (MvdXMLVersionCheck.checkMvdXMLSchemaVersion(tempMvdxmlFile.getAbsolutePath(), "http://buildingsmart-tech.org/mvd/XML/1.2")) {
		    IssueReport issuereport = MvdXMLv1dot2Check.check(tempIfcFile.toPath(), tempMvdxmlFile.getAbsolutePath());

		    tempBCFZipFile = File.createTempFile("mvdXMLCheckResult", ".bcfzip");
		    tempBCFZipFile.deleteOnExit();
		    issuereport.writeReport(tempBCFZipFile.getAbsolutePath().toString());

		} else {
		    // mvdXML 1_1
		    if (MvdXMLVersionCheck.checkMvdXMLSchemaVersion(tempMvdxmlFile.getAbsolutePath(), "http://buildingsmart-tech.org/mvdXML/mvdXML1-1")) {
			IssueReport issuereport = MvdXMLv1undescore1Check.check(tempIfcFile.toPath(), tempMvdxmlFile.getAbsolutePath());

			tempBCFZipFile = File.createTempFile("mvdXMLCheckResult", ".bcfzip");
			tempBCFZipFile.deleteOnExit();
			issuereport.writeReport(tempBCFZipFile.getAbsolutePath().toString());

		    }
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }

	    final File final_BCFZipFile = tempBCFZipFile;
	    StreamingOutput fileStream = new StreamingOutput() {
		@Override
		public void write(java.io.OutputStream output) throws IOException, WebApplicationException {
		    try {
			byte[] data = Files.readAllBytes(final_BCFZipFile.toPath());
			output.write(data);
			output.flush();
		    } catch (Exception e) {
			throw new WebApplicationException("File Not Found !!");
		    }
		}
	    };
	    return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM).header("content-disposition", "attachment; filename = result.bcfzip").build();
	} catch (Exception e) {
	    e.printStackTrace();
	    issueReportBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    issueReportBean.setMessage("Error: " + e.getMessage());
	}

	return Response.noContent().build();
    }

   
}