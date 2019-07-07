package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.serviceImpl.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	ProductServiceImpl productServiceImpl;

	@PostMapping("/products")
	public Product addProcucts(@RequestBody Product product) {
		return productServiceImpl.registerProducts(product);
	}
	
	@GetMapping("/products")
	public List<Product> products()
	{
		return productServiceImpl.products();
		
	}
//	@GetMapping("/products/{categoryId}")
//	public List<Product> products(@PathVariable Long categoryId)
//	{
//		return productServiceImpl.products(categoryId);
//		
//	}
//	
//	@GetMapping("/productName")
//	public   List<Product> findByName(@PathVariable String productName)
//	{
//		return productServiceImpl.findByName(productName);
//		
//	}

}
