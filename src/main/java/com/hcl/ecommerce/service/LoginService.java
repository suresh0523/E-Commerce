package com.hcl.ecommerce.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
	
	public String login(String login,String password);
}
