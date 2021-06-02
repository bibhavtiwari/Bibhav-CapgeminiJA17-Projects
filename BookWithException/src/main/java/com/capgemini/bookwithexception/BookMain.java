package com.capgemini.bookwithexception;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.bookwithexception.exception.BookIdCannotBeNegative;
import com.capgemini.bookwithexception.exception.BookNameCannotBeNull;
import com.capgemini.bookwithexception.exception.PriceIsNotValidException;
import com.capgemini.bookwithexception.model.Book;
import com.capgemini.bookwithexception.service.BookService;
public class BookMain {
	static int bookid;
	static int price;
	static String bName;
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws BookIdCannotBeNegative, BookNameCannotBeNull, PriceIsNotValidException {
		// TODO Auto-generated method stub
		
		ArrayList<Book> blist = new ArrayList<Book>();
		BookService bs = new BookService();
		
		char ch;
		do
		{
			System.out.println("Enter 1 to create customer.");
			System.out.println("Enter 2 to display customer.");
			System.out.println("Enter 3 to update customer.");
			System.out.println("Enter 4 to delete customer.");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1: 
				readDetails();
				bs.addRecord(bookid, bName, price);
				break;
			 case 2:
				 bs.displayRecords();
				break;
			case 3:
				bs.updateRecords();
				break;
			case 4:
				bs.deleteRecord();
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
		System.out.println("Enter the Book details\nEnter the Bid");
		bookid=sc.nextInt();
		System.out.println("enter the Name of book");
		bName=sc.next();
		System.out.println("enter price");
		price=sc.nextInt();
	}
	
	
		
	

}
