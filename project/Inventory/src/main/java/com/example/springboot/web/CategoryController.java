package com.example.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.api.dto.CategoryDtoList;
import com.example.springboot.api.service.CategoryService;

@RestController
@RequestMapping("/inventory")
public class CategoryController {
	
	private CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}
	
	@GetMapping("/categories")
	public CategoryDtoList listCategories() {
		
		return categoryService.findAll();
		
	}
	

}
