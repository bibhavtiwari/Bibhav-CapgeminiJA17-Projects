package com.capgemini.hashandequal.service;

import java.util.ArrayList;
import java.util.Collections;

import com.capgemini.hashandequal.model.Product;

public class ProductManager {
 ArrayList<Product> prolist = new ArrayList<Product>();
	public void createProduct() {
		Product p = new Product(1234,"Pen",35);
		Product p1 = new Product(134,"Erazer",25);
		prolist.add(p);
		prolist.add(p1);
		prolist.add(new Product(234,"Pen",65));
	}
	public void compareProducts() {
		if(prolist.get(0).equals(prolist.get(1))) {
			System.out.println("Equal");
		}else {
			System.out.println("Not Equal");
		}
	}
	public void sortProduct() {
		Collections.sort(prolist);
		System.out.println("Sorted List in comparable");
		for(Product p : prolist) {
			System.out.println(p.getPname());
		}
		
	}
	public void sortProductUsingName() {
		Collections.sort(prolist,new ProductNameComparator());
		System.out.println("Sorted List using Name");
		for(Product p : prolist) {
			System.out.println(p.getPname()+"\t\t"+p.getPrice());
		}
	}
	public void sortProductUsingProductId() {
		Collections.sort(prolist,new ProductIDComparator());
		System.out.println("Sorted List using ID");
		for(Product p : prolist) {
			System.out.println(p.getPname()+"\t\t"+p.getPid());
		}
	}
	public void sortProductUsingPrice() {
		Collections.sort(prolist,new ProductPriceComparator());
		System.out.println("Sorted List according to Price");
		for(Product p : prolist) {
			System.out.println(p.getPname()+"\t\t"+p.getPrice());
		}
	}

	

}
