package com.hcl.ecommerce.serviceImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.repository.LoginRepo;
import com.hcl.ecommerce.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	LoginRepo loginRepo;

//	@Override
//	public String login(User user) {
//
//		User user1 = loginRepo.getUserDetails(user.getLogin());
//
//		if (user != null) {
//
//			if (user.getUserName().equalsIgnoreCase(user.getLogin()) &&
//
//					user.getPassword().equalsIgnoreCase(user.getPassword())) {
//
//				return "login successful";
//
//			} else if (user.getPassword() != user.getPassword()) {
//
//				return "Password entered is wrong";
//
//			}
//
//		} else {
//
//			return "User Name entered is wrong";
//
//		}
//		return null;
//	}

	@Override
	public String login(String login, String password) throws UserNotFoundException {

		
		Optional<User> user = loginRepo.getUserDetails(login, password);
		
		LOGGER.info("near to User details");
		if(user.isPresent())
		{
		LOGGER.info("haiiii");
		}else
		{
			throw new UserNotFoundException("Please Enter Valid Login and Password ");
		}
		return "User LoginDone Sucessfully !";
	}

}
