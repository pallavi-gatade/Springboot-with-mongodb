package com.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.dto.ProductRequestDto;
import com.practice.service.ProductService;

public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService){
		this.productService = productService;
	} 
	
	@PostMapping("/product")
	public ResponseEntity<ProductRequestDto> saveProduct(@RequestBody ProductRequestDto productDetails) {
		
		productDetails = productService.saveProduct(productDetails);
		
		return ResponseEntity.ok(productDetails);
	}
}
