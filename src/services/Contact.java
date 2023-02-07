package services;

/**
 * 
 * @author Eric Slutz
 * 
 * SNHU CS-320
 * Project 1
 *
 */
public class Contact {
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;

	/**
	 * Empty default constructor.
	 */
	private Contact() {
	}

	/**
	 * Public constructor to create a new contact.
	 * 
	 * @param value for the contactId, cannot be changed once initialized
	 * @param value for the contact first name
	 * @param value for the contact last name
	 * @param value for the contact phone number
	 * @param value for the contact address
	 * @throws IllegalArgumentException if given invalid input
	 */
	public Contact(final String contactId, final String firstName, final String lastName, final String phone, final String address) throws IllegalArgumentException {
		this();

		// Check contactId meets requirements before setting.
		if (contactId == null || contactId.isBlank()) {
			throw new IllegalArgumentException("contactId must have a value.");
		} else if (contactId.length() > 10) {
			throw new IllegalArgumentException("contactId cannot be longer than 10 characters.");
		} else {
			this.contactId = contactId;
		}

		// Calls methods to sets the rest of the values and validate the input.
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}

	/**
	 * Getter for contactId.
	 * 
	 * @return contactId value
	 */
	public String getContactId() {
		return this.contactId;
	}

	/**
	 * Getter for firstName.
	 * 
	 * @return firstName value
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Setter for firstName.
	 * 
	 * @param firstName value to set as firstName
	 * @throws IllegalArgumentException if argument is blank or null or over 10 characters
	 */
	public void setFirstName(final String firstName) throws IllegalArgumentException {
		// Check fistName meets requirements before setting
		if (firstName == null || firstName.isBlank()) {
			throw new IllegalArgumentException("firstName must have a value.");
		} else if (firstName.length() > 10) {
			throw new IllegalArgumentException("firstName cannot be longer than 10 characters.");
		} else {
			this.firstName = firstName;
		}
	}

	/**
	 * Getter for lastName.
	 * 
	 * @return lastName value
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Setter for lastName.
	 * 
	 * @param value to set as lastName
	 * @throws IllegalArgumentException if argument is blank or null or over 10 characters
	 */
	public void setLastName(final String lastName) throws IllegalArgumentException {
		// Check lastName meets requirements before setting
		if (lastName == null || lastName.isBlank()) {
			throw new IllegalArgumentException("lastName must have a value.");
		} else if (lastName.length() > 10) {
			throw new IllegalArgumentException("lastName cannot be longer than 10 characters.");
		} else {
			this.lastName = lastName;
		}
	}

	/**
	 * Getter for phone.
	 * 
	 * @return phone value
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * Setter for phone.
	 * 
	 * @param value to set as phone
	 * @throws IllegalArgumentException if argument is blank or null or over 10 characters
	 */
	public void setPhone(final String phone) throws IllegalArgumentException {
		// Check phone meets requirements before setting
		if (phone == null || phone.isBlank()) {
			throw new IllegalArgumentException("phone number must have a value.");
		} else if (phone.length() != 10 || !phone.matches("[0-9]+")) {
			throw new IllegalArgumentException("phone number must be 10 digits.");
		} else {
			this.phone = phone;
		}
	}

	/**
	 * Getter for address.
	 * 
	 * @return address value
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Setter for address.
	 * 
	 * @param value to set as address
	 * @throws IllegalArgumentException if argument is blank or null or over 10 characters
	 */
	public void setAddress(final String address) throws IllegalArgumentException {
		// Check address meets requirements before setting
		if (address == null || address.isBlank()) {
			throw new IllegalArgumentException("address must have a value.");
		}
		if (address.length() > 30) {
			throw new IllegalArgumentException("address cannot be longer than 30 characters.");
		}
		this.address = address;
	}
}
