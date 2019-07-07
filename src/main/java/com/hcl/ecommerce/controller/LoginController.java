package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.serviceImpl.LoginServiceImpl;

@RestController
@RequestMapping
public class LoginController {

	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	

	@PostMapping("/login/{login}/{password}")

	public String login(@PathVariable String login,@PathVariable String password) {

		

		return loginServiceImpl.login(login, password);

	}

	
	
}
