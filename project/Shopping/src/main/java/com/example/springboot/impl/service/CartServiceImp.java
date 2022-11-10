package com.example.springboot.impl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springboot.api.dto.CartDto;
import com.example.springboot.api.dto.CartProductDto;
import com.example.springboot.api.service.CartService;
import com.example.springboot.impl.entity.Cart;
import com.example.springboot.impl.entity.CartProduct;
import com.example.springboot.impl.repository.CartProductRepository;
import com.example.springboot.impl.repository.CartRepository;

@Service
public class CartServiceImp implements CartService {
	
	CartRepository cartRepository;
	CartProductRepository cartProductRepository;
	
	public CartServiceImp(CartRepository cartRepository, CartProductRepository cartProductRepository) {
		super();
		this.cartRepository = cartRepository;
		this.cartProductRepository = cartProductRepository;
	}

	// CartDto nesnesinden daha çok özellik de alınabilir...
	@Override
	public long createNewCart(String customerName) {
		
		Cart newCart = new Cart(customerName);
		
		Cart savedCart = cartRepository.save(newCart);
	
		return savedCart.getCartId();
	}

	@Override
	public void removeCartProduct(long cartId, long productId) {
		
		Optional<Cart> foundCart = cartRepository.findById(cartId);
		
		if(!foundCart.isPresent()) return;

		for(CartProduct cartProduct : foundCart.get().getCartProducts()) {
			
			// İstenilen Product'ı bulmaya çalışıyoruz...
			if(cartProduct.getProductId() == productId) {
				
				// Eğer bir tane ürün varsa ürünü tamamen sil diğer durumda ürünü bir azalt
				if(cartProduct.getSalesQuantity() > 1) { 
					
					cartProduct.setSalesQuantity(cartProduct.getSalesQuantity() - 1);
					//cartProductRepository.save(cartProduct);
					
					foundCart.get().refreshTotalAmount(-cartProduct.getSalesPrice());
					cartRepository.save(foundCart.get());
					
				}else {
					// Cart'tan o ürünü tamamen çıkar
					foundCart.get().refreshTotalAmount(-cartProduct.getLineAmount());
					
					foundCart.get().getCartProducts().remove(cartProduct);
					cartRepository.save(foundCart.get());
					
					
					cartProductRepository.delete(cartProduct);
					
				}
				
				break;
				
			}
			
			
		}	
		
	}

	@Override
	public void checkout(long cartId) {
		
		Optional<Cart> foundCart = cartRepository.findById(cartId);
		
		if(!foundCart.isPresent()) return;
		
		if(foundCart.get().isCartStatus()) return;
		
		foundCart.get().setCartStatus(true);
		
		cartRepository.save(foundCart.get());
		
	}

	@Override
	public CartDto findCart(long cartId) {
	
		Optional<Cart> foundCart = cartRepository.findById(cartId);
		
		if(!foundCart.isPresent()) return null;
		
		return CartToDTO(foundCart.get());
	}
	
	
	// DTO - Entity Dönüştürme fonksiyonları...
	
	private CartDto CartToDTO(Cart cart) {
		
		List<CartProductDto> cartProductDtos = new ArrayList<>();
		
		for(CartProduct cp : cart.getCartProducts()) {
			
			cartProductDtos.add(CartProductToDTO(cp));
		}
		
		CartDto cartDto = new CartDto(cart.getCartId(), cart.getCustomerName(), cart.getTotalAmount(),
				cart.isCartStatus(), cartProductDtos);
		
		
		return cartDto;
	}
	
	private CartProductDto CartProductToDTO(CartProduct cartProduct) {
		
		CartProductDto cartProductDto  = new CartProductDto(cartProduct.getCartProductId(), cartProduct.getCart().getCartId(),
				cartProduct.getProductId(), cartProduct.getSalesQuantity(), cartProduct.getSalesPrice(),
				cartProduct.getLineAmount());
		
		cartProductDto.setProductName(cartProduct.getProductName());
		
		return cartProductDto;
		
	}


}
