package com.example.springboot.impl.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springboot.api.dto.CartProductDto;
import com.example.springboot.api.service.CartProductService;
import com.example.springboot.impl.entity.Cart;
import com.example.springboot.impl.entity.CartProduct;
import com.example.springboot.impl.repository.CartProductRepository;
import com.example.springboot.impl.repository.CartRepository;

@Service
public class CartProductImp implements CartProductService {
	
	CartProductRepository cartProductRepository;
	CartRepository cartRepository;

	public CartProductImp(CartProductRepository cartProductRepositor, CartRepository cartRepository) {
		super();
		this.cartProductRepository = cartProductRepositor;
		this.cartRepository = cartRepository;
	}

	@Override
	public void addCartProduct(CartProductDto cartProductDto) {
		
		CartProduct cartProduct = CartProductToEntity(cartProductDto);
		
		// cartProduct'daki cartId bilgisi yanlışsa fonksiyondan çık
		if(cartProduct == null) return;
		
		//cartProductRepository.save(cartProduct); //Cascade'den dolayı iki kere kaydoluyor
		
	}
	
	private CartProduct CartProductToEntity(CartProductDto cartProductDto) {
		
		Optional<Cart> cart = cartRepository.findById(cartProductDto.getCartId());
		
		// DTO'daki cartId'de bir Cart yoksa fonksiyondan çık
		if(cart.isEmpty()) return null;
		
		CartProduct cartProduct  = new CartProduct(
				cartProductDto.getProductId(), cartProductDto.getSalesQuantity(), cartProductDto.getSalesPrice(),
				cart.get());
		
		cartProduct.setProductName(cartProductDto.getProductName());
		
		cart.get().addCartProduct(cartProduct); //line_amount'u total_amount'a ekle
		
		cartRepository.save(cart.get()); // başka bir yere taşınabilir fakat bulma işleminden sonra buraya koydum
		
		return cartProduct;
		
	}

}
