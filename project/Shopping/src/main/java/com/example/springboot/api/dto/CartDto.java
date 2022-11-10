package com.example.springboot.api.dto;

import java.util.List;

public class CartDto {
	
	private long cartId;
	
	private String customerName;
	
	private double totalAmount;
	
	private boolean cartStatus;
	
	private List<CartProductDto> cartProductDtos;

	public CartDto() {
		super();
	}

	public CartDto(String customerName, double totalAmount, boolean cartStatus) {
		super();
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.cartStatus = cartStatus;
	}

	public CartDto(String customerName, double totalAmount, boolean cartStatus, List<CartProductDto> cartProductDtos) {
		super();
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.cartStatus = cartStatus;
		this.cartProductDtos = cartProductDtos;
	}
	
	public CartDto(long cartId, String customerName, double totalAmount, boolean cartStatus,
			List<CartProductDto> cartProductDtos) {
		super();
		this.cartId = cartId;
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.cartStatus = cartStatus;
		this.cartProductDtos = cartProductDtos;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(boolean cartStatus) {
		this.cartStatus = cartStatus;
	}

	public List<CartProductDto> getCartProductDtos() {
		return cartProductDtos;
	}

	public void setCartProductDtos(List<CartProductDto> cartProductDtos) {
		this.cartProductDtos = cartProductDtos;
	}

	public long getCartId() {
		return cartId;
	}
	

}
