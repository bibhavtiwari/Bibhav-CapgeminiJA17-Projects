package com.capgemini.hashandequal.service;

import java.util.Comparator;

import com.capgemini.hashandequal.model.Product;

public class ProductIDComparator implements Comparator<Product> {

	@Override
	public int compare(Product pro1, Product pro2) {
		// TODO Auto-generated method stub
		if(pro1.getPid() == pro2.getPid()) {
			return 0;
		}
		else if(pro1.getPid() > pro2.getPid()) {
			return 1;
		}
		else 
			return -1;
		
	}

}
