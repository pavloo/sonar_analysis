package com.example_osadchyi;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * User: paul
 * Date: 4/25/13
 * Time: 11:51 PM
  */

@Path("/sayhello/{yourname}")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class HelloWorldREST {

    @GET
    public Response sayHello(@PathParam("yourname") String name){
        Map<String, String> responseContent = new HashMap<String, String>();
        responseContent.put("Reply", "Hello, " + name);
        return Response.status(200).entity(responseContent).build();
    }
}
