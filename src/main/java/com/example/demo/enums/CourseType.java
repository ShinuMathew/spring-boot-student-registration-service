package com.example.demo.enums;

public enum CourseType {

	FRONTEND_DEVELOPMENT("frontend_development"), 
	BACKEND_DEVELOPMENT("backend_development"), 
	FULLSTACK_DEVELOPMENT("fullstack_development"), 
	DEVOPS("devops"), 
	AUTOMATION("automation"), 
	PERFORMANCE("performance"), 
	MACHINE_LEARNING("machine_learning");
	
	private String value;
	
	CourseType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
