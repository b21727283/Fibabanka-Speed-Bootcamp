package com.example.springboot.web.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.api.dto.CartDto;
import com.example.springboot.api.dto.CartProductDto;
import com.example.springboot.api.dto.ProductDto;

@Component
public class ShoppingClient {
	
	InventoryClient inventoryClient;
	
	public ShoppingClient(InventoryClient inventoryClient) {
		super();
		this.inventoryClient = inventoryClient;
	}

	public long createCart(String customerName) {
		
		String url = "http://localhost:8082/shopping/cart/create";
		
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, customerName, Long.class);
	
	}
	
	public void addCartProduct(CartProductDto cartProductDto) {
		
		String url = "http://localhost:8082/shopping/cart/add";
		
		RestTemplate restTemplate = new RestTemplate();
		
		if(cartProductDto.getProductId() != 0) {
			
			ProductDto productDto = inventoryClient.getProduct(cartProductDto.getProductId());
			
			// İki mikroservisten yararlanılan kısım
			// ProductName CardProductDto'daki productId yoluyla Inventory mikroservisinden alınıyor
			if(productDto != null) {
				System.out.println(productDto.getProductName());
				cartProductDto.setProductName(productDto.getProductName());
				cartProductDto.setSalesPrice(productDto.getSalesPrice());
				
				System.out.println(cartProductDto.getSalesPrice());
				// İstenen Product yoksa istekte bulunma
				restTemplate.postForObject(url, cartProductDto, Void.class);
			}
		}
		
	}
	
	public void deleteCartProduct(long cartId, long productId) {
		
		String url = "http://localhost:8082/shopping/cart/" + cartId + "/remove/"
				+ productId;
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	}
	
	public void checkout(long cartId) {
		
		String url = "http://localhost:8082/shopping/checkout/" + cartId;
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(url, Void.class);
	
	}
	
	public CartDto findCart(long cartId) {
		
		String url = "http://localhost:8082/shopping/cart/find/" + cartId;
		
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, CartDto.class);
	
	}
	
	
	

}
