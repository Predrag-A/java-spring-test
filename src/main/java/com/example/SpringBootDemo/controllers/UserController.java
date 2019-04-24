package com.example.SpringBootDemo.controllers;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringBootDemo.classes.User;

@Controller
public class UserController {

	private static ArrayList<User> userList = new ArrayList<User>();
	private final AtomicLong counter = new AtomicLong();

	@GetMapping(value = "/users")
	public String userList(@RequestParam(value = "locale", required = false, defaultValue = "en") String locale,
			Model model) {
		if (userList.size() < 10) {
			userList.add(new User("RandomUserName", counter.incrementAndGet(), true));
		}
		model.addAttribute("userList", userList);
		model.addAttribute("locale", locale);
		return "users";
	}

	@PostMapping(value = "/users")
	public String addUser(@RequestParam(value = "locale", required = false, defaultValue = "en") String locale,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "alive", required = true) String alive, Model model) {

		userList.add(new User(name, counter.incrementAndGet(), alive.equals("yes")));
		model.addAttribute("userList", userList);
		model.addAttribute("locale", locale);
		return "users";
	}

	@GetMapping(value = "/users/user")
	public String user(@RequestParam(value = "id", required = true) int id, Model model) {
		model.addAttribute("user", userList.get(id));
		return "user";
	}

}