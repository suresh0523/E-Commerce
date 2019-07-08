package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("/users")
	public String users(@RequestBody User user) {
		return userServiceImpl.user(user);

	}
	
	@DeleteMapping("/users/{userId}")
	public String users(@PathVariable Long userId) {
		return userServiceImpl.deleteAccount(userId);
	}
	
	@PutMapping("/users/{userId}")
	public String updateUserProfile(@PathVariable Long userId,@RequestBody User user) throws UserNotFoundException
	{
		return userServiceImpl.updateUserProfile(userId, user);
	}
	
	@GetMapping("/users/{userType}")
	public List<User> findUsers(@PathVariable String userType)
	{
		return userServiceImpl.findUsers(userType);
	}
	

	@PostMapping("/users/{login}/{password}")
	public String loginUser(@RequestHeader(value ="login") String login,@RequestHeader(value ="password") String password) {
		return userServiceImpl.findUsernameAndPassword(login, password);
	}
	
//	@GetMapping("/userType/{userType}")
//	public  List<User> findUsers(@PathVariable String userType)
//	{
//		
//		return userServiceImpl.findUsers(userType);
//		
//		
//	}
}
