package com.capgemini.hashandequal.service;

import java.util.Comparator;

import com.capgemini.hashandequal.model.Product;

public class ProductPriceComparator implements Comparator<Product> {

	@Override
	public int compare(Product pro1, Product pro2) {
		// TODO Auto-generated method stub
		if(pro1.getPrice() == pro2.getPrice()) {
			return 0;
		}
		else if(pro1.getPrice() > pro2.getPrice()) {
			return 1;
		}
		else 
			return -1;
		
	}

}
