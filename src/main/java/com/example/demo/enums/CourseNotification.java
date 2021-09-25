package com.example.demo.enums;

public enum CourseNotification {

	INPROGRESS("inprogress"),
	YETTOSTART("yettostart"),
	FINISHED("finished"),
	DELAYED("delayed"),
	CANCELLED("cancelled");
	
	private String value;
	
	CourseNotification(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
