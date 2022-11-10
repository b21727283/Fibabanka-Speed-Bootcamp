package com.example.springboot.api.service;

import com.example.springboot.api.dto.CartDto;
import com.example.springboot.api.dto.CartProductDto;

public interface CartService {
	
	long createNewCart(String customerName);
	
	void removeCartProduct(long cartId, long productId);
	
	void checkout(long cartId);
	
	CartDto findCart(long cartId);
	
	
}
