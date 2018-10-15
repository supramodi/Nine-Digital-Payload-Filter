package com.nine.segment.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONException;
import org.json.JSONObject;

import com.nine.segment.data.ResponsePayload;
import com.nine.segment.service.PayloadService;

/**
 * Root resource (exposed at "payload" path)
 */
@Path("payload")
public class PayloadResource {

	PayloadService payloadService = new PayloadService();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.Serves as the health end point for the web service.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Web Service Up and Running... Health check successful.";
	}
	
	/**
	 * Method handling HTTP POST requests. The returned object will be sent to the
	 * client as "application/json" media type.
	 * @param requestPayload, inbound request payload as a String
	 * @return Response object that will be returned as a application/json response.
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPayload(String requestPayload) {
		JSONObject errorObject = new JSONObject();
		try {
			errorObject.put("error", "Could not decode request: JSON parsing failed");
			
			/*process the request and filter the list of json objects with 
			 * DRM enabled (drm: true) and at least one episode (episodeCount > 0). */
			List<ResponsePayload> filteredObjectList = payloadService.processAndFilterRequestPayload(requestPayload.toString());
			
			/*populate the response json(array)  */
			JSONObject responseObject = payloadService.populateResponsePayload(filteredObjectList);
			
			/*to make response generic across error/success scenarios, return the Response with
			 * relevant body */
			return Response.status(Status.OK).entity(responseObject.toString()).build();
		} catch (JSONException e1) {
			e1.printStackTrace();
			/* Error occurred. eg: invalid json request */
			return Response.status(Status.BAD_REQUEST).entity(errorObject.toString()).build();
		}
	}

}
