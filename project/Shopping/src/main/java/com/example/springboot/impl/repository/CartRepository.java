package com.example.springboot.impl.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.impl.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

}
