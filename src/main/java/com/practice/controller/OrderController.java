package com.practice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.practice.dto.OrderRequestDto;
import com.practice.service.OrderService;

public class OrderController {
	
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping("/order")
	public ResponseEntity<OrderRequestDto> saveOrder(@RequestBody OrderRequestDto orderData) {
		
		orderData = orderService.saveOrder(orderData);
		
		return ResponseEntity.ok(orderData);
	}
}
