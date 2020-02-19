package de.rwth_aachen.dc.mvd.ifcvalidator.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class IfcValidator {

    @GET
    @Path("/hello")
    public String hello()
    {
         return "Hello from IfcValidator! It works. ";
    }

}