package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import services.Task;

/**
 * 
 * @author Eric Slutz
 * 
 * SNHU CS-320
 * Module 4 Milestone
 *
 */
class TaskTest {
	/**
	 * Tests creating a task with valid arguments.
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
	void testCreateTaskWithValidId(String testId) {
		assertTrue(new Task(testId, "name", "description").getTaskId() == testId);
	}
	
	/**
	 * Tests creating a task with invalid null or empty argument for taskId.
	 * 
	 * @param testId values to be tested
	 */
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    " })
	void testCreateTaskWithInvalidNullOrEmptyId(String testId) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Task(testId, "name", "description"));
		assertEquals("taskId must have a value.", exception.getMessage());			
	}
	
	/**
	 * Tests creating a task with invalid length argument for taskId.
	 * 
	 * @param testId values to be tested
	 */
	@Test
	void testCreateTaskWithInvalidLengthId() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Task("01234567890", "name", "description"));
		assertEquals("taskId cannot be longer than 10 characters.", exception.getMessage());	
	}
	
	/**
	 * Tests creating a task with valid arguments.
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
			"0123456789",
			"01234567890123456789" })
	void testCreateTaskWithValidName(String testName) {
		assertTrue(new Task("id", testName, "description").getName() == testName);
	}
	
	/**
	 * Tests creating a task with invalid null or empty argument for name.
	 * 
	 * @param testName values to be tested
	 */
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    " })
	void testCreateContactWithInvalidNullOrEmptyName(String testName) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Task("id", testName, "description"));
		assertEquals("name must have a value.", exception.getMessage());		
	}
	
	/**
	 * Tests creating a task with invalid length argument for name.
	 * 
	 * @param testName values to be tested
	 */
	@Test
	void testCreateContactWithInvalidLengthName() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Task("id", "012345678901234567890", "description"));
		assertEquals("name cannot be longer than 20 characters.", exception.getMessage());	
	}
	
	/**
	 * Tests creating a task with valid arguments.
	 * 
	 * @param testDescription values to be tested
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
			"012345678901234567890123456789",
			"0123456789012345678901234567890123456789",
			"01234567890123456789012345678901234567890123456789" })
	void testCreateTaskWithValidDescription(String testDescription) {
		assertTrue(new Task("id", "name", testDescription).getDescription() == testDescription);
	}
	
	/**
	 * Tests creating a task with invalid argument for description.
	 * 
	 * @param testDescription values to be tested
	 */
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    " })
	void testCreateTaskWithInvalidNullOrEmptyDescription(String testDescription) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Task("id", "name", testDescription));
		assertEquals("description must have a value.", exception.getMessage());	
	}
	
	/**
	 * Tests creating a task with invalid length argument for description.
	 * 
	 * @param testDescription values to be tested
	 */
	@Test
	void testCreateTaskWithInvalidLengthDescription() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Task("id", "name", "012345678901234567890123456789012345678901234567890"));
		assertEquals("description cannot be longer than 50 characters.", exception.getMessage());	
	}
}
