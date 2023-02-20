package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import services.Contact;

/**
 * 
 * @author Eric Slutz
 * 
 * SNHU CS-320
 * Module 3 Milestone
 *
 */
class ContactTest {
	/**
	 * Tests creating a contact with valid arguments.
	 * 
	 * @param testId values to be tested
	 */
	@ParameterizedTest
	@ValueSource(strings = { 
			"0",
			"01",
			"012",
			"0123",
			"01234",
			"012345",
			"0123456",
			"01234567",
			"0123456789" })
	void testCreateContactWithValidId(String testId) {
		assertTrue(new Contact(testId, "fName", "lName", "0123456789", "address").getContactId() == testId);
	}
	
	/**
	 * Tests creating a contact with invalid null or empty argument for contactId.
	 * 
	 * @param testId values to be tested
	 */
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    " })
	void testCreateContactWithInvalidNullOrEmptyId(String testId) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact(testId, "fName", "lName", "0123456789", "address"));
		assertEquals("contactId must have a value.", exception.getMessage());	
	}
	
	/**
	 * Tests creating a contact with invalid length argument for contactId.
	 * 
	 * @param testId values to be tested
	 */
	@Test
	void testCreateContactWithInvalidLengthId(String testId) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("01234567890", "fName", "lName", "0123456789", "address"));
		assertEquals("contactId cannot be longer than 10 characters.", exception.getMessage());			
	}

	/**
	 * Tests creating a contact with valid argument for firstName.
	 * 
	 * @param testFirstName values to be tested
	 */
	@ParameterizedTest
	@ValueSource(strings = { 
			"0",
			"01",
			"012",
			"0123",
			"01234",
			"012345",
			"0123456",
			"01234567",
			"0123456789" })
	void testCreateContactWithValidFirstName(String testFirstName) {
		Contact testContact = new Contact("id", testFirstName, "lName", "0123456789", "address");
		assertTrue(testContact.getFirstName() == testFirstName);	
	}
	
	/**
	 * Tests creating a contact with invalid null or empty argument for firstName.
	 * 
	 * @param testFirstName values to be tested
	 */
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    " })
	void testCreateContactWithInvalidNullOrEmptyFirstName(String testFirstName) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", testFirstName, "lName", "0123456789", "address"));
		assertEquals("firstName must have a value.", exception.getMessage());	
	}
	
	/**
	 * Tests creating a contact with invalid length argument for firstName.
	 * 
	 * @param testFirstName values to be tested
	 */
	@Test
	void testCreateContactWithInvalidLengthFirstName() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "01234567890", "lName", "0123456789", "address"));
		assertEquals("firstName cannot be longer than 10 characters.", exception.getMessage());	
	}
	
	/**
	 * Tests creating a contact with valid argument for lastName.
	 * 
	 * @param testLastName values to be tested
	 */
	@ParameterizedTest
	@ValueSource(strings = { 
			"0",
			"01",
			"012",
			"0123",
			"01234",
			"012345",
			"0123456",
			"01234567",
			"0123456789" })
	void testCreateContactWithValidLastName(String testLastName) {
		Contact testContact = new Contact("id", "fName", testLastName, "0123456789", "address");
		assertTrue(testContact.getLastName() == testLastName);
	}
	
	/**
	 * Tests creating a contact with invalid null or empty argument for lastName.
	 * 
	 * @param testLasttName values to be tested
	 */
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    " })
	void testCreateContactWithInvalidNullOrEmptyLastName(String testLasttName) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fName", testLasttName, "0123456789", "address"));
		assertEquals("lastName must have a value.", exception.getMessage());	
	}
	
	/**
	 * Tests creating a contact with invalid length argument for firstName.
	 * 
	 * @param testFirstName values to be tested
	 */
	@Test
	void testCreateContactWithInvalidLengthLastName() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fname", "01234567890", "0123456789", "address"));
		assertEquals("lastName cannot be longer than 10 characters.", exception.getMessage());	
	}
	
	/**
	 * Tests creating a contact with valid argument for phone.
	 * 
	 * @param testPhone values to be tested
	 */
	@Test
	void testCreateContactWithValidPhone() {
		Contact testContact = new Contact("id", "fName", "lName", "0123456789", "address");
		assertTrue(testContact.getPhone() == "0123456789");
	}
	
	/**
	 * Tests creating a contact with invalid null or empty argument for phone.
	 * 
	 * @param testPhone values to be tested
	 */
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    " })
	void testCreateContactWithInvalidNullOrEmptyPhone(String testPhone) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fName", "lName", testPhone, "address"));
		assertEquals("phone number must have a value.", exception.getMessage());
	}

	/**
	 * Tests creating a contact with invalid length or non-digit argument for phone.
	 * 
	 * @param testPhone values to be tested
	 */
	@ParameterizedTest
	@ValueSource(strings = { 
			"01234",
			"abcdefghij",
			"01234567890" })
	void testCreateContactWithInvalidLengthOrNonDigitPhone(String testPhone) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fName", "lName", testPhone, "address"));
		assertEquals("phone number must be 10 digits.", exception.getMessage());
	}
	
	/**
	 * Tests creating a contact with valid argument for address.
	 * 
	 * @param testAddress values to be tested
	 */
	@ParameterizedTest
	@ValueSource(strings = { 
			"0",
			"01",
			"012",
			"0123",
			"01234",
			"012345",
			"0123456",
			"01234567",
			"0123456789",
			"01234567890123456789",
			"012345678901234567890123456789" })
	void testContactWithValidAddress(String testAddress) {
		Contact testContact = new Contact("id", "fName", "lName", "0123456789", testAddress);
		assertTrue(testContact.getAddress() == testAddress);
	}
	
	/**
	 * Tests creating a contact with invalid null or empty argument for address.
	 * 
	 * @param testAddress values to be tested
	 */
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    " })
	void testContactWithInvalidNullOrEmptyAddress(String testAddress) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fName", "lName", "0123456789", testAddress));
		assertEquals("address must have a value.", exception.getMessage());
	}
	
	/**
	 * Tests creating a contact with invalid length argument for address.
	 * 
	 * @param testAddress values to be tested
	 */
	@Test
	void testContactWithInvalidLengthAddress() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fName", "lName", "0123456789", "0123456789012345678901234567890"));
		assertEquals("address cannot be longer than 30 characters.", exception.getMessage());
	}
}
