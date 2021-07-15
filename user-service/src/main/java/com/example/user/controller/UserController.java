package com.example.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entity.User;
import com.example.user.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	List<User> processGet() {
		System.out.println("called");
		return userService.getUsers();
	}
	
	@GetMapping("/user/{id}r")
	Optional<User> getUser(@PathVariable("id") String id) {
		System.out.println("called");
		return userService.getUser(id);
	}

	
	@PostMapping("/user")
	String createUser(@RequestBody User user) {
		System.out.println(user.getFirstname());
		
		return userService.createUser(user);
	}
	
}
