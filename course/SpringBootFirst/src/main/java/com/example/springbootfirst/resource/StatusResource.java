package com.example.springbootfirst.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootfirst.Product;

@RestController
public class StatusResource {
	
	@GetMapping("/status/ok/{id}")
	public ResponseEntity<?> getProduct(@PathVariable("id") int productId){
		
		Product product = new Product(productId, "Cep Telefonu", 1450);
		
		return new ResponseEntity<>(product, HttpStatus.OK);
		
		/*return ResponseEntity
				.ok()
				.body(product);*/
		
	
		/*return ResponseEntity
				.status(HttpStatus.OK)
				.body(product);
		
		
				
		return ResponseEntity.ok(product);
				
		*/
		
		
	}
	
	
	@GetMapping("/status/notFound/{id}")
	public ResponseEntity<?> getNotFound(@PathVariable("id") int productId){
		
		if(productId == 0) {
			
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Ürün bulunamadı");
		}
		
		Product product = new Product(productId, "Cep Telefonu", 1450);
		
		return ResponseEntity.ok(product);
		
	}

}
