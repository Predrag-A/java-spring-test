package com.example.SpringBootDemo.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloBeanDependent {

	@Autowired
	private HelloBean dependency;

	public String getDependencyMessage() {
		return dependency.getMessage();
	}

	public void setDependencyMessage(String dependency) {
		this.dependency.setMessage(dependency);
	}

}
