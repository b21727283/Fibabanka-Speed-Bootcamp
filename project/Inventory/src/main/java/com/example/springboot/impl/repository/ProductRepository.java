package com.example.springboot.impl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.springboot.api.dto.ProductDto;
import com.example.springboot.impl.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query("select p from Product as p where p.category.categoryId = :categoryId ")
	public List<Product> findAllByCategory(@Param("categoryId") long categoryId);
}
