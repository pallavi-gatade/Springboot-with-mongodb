package com.practice.service.impl;

import com.practice.dto.ProductRequestDto;
import com.practice.entity.Product;
import com.practice.repository.ProductRepository;
import com.practice.service.ProductService;

public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepo;
	
	public ProductServiceImpl(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	@Override
	public ProductRequestDto  saveProduct(ProductRequestDto productDetails) {

		Product product = new Product();
		product.setName(productDetails.getProductName());
		product.setCategory(productDetails.getProductCategory());
		product.setPrice(productDetails.getProductPrice());
		productRepo.save(product);
		
 		return productDetails;
	}

}
