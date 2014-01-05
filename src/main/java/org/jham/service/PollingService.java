package org.jham.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jham.transferobjects.GarageDoorEnum;
import org.jham.transferobjects.PollResults;

@Path("/poll")
public class PollingService {

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/{clientIdentifier}")
	public PollResults pollForInstructions(@PathParam("clientIdentifier") String clientId) {
		PollResults results = new PollResults();
		
		results.setDoorStatus(GarageDoorEnum.DOWN);
		
		return results;
	}
}
