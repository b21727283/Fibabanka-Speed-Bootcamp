package com.example.springboot.api.dto;

public class CategoryDto {
	
	private long categoryId;
	
	private String categoryName;

	public CategoryDto() {
		super();
	}

	public CategoryDto(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public CategoryDto(long categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
}
