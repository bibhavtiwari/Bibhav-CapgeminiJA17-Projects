package com.capgemini.hashandequal.service;

import java.util.Comparator;

import com.capgemini.hashandequal.model.Product;

public class ProductNameComparator implements Comparator<Product>{

	@Override
	public int compare(Product pro1, Product pro2) {
		// TODO Auto-generated method stub
		return pro1.getPname().compareTo(pro2.getPname());
	}	
	

}
