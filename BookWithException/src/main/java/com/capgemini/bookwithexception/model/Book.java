package com.capgemini.bookwithexception.model;

import com.capgemini.bookwithexception.exception.BookIdCannotBeNegative;
import com.capgemini.bookwithexception.exception.BookNameCannotBeNull;
import com.capgemini.bookwithexception.exception.PriceIsNotValidException;

public class Book {
private int bookid;
private String bName;
private int price;
public Book() {
	super();
}

public int getBookid() {
	return bookid;
}



public void setBookid(int bookid) {
	this.bookid = bookid;
}



public String getbName() {
	return bName;
}



public void setbName(String bName) {
	this.bName = bName;
}



public int getPrice() {
	return price;
}



public void setPrice(int price) {
	this.price = price;
}



public Book(int bookid, String bName, int price) {
	super();
	this.bookid = bookid;
	this.bName = bName;
	this.price = price;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bName == null) ? 0 : bName.hashCode());
	result = prime * result + bookid;
	result = prime * result + price;
	return result;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Book other = (Book) obj;
	if (bName == null) {
		if (other.bName != null)
			return false;
	} else if (!bName.equals(other.bName))
		return false;
	if (bookid != other.bookid)
		return false;
	if (price != other.price)
		return false;
	return true;
}
public void validateBookName() throws BookNameCannotBeNull {
	// TODO Auto-generated method stub
	if(this.bName.isBlank()) {
		throw new BookNameCannotBeNull(this.bName);
	}
}
public void validateBookId() throws BookIdCannotBeNegative {
	// TODO Auto-generated method stub
	if(this.bookid < 0) {
		throw new BookIdCannotBeNegative("Book id cannot be negative");
	}
}
public void validatePrice() throws PriceIsNotValidException {
	// TODO Auto-generated method stub
	if(this.price < 0|| this.price == 0) {
		throw new PriceIsNotValidException("Price can't be 0 or Negative");
	}
}



}
