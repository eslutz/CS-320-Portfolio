package services;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Eric Slutz
 * 
 * SNHU CS-320
 * Project 1
 *
 */
public class AppointmentService {
	private final List<Appointment> appointments;
	
	/**
	 * Default constructor for AppointmentService that initializes a new list of appointments.
	 */
	public AppointmentService() {
		this.appointments = new ArrayList<Appointment>();
	}

	/**
	 * Getter for appointments.
	 * 
	 * @return the appointments
	 */
	public List<Appointment> getAppointments() {
		return appointments;
	}
	
	/**
	 * Method to add a new appointment to the list of appointments.
	 * 
	 * @param newAppt appointment to be added to the appointments list
	 * @return true for appointment added, false for appointment already exists
	 */
	public boolean addAppointment(final Appointment newAppt) {
		boolean apptExists = false;
		for(Appointment appt : appointments) {
			if (newAppt.getAppointmentId() == appt.getAppointmentId()) {
				apptExists = true;
			}
		}
		
		// If appointment doesn't exist, add it to the appointments list.
		if (!apptExists) {
			this.appointments.add(newAppt);
			// Return true for adding appointment to list.
			return true;
		} else {
			// Appointment already exists, return false for adding the appointment.
			return false;
		}
	} 
	
	/**
	 * Method to delete an appointment from the list with the matching id.
	 * 
	 * @param id value to match to existing ids
	 * @return true for appointment found and deleted, false if not found
	 */
	public boolean deleteAppointment(final String id) {
		return this.appointments.removeIf(appt -> (appt.getAppointmentId() == id));
	}
}
