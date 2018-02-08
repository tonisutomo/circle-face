package com.circle.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
	
	private static final String REST_URI = "http://localhost:8080/circle-api/rest/circle";
    private Client client = ClientBuilder.newClient();

    public Response createJsonCircle(Circle emp) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(emp, MediaType.APPLICATION_JSON));
    }

    public Circle getJsonCircle(String name) {
        return client.target(REST_URI).path(name).request(MediaType.APPLICATION_JSON).get(Circle.class);
    }
}
