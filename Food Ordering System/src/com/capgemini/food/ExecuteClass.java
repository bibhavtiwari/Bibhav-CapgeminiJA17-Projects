package com.capgemini.food;

import java.util.Scanner;

public class ExecuteClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServiceClass sv = new ServiceClass();
		Scanner sc = new Scanner(System.in);
		sv.dbConnection();

		char cont = 'y';
		while (cont == 'y') {
			System.out.println("Enter the choice: ");
			System.out.println("1.customer");
			System.out.println("2.vendor");
			String tran = sc.next();
			switch(tran) {
			case "customer":
				System.out.println("register: New Customer");
				System.out.println("login: Already Registered Customers");
				String stran = sc.next();
				switch(stran) {
				case "register":
				 sv.insertIntoCustomer();
				 System.out.println("Registered continue again and login");
					
					break;
				case "login":
					System.out.println("Enter Customer ID");
					int cid = sc.nextInt();
					System.out.println("Enter Password");
					String pass = sc.next();
					sv.loginCustomer(cid, pass);
					sv.displayCustomerbyID(cid);
					break;
				
				}//End Sub Switch
				break;
			case "vendor":
				System.out.println("register: New Vendor");
				System.out.println("login: Already Registered Vendor");
				String stran1 = sc.next();
				switch(stran1) {
				case "register":
					sv.insertIntoVendor();
					System.out.println("Registered continue again and login");
					
					break;
				case "login":
					System.out.println("Enter Vendor ID");
					int vid = sc.nextInt();
					System.out.println("Enter Password");
					String pass = sc.next();
					sv.loginVendor(vid,pass);
					String trans2 = sc.next();
					switch(trans2) {
					case "insertmenu":
						sv.insertIntoMenu();
						break;
					case "updatemenu":
						break;
					}
					break;
				
				}//End Sub Switch
				break;
			}//Switch end
		System.out.println("want to continue ?");
		cont = sc.next().trim().charAt(0);
	}//while
	}

}
