package com.capgemini.authorapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorServTest {
	private AuthorServ autserv;
	@BeforeEach
	public void setup() {
		autserv = new AuthorServ();
	}
	@Test
	@DisplayName("Should create a author")
	public void shouldCreateContact() {
		autserv.addAuthor("Rama", "Krishna@gmail.com", 'm');
		assertFalse(autserv.getAllAuthors().isEmpty());
		assertEquals(1, autserv.getAllAuthors().size());
	}
	@Test
	@DisplayName("Should not create author when  name is null")
	public void NameIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			autserv.addAuthor(null, "Krishna@gmail.com", 'm');
		});
	}
	@Test
	@DisplayName("Should not create author when  name is null")
	public void EmailIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			autserv.addAuthor("Rama", null, 'm');
		});
	}
	@Test
	@DisplayName("Should not create author when  name is null")
	public void GenderIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			autserv.addAuthor("Rama", "Krishna@gmail.com", (Character) null);
		});
	}
	@Test
	@DisplayName("Should test Email if it contains @")
	public void shouldTestPhoneNumberFormat() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			autserv.addAuthor("Rama", "Krishnagmail.com", 'm');
		});
}
}
