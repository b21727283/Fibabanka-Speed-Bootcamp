package com.example.springboot.api.dto;

import java.util.List;

public class ProductDtoList {
	
	List<ProductDto> productDtos;

	public ProductDtoList() {
		super();
	}

	public ProductDtoList(List<ProductDto> productDtos) {
		super();
		this.productDtos = productDtos;
	}

	public List<ProductDto> getProductDtos() {
		return productDtos;
	}

	public void setProductDtos(List<ProductDto> productDtos) {
		this.productDtos = productDtos;
	}

}
