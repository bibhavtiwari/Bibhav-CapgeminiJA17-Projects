package com.capgemini.bookmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.bookmanagement.entity.Book;
import com.capgemini.bookmanagement.exception.BookNotFoundException;
import com.capgemini.bookmanagement.repository.IBookRepository;



@Service
public class BookService implements IBookService {
	
	@Autowired
	private IBookRepository bookRepository;

	@Override
	public List<Book> showAllBooks() {
		// TODO Auto-generated method stub
		return this.bookRepository.findAll();
	}

	@Override
	public Book showBookById(long bookid) {
		// TODO Auto-generated method stub
		return this.bookRepository.findById(bookid)
				.orElseThrow(() -> new BookNotFoundException("Order not found with id " + bookid));
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return this.bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book, long bookid) {
		// TODO Auto-generated method stub
		Book existingbook = this.bookRepository.findById(bookid)
		.orElseThrow(() -> new BookNotFoundException("Order not found with id " + bookid));
		existingbook.setBookname(book.getBookname());
		existingbook.setBookprice(book.getBookprice());
		existingbook.setBookcategory(book.getBookcategory());
		existingbook.setBoolavailable(book.getBookavailable());
		existingbook.setBookdescription(book.getBookdescription());
		return this.bookRepository.save(existingbook);
		
	}

	@Override
	public ResponseEntity<Book> deleteBook(long bookid) {
		// TODO Auto-generated method stub
		Book existingbook = this.bookRepository.findById(bookid)
				.orElseThrow(() -> new BookNotFoundException("Order not found with id " + bookid));
		this.bookRepository.delete(existingbook);
		return ResponseEntity.ok().build();
	}

	

	@Override
	public List<Book> showBookByName(String bookname) {
		// TODO Auto-generated method stub
		return this.bookRepository.showBookByName(bookname);
	}

	@Override
	public List<Book> showBookByQuantity(long bookavailable) {
		// TODO Auto-generated method stub
		return this.bookRepository.showBookByQuantity(bookavailable);
	}

	@Override
	public String showBookDescriptionById(long bookid) {
		// TODO Auto-generated method stub
		return this.bookRepository.showBookDescriptionById(bookid);
	}

	@Override
	public long showBookQuantityByName(String bookname) {
		// TODO Auto-generated method stub
		return this.bookRepository.showBookQuantityByName(bookname);
	}

	@Override
	public long showBookPriceByName( String bookname) {
		// TODO Auto-generated method stub
		return this.bookRepository.showBookPriceByName(bookname);
	}

	@Override
	public long showBookPriceById(long bookid) {
		// TODO Auto-generated method stub
		return this.bookRepository.showBookPriceById(bookid);
	}

@Override
public List<Book> showBookByCategory(String bookcategory) {
	// TODO Auto-generated method stub
	return this.bookRepository.showBookByCategory(bookcategory);
}

	
}
