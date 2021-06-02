package com.capgemini.vegetable;

import java.util.ArrayList;
import java.util.Scanner;
import com.capgemini.vegetable.model.Vegetable;
import com.capgemini.vegetable.service.VegetableManage;

public class VegetableMain {
	static int vegid;
	static String vegname;
	static float vegprice;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[]args) {
		ArrayList<Vegetable> veglist = new ArrayList<Vegetable>();
		VegetableManage bs = new VegetableManage();
		
		char ch;
		do
		{
			System.out.println("Enter 1 to create .");
			System.out.println("Enter 2 to display .");
			System.out.println("Enter 3 to update .");
			System.out.println("Enter 4 to delete .");
			System.out.println("Enter 5 to sort using vegetable name .");
			System.out.println("Enter 6 to sort using vegetable ID .");
			System.out.println("Enter 7 to sort using vegetable Price .");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1: 
				readDetails();
				bs.createVegetable(vegid, vegname, vegprice);
				break;
			 case 2:
				 bs.sortVegetable();
				break;
			case 3:
				bs.updateVegetable();
				break;
			case 4:
				bs.deleteVegetable();
				break;
			case 5:
				bs.sortVegetableUsingName();
				break;
			case 6:
				bs.sortVegetableUsingVegetableId();
				break;
			case 7:
				bs.sortVegetableUsingPrice();
				break;
		
			default:
				System.out.println("Wrong choice.");
			}
			System.out.println("Enter y to continue: ");
			ch = sc.next().trim().charAt(0);
		}while(ch == 'y');
		sc.close();
		}
	
	
	private static void readDetails() {
		System.out.println("Enter the Vegetable details\nEnter the vegid");
		vegid=sc.nextInt();
		System.out.println("enter the vegetable Name");
		vegname=sc.next();
		System.out.println("enter vegetable price");
		vegprice=sc.nextInt();
	}
}
