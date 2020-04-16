package de.rwth_aachen.dc.mvd.ifcvalidator.rest;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.MVDCheck_BOTServiceDescriotor;

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
     * /api/hello
     * 
     * A HTTP GET interface to test REST API connection.
     * 
     * @return "Hello from IfcValidator! It works. "
     */
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
	return "Hello from IfcValidatorAPI! It works. ";
    }
    
    
    
    /**
     * /api/serviceist
     * 
     * A HTTP GET Interface to return the BOT service descriptor for the service
     * 
     * @return "Hello from IfcValidator! It works. "
     */
    @GET
    @Path("/servicelist")
    @Produces(MediaType.APPLICATION_JSON)
    public MVDCheck_BOTServiceDescriotor servicelist() {
	
	return new MVDCheck_BOTServiceDescriotor();
    }
    
    @GET
    @Path("/servicelist")
    @Produces(MediaType.TEXT_PLAIN)
    public String servicelist_plain() {
	
	return "list";
    }

    
    /**
     * /api/serviceist
     * 
     * A HTTP GET Interface to return the BOT service descriptor for the service
     * 
     * @return "Result of the upload operation. "
     */
    @POST
    @Path("/mvdxml/{mvdxmlid}")
    @Consumes(MediaType.APPLICATION_ATOM_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseBean register_mvdxml_json(@PathParam("mvdxmlid") String mvdxmlid,String mvdxmlContent) {
	System.out.println("mvdxml content: \n"+mvdxmlContent);
	ResponseBean responseBean = new ResponseBean();
	
	try {
	    File tempFile = File.createTempFile("MvdXML-", ".xml");
	    FileOutputStream fos = new FileOutputStream(tempFile.getAbsolutePath());
	    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
	    outStream.writeUTF(mvdxmlContent);
	    outStream.close();
	    
	    
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return responseBean;
    }
    

    /**
     * NOT Implemented yet
     * mvdXML Checker 1.1
     * 
     * @param ifc The IFC file as a body
     * @return JSON Result of the validation
     */
    
    @POST
    @Path("/check/{mvdxmlid}")
    @Consumes("application/ifc")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseBean check_withsSecifiedMvcxml_json(@PathParam("mvdxmlid") String mvdxmlid,String ifcStepContent) {
	System.out.println("ifc content: \n"+ifcStepContent);
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
    
    
    /**
     * NOT Implemented yet
     * mvdXML Checker 1.1
     * 
     * Uses the system default mvdXML file 
     * @param ifc The IFC file as a body
     * @return JSON Result of the validation
     */
    
    @POST
    @Path("/check")
    @Consumes("application/ifc")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseBean check_json(String ifcStepContent) {
	System.out.println("ifc content: \n"+ifcStepContent);
	ResponseBean responseBean = new ResponseBean();
	try {
	    File tempFile = File.createTempFile("ifcChecker-", ".ifc");
	    FileOutputStream fos = new FileOutputStream(tempFile.getAbsolutePath());
	    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
	    outStream.writeUTF(ifcStepContent);
	    outStream.close();
	    
	    
	    
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return responseBean;
    }

}