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
public class ContactService {
	private final List<Contact> contacts;

	/**
	 * Default constructor for ContactService that initializes a new list of contacts.
	 */
	public ContactService() {
		this.contacts  = new ArrayList<Contact>();
	}

	/**
	 * Getter for the list of contacts.
	 * 
	 * @return list of contacts
	 */
	public List<Contact> getContacts(){
		return contacts;
	}

	/**
	 * Method to add a new contact to the list of contacts.
	 * 
	 * @param newContact contact to be added to the contacts list
	 * @return true for contact added, false for contact already exists
	 */
	public boolean addContact(final Contact newContact) {
		boolean contactExists = false;
		for(Contact contact : contacts) {
			if (newContact.getContactId() == contact.getContactId()) {
				contactExists = true;
			}
		}
		
		// If contact doesn't exist, add it to the contacts list.
		if (!contactExists) {
			this.contacts.add(newContact);
			// Return true for adding contact to list.
			return true;
		} else {
			// Contact already exists, return false for adding the contact.
			return false;
		}
	}

	/**
	 * Method to delete a contact from the list with the matching id.
	 * 
	 * @param id value to match to existing ids
	 * @return true for contact found and deleted, false if not found
	 */
	public boolean deleteContact(final String id) {
		return this.contacts.removeIf(contact -> (contact.getContactId() == id));
	}

	/**
	 * Method to update the first name of a contact from the list with the matching id.
	 * 
	 * @param id value to match to existing ids
	 * @return true for contact found and updated, false if not found
	 */
	public boolean updateFirstName(final String id, final String firstName) {
		boolean updateComplete = false;
		for(Contact contact : contacts) {
			if (contact.getContactId() == id) {
				contact.setFirstName(firstName);
				updateComplete = true;
			}
		}
		return updateComplete;
	}

	/**
	 * Method to update the last name of a contact from the list with the matching id.
	 * 
	 * @param id value to match to existing ids
	 * @return true for contact found and updated, false if not found
	 */
	public boolean updateLastName(final String id, final String lastName) {
		boolean updateComplete = false;
		for(Contact contact : contacts) {
			if (contact.getContactId() == id) {
				contact.setLastName(lastName);
				updateComplete = true;
			}
		}
		return updateComplete;
	}

	/**
	 * Method to update the phone number of a contact from the list with the matching id.
	 * 
	 * @param id value to match to existing ids
	 * @return true for contact found and updated, false if not found
	 */
	public boolean updatePhone(final String id, final String phone) {
		boolean updateComplete = false;
		for(Contact contact : contacts) {
			if (contact.getContactId() == id) {
				contact.setPhone(phone);
				updateComplete = true;
			}
		}
		return updateComplete;
	}

	/**
	 * Method to update the address of a contact from the list with the matching id.
	 * 
	 * @param id value to match to existing ids
	 * @return true for contact found and updated, false if not found
	 */
	public boolean updateAddress(final String id, final String address) {
		boolean updateComplete = false;
		for(Contact contact : contacts) {
			if (contact.getContactId() == id) {
				contact.setAddress(address);
				updateComplete = true;
			}
		}
		return updateComplete;
	}
}
