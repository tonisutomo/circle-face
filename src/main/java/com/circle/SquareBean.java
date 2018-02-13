package com.circle;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.circle.client.ClientService;
import com.circle.model.Square;

@ManagedBean
@RequestScoped
public class SquareBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Square square;
	
	@PostConstruct
	public void init() {
		square = new Square();
		square.setName("Namae");
		square.setColor("Warnae");
	}
	
	public String submit() {
		System.out.println(square.getName());
		System.out.println(square.getColor());
		String s = ClientService.createJsonSquare(getSquare());
		System.out.println(s);
		return "welcome?faces-redirect=true";
	}
	
	public Square getSquare() {
		return square;
	}

	public void setSquare(Square square) {
		this.square = square;
	}
}