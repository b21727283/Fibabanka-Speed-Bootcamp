package com.example.springboot.impl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cartId;
	
	private String customerName;
	
	private double totalAmount;
	
	private boolean cartStatus = false; // False -> Yeni, True -> Bitmiş
	
	@OneToMany(mappedBy="cart", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<CartProduct> cartProducts;

	public Cart() {
		super();
	}
	
	public Cart(String customerName) {
		super();
		this.customerName = customerName;
		this.cartProducts = new ArrayList<>();
	}

	public Cart(String customerName, double totalAmount, boolean cartStatus) {
		super();
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.cartStatus = cartStatus;
		this.cartProducts = new ArrayList<>();
	}

	public Cart(String customerName, double totalAmount, boolean cartStatus, List<CartProduct> cartProducts) {
		super();
		this.customerName = customerName;
		this.totalAmount = totalAmount;
		this.cartStatus = cartStatus;
		this.cartProducts = cartProducts;
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

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

	public long getCartId() {
		return cartId;
	}
	
	public void addCartProduct(CartProduct cardProduct) {
		
		this.totalAmount += cardProduct.getLineAmount();
		this.cartProducts.add(cardProduct);
		
	}
	
	public void refreshTotalAmount(double change) {
		
		this.totalAmount += change;
		
	}
	
	

}
