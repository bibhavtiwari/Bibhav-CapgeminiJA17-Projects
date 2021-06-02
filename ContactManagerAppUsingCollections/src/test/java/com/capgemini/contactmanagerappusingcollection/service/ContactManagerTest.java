package com.capgemini.contactmanagerappusingcollection.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.capgemini.ContactManagerAppUsingCollections.service.ContactManager;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;



public class ContactManagerTest {
	/**
	 * Object of Contact Manager Test
	 */
	private ContactManager contManager;

	@BeforeAll
	public static void setupAll() {
		System.out.println("Should print before all tests");
	}

	@BeforeEach
	public void setup() {
		System.out.println("Should print before each test");
		System.out.println("Instantiating the Contact Manager App");
		contManager = new ContactManager();
	}

	@Test
	@DisplayName("Should create a contact")

	public void shouldCreateContact() {
		contManager.addContact("Rama", "Krishna", "01234567891");
		assertFalse(contManager.getAllContacts().isEmpty());
		assertEquals(1, contManager.getAllContacts().size());
	}

	@Test
	@DisplayName("Should not create contact when first name is null")
	public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			contManager.addContact(null, "Krishna", "0123456789");
		});
	}

	@Test
	@DisplayName("Should not create contact when last name is null")
	public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			contManager.addContact("Hare", null, "0123456789");
		});
	}

	@Test
	@DisplayName("Should not create contact when phone number is null")
	public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			contManager.addContact("Hare", "Krishna", null);
		});
	}

	@Test
	@DisplayName("Should test phone number start with 0")
	public void shouldTestPhoneNumberFormat() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			contManager.addContact("Hare", "Krishna", "89898989898");
		});
	}

	@Nested
	class RepeatedTests {
		@DisplayName("Should create contact")
		@RepeatedTest(value=5, name="Repeating contact creation test {currentRepetition} of {totalRepetition}")
		public void shouldCreateContactRepeatedly() {
			contManager.addContact("Rama", "Krishna", "01234567891");
			assertFalse(contManager.getAllContacts().isEmpty());
			assertEquals(1, contManager.getAllContacts().size());
		}
	}

	@Nested
	class ParameterizedTests {
		@DisplayName("Phone number should match with required format")
		@ParameterizedTest
		@ValueSource(strings= {"09876543211", "09876543212", "09876543213"})
		public void shouldTestPhoneNumberFormatUsingValueSource(String phoneNumber) {
			contManager.addContact("Rama","Krishna",phoneNumber);
			assertFalse(contManager.getAllContacts().isEmpty());
			assertEquals(1,contManager.getAllContacts().size());

		}
	}

	private static List<String> phoneNumberList(){
		return Arrays.asList("09876543234","09876543235","09876543236");
	}

	@DisplayName("Testing Phone Numbers in required format using Method Source")
	@ParameterizedTest
	@MethodSource("phoneNumberList")
	public void testPhoneNumbersUsingMethodSource(String phoneNumber) {
		contManager.addContact("Rama","Krishna",phoneNumber);
		assertFalse(contManager.getAllContacts().isEmpty());
		assertEquals(1,contManager.getAllContacts().size());	
	}

	@Test
	@DisplayName("disable test")
	@Disabled
	public void disabledTest() {
		throw new RuntimeException("this test is a disabled test");
	}

	@AfterEach
	public void tearDown() {
		System.out.println("Should execute after each test");
	}

	@AfterAll
	public static void tearDownAll() {
		System.out.println("should execute after all tests are done");
	}
}