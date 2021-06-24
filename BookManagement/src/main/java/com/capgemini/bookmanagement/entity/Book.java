package com.capgemini.bookmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "book_Sequence")
    @SequenceGenerator(name = "book_Sequence", sequenceName = "BOOK_SEQ")
	private long bookid;
	
	@Column(name = "bookname")
	private String bookname;
	
	@Column(name = "bookprice")
	private long bookprice;
	
	@Column(name = "bookcategory")
	private String bookcategory;
	
	@Column(name = "bookavailable")
	private long bookavailable;
	
	@Column(name = "bookdescription")
	private String bookdescription;

	public Book() {
		super();
	}

	public Book(String bookname, long bookprice, String bookcategory, long bookavailable, String bookdescription) {
		super();
		this.bookname = bookname;
		this.bookprice = bookprice;
		this.bookcategory = bookcategory;
		this.bookavailable = bookavailable;
		this.bookdescription = bookdescription;
	}

	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public long getBookprice() {
		return bookprice;
	}

	public void setBookprice(long bookprice) {
		this.bookprice = bookprice;
	}

	public String getBookcategory() {
		return bookcategory;
	}

	public void setBookcategory(String bookcategory) {
		this.bookcategory = bookcategory;
	}

	public long getBookavailable() {
		return bookavailable;
	}

	public void setBoolavailable(long bookavailable) {
		this.bookavailable = bookavailable;
	}

	public String getBookdescription() {
		return bookdescription;
	}

	public void setBookdescription(String bookdescription) {
		this.bookdescription = bookdescription;
	}
	
	
	

}
