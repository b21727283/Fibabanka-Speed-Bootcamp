package com.example.springboot.impl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.api.dto.CategoryDto;
import com.example.springboot.api.dto.CategoryDtoList;
import com.example.springboot.api.service.CategoryService;
import com.example.springboot.impl.entity.Category;
import com.example.springboot.impl.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {
	
	CategoryRepository categoryRepository;
	
	public CategoryServiceImp(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}


	@Override
	public CategoryDtoList findAll() {
		
		Iterable<Category> categories = categoryRepository.findAll();
		
		List<CategoryDto> categoryList = new ArrayList<>();
		
		CategoryDtoList categoryDtoList = new CategoryDtoList(categoryList);
		
		for (Category ct : categories) {
	       
			categoryList.add(toDto(ct));
	    }
		
		return categoryDtoList;
	}
	
	
	private CategoryDto toDto(Category category) {
		
		return new CategoryDto(category.getCategoryId(), category.getCategoryName());
		
	}

}
