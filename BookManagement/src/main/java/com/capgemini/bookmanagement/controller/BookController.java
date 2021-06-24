package com.capgemini.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.bookmanagement.entity.Book;
import com.capgemini.bookmanagement.service.IBookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired 
	private IBookService bookService;
	
	@GetMapping("/showbooks")
	public  List<Book> showAllBooks() {
		return this.bookService.showAllBooks();
	}
	
	@PostMapping("/addbook")
	public Book saveOrder(@RequestBody Book book) {
		return this.bookService.addBook(book);
	}
	
	@PutMapping("/updatebook/{bookid}")
	public Book updateBook(@RequestBody Book book ,@PathVariable("bookid") long bookid) {
		return this.bookService.updateBook(book, bookid);
}
	@DeleteMapping("/deletebook/{bookid}")
	public ResponseEntity<Book> deleteBook(@PathVariable("bookid")long bookid){
	    return this.bookService.deleteBook(bookid);
	
}
	@GetMapping("/showbookbyid/{bookid}")
	public Book getBookById(@PathVariable("bookid")long bookid){
		return this.bookService.showBookById(bookid);
	}

	@GetMapping("/showbookbycategory/{bookcategory}")
	public List<Book> showBookByCategory(@PathVariable("bookcategory")String bookcategory){
		return this.bookService.showBookByCategory(bookcategory);
	}
	
	@GetMapping("/showbookbyname/{bookname}")
	public List<Book> showBookByName(@PathVariable("bookname")String bookname){
		return this.bookService.showBookByName(bookname);
	}
	
	@GetMapping("/showbookbyquantity/{bookavailable}")
	public List<Book> showBookByQuantity(@PathVariable("bookavailable")long bookavailable){
		return this.bookService.showBookByQuantity(bookavailable);
	}

	@GetMapping("/showbookdescbyid/{bookid}")
	public String showdescriptionById(@PathVariable("bookid")long bookid){
		return this.bookService.showBookDescriptionById(bookid);
	}

	@GetMapping("/showbookquantitybyname/{bookname}")
	public long showquantitybyname(@PathVariable("bookname")String bookname){
		return this.bookService.showBookQuantityByName(bookname);
	}
	@GetMapping("/showbookpricebyname/{bookname}")
	public long showBookPriceByname(@PathVariable("bookname")String bookname){
		return this.bookService.showBookPriceByName(bookname);
	}

	@GetMapping("/showbookpricebyid/{bookid}")
	public long showbookpriceId(@PathVariable("bookid")long bookid){
		return this.bookService.showBookPriceById(bookid);
	}
	
}
