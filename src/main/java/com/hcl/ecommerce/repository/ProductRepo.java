package com.hcl.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.ProductCategory;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	
	//@Query(value = "select * from ecommerce.product where category_id = ?1", nativeQuery = true)
	public List<Product> findByCategoryId(ProductCategory categoryId);
	
	public List<Product> findByProductName(String productName);
	
	
	

}
