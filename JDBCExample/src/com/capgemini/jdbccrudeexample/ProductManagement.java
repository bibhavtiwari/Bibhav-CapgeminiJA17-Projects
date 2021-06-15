package com.capgemini.jdbccrudeexample;

import java.util.Scanner;

public class ProductManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProductManagementSystem pms = new ProductManagementSystem();
		pms.dbConnection();
		
		char cont = 'y';
		while (cont == 'y') {
			System.out.println("Enter the choice: ");
			System.out.println("insert : To Insert the Product");
			System.out.println("update : To update the Product");
			System.out.println("delete : To delete the Product");
			System.out.println("getproduct : To get a single the Product");
			System.out.println("getallproduct : To get all  the Product");
			String transac = sc.next();
		
		switch(transac) {
		case "insert":
			pms.insertIntoProductUsingPS();
			break;
		case "update":
			pms.updateProductUsingId();
			break;
		case "delete":
			pms.deleteProductUsingID();
			break;
		case "getproduct":
			pms.getProductbyId();
			break;
		case "getallproduct":
			pms.getAllProduct();
			break;
		case "exit":
            System.out.println("Thank you for visiting......");
            System.out.println("Please visit again");
            System.exit(0);
            break;
		default:
			break;
		}//switch close
		System.out.println("want to continue ?");
		cont = sc.next().trim().charAt(0);
	}//while
	}

}
