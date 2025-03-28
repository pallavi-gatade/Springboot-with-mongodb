package com.practice.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.mongodb.assertions.Assertions;
import com.practice.dto.ProductRequestDto;
import com.practice.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

	@Mock
	private ProductService productService;

	@InjectMocks
	private ProductController productController;
	
	@Test
	public  void testSaveProdct() throws Exception {
		
		ProductRequestDto productRequestDto = new ProductRequestDto();
		productRequestDto.setProductName("Adidas");
		productRequestDto.setProductCategory("Shoes");
		productRequestDto.setProductPrice(5400);
		
		when(productService.saveProduct(productRequestDto)).thenReturn(productRequestDto);
		
		ResponseEntity<ProductRequestDto> userRequestDto = productController.saveProduct(productRequestDto);

		Assertions.assertNotNull(userRequestDto);
	}
}
