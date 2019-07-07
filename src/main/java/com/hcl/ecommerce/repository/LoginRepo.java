package com.hcl.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.User;

@Repository
public interface LoginRepo extends JpaRepository<User, Long> {
	
	@Query(value = "select * from ecommerce.users where login = ?1 and password=?2 ",nativeQuery = true)
	public Optional<User> getUserDetails(String login,String password);

}
