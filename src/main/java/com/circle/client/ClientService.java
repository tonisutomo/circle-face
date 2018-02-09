package com.circle.client;

import javax.ws.rs.core.Response;

import com.circle.model.Square;

public class ClientService {

	private static RestClient client = new RestClient();
	
    public static Circle getJsonCircleApi(String name ) {
    		Circle circle = client.getJsonCircleApi(name);
        return circle;
    }	
    
    public static String createJsonCircleApi(Circle circle) {
		Response response = client.createJsonCircleApi(circle);
		return "Status " + response.getStatus() + response.readEntity(String.class); 
    }	

    public static Circle getJsonCircle(String name ) {
		Circle circle = client.getJsonCircle(name);
		return circle;
    }	

    public static Square getJsonSquare(String name ) {
		Square square = client.getJsonSquare(name);
		return square;
    }
}
