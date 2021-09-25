package com.example.demo.enums;

public enum Status {

	FAILED("failed"),
	SUCCESS("success"),
	PENDING("pending");
	
	private String value;
	
	Status(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
