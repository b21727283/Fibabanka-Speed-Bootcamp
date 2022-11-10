package com.example.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.api.dto.ProductDto;
import com.example.springboot.api.dto.ProductDtoList;
import com.example.springboot.api.service.ProductService;

@RestController
@RequestMapping("/inventory")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/products/{categoryId}")
	public ProductDtoList listProducts(@PathVariable("categoryId") long categoryId) {
		
		return productService.findAllByCategory(categoryId);
		
	}
	
	@GetMapping("/product/{id}")
	public ProductDto find(@PathVariable("id") long productId) {
		
		return productService.findById(productId);
	}
	
	
	
	

}
