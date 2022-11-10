package com.example.springbootfirst.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.springbootfirst.Product;

@Controller
public class ProductController {
	
	@GetMapping("/product/get")
	@ResponseBody
	public String getProduct() {
		
		int productId = 301;
		
		String url = "http://localhost:8080/api/product/" + Integer.toString(productId);
		
		Product product = new Product(productId, "telefon", 1500);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(url, Product.class);
		
		System.out.println("Ürün: "+ product.getName());
		
		return "İşlem başarılı";
	}
	
	
	@GetMapping("/product/post")
	@ResponseBody
	public String postProduct() {
		
		int productId = 301;
		
		String url = "http://localhost:8080/api/product";
		
		
		Product product = new Product(productId, "telefon", 1500);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(url, product, Void.class);
		
		System.out.println("Ürün: "+ product.getName());
		
		return "Yollanma başarılı";
	}
	
	
	@GetMapping("/product/put")
	@ResponseBody
	public String putProduct() {
		
		String url = "http://localhost:8080/api/product";
		
		
		Product product = new Product(301, "tablet", 1500);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Product>(product), Void.class);
		
		System.out.println("Ürün: "+ product.getName());
		
		return "Koyma başarılı";
	}
	
	
	@GetMapping("/product/delete")
	@ResponseBody
	public String deleteProduct() {
		
		int productId = 301;
		
		String url = "http://localhost:8080/api/product/" + Integer.toString(productId);
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	
		
		return "Silme başarılı";
	}
	
	
	

}
