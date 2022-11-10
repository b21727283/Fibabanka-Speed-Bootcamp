package com.example.springboot.api.dto;

public class ProductDto {
	
	private long productId;

	private String productName;
	
	private double salesPrice;
	
	private long categoryId;

	public ProductDto() {
		super();
	}

	public ProductDto(String productName, double salesPrice) {
		super();
		this.productName = productName;
		this.salesPrice = salesPrice;
	}
	
	public ProductDto(long productId, String productName, double salesPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
	}
	

	public ProductDto(long productId, String productName, double salesPrice, long categoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	

}
