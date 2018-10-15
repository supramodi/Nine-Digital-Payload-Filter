package com.nine.segment.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.nine.segment.data.ResponsePayload;

/**
 * Service class to process/filter/create request/response payloads.
 *
 */
public class PayloadService {

	/**
	 * Process the jason request and filter the objects.
	 * 
	 * @param request
	 * @return
	 * @throws JSONException
	 */
	public List<ResponsePayload> processAndFilterRequestPayload(String request) throws JSONException {
		List<ResponsePayload> objectList = new ArrayList<ResponsePayload>();
		JSONObject obj = new JSONObject(request.toString());
		// get Array type
		JSONArray results = obj.getJSONArray("payload");
		// under payload, get the array elements (shows)
		for (int i = 0; i < results.length(); i++) {
			JSONObject showObject = results.getJSONObject(i);
			if (showObject.has("drm")) {
				boolean drm = showObject.getBoolean("drm");
				int episodeCount = showObject.getInt("episodeCount");
				if (true == drm && episodeCount > 0) {
					/* No mapper being used as simple JSONObject processing with a single level of
					 * sub element*/
					JSONObject showImage = showObject.getJSONObject("image");
					ResponsePayload responseObject = new ResponsePayload();
					responseObject.setSlug(showObject.getString("slug"));
					responseObject.setTitle(showObject.getString("title"));
					responseObject.setImage(showImage.getString("showImage"));
					objectList.add(responseObject);
				}
			}
		}
		return objectList;
	}

	/**
	 * Populate json response.
	 * @param filteredObjectList
	 * @return
	 * @throws JSONException
	 */
	public JSONObject populateResponsePayload(List<ResponsePayload> filteredObjectList) throws JSONException {
		JSONObject outputObject = new JSONObject();
		JSONArray responseArray = new JSONArray();
		/*Simple java bean to jsonobject mapping*/
		for (int j = 0; j < filteredObjectList.size(); j++) {
			JSONObject jsonResObject = new JSONObject();
			ResponsePayload responseObject = filteredObjectList.get(j);
			jsonResObject.put("image", responseObject.getImage());
			jsonResObject.put("slug", responseObject.getSlug());
			jsonResObject.put("title", responseObject.getTitle());
			responseArray.put(j, jsonResObject);
		}
		outputObject.put("response", responseArray);
		return outputObject;
	}

}
