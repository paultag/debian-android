package org.anized.deapi;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class DeAPIService {
	private static final String USER_AGENET = "DeAPIService Consumer (Debian App)";
	
	private String serviceRoot;
	private String service;
	
	public DeAPIService(String root, String service) {
		this.serviceRoot = root;
		this.service = service;
	}
	
	public String fetchJSON(String url) throws DeAPIException {
		HttpGet request = new HttpGet(url);
		request.addHeader("User-Agent", DeAPIService.USER_AGENET);
        DefaultHttpClient client = new DefaultHttpClient();
        
        try {
	        HttpResponse response = client.execute(request);
	        int statusCode = response.getStatusLine().getStatusCode();

	        if (statusCode == HttpStatus.SC_OK) {
	        	String body = EntityUtils.toString(response.getEntity());
	        	return body;
	        } else {
	        	throw new DeAPIException("Bad status code on fetching thing");
	        }
        } catch (Exception e) {
	    	throw new DeAPIException(e);
	    }
	}
	
	public JSONObject getObj(String url) throws JSONException, DeAPIException {
		return new JSONObject(this.fetchJSON(url));
	}
	
	public JSONObject request(String method, List<String> args) throws DeAPIException {
		String url = this.serviceRoot + "/" + this.service;
		
		url += "/" + method;
		for ( String s : args ) {
			url += "/" + s;
		}
		Log.d("debian", url);
		try {
			JSONObject obj = this.getObj(url);
			if ( ! obj.getBoolean("ok") ) {
				throw new DeAPIException("Invalid request - got a nokay");
			}
			return obj;
		} catch (JSONException e) {
			throw new DeAPIException(e);
		}
	}
}
