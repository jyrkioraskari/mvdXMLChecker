package de.rwth_aachen.dc.mvd.ifcvalidator.rest;

import java.io.IOException;
import java.nio.file.Files;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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

    @GET
    @Path("/check")
    public ResponseBean check(@QueryParam("ifcFileURL") String ifcFileURL,@QueryParam("mvdXMLURL") String mvdXMLURL) {
	ResponseBean responseBean = new ResponseBean();
	return responseBean;
    }
    
    @POST
    @Path("/check")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
    public ResponseBean check(IfcCheckRequest request) {
	ResponseBean responseBean = new ResponseBean();
	return responseBean;

    }
    
 
}