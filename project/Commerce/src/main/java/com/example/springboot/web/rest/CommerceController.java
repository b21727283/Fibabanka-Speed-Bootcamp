package com.example.springboot.web.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.api.dto.CartDto;
import com.example.springboot.api.dto.CartProductDto;
import com.example.springboot.api.dto.CategoryDtoList;
import com.example.springboot.api.dto.ProductDto;
import com.example.springboot.api.dto.ProductDtoList;
import com.example.springboot.api.service.CommerceService;

@RestController
@RequestMapping("/commerce")
public class CommerceController {
	
	CommerceService commerceService;
	
	public CommerceController(CommerceService commerceService) {
		super();
		this.commerceService = commerceService;
	}

	@GetMapping("/inventory/categories")
	public CategoryDtoList getCategories() {
		
		return commerceService.findAll();
		
	}
	
	@GetMapping("/inventory/products/{categoryId}")
	public ProductDtoList getProducts(@PathVariable("categoryId") long categoryId) {
		
		return commerceService.findAllByCategory(categoryId);
	}
	
	@GetMapping("/inventory/product/{id}")
	public ProductDto getProduct(@PathVariable("id") long productId) {
		
		return commerceService.findById(productId);
		
	}
	
	@PostMapping("/shopping/cart/create")
	public long createNewCart(@RequestBody String customerName) {
		
		return commerceService.createNewCart(customerName);
	}
	
	@PostMapping("/shopping/cart/add")
	public void addCartProduct(@RequestBody CartProductDto cartProductDto) {
		
		System.out.println(cartProductDto.isDeneme());
		System.out.println(cartProductDto.getProductId());
		commerceService.addCartProduct(cartProductDto);
	}
	
	@DeleteMapping("/shopping/cart/{cartId}/remove/{productId}")
	public void removeCartProduct(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		
		commerceService.removeCartProduct(cartId, productId);
		
	}
	
	@GetMapping("/shopping/checkout/{cartId}")
	public void checkout(@PathVariable("cartId") long cartId) {
		
		commerceService.checkout(cartId);
		
	}
	
	@GetMapping("/shopping/cart/find/{cartId}")
	public CartDto findCart(@PathVariable("cartId") long cartId) {
		
		return commerceService.findCart(cartId);
		
	}
	

}
