package com.example.springboot.impl.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartProduct {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cartProductId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	private long productId;
	
	private long salesQuantity;
	
	private double salesPrice;
	
	private double lineAmount;
	
	private String productName;

	public CartProduct() {
		super();
	}

	public CartProduct(long productId, long salesQuantity, double salesPrice, Cart cart) {
		super();
		this.productId = productId;
		this.salesQuantity = salesQuantity;
		this.salesPrice = salesPrice;
		this.cart = cart;
		
		calculateLineAmount();
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

	public Cart getCart() {
		return cart;
	}

	public void calculateLineAmount() {
		
		this.lineAmount = this.salesQuantity *  this.salesPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	

}
