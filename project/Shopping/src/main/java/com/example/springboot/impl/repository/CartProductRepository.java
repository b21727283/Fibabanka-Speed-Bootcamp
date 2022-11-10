package com.example.springboot.impl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.springboot.impl.entity.CartProduct;

public interface CartProductRepository extends CrudRepository<CartProduct, Long> {


}
