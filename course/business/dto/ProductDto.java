package com.example.springbootfirst.business.dto;

public class ProductDto {
	
	private int productId;
	
	private String productName;
	
	private int salesPrice;
	
	public ProductDto() {
		super();
	}

	public ProductDto(int productId, String productName, int salesPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
	}

	public ProductDto(String productName, int salesPrice) {
		this.productName = productName;
		this.salesPrice = salesPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(int salesPrice) {
		this.salesPrice = salesPrice;
	}
	
}
