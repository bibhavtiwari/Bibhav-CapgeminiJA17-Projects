package com.capgemini.vegetable.service;

import java.util.Comparator;

import com.capgemini.vegetable.model.Vegetable;

public class VegetableNameComparator implements Comparator<Vegetable> {

	@Override
	public int compare(Vegetable veg1, Vegetable veg2) {
		// TODO Auto-generated method stub
		return veg1.getVegname().compareTo(veg2.getVegname());
	}

}
