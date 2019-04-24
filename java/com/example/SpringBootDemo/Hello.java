package com.example.SpringBootDemo;

import org.springframework.beans.factory.annotation.Value;

public class Hello {

	@Value("Default Value")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
