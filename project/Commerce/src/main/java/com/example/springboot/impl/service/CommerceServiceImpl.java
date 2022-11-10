package com.example.springboot.impl.service;

import org.springframework.stereotype.Service;

import com.example.springboot.api.dto.CartDto;
import com.example.springboot.api.dto.CartProductDto;
import com.example.springboot.api.dto.CategoryDtoList;
import com.example.springboot.api.dto.ProductDto;
import com.example.springboot.api.dto.ProductDtoList;
import com.example.springboot.api.service.CommerceService;
import com.example.springboot.web.client.InventoryClient;
import com.example.springboot.web.client.ShoppingClient;

@Service
public class CommerceServiceImpl implements CommerceService{
	
	InventoryClient inventoryClient;
	ShoppingClient shoppingClient;

	public CommerceServiceImpl(InventoryClient inventoryClient, ShoppingClient shoppingClient) {
		super();
		this.inventoryClient = inventoryClient;
		this.shoppingClient = shoppingClient;
	}

	@Override
	public CategoryDtoList findAll() {
		
		return inventoryClient.getCategories();
	}

	@Override
	public ProductDtoList findAllByCategory(long categoryId) {
		
		return inventoryClient.getProducts(categoryId);
	}

	@Override
	public ProductDto findById(long productId) {
		
		return inventoryClient.getProduct(productId);
	}

	@Override
	public long createNewCart(String customerName) {
		
		return shoppingClient.createCart(customerName);
	}

	@Override
	public void removeCartProduct(long cartId, long productId) {
		
		shoppingClient.deleteCartProduct(cartId, productId);
		
	}

	@Override
	public void checkout(long cartId) {
		
		shoppingClient.checkout(cartId);
		
	}

	@Override
	public CartDto findCart(long cartId) {
		
		return shoppingClient.findCart(cartId);
	}

	@Override
	public void addCartProduct(CartProductDto cartProductDto) {
		
		shoppingClient.addCartProduct(cartProductDto);
		
	}

}
