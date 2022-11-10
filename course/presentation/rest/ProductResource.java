package com.example.springbootfirst.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootfirst.business.dto.ProductDto;
import com.example.springbootfirst.business.service.ProductService;

@RestController
public class ProductResource {
	
	private ProductService productService;

	public ProductResource(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/api/products")
	public List<ProductDto> getProducts(){
		
		return productService.findAll();
	
	}
	
	@GetMapping("/api/product/{id}")
	public ProductDto getProduct(@PathVariable("id") int productDtoId) {
		
		return productService.find(productDtoId);
		
	}
	
	@PostMapping("/api/product")
	public void postProduct(@RequestBody ProductDto productDto) {
		
		productService.create(productDto);
	}
	
	@PutMapping("/api/product")
	public void putProduct(@RequestBody ProductDto productDto) {
		
		productService.update(productDto);
	}
	
	@DeleteMapping("/api/product/{id}")
	public void deleteProduct(@PathVariable("id") int productDtoId) {
		
		productService.delete(productDtoId);
	}
	
	

}
