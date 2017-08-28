package app;

import java.io.StringReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RESTCaller {
	
	private static final String URLSUFFIX = "?locale=en_US&jsonp=true&apikey=b2g55e949nuw55syxbwppdcnmhcde87h";
	private static final String ITEMPREFIX = "https://us.api.battle.net/wow/item/";
	
	public static String RESTCall(String id) {
		String result = null;
		try {
			Client client = Client.create();
			
	
			WebResource webResource = client
			   .resource(ITEMPREFIX + id + URLSUFFIX);
			
			ClientResponse response = webResource.accept("application/json")
	                .get(ClientResponse.class);
			
			if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}
			
			String output = response.getEntity(String.class);
			
			String jsonString = output.substring(output.indexOf("(")+1, output.indexOf(")"));
			result = jsonString;
		}
		catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}
	
	public static void main(String[] args) {
		String json = RESTCall("140806");
	}
}
