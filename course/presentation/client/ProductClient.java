package com.example.springbootfirst.presentation.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.springbootfirst.business.dto.ProductDto;

@Component
public class ProductClient {
	
	public ProductDto getProduct(int productId) {
		
		String url = "http://localhost:8080/api/product/" + Integer.toString(productId);
		
		RestTemplate restTemplate = new RestTemplate();
		ProductDto productDto = restTemplate.getForObject(url, ProductDto.class);
		
		return productDto;
	}
	
	
	public String postProduct() {
		
		String url = "http://localhost:8080/api/product";
		
		ProductDto productDto = new ProductDto( "ütü", 1500);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, productDto, Void.class);
		
		System.out.println("Ürün: "+ productDto.getProductName());
		
		return "Yollanma başarılı";
	}
	
	
	public String putProduct() {
		
		String url = "http://localhost:8080/api/product";
		
		ProductDto productDto = new ProductDto(1,"tablet", 1500);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<ProductDto>(productDto), Void.class);
		
		System.out.println("Değişen ürün: "+ productDto.getProductName());
		
		return "Koyma başarılı";
	}
	
	
	public String deleteProduct() {
		
		int productId = 1;
		
		String url = "http://localhost:8080/api/product/" + Integer.toString(productId);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	
		return "Silme başarılı";
	}
	
	
}

