package com.hcl.ecommerce.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.ProductCategory;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.serviceImpl.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { TestContext.class, ProductController.class })
@WebAppConfiguration
public class ProductControllerTest {

	@InjectMocks
	ProductController productController;

	MockMvc mockMvc;

	@Mock
	ProductServiceImpl productServiceImpl;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void testRegisterProduct() throws Exception {
		User user=new User();
		user.setLogin("test");
		user.setPassword("3453");
		user.setUserType("Seller");
		user.setUserName("suresh");
		user.setUserId(12L);
		
		ProductCategory productCategory=new ProductCategory();
		productCategory.setCategoryId(25L);
		productCategory.setCategoryName("Elecric");
		
		
		Product product=new Product(12L, "Bulb", 10, "Available", productCategory, user);
		
		String str = "";
		Mockito.when(productServiceImpl.registerProducts(product)).thenReturn(product);
		this.mockMvc.perform(post("/products").contentType(MediaType.APPLICATION_JSON_UTF8).content(asJsonString(str))).andReturn();
//		this.mockMvc.perform(MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON_UTF8).content(asJsonString(str)))
//				.andReturn();
		Product st = productController.addProcucts(product);
		assertEquals(product, st);
	}
	
//	@Test
//	public void testListProducts()
//	{
//		List<Product> li=new ArrayList<>();
//		User user=new User();
//		user.setLogin("test");
//		user.setPassword("3453");
//		user.setUserType("Seller");
//		user.setUserName("suresh");
//		user.setUserId(12L);
//		
//		ProductCategory productCategory=new ProductCategory();
//		productCategory.setCategoryId(25L);
//		productCategory.setCategoryName("Elecric");
//		
//		
//		Product product=new Product(12L, "Bulb", 10, "Available", productCategory, user);
//		Product product1=new Product(16L, "Fan", 100, "Available", productCategory, user);
//		li.add(product);
//		li.add(product1);
//		Mockito.when(productServiceImpl.products()).thenReturn(li);
//		
//		mockMvc.perform(MockMvcRequestBuilders.get("/products")).andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//		.content(asJsonString(product)).andReturn();
//		//this.mockMvc.perform(get("/products").contentType(MediaType.APPLICATION_JSON_UTF8).content(asJsonString(li)).;
//	}

	public static String asJsonString(final Object obj) throws JsonProcessingException {

		return new ObjectMapper().writeValueAsString(obj);

	}
}
