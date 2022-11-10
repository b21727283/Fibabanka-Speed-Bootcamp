package com.example.springboot.api.service;

import com.example.springboot.api.dto.CartProductDto;

public interface CartProductService {
	
	void addCartProduct(CartProductDto cartProductDto);
	
}
