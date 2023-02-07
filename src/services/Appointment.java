package services;

import java.util.Date;

/**
 * 
 * @author Eric Slutz
 * 
 * SNHU CS-320
 * Project 1
 *
 */
public class Appointment {
	private String apptId;
	private Date date;
	private String description;
	
	/**
	 * Empty default constructor.
	 */
	private Appointment() {
	}
	
	public Appointment(final String apptId, final Date date, final String description) {
		this();
		
		// Check apptId meets requirements before setting.
		if (apptId == null || apptId.isBlank()) {
			throw new IllegalArgumentException("apptId must have a value.");
		} else if (apptId.length() > 10) {
			throw new IllegalArgumentException("apptId cannot be longer than 10 characters.");
		} else {
			this.apptId = apptId;
		}
		
		setDate(date);
		setDescription(description);
	}

	/**
	 * Getter for apptId.
	 * 
	 * @return the apptId
	 */
	public String getAppointmentId() {
		return apptId;
	}

	/**
	 * Getter for date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Setter for date.
	 * 
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		// Check date meets requirements before setting
		if (date == null) {
			throw new IllegalArgumentException("date must have a value.");
		} else if (date.before(new Date())) {
			throw new IllegalArgumentException("date must must be in the future.");
		} else {
			this.date = date;
		}
	}

	/**
	 * Getter for description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter for description.
	 * 
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		// Check description meets requirements before setting
		if (description == null || description.isBlank()) {
			throw new IllegalArgumentException("description must have a value.");
		} else if (description.length() > 50) {
			throw new IllegalArgumentException("description cannot be longer than 50 characters.");
		} else {
			this.description = description;
		}
	}
	
}
