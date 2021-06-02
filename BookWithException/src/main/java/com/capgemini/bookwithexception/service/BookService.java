package com.capgemini.bookwithexception.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.bookwithexception.exception.ArrayListIsNullException;
import com.capgemini.bookwithexception.exception.BookAlreadyFoundException;
import com.capgemini.bookwithexception.exception.BookIdCannotBeNegative;
import com.capgemini.bookwithexception.exception.BookNameCannotBeNull;
import com.capgemini.bookwithexception.exception.BookNotFoundException;
import com.capgemini.bookwithexception.exception.PriceIsNotValidException;
import com.capgemini.bookwithexception.model.Book;

public class BookService {
	Scanner sc = new Scanner(System.in);
	ArrayList<Book> blist = new ArrayList<Book>();
	Book bkr;
	public void addRecord(int bid,String bName,int price) throws BookNameCannotBeNull, PriceIsNotValidException {
		Book bk = new Book(bid,bName,price);
		try {
			validateBook(bk);
			checkIfBookAlreadyExists(bk);
			blist.add(bk);
			
		}catch(BookIdCannotBeNegative ex) {
			System.out.println(ex.getMessage());
		}
		catch(BookNameCannotBeNull ex) {
			System.out.println(ex.getMessage());
		}
		catch(PriceIsNotValidException ex) {
			System.out.println(ex.getMessage());
		}
		catch(BookAlreadyFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	private void checkIfBookAlreadyExists(Book bk) throws BookAlreadyFoundException {
		// TODO Auto-generated method stub
		for(Book book : blist) {
			if(book.getBookid()==bk.getBookid()) {
				throw new BookAlreadyFoundException("Book Already Found");
			}
		}
		
	}
	private void validateBook(Book bk) throws BookIdCannotBeNegative, BookNameCannotBeNull, PriceIsNotValidException {
		// TODO Auto-generated method stub
		bk.validateBookId();
		bk.validateBookName();
		bk.validatePrice();
		
	}
	public void displayRecords() {
		try {
			if(blist.size()==0) {
		
			throw new ArrayListIsNullException("No Records are Present");
		}
		else {
		for(Book book : blist) {
			System.out.println(book.getBookid() + book.getbName() + book.getPrice());
		}
		}
		}
		catch(ArrayListIsNullException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void updateRecords() {
		System.out.println("Enter the bid of the Book you want to update");
		int ch_bid=sc.nextInt();
		int flag=0;
		for(Book bk:blist) {
			if(bk.getBookid()==ch_bid) {
				int curr_id=bk.getBookid();
				String curr_name=bk.getbName();
				int curr_price=bk.getPrice();
				flag=1;
				System.out.println("Select one choice\n1. Update Book Name\n2. Update Book Price");
				int choi=sc.nextInt();
				if(choi==1) {
					System.out.println("Enter new Book Name");
					String new_name=sc.next();
					try {
						if(new_name.length()==0) {
							throw new BookNameCannotBeNull("Book Name Can't be null");
						}
						else {
							bkr=new Book(curr_id,new_name,curr_price);
							blist.set(blist.indexOf(bk), bkr);
							System.out.println("updated successfully");
						}
					}
					catch(BookNameCannotBeNull ex) {
						System.out.println(ex.getMessage());
					}
				}
				else if(choi==2) {
					System.out.println("Enter new Book Price");
					int new_price=sc.nextInt();
					try {
						if(new_price==0 || new_price<0) {
							throw new PriceIsNotValidException("Price can't be 0 or negative");
						}
						else {
							bkr=new Book(curr_id,curr_name,new_price);
							blist.set(blist.indexOf(bk), bkr);	
							System.out.println("updated successfully");
						}
					}
					catch(PriceIsNotValidException ex) {
						System.out.println(ex.getMessage());
					}	
				}
			}//if end
			break;
		}//for end
		try {
			if(flag==0) {
				throw new BookNotFoundException("Book Record not found with this bid");
			}
		}
		catch(BookNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deleteRecord() {
		System.out.println("Enter the bid of the Book you want to delete");
		int ch_bid=sc.nextInt();
		int flag=0;
		for(Book book : blist) {
			if(book.getBookid()==ch_bid) {
				blist.remove(blist.indexOf(book));
				System.out.println("Deleted Successfully!!!");
				flag=1;	
				break;
			}	
		}
		try {
			if(flag==0) {
				throw new BookNotFoundException("Book Record not found with this bid");
			}
		}
		catch(BookNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
}
