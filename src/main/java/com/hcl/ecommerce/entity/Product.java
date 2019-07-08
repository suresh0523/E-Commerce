package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Product {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private int productQuantity;
	private String productStatus;

	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private ProductCategory categoryId;
	
	

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	

	public ProductCategory getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(ProductCategory categoryId) {
		this.categoryId = categoryId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", productStatus=" + productStatus + ", categoryId=" + categoryId + ", user=" + user
				+ "]";
	}
	
	

	public Product(Long productId, String productName, int productQuantity, String productStatus,
			ProductCategory categoryId, User user) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productStatus = productStatus;
		this.categoryId = categoryId;
		this.user = user;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



}
