package com.example.springboot.web.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.api.dto.CategoryDtoList;
import com.example.springboot.api.dto.ProductDto;
import com.example.springboot.api.dto.ProductDtoList;

@Component
public class InventoryClient {
	
	
	public CategoryDtoList getCategories() {
		
		String url = "http://localhost:8081/inventory/categories";
		
		RestTemplate restTemplate = new RestTemplate();
		
		CategoryDtoList response = restTemplate.getForObject(url, CategoryDtoList.class);
	
		return response;
		
	}
	
	public ProductDtoList getProducts(long categoryId) {
		
		String url = "http://localhost:8081/inventory/products/" + categoryId;
		
		RestTemplate restTemplate = new RestTemplate();
		
		ProductDtoList response = restTemplate.getForObject(url, ProductDtoList.class);
	
		return response;
		
	}
	
	public ProductDto getProduct(long productId) {
		
		String url = "http://localhost:8081/inventory/product/" + productId;
		
		RestTemplate restTemplate = new RestTemplate();
		
		ProductDto response = restTemplate.getForObject(url, ProductDto.class);
	
		return response;
		
		
	}
	

}
