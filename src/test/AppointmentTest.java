package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import services.Appointment;

/**
 * 
 * @author Eric Slutz
 * 
 * SNHU CS-320
 * Module 5 Milestone
 *
 */
class AppointmentTest {
	private Date testApptDate;
	
	@BeforeEach
	void setUp() {
		try {
			testApptDate = new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01");
		} catch (ParseException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
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
	void testCreateAppointmentWithValidId(String testId) {
		assertTrue(new Appointment(testId, testApptDate, "description").getAppointmentId() == testId);
	}

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    " })
	void testCreateAppointmentWithInvalidNullOrEmptyId(String testId) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment(testId, testApptDate, "description"));
		assertEquals("apptId must have a value.", exception.getMessage());	
	}
	
	@Test
	void testCreateTaskWithInvalidLengthId() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment("01234567890", testApptDate, "description"));
		assertEquals("apptId cannot be longer than 10 characters.", exception.getMessage());	
	}
	
	@Test
	void testDateWithValidDate() throws ParseException {
		assertTrue(new Appointment("id", testApptDate, "description").getDate() == testApptDate);
	}
	
	@ParameterizedTest
	@NullSource
	void testCreateAppointmentWithInvalidNullDate(Date testDate) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment("id", testDate, "description"));
		assertEquals("date must have a value.", exception.getMessage());	
	}
	
	@ParameterizedTest
	@ValueSource(strings = { 
			"2018-01-01",
			"2018-01-31" })
	void testCreateAppointmentWithInvalidPastDate(String testDate) throws ParseException {
		Date testPastApptDate = new SimpleDateFormat("yyyy-MM-dd").parse(testDate);
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment("id", testPastApptDate, "description"));
		assertEquals("date must must be in the future.", exception.getMessage());	
	}
	
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
	void testCreateAppointmentWithValidDescription(String testDescription) throws ParseException {
		assertTrue(new Appointment("id", testApptDate, testDescription).getDescription() == testDescription);
	}
	
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    " })
	void testCreateAppointmentWithInvalidNullOrEmptyDescription(String testDescription) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment("id", testApptDate, testDescription));
		assertEquals("description must have a value.", exception.getMessage());	
	}
	
	@Test
	void testCreateAppointmentWithInvalidLengthDescription() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Appointment("id", testApptDate, "012345678901234567890123456789012345678901234567890"));
		assertEquals("description cannot be longer than 50 characters.", exception.getMessage());	
	}
}
