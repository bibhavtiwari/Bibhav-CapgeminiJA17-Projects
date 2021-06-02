package com.capgemini.hashandequal;

import com.capgemini.hashandequal.service.ProductManager;

public class ProductMain {
	public static void main(String[]args) {
		ProductManager pm = new ProductManager();
		pm.createProduct();
		pm.compareProducts();
		pm.sortProduct();
		pm.sortProductUsingName();
		pm.sortProductUsingProductId();
		pm.sortProductUsingPrice();
	}
}
