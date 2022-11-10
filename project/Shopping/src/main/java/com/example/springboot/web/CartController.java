package com.example.springboot.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.api.dto.CartDto;
import com.example.springboot.api.dto.CartProductDto;
import com.example.springboot.api.service.CartProductService;
import com.example.springboot.api.service.CartService;

@RestController
@RequestMapping("/shopping")
public class CartController {
	
	private CartService cartService;
	private CartProductService cartProductService;
	
	public CartController(CartService cartService, CartProductService cartProductService) {
		super();
		this.cartService = cartService;
		this.cartProductService = cartProductService;
	}
	
	@PostMapping("/cart/create")
	public long createNewCart(@RequestBody String customerName) {
		
		return cartService.createNewCart(customerName);
	}
	
	@PostMapping("/cart/add")
	public void addCartProduct(@RequestBody CartProductDto cartProductDto) {
		
		cartProductService.addCartProduct(cartProductDto);
	}
	
	@DeleteMapping("/cart/{cartId}/remove/{productId}")
	public void removeCartProduct(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		
		cartService.removeCartProduct(cartId, productId);
		
	}
	
	@GetMapping("/checkout/{cartId}")
	public void checkout(@PathVariable("cartId") long cartId) {
		
		cartService.checkout(cartId);
		
	}
	
	@GetMapping("/cart/find/{cartId}")
	public CartDto findCart(@PathVariable("cartId") long cartId) {
		
		return cartService.findCart(cartId);
		
	}
	
	
	
 
}
