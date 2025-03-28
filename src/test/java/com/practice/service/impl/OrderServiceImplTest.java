package com.practice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.practice.dto.OrderRequestDto;
import com.practice.dto.ProductRequestDto;
import com.practice.dto.UserRequestDto;
import com.practice.entity.Order;
import com.practice.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

	@Mock
	private OrderRepository orderRepo;

	@InjectMocks
	private OrderServiceImpl orderServiceImpl;

	@Test
	public void testSaveUser() {
		
		OrderRequestDto orderDto = new OrderRequestDto();
		
		orderDto.setOrderStatus("Order Confirmed");
		 LocalDate purchaseDate = LocalDate.parse("2025-02-25"); 
		 orderDto.setOrderPurchaseDate(purchaseDate);
		 LocalDate deliveredDate = LocalDate.parse("2025-03-01"); 
		 orderDto.setOrderDeliveryDate(deliveredDate);

		 List<ProductRequestDto> products = new ArrayList<>();
			
		 ProductRequestDto productDto = new ProductRequestDto();
		 productDto.setProductCategory("Shoes");                
		 productDto.setProductName("Adidas");
		 productDto.setProductPrice(5400);
		 products.add(productDto);
		 orderDto.setProducts(products); 
		 
		 UserRequestDto userDto = new UserRequestDto();
		 userDto.setUserName("Pinky");                
		 userDto.setTierType(2);
		 
		 orderDto.setUser(userDto);
		
		 OrderRequestDto result = orderServiceImpl.saveOrder(orderDto);

			Assertions.assertNotNull(result);
			Assertions.assertEquals("Order Confirmed", result.getOrderStatus());
			Assertions.assertEquals(purchaseDate, result.getOrderPurchaseDate());
			assertEquals(5400, result.getProducts().get(0).getProductPrice());
			Assertions.assertEquals("Pinky", result.getUser().getUserName());

			verify(orderRepo, times(1)).save(any(Order.class));
		
	}
	
}
