package com.capgemini.authorapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthorTest {
	static Author aut;
	Author aut1;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		aut = new Author("Rama","Krishna@gmail.com",'m');	
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		aut = null;
	}
	@BeforeEach
	void setUp() throws Exception {
		aut1 = new Author();
	}
	@AfterEach
	void tearDown() throws Exception {
		aut1 = null;
	}
	@Test
	void testAuthor() {
		assertEquals(new Author(),aut1);
	}
	@Test
	void testGetName() {
		assertEquals("Rama",aut.getName());
	}
	@Test
	void testGetEmail() {
		assertEquals("Krishna@gmail.com",aut.getEmail());
	}


	@Test
	void testGetGender() {
		assertEquals('m',aut.getGender());
	}
	
	
}
