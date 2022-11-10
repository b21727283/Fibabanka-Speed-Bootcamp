package com.example.springbootfirst.business.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springbootfirst.business.dto.ProductDto;
import com.example.springbootfirst.data.entity.Product;
import com.example.springbootfirst.data.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	
	//@Autowired
	private ProductRepository productRepository;
	
	public ProductServiceImp(ProductRepository productRepository) {
		
		this.productRepository = productRepository;
	}

	@Override
	public int create(ProductDto productDto) {
		
		/*Product product = new Product(productDto.getProductId(), 
				productDto.getProductName(), productDto.getSalesPrice());*/
		
		Product product = toEntity(productDto);
		
		productRepository.save(product);
		
		return  product.getId();

	}

	@Override
	public void update(ProductDto productDto) {
		
		/*Product product = new Product(productDto.getProductId(), 
				productDto.getProductName(), productDto.getSalesPrice());*/
		
		Product product = toEntity(productDto);
		
		productRepository.save(product);
		

	}

	@Override
	public ProductDto find(int productId) {
		
		Optional<Product> optional = productRepository.findById(productId);
		
		if(optional.isPresent()) {
			
			Product product = optional.get();
			/*ProductDto productDto = new ProductDto(product.getId(), product.getName(),
					product.getPrice());*/
			
			ProductDto productDto = toDTO(product);
			
			return productDto;
			
		}
		//productRepository.findById(productId);
		return null;
	}

	

	@Override
	public List<ProductDto> findAll() {
		
		Iterable<Product> products = productRepository.findAll();
		
		List<ProductDto> productDtos = new ArrayList<ProductDto>();
		
		for(Product p: products) {
			
			/*ProductDto productDto = new ProductDto(p.getId(), p.getName(),
					p.getPrice());*/
			
			ProductDto productDto = toDTO(p);
			
			productDtos.add(productDto);
			
		}

		return productDtos;
	}

	@Override
	public void delete(int productId) {
		
		if(productRepository.existsById(productId)) {
			
			productRepository.deleteById(productId);
		}
		
	}
	
	
	private Product toEntity(ProductDto productDto) {
		
		Product product = new Product(productDto.getProductId(), 
				productDto.getProductName(), productDto.getSalesPrice());
		
		return product;
		
	}
	
	private ProductDto toDTO(Product product) {
		
		ProductDto productDto = new ProductDto(product.getId(), product.getName(),
				product.getPrice());
		
		return productDto;
	}

}
