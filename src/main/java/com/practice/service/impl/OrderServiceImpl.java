package com.practice.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.practice.dto.OrderRequestDto;
import com.practice.dto.ProductRequestDto;
import com.practice.entity.Order;
import com.practice.entity.Product;
import com.practice.entity.User;
import com.practice.repository.OrderRepository;
import com.practice.service.OrderService;

public class OrderServiceImpl implements OrderService{

	private final OrderRepository orderRepo;
	
	public OrderServiceImpl(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	
	@Override
	public OrderRequestDto saveOrder(OrderRequestDto orderData) {

		Order order = new Order();
		order.setStatus(orderData.getOrderStatus());
		order.setOrderDate(orderData.getOrderPurchaseDate());
		order.setDeliveryDate(orderData.getOrderDeliveryDate());
		
		List<Product> productdata = new ArrayList<Product>();
		for (ProductRequestDto productDto :  orderData.getProducts()) {
		
			Product product = new Product();
			product.setCategory(productDto.getProductCategory());
			product.setName(productDto.getProductName());
			product.setPrice(productDto.getProductPrice());
			productdata.add(product);
		}
		order.setProducts(productdata);

		User user = new User();
		user.setName(orderData.getUser().getUserName());
		user.setTier(orderData.getUser().getTierType());
		
		order.setUser(user);
		orderRepo.save(order);
		
		return orderData;
	}
}
