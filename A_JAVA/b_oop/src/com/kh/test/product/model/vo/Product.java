package com.kh.test.product.model.vo;

public class Product {

	private String productCode;
	private int price;
	
	public Product() {
		
	}

	public Product(String productCode, int price) {
		this.productCode = productCode;
		this.price = price;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
