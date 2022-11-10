package com.example.springboot.impl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springboot.api.dto.ProductDto;
import com.example.springboot.api.dto.ProductDtoList;
import com.example.springboot.api.service.ProductService;
import com.example.springboot.impl.entity.Product;
import com.example.springboot.impl.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	
	ProductRepository productRepository;

	public ProductServiceImp(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public ProductDtoList findAllByCategory(long categoryId) {
		
		List<Product> productList = productRepository.findAllByCategory(categoryId);
		
		List<ProductDto> productDtos = new ArrayList<>();
		
		for (Product p : productList) {
			
			productDtos.add(toDTO(p));
		}
		
		ProductDtoList productDtoList = new ProductDtoList(productDtos);
		
		return productDtoList;
	}

	@Override
	public ProductDto findById(long productId) {
		
		Optional<Product> optional = productRepository.findById(productId);
		
		if(optional.isPresent()) {
			
			Product product = optional.get();
			
			ProductDto productDto = toDTO(product);
			
			return productDto;
			
		}
	
		return null;
	
	}
	
	private ProductDto toDTO(Product product) {
		
		ProductDto productDto = new ProductDto(product.getProductId(), product.getProductName(),
				product.getSalesPrice(), product.getCategory().getCategoryId());
		
		return productDto;
	}


}
