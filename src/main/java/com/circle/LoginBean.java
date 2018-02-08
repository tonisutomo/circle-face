package com.circle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.circle.client.Circle;
import com.circle.client.ClientService;

@ManagedBean @RequestScoped 
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	private Circle circle;
	
	public String login() {
		setCircle(ClientService.produceJSON(name));
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
