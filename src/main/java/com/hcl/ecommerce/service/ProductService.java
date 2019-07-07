package com.hcl.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.Product;

@Service
public interface ProductService {

	Product registerProducts(Product products);
	
	List<Product> products();
	
		
	List<Product> products(Long categoryId);
	
	//List<Product> findByName(String productName);
	
	
}
