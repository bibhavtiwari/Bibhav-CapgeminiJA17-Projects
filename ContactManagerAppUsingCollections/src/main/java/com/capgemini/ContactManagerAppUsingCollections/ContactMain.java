package com.capgemini.ContactManagerAppUsingCollections;

import java.util.Collection;
import java.util.Scanner;

import com.capgemini.ContactManagerAppUsingCollections.model.Contact;
import com.capgemini.ContactManagerAppUsingCollections.service.ContactManager;

public class ContactMain {
	static Scanner sc = new Scanner(System.in);
	static String fName;
	static String lName;
	static String phNo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContactManager cm = new ContactManager();


		char choice ='y';
		while(choice == 'y') {
			System.out.println("Enter the choice");
			char ch = sc.next().trim().charAt(0);
			switch(ch) {
			case 'a':
				readDetails();
				cm.addContact(fName, lName, phNo);
				break;
			case 'g':
				Collection<Contact> data = cm.getAllContacts();
				System.out.println(data);
				break;
			case 'u':
				//cm.updateContactByKey(cm.generateKey(null))
				System.out.println("Update contact by key");
				break;
			case 'd':
				//cm.removeContactByKey(cm.generateKey(null))
				System.out.println("remove contact by key");
				break;
			case 'f':
				//cm.getContactByKey(cm.generateKey(null))
				System.out.println("Find contact by key");
				break;
			default:
				break;
			}//Switch close
			System.out.println("Continue y");
			choice = sc.next().trim().charAt(0);
		}//While close
	}
	public static void readDetails() {
		System.out.println("Enter the contact details");
		System.out.println("Enter First Name");
		fName = sc.next();
		System.out.println("Enter Last Name");
		lName = sc.next();
		System.out.println("Enter phone number");
		phNo = sc.next();
	}
}
