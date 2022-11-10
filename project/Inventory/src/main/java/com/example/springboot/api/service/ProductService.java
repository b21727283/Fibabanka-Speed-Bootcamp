package com.example.springboot.api.service;

import com.example.springboot.api.dto.ProductDto;
import com.example.springboot.api.dto.ProductDtoList;

public interface ProductService {
	
	ProductDtoList findAllByCategory(long categoryId);
	
	ProductDto findById(long productId);

}
