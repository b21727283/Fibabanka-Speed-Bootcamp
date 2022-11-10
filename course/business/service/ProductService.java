package com.example.springbootfirst.business.service;

import java.util.List;

import com.example.springbootfirst.business.dto.ProductDto;

public interface ProductService {
	
	int create(ProductDto productDto);
	
	void update(ProductDto productDto);
	
	ProductDto find(int productId);
	
	List<ProductDto> findAll();
	
	void delete(int productId);

}
