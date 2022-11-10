package com.example.springbootfirst.presentation.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootfirst.business.dto.ProductDto;

@Controller
@RequestMapping("/commerce")
public class CommerceClient {
	
	private ProductClient productClient;
	
	public CommerceClient(ProductClient productClient) {
		super();
		this.productClient = productClient;
	}

	@GetMapping("/product/get")
	@ResponseBody
	public String getProduct() {
		
		int productId = 1;
	
		ProductDto productDto = productClient.getProduct(productId);
		
		System.out.println("Ürün: "+ productDto.getProductName());
		
		return "Edinme başarılı";
	}
	
	
	@GetMapping("/product/post")
	@ResponseBody
	public String postProduct() {
		
		return productClient.postProduct();
	}
	
	
	@GetMapping("/product/put")
	@ResponseBody
	public String putProduct() {
		
		return productClient.putProduct();
	}
	
	
	@GetMapping("/product/delete")
	@ResponseBody
	public String deleteProduct() {
		
		return productClient.deleteProduct();
	}

	
}
