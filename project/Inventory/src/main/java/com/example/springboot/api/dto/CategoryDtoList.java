package com.example.springboot.api.dto;

import java.util.List;

public class CategoryDtoList {
	
	List<CategoryDto> categoryDtos;

	public CategoryDtoList(List<CategoryDto> categoryDtos) {
		super();
		this.categoryDtos = categoryDtos;
	}

	public List<CategoryDto> getCategoryDtos() {
		return categoryDtos;
	}

	public void setCategoryDtos(List<CategoryDto> categoryDtos) {
		this.categoryDtos = categoryDtos;
	}

}
