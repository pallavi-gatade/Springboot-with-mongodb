package com.practice.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Generated
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

	private String orderStatus;
	
	private LocalDate orderPurchaseDate ;
	
	private LocalDate orderDeliveryDate;
	
	private List<ProductRequestDto> products;
	
	private UserRequestDto user;

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getOrderPurchaseDate() {
		return orderPurchaseDate;
	}

	public void setOrderPurchaseDate(LocalDate orderPurchaseDate) {
		this.orderPurchaseDate = orderPurchaseDate;
	}

	public LocalDate getOrderDeliveryDate() {
		return orderDeliveryDate;
	}

	public void setOrderDeliveryDate(LocalDate orderDeliveryDate) {
		this.orderDeliveryDate = orderDeliveryDate;
	}

	public List<ProductRequestDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductRequestDto> products) {
		this.products = products;
	}

	public UserRequestDto getUser() {
		return user;
	}

	public void setUser(UserRequestDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "OrderRequestDto [orderStatus=" + orderStatus + ", orderPurchaseDate=" + orderPurchaseDate
				+ ", orderDeliveryDate=" + orderDeliveryDate + ", products=" + products + ", user=" + user + "]";
	}

	
	
}
