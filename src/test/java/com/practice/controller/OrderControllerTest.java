package com.practice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.mongodb.assertions.Assertions;
import com.practice.dto.OrderRequestDto;
import com.practice.dto.ProductRequestDto;
import com.practice.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {
	
	@Mock
	private OrderService orderService;
	
	@InjectMocks
	private OrderController orderController;
	
	@Test
	public  void testSaveOrder() throws Exception {
		
		OrderRequestDto orderRequestDto = new OrderRequestDto();
		orderRequestDto.setOrderStatus("Order Confirmed");
		 LocalDate purchaseDate = LocalDate.parse("2025-02-25"); 
		orderRequestDto.setOrderPurchaseDate(purchaseDate);
		 LocalDate deliveredDate = LocalDate.parse("2025-03-01"); 
		 orderRequestDto.setOrderDeliveryDate(deliveredDate);

		 List<ProductRequestDto> products = new ArrayList<>();
			
		 ProductRequestDto productDto = new ProductRequestDto();
		 productDto.setProductCategory("Shoes");                
		 productDto.setProductName("Adidas");
		 productDto.setProductPrice(5400);
		 products.add(productDto);
		 orderRequestDto.setProducts(products); 
		 
		when(orderService.saveOrder(orderRequestDto)).thenReturn(orderRequestDto);
		
		ResponseEntity<OrderRequestDto> orderData = orderController.saveOrder(orderRequestDto);

		Assertions.assertNotNull(orderData);
		assertEquals(200, orderData.getStatusCodeValue()); 
		Assertions.assertNotNull(orderData.getBody()); 
		Assertions.assertNotNull(orderData.getBody().getProducts());
		Assertions.assertTrue(
			    orderData.getBody() != null && 
			    orderData.getBody().getProducts() != null && 
			    !orderData.getBody().getProducts().isEmpty()
			);
		assertEquals("Order Confirmed", orderData.getBody().getOrderStatus());
	}

}
