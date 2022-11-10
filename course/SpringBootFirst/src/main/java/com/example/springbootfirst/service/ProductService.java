package com.example.springbootfirst.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.springbootfirst.Product;

public interface ProductService {
	
	Product find(int productId);
	
	List<Product> findAll();
	
	public void createProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(int productId);
}
