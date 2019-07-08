package com.hcl.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.User;

@Service
public interface UserService {
	public String user(User user);
	
	public String deleteAccount(Long userId);

	public String updateUserProfile(Long userId,User user);
	

	public String findUsernameAndPassword(String login,String password );
	
	public List<User> findUsers(String userType);
	


}
