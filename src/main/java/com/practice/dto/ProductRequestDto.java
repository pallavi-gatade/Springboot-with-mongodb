package com.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Generated
public class ProductRequestDto {

	private String productName;
	
	private String productCategory;
	
	private double productPrice;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "ProductRequestDto [productName=" + productName + ", productCategory=" + productCategory
				+ ", productPrice=" + productPrice + "]";
	}
	
}
