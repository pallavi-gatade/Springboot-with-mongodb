package com.practice.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.practice.dto.ProductRequestDto;
import com.practice.entity.Product;
import com.practice.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

	@Mock
	private ProductRepository productRepo;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	@Test
	public void testSaveProduct() {
		ProductRequestDto productDto = new ProductRequestDto();
		productDto.setProductName("Adidas");
		productDto.setProductCategory("Shoes");
		productDto.setProductPrice(5400);

		ProductRequestDto result = productServiceImpl.saveProduct(productDto);

		Assertions.assertNotNull(result);
		Assertions.assertEquals("Adidas", result.getProductName());
		Assertions.assertEquals("Shoes", result.getProductCategory());
		Assertions.assertEquals(5400, result.getProductPrice());
		verify(productRepo, times(1)).save(any(Product.class));

	}
}
