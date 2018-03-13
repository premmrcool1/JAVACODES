package org.prem.rest.resttest.Message;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.prem.rest.resttest.Model.*;
import org.prem.rest.resttest.service.*;

@Path("/Message")
public class MessageResource {
	
	Messageservice messageservice = new Messageservice();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages()
	{
		return messageservice.getAllMessages();
		
	}

	
	@GET
	@Path("/{messageid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(@PathParam("messageid") String messageid)
	{
		return "Got Path Param" + messageid;
		
	}
}
