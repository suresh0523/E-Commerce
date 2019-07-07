package com.hcl.ecommerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.repository.ProductRepo;
import com.hcl.ecommerce.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductRepo productRepo;
	
	
	
	@Override
	public Product registerProducts(Product products) {
		
		return productRepo.save(products);
	}

	@Override
	public List<Product> products() {
		
		
		return productRepo.findAll();
	}

	@Override
	public List<Product> products(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Product> products(Long categoryId) {
//		return productRepo.findByCategoryId(categoryId);	
//	}

//	@Override
//	public List<Product> findByName(String productName) {
//		
//		Product pp= new Product();
//		pp.setProductName(productName);
//		
//	   // return	productRepo.findByName(pp.getProductName());
//		
//		
//		return null;
//	}
//
//	@Override
//	public List<Product> products(Long categoryId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	

}
