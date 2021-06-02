package com.capgemini.vegetable.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


import com.capgemini.vegetable.model.Vegetable;



public class VegetableManage {
	Vegetable vgi;
	Scanner sc = new Scanner(System.in);
	ArrayList<Vegetable> veglist = new ArrayList<Vegetable>();
	public void createVegetable(int vegid,String vegname,float vegprice) {
		veglist.add(new Vegetable(vegid,vegname,vegprice));
	}
	public void sortVegetable() {
		Collections.sort(veglist);
		System.out.println("Displaying Vegetables After sorting");
		for(Vegetable v : veglist) {
			System.out.println(v.getVegname());
			
		}
		}
	public void updateVegetable() {
		System.out.println("Enter the vegid of the Vegetable you want to update");
		int ch_vegid=sc.nextInt();
		int flag=0;
		for(Vegetable vg:veglist) {
			if(vg.getVegid()==ch_vegid) {
				int curr_id=vg.getVegid();
				String curr_name=vg.getVegname();
				float curr_price=vg.getPrice();
				flag=1;
				System.out.println("Select one choice\n1. Update Vegetable Name\n2. Update Vegetable Price");
				int choi=sc.nextInt();
				if(choi==1) {
				System.out.println("Enter new Vegetable Name");
				String new_name=sc.next();
				vgi=new Vegetable(curr_id,new_name,curr_price);
				veglist.set(veglist.indexOf(vg), vgi);
				System.out.println("updated successfully");
			} else if (choi == 2) {
				System.out.println("Enter new Vegetable price");
				Float new_price=sc.nextFloat();
				vgi = new Vegetable(curr_id,curr_name,new_price);
				veglist.set(veglist.indexOf(vg), vgi);
				System.out.println("updated successfully");
			}
				
		}
		}
	}
	
	public void deleteVegetable() {
		
	
	System.out.println("Enter the bid of the Book you want to delete");
	int ch_vegid=sc.nextInt();
	int flag=0;
	for(Vegetable vege : veglist) {
		if(vege.getVegid()==ch_vegid) {
			veglist.remove(veglist.indexOf(vege));
			System.out.println("Deleted Successfully!!!");
			flag=1;	
			break;
		}
}
}
	public void sortVegetableUsingName() {
		Collections.sort(veglist,new VegetableNameComparator());
		System.out.println("Sorted List using Name");
		for(Vegetable v : veglist) {
			System.out.println(v.getVegname()+"\t\t"+v.getPrice());
		}
	}
	public void sortVegetableUsingVegetableId() {
		Collections.sort(veglist,new VegetableIDComparator());
		System.out.println("Sorted List using ID");
		for(Vegetable v : veglist) {
			System.out.println(v.getVegname()+"\t\t"+v.getVegid());
		}
	}
	public void sortVegetableUsingPrice() {
		Collections.sort(veglist,new VegetablePriceComparator());
		System.out.println("Sorted List according to Price");
		for(Vegetable v : veglist) {
			System.out.println(v.getVegname()+"\t\t"+v.getPrice());
		}
	}

	}