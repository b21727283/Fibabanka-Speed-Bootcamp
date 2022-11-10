package com.example.springbootfirst.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.springbootfirst.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	// JPQL
	@Query("select p from Product as p where p.price >= :minPrice ")
	List<Product> findAllBySalesPriceMin(@Param("minPrice") int minPrice);
		
		
	

}
