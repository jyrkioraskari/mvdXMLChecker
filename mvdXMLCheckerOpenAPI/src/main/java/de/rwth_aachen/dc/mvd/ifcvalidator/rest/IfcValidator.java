package de.rwth_aachen.dc.mvd.ifcvalidator.rest;

import java.io.IOException;
import java.nio.file.Files;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.rwth_aachen.dc.mvd.ifcvalidator.rest.beans.MVDCheck_BOTServiceDescriotor;

@Path("/")
public class IfcValidator {

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
    public String hello() {
	return "Hello from IfcValidator! It works. ";
    }
    
    
    /**
     * /api/serviceist
     * 
     * A HTTP GET Interface to return the BOT service descriptor for the service
     * 
     * @return "Hello from IfcValidator! It works. "
     */
    @GET
    @Path("/serviceist")
    @Produces(MediaType.APPLICATION_JSON)
    public MVDCheck_BOTServiceDescriotor servicelist() {
	
	return new MVDCheck_BOTServiceDescriotor();
    }

    /**
     * NOT Implemented yet
     * 
     * @param ifc The IFC file as a body
     * @return JSON Result of the validation
     */
    
    @POST
    @Path("/check")
    @Consumes("application/ifc")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseBean check(String ifc) {
	ResponseBean responseBean = new ResponseBean();
	return responseBean;
    }
    
 
}