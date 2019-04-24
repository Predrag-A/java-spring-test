package com.example.SpringBootDemo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.SpringBootDemo.beans.BeanConfig;
import com.example.SpringBootDemo.classes.Greeting;
import com.example.SpringBootDemo.classes.Quote;

@RestController
public class RestExampleController {

	private static final String template = "Hello, %s, %s";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World", required = false) String name,
			@CookieValue(value = "hitCounter", defaultValue = "0") Long hitCounter, HttpServletResponse response) {

		// Cookie with value hitCounter is bound to Long hitCounter, defVal is when
		// request does not contain the cookie
		hitCounter++;
		// New cookie is created that is added to response with the value from the
		// request
		Cookie cookie = new Cookie("hitCounter", hitCounter.toString());
		// Setting the maximum age of the cookie - 1000s
		cookie.setMaxAge(1000);
		response.addCookie(cookie);
		return new Greeting(counter.incrementAndGet(), String.format(template, name, hitCounter.toString()));
	}

	// Accessing different rest service and returning accessed object
	@SuppressWarnings("resource")
	@RequestMapping("/quote")
	public Quote quote() {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		RestTemplate restTemplate = ctx.getBean(RestTemplate.class);
		return restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
	}
}
