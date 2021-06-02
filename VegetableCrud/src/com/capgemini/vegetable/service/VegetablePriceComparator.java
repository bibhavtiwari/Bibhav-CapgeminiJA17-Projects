package com.capgemini.vegetable.service;

import java.util.Comparator;

import com.capgemini.vegetable.model.Vegetable;

public class VegetablePriceComparator implements Comparator<Vegetable> {

	@Override
	public int compare(Vegetable veg1, Vegetable veg2) {
		// TODO Auto-generated method stub
		if(veg1.getPrice() == veg2.getPrice()) {
			return 0;
		}
		else if(veg1.getPrice() > veg2.getPrice()) {
			return 1;
		}
		else 
			return -1;
	}

}
