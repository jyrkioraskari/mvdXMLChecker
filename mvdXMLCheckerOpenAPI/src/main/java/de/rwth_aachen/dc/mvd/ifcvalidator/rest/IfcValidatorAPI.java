package de.rwth_aachen.dc.mvd.ifcvalidator.rest;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import de.rwth_aachen.dc.mvd.ifcvalidator.db.MvdXMLFileHandle;
import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.MVDCheck_BOTServiceDescriotor;
import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.MvdXMLFileHandleList;
import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.ResponseBean;
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

    /**
     * 
     * 
     * A HTTP GET interface to test the REST API connection.
     * 
     * @return Hello from IfcValidator! It works.
     */
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
	return "Hello from IfcValidatorAPI! It works. ";
    }

    /**
     * 
     * 
     * A HTTP GET Interface to return the BOT service descriptor for the service
     * 
     * @return Service list
     */
    @GET
    @Path("/servicelist")
    @Produces(MediaType.APPLICATION_JSON)
    public MVDCheck_BOTServiceDescriotor servicelist() {

	return new MVDCheck_BOTServiceDescriotor();
    }

    /**
     * The Bot interface definition service list
     * 
     * @return human readable list of the services at the system
     */
    @GET
    @Path("/servicelist")
    @Produces(MediaType.TEXT_PLAIN)
    public String servicelist_plain() {

	return "list";
    }

    /**
     * Saves the mvd 1.1 definition to the server for a later usage
     * 
     * @param mvdxmlContent The xml content of a mvdXML file as a string
     * @return Retuns the Id number of the file in the system. -1 if not succeed.
     */

    @POST
    @Path("/mvdxml")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseBean register_mvdxml_json(String mvdxmlContent) {
	ResponseBean responseBean = new ResponseBean();
	System.out.println("mvdxml content: \n" + mvdxmlContent);

	try {
	    File tempFile = File.createTempFile("MvdXML-", ".xml");
	    FileOutputStream fos = new FileOutputStream(tempFile.getAbsolutePath());
	    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
	    outStream.writeUTF(mvdxmlContent);
	    outStream.close();

	    MvdXMLFileHandle mvdXMLFile  = new MvdXMLFileHandle(tempFile.getAbsolutePath());
	    Transaction transaction = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		transaction = session.beginTransaction();
		Serializable id=session.save(mvdXMLFile);
		responseBean.setMessage("ID was:"+id.toString());
		responseBean.setResult(id.toString());
		transaction.commit();
	    } catch (Exception e) {
		if (transaction != null) {
		    transaction.rollback();
		}
		e.printStackTrace();
		responseBean.setCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		responseBean.setMessage("Error: "+e.getMessage());
		responseBean.setResult("-1");
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return responseBean;
    }

    /**
     * Lists the mvd 1.1 definition files in the server
     * 
     * @return Retuns the mvdXML files in the server
     */

    @GET
    @Path("/mvdxml")
    @Produces(MediaType.APPLICATION_JSON)
    public MvdXMLFileHandleList list_mvdxml_json() {
	final MvdXMLFileHandleList list = new MvdXMLFileHandleList();
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    List<MvdXMLFileHandle> mvdXMLFiles = session.createQuery("from MvdXMLFileHandle", MvdXMLFileHandle.class).list();
	    mvdXMLFiles.forEach(f -> list.append(f));
	} catch (Exception e) {

	    e.printStackTrace();
	}
	return list;
    }

    /**
     * Lists the mvd 1.1 definition files in the server
     * 
     * @return Retuns the mvdXML files in the server
     */

    @GET
    @Path("/mvdxml")
    @Produces(MediaType.TEXT_PLAIN)
    public String list_mvdxml_plain() {
	final StringBuilder sb = new StringBuilder();
	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	    List<MvdXMLFileHandle> mvdXMLFiles = session.createQuery("from MvdXMLFileHandle", MvdXMLFileHandle.class).list();
	    mvdXMLFiles.forEach(s -> sb.append(s.getFile_path() + "\n"));
	} catch (Exception e) {

	    e.printStackTrace();
	}
	return sb.toString();
    }

    /**
     * Checks the validity the validity of the given IFC Step file content against
     * the referred mvdXML 1.1 definition
     * 
     * @param mvdxmlid       The reference Id foe the mvdXML file that has been
     *                       saved to the server earlier
     * @param ifcStepContent The IFC STEP file as a string
     * @return JSON Result of the validation
     */

    @POST
    @Path("/check/{mvdxmlid}")
    @Consumes("application/ifc")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseBean check_withsSecifiedMvcxml(@PathParam("mvdxmlid") String mvdxmlid, String ifcStepContent) {
	System.out.println("ifc content: \n" + ifcStepContent);
	try {
	    File tempFile = File.createTempFile("ifcChecker-", ".ifc");
	    FileOutputStream fos = new FileOutputStream(tempFile.getAbsolutePath());
	    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
	    outStream.writeUTF(ifcStepContent);
	    outStream.close();

	} catch (IOException e) {
	    e.printStackTrace();
	}
	ResponseBean responseBean = new ResponseBean();
	return responseBean;
    }

}