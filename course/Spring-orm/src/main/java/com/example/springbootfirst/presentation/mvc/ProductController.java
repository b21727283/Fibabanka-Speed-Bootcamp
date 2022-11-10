package com.example.springbootfirst.presentation.mvc;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.springbootfirst.data.entity.Product;
import com.example.springbootfirst.data.repository.ProductRepository;

@Controller
@RequestMapping("/inventory")
public class ProductController {
	
	
	//@Autowired
	private ProductRepository productRepository;
	
	public ProductController(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}
	
	@GetMapping("/product/insert")
	@ResponseBody
	public String insertProduct() {
		
		
		Product product = new Product(0, "Cep Telefonu", 1430);
		productRepository.save(product);
		return "Sokuldu: " + product.getId();
		

		
	}
	
	
	@GetMapping("/product/find")
	@ResponseBody
	public String findProduct() {
		
		int productId = 1;
		
		Optional<Product> optional = productRepository.findById(productId);
		
		if(optional.isPresent()) {
			
			Product product = optional.get();
			System.out.println(product.getId()
					+ " " + product.getName() + 
					" " + product.getPrice());
			
			return "Ürün bulundu: " + product.getName();
			
		}
		//productRepository.findById(productId);
		return "Ürün bulunamadı";
		

		
	}
	
	
	@GetMapping("/product/list")
	@ResponseBody
	public String listProducts() {
		
		Iterable<Product> products = productRepository.findAll();
		int count = 0;
	
		
		for(Product p: products) {
			
			System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
			
			count++;
			
		}
		//productRepository.findById(productId);
		return "Ürün sayısı: " + count;
		

		
	}
	
	@GetMapping("/product/delete")
	@ResponseBody
	public String deleteProduct() {
		
		int productId = 4;
		
		if(!productRepository.existsById(productId)) {
			
			return "Ürün (Id: " + productId + ") bulunamadı";
		}
		
		productRepository.deleteById(productId);
		//productRepository.findById(productId);
		return "Silme işlemi gerçekleşti";
		

		
	}
	
	@GetMapping("/product/expensive")
	@ResponseBody
	public String listExpensiveProducts() {
		
		int minPrice = 6000;
		
		Iterable<Product> products = productRepository.findAllBySalesPriceMin(minPrice);
		int count = 0;
	
		
		for(Product p: products) {
			
			System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
			
			count++;
			
		}
		//productRepository.findById(productId);
		return "Ürün sayısı: " + count;
		

		
	}
	
	

}
