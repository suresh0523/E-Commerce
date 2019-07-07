package com.hcl.ecommerce.serviceImpl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.ProductCategory;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.ProductRepo;
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Mock
	ProductRepo productRepo;
	
	
	
	@Test
	public void testAddProducts() {
		
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
		Mockito.when(productRepo.save(product)).thenReturn(product);
		Product st=productServiceImpl.registerProducts(product);
		assertEquals(product, st);
		
	}
	
	@Test
	public void testListAllProduct()
	{
		List<Product> li=new ArrayList<>();
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
		Product product1=new Product(16L, "Fan", 100, "Available", productCategory, user);
		li.add(product);
		li.add(product1);
		List<Product> li1 = productServiceImpl.products();
		assertEquals(0, li1.size());
		
		
	}
	

}
