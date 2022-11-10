package com.example.springbootfirst.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootfirst.Product;
import com.example.springbootfirst.service.ProductService;

@RestController
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/api/products")
	public List<Product> getProducts(){
		
		/*List<Product> products = new ArrayList<Product>();
		
		products.add(new Product(300, "bilgisayar", 1500));
		products.add(new Product(301, "telefon", 900));
		
	
		return products;*/
		
		return productService.findAll();
		
		
	}
	
	@GetMapping("/api/product/{id}")
	public Product getProduct(@PathVariable("id") int productId) {
		
		// return new Product(productId, "bilgisayar", 1500);
		
		return productService.find(productId);

		
	}
	
	@PostMapping("/api/product")
	public void postProduct(@RequestBody Product product) {
		//System.out.println("ürün eklendi " + product.getId() + " " + product.getName() + " " + product.getPrice());
		
		productService.createProduct(product);
	}
	
	@PutMapping("/api/product")
	public void putProduct(@RequestBody Product product) {
		//System.out.println("ürün değişti " + product.getId() + " " + product.getName() + " " + product.getPrice());
		
		productService.updateProduct(product);
	}
	
	@DeleteMapping("/api/product/{id}")
	public void deleteProduct(@PathVariable("id") int productId) {
		//System.out.println("ürün silindi " + productId );
		
		productService.deleteProduct(productId);
	}
	

}
