package com.hcl.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.User;
@Repository
public interface UserRepo  extends JpaRepository<User, Long>{

	public Optional<User> findById(Long userId);	

	//public User findByType(User userType);login
	
	public User findByLogin(String login);
	
	public List<User> findByUserType(String userType);
	
}
