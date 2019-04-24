package com.example.SpringBootDemo.beans;

import org.springframework.beans.factory.annotation.Value;

public class HelloBean {

	@Value("Default Bean Message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
