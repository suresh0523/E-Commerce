package com.hcl.ecommerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.ProductCategory;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.ProductRepo;
import com.hcl.ecommerce.repository.UserRepo;
import com.hcl.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	UserRepo userRepo;

	@Override
	public Product registerProducts(Product products) {

		
		Product pp1 =new Product();
		long userId = products.getUser().getUserId();
		
	User user=	userRepo.findById(userId).get();
		if(user.getUserType().equals("Seller")) {
			pp1 = productRepo.save(products);
		}
		return pp1;

	}

	@Override
	public List<Product> products() {

		return productRepo.findAll();
	}

	@Override
	public List<Product> products(long categoryId) {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryId(categoryId);

		List<Product> li = productRepo.findByCategoryId(productCategory);
		return li;
	}

	@Override
	public List<Product> findByProductName(String productName) {
		List<Product> li = productRepo.findByProductName(productName);
		return li;
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
