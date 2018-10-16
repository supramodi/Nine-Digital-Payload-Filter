package com.nine.segment.resource.test;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.nine.segment.resource.PayloadResource;

public class PayloadResourceTest {
	
	    public static PayloadResource payloadResource = new PayloadResource();
	    
	    @Test
	    public void healthCheck() throws Exception {
	    	String response = payloadResource.healthCheck();
	        assertEquals("Web Service Up and Running... Health check successful.", response);
	    }
	    
	    @Test
	    public void postPositiveScenario() throws Exception {
	        Response response = payloadResource.getPayload("{\r\n" + 
	        		"  \"payload\": [\r\n" + 
	        		"    {\r\n" + 
	        		"      \"country\": \"UK\",\r\n" + 
	        		"      \"description\": \"What's life like when you have enough children to field your own football team?\",\r\n" + 
	        		"      \"drm\": true,\r\n" + 
	        		"      \"episodeCount\": 3,\r\n" + 
	        		"      \"genre\": \"Reality\",\r\n" + 
	        		"      \"image\": {\r\n" + 
	        		"        \"showImage\": \"http://mybeautifulcatchupservice.com/img/shows/16KidsandCounting1280.jpg\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"language\": \"English\",\r\n" + 
	        		"      \"nextEpisode\": null,\r\n" + 
	        		"      \"primaryColour\": \"#ff7800\",\r\n" + 
	        		"      \"seasons\": [\r\n" + 
	        		"        {\r\n" + 
	        		"          \"slug\": \"show/16kidsandcounting/season/1\"\r\n" + 
	        		"        }\r\n" + 
	        		"      ],\r\n" + 
	        		"      \"slug\": \"show/16kidsandcounting\",\r\n" + 
	        		"      \"title\": \"16 Kids and Counting\",\r\n" + 
	        		"      \"tvChannel\": \"GEM\"\r\n" + 
	        		"    }\r\n" + 
	        		"  ]\r\n" + 
	        		"}");
	        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
	    }
	    
	    @Test
	    public void postNegativeScenario() throws Exception {
	        Response response = payloadResource.getPayload("{\r\n" + 
	        		"  \"payloadtest\": [\r\n" + 
	        		"    {\r\n" + 
	        		"      \"country\": \"UK\",\r\n" + 
	        		"      \"description\": \"What's life like when you have enough children to field your own football team?\",\r\n" + 
	        		"      \"drm\": true,\r\n" + 
	        		"      \"episodeCount\": 3,\r\n" + 
	        		"      \"genre\": \"Reality\",\r\n" + 
	        		"      \"image\": {\r\n" + 
	        		"        \"showImage\": \"http://mybeautifulcatchupservice.com/img/shows/16KidsandCounting1280.jpg\"\r\n" + 
	        		"      },\r\n" + 
	        		"      \"language\": \"English\",\r\n" + 
	        		"      \"nextEpisode\": null,\r\n" + 
	        		"      \"primaryColour\": \"#ff7800\",\r\n" + 
	        		"      \"seasons\": [\r\n" + 
	        		"        {\r\n" + 
	        		"          \"slug\": \"show/16kidsandcounting/season/1\"\r\n" + 
	        		"        }\r\n" + 
	        		"      ],\r\n" + 
	        		"      \"slug\": \"show/16kidsandcounting\",\r\n" + 
	        		"      \"title\": \"16 Kids and Counting\",\r\n" + 
	        		"      \"tvChannel\": \"GEM\"\r\n" + 
	        		"    }\r\n" + 
	        		"  ]\r\n" + 
	        		"}");
	        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
	    }
	

}
