package com.my.rest.model;

public class Pojo {

	int id;
	String value;

	public Pojo() {
		
	}

	public Pojo(int id, String value) {
		this.id = id;
		this.value= value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getID() {
		return id;
	}

	public void setID(int num) {
		this.id = num;
	}
	
	
}
