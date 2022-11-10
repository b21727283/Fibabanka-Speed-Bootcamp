package com.example.springboot.impl.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.impl.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
