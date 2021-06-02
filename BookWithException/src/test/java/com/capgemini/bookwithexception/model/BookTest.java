package com.capgemini.bookwithexception.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {
		static Book bok;
		Book bok1;
		
		@BeforeAll
		static void setUpBeforeClass() throws Exception {
			bok = new Book(1234,"Krishna",100);	
		}
		@AfterAll
		static void tearDownAfterClass() throws Exception {
			bok = null;
		}
		@BeforeEach
		void setUp() throws Exception {
			bok1 = new Book();
		}
		@AfterEach
		void tearDown() throws Exception {
			bok1 = null;
		}
		@Test
		void testBook() {
			assertEquals(new Book(),bok1);
		}
		@Test
		void testGetbookId() {
			assertEquals(1234,bok.getBookid());
		}
		@Test
		void testGetbookName() {
			assertEquals("Krishna",bok.getbName());
		}


		@Test
		void testGetPrice() {
			assertEquals(100,bok.getPrice());
		}
		
}
