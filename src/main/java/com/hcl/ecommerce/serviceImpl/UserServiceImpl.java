package com.hcl.ecommerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.repository.UserRepo;
import com.hcl.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	public String user(User user) {
		userRepo.save(user);
		return "User Account Created Sucessfully";
	}

	@Override
	public String deleteAccount(Long userId) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(userId);
		if (user.isPresent()) {
			System.out.println(user);
			userRepo.deleteById(userId);
		} else if (user != null) {
			System.out.println(user);
			throw new UserNotFoundException("User Details Not Found !");
		}
		return "User Deleted Sucessfully !";
	}

	@Override
	public String updateUserProfile(Long userId, User user) throws UserNotFoundException {
		Optional<User> userData = userRepo.findById(userId);
		if(userData.isPresent())
		{
			userData.get().setLogin(user.getLogin());
			userData.get().setPassword(user.getPassword());
			userData.get().setUserName(user.getUserName());
			userData.get().setUserType(user.getUserType());
			
			userRepo.save(userData.get());
			
		}else {
			throw new UserNotFoundException("User Details Not Exist !");
		}
		return "User Details Updated Sucessfully !";
	}

	@Override
	public List<User> users(String userType) {
		List<User>li1=new ArrayList<>();
		List<User> li =userRepo.findAll();
		for (User user : li) {
			if(user.getUserType().equals("Seller"))
			{
				li.add(user);
			}
		}
		return li;
	}
}
