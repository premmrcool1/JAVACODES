package org.prem.example;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("books")
public class PostMethodExample {
 
    @POST
    @Produces("MediaType.TEXT_PLAIN")
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public Response getAllBooks(@PathParam("id") String bookId){
    return Response.status(200)
               .entity("Book id is : " + 1).build();
    }
     
}