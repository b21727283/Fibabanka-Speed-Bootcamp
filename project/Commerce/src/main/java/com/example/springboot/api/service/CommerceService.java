package com.example.springboot.api.service;

import com.example.springboot.api.dto.CartDto;
import com.example.springboot.api.dto.CartProductDto;
import com.example.springboot.api.dto.CategoryDtoList;
import com.example.springboot.api.dto.ProductDto;
import com.example.springboot.api.dto.ProductDtoList;

public interface CommerceService {
	
	CategoryDtoList findAll();
	
	ProductDtoList findAllByCategory(long categoryId);
	
	ProductDto findById(long productId);
	
	long createNewCart(String customerName);
	
	void removeCartProduct(long cartId, long productId);
	
	void checkout(long cartId);
	
	CartDto findCart(long cartId);
	
	void addCartProduct(CartProductDto cartProductDto);
	
}
