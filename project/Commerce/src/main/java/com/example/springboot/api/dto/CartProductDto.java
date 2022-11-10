package com.example.springboot.api.dto;

public class CartProductDto {
	
	private long cartProductId;
	
	private long cartId;
	
	private long productId;
	
	private String productName;
	
	private long salesQuantity;
	
	private double salesPrice;
	
	private double lineAmount;
	
	private boolean deneme = false;
	
	public CartProductDto() {
		super();
	}

	public CartProductDto(long cartId, long productId, long salesQuantity) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.salesQuantity = salesQuantity;
		this.setDeneme(true);
	}
	
	
	public CartProductDto(String productName, long salesQuantity, double salesPrice,
			double lineAmount) {
		super();
		this.productName = productName;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
		this.lineAmount = lineAmount;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(long salesQuantity) {
		this.salesQuantity = salesQuantity;
		
		calculateLineAmount();
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
		
		calculateLineAmount();
	}

	public double getLineAmount() {
		return lineAmount;
	}

	public long getCartProductId() {
		return cartProductId;
	}

	public void calculateLineAmount() {
		
		this.lineAmount = this.salesQuantity *  this.salesPrice;
	}

	public long getCartId() {
		return cartId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public boolean isDeneme() {
		return deneme;
	}

	public void setDeneme(boolean deneme) {
		this.deneme = deneme;
	}

}
