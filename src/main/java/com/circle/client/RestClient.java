package com.circle.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.circle.model.Square;


public class RestClient {
	
	private static final String REST_URI_API = "http://localhost:8080/circle-api/rest/circle";
	private static final String REST_URI_SERVER = "http://localhost:9090/circle-server";
    private Client client = ClientBuilder.newClient();

    public Response createJsonCircleApi(Circle circle) {
        return client.target(REST_URI_API).request(MediaType.APPLICATION_JSON).post(Entity.entity(circle, MediaType.APPLICATION_JSON));
    }

    public Circle getJsonCircleApi(String name) {
    		return client.target(REST_URI_API).path(name).request(MediaType.APPLICATION_JSON).get(Circle.class);
    }
        
    public Response createJsonCircle(Circle circle) {
        return client.target(REST_URI_SERVER).request(MediaType.APPLICATION_JSON).post(Entity.entity(circle, MediaType.APPLICATION_JSON));
    }

    public Response createJsonSquare(Square square) {
        return client.target(REST_URI_SERVER).path("square").path("simpan").request(MediaType.APPLICATION_JSON).post(Entity.entity(square, MediaType.APPLICATION_JSON));
    }

    public Circle getJsonCircle(String name) {
		return client.target(REST_URI_SERVER).path("circle").path("login").queryParam("name", name).request(MediaType.APPLICATION_JSON).get(Circle.class);
    }

    public Square getJsonSquare(String name) {
		return client.target(REST_URI_SERVER).path("square").path("search").queryParam("name", name).request(MediaType.APPLICATION_JSON).get(Square.class);
    }

    public Circle getJsonCircleX(String name) {
        Circle circle = new Circle();
        
        WebTarget webTarget = client.target(REST_URI_SERVER);
        //webTarget.register(FilterForExampleCom.class);
        WebTarget resourceWebTarget = webTarget.path("circle");
        WebTarget loginWebTarget = resourceWebTarget.path("login");
        WebTarget loginWebTargetWithQueryParam =
                loginWebTarget.queryParam("name", name);
         
        Invocation.Builder invocationBuilder =
                loginWebTargetWithQueryParam.request(MediaType.APPLICATION_JSON);
        //invocationBuilder.header("some-header", "true");
         
        Response response = invocationBuilder.get();
//        System.out.println(response.getStatus());
//        System.out.println(response.readEntity(String.class));

        if (response.getStatus() == 200) {
        		StringReader stringReader = new StringReader(invocationBuilder.get(String.class));
        		try {
        			JsonReader jsonReader = Json.createReader(stringReader);        			   
        			JsonObject jo = jsonReader.readObject();
//        	   	JsonObject addrObj = jo.getJsonObject("address");
        			circle.setFirstName(jo.getString("firstName"));
        			circle.setLastName(jo.getString("lastName"));
            } catch(Exception e) {
        			e.printStackTrace();
        		}
        }
        
        return circle;
    }
    
}
