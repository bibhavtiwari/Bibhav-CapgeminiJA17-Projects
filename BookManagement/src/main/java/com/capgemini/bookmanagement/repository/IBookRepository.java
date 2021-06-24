package com.capgemini.bookmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.bookmanagement.entity.Book;


@Repository
public interface IBookRepository  extends JpaRepository<Book,Long> {

	@Query("SELECT b FROM Book b WHERE b.bookcategory=?1")
	public List<Book> showBookByCategory(String bookcategory);
	
	@Query("SELECT b FROM Book b WHERE b.bookname=?1")
	public List<Book> showBookByName(String bookname);
	
	@Query("SELECT b FROM Book b WHERE b.bookavailable=?1")
	public List<Book> showBookByQuantity(long bookavailable);

	@Query("SELECT b.bookdescription FROM Book b WHERE b.bookid = ?1")
	String showBookDescriptionById(long bookid);
	
	@Query("SELECT b.bookprice FROM Book b WHERE b.bookid = ?1")
	Long showBookPriceById(long bookid);
	
	@Query("SELECT b.bookavailable FROM Book b WHERE b.bookname = ?1")
	Long showBookQuantityByName(String bookname);
	
	@Query("SELECT b.bookprice FROM Book b WHERE b.bookname = ?1")
	Long showBookPriceByName(String bookname);

	
}
