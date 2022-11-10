package com.example.springbootfirst.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootfirst.Product;

@Service
public class ProductServiceImp implements ProductService {

	@Override
	public Product find(int productId) {
		
		return new Product(productId, "bilgisayar", 1500);
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product(300, "bilgisayar", 1500));
		products.add(new Product(301, "telefon", 900));
		
	
		return products;
	}

	@Override
	public void createProduct(Product product) {
		
		product.setId(305);
		System.out.println("ürün eklendi " + product.getId() + " " + product.getName() + " " + product.getPrice());
		
	}

	@Override
	public void updateProduct(Product product) {
		
		product.setPrice(3000);
		System.out.println("ürün değişti " + product.getId() + " " + product.getName() + " " + product.getPrice());
		
	}

	@Override
	public void deleteProduct(int productId) {
		System.out.println("ürün silindi " + productId );
		
	}

}
