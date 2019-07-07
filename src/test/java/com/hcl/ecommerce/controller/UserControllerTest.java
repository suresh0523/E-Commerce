package com.hcl.ecommerce.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.serviceImpl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {TestContext.class,UserController.class})
@WebAppConfiguration
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	MockMvc mockMvc;

	@Mock
	UserServiceImpl userServiceImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testaddUser() throws JsonProcessingException, Exception {
		User user = new User();
		user.setUserId(12L);
		user.setLogin("suresh");
		user.setPassword("575482bhbkj");
		user.setUserName("mahesh");
		user.setUserType("Buyer");

		String str = "User Account Created Sucessfully";
		Mockito.when(userServiceImpl.user(user)).thenReturn(str);
		this.mockMvc.perform(MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON_UTF8).content(asJsonString(str)))
				.andReturn();
		String st = userController.users(user);
		assertEquals(str, st);
	}

	@Test
	public void testUpdateProfile() throws JsonProcessingException, Exception {
		String str = "value";
		Long userId = 23L;

		User user = new User();
		User user1 = new User();
		user.setUserId(12L);
		user.setLogin("suresh");
		user.setPassword("575482bhbkj");
		user.setUserName("mahesh");
		user.setUserType("Buyer");
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonRequest = objectMapper.writeValueAsString(user);

		Mockito.when(userServiceImpl.updateUserProfile(34L, user)).thenReturn(str);
		this.mockMvc.perform(
				MockMvcRequestBuilders.put("/users/{userId}",34L).contentType(MediaType.APPLICATION_JSON)
				.content(jsonRequest)).andExpect(status().isOk()).andReturn();
		String st1 = userController.updateUserProfile(userId, user1);
		assertEquals("User Details Updated Sucessfully !", "User Details Updated Sucessfully !");
	}

	@Test
	public void testdeleteCustomer() throws JsonProcessingException, Exception {

		Long userId = 1234L;
		User user = new User();
		User user1 = new User();
		user.setUserId(12L);
		user.setLogin("suresh");
		user.setPassword("575482bhbkj");
		user.setUserName("mahesh");
		user.setUserType("Buyer");
		String str = "value";

		Mockito.when(userServiceImpl.deleteAccount(userId)).thenReturn("value");

		this.mockMvc

				.perform(delete("/{userId}", 1234L).contentType(MediaType.APPLICATION_JSON_UTF8).content(asJsonString(userId)))

				.andReturn();

		String str1 = userController.users(userId);

		assertEquals(str, str1);

	}
	
	@Test(expected = UserNotFoundException.class)
	public void testUserNotFoundException() throws UserNotFoundException {
		userServiceImpl.deleteAccount(2L);
	}


	public static String asJsonString(final Object obj) throws JsonProcessingException {

		return new ObjectMapper().writeValueAsString(obj);

	}

}
