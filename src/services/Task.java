package services;

/**
 * 
 * @author Eric Slutz
 * 
 * SNHU CS-320
 * Project 1
 *
 */
public class Task {
	private String taskId;
	private String name;
	private String description;
	
	/**
	 * Empty default constructor.
	 */
	private Task() {
	}
	
	/**
	 * Public constructor to create a new task.
	 * 
	 * @param taskId value for the taskId, cannot be changed once set
	 * @param name value for the task name
	 * @param description value for the task description
	 */
	public Task(final String taskId, final String name, final String description) {
		this();
		
		// Check taskId meets requirements before setting.
		if (taskId == null || taskId.isBlank()) {
			throw new IllegalArgumentException("taskId must have a value.");
		} else if (taskId.length() > 10) {
			throw new IllegalArgumentException("taskId cannot be longer than 10 characters.");
		} else {
			this.taskId = taskId;
		}
		
		// Calls methods to sets the rest of the values and validate the input.
		setName(name);
		setDescription(description);
	}

	/**
	 * Getter for taskId.
	 * 
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * Getter for name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name.
	 * 
	 * @param name the name to set
	 */
	public void setName(final String name) {
		// Check name meets requirements before setting
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("name must have a value.");
		} else if (name.length() > 20) {
			throw new IllegalArgumentException("name cannot be longer than 20 characters.");
		} else {
			this.name = name;
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
	public void setDescription(final String description) {
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
