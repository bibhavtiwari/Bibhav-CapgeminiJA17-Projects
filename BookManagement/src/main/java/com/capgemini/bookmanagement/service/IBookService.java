package com.capgemini.bookmanagement.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.bookmanagement.entity.Book;


@Service
public interface IBookService {

	public List<Book> showAllBooks();
	public Book showBookById(long bookid);
	public Book addBook(Book book);
	public Book updateBook(Book book , long bookid);
	public ResponseEntity<Book> deleteBook(long bookid);
	public List<Book> showBookByCategory(String bookcategory);
	public List<Book> showBookByName(String bookname);
	public List<Book> showBookByQuantity(long bookavailable);
	public String showBookDescriptionById( long bookid);
	public long showBookQuantityByName(String bookname);
	public long showBookPriceByName(String bookname);
	public long showBookPriceById(long bookid);
	

}
