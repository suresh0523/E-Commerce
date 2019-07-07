package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.ProductCategory;
@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {

}
