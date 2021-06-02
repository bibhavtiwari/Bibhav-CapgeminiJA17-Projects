package com.capgemini.authorapp;

import java.util.Collection;
import java.util.Scanner;

import com.capgemini.authorapp.model.Author;
import com.capgemini.authorapp.service.AuthorServ;

public class AuthorMain {
	static Scanner sc = new Scanner(System.in);
	static String Name;
	static String Email;
	static char Gender;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuthorServ cm = new AuthorServ();
		char choice ='y';
		while(choice == 'y') {
			System.out.println("Enter the choice");
			char ch = sc.next().trim().charAt(0);
			switch(ch) {
			case 'a':
				readDetails();
				cm.addAuthor(Name, Email, Gender);
				break;
			case 'g':
				Collection<Author> data = cm.getAllAuthors();
				System.out.println(data);
				break;
			default:
				break;
			}//Switch close
			System.out.println("Continue y");
			choice = sc.next().trim().charAt(0);
		}//While close
}
	public static void readDetails() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Author details");
		System.out.println("Enter the Name");
		Name = sc.next();
		System.out.println("Enter Email");
		Email = sc.next();
		System.out.println("Enter gender");
		Gender = sc.next().charAt(0);
	}
}
