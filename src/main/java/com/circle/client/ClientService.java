package com.circle.client;

public class ClientService {

	private static RestClient client = new RestClient();
	
    public static Circle produceJSON(String name ) {
    		Circle circle = client.getJsonCircle(name);
        return circle;
    }	
    
}
