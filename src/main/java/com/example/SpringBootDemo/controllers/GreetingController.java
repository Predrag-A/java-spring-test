package com.example.SpringBootDemo.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBootDemo.beans.BeanConfig;
import com.example.SpringBootDemo.beans.HelloBeanDependent;

@Controller
public class GreetingController {

	// Request Mapping that returns String, has Model in parameter
	@RequestMapping({ "/", "/hello" })
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			@RequestParam(name = "num", required = false, defaultValue = "1") String num, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("num", num);
		return "hello";
	}

	// Request Mapping that returns ModelAndView object, no parameters
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		// Using annotation config to get bean
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		HelloBeanDependent hello = ctx.getBean(HelloBeanDependent.class);

		return new ModelAndView("welcome", "message", hello.getDependencyMessage());
	}

	// Testing localization
	@GetMapping("/international")
	public String international() {
		return "international";
	}
}
