package com.circle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.circle.client.Circle;
import com.circle.client.ClientService;
import com.circle.model.Square;

@ManagedBean 
@RequestScoped 
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	private Circle circle;
	private Square square;
	
	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public String login() {
		setCircle(ClientService.getJsonCircle(name));
		String s = ClientService.createJsonCircleApi(getCircle());
		System.out.println(s);
		setSquare(ClientService.getJsonSquare(name));
		return "welcome";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}
}
