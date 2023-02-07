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
public class TaskService {
	private final List<Task> tasks;
	
	/**
	 * Default constructor for TaskService that initializes a new list of tasks.
	 */
	public TaskService() {
		this.tasks = new ArrayList<Task>();
	}

	/**
	 * Getter for the list of tasks.
	 * 
	 * @return list of tasks
	 */
	public List<Task> getTasks() {
		return tasks;
	}
	
	/**
	 * Method to add a new task to the list of tasks.
	 * 
	 * @param newTask task to be added to the tasks list
	 * @return true for task added, false for task already exists
	 */
	public boolean addTask(final Task newTask) {
		boolean taskExists = false;
		for(Task task : tasks) {
			if (newTask.getTaskId() == task.getTaskId()) {
				taskExists = true;
			}
		}
		
		// If task doesn't exist, add it to the tasks list.
		if (!taskExists) {
			this.tasks.add(newTask);
			// Return true for adding task to list.
			return true;
		} else {
			// Task already exists, return false for adding the task.
			return false;
		}
	}
	
	/**
	 * Method to delete a task from the list with the matching id.
	 * 
	 * @param id value to match to existing ids
	 * @return true for task found and deleted, false if not found
	 */
	public boolean deleteContact(final String id) {
		return this.tasks.removeIf(task -> (task.getTaskId() == id));
	}
	
	
	/**
	 * Method to update the name of a task from the list with the matching id.
	 * 
	 * @param id value to match to existing ids
	 * @return true for task found and updated, false if not found
	 */
	public boolean updateName(final String id, final String firstName) {
		boolean updateComplete = false;
		for(Task task : tasks) {
			if (task.getTaskId() == id) {
				task.setName(firstName);
				updateComplete = true;
			}
		}
		return updateComplete;
	}

	/**
	 * Method to update the description of a task from the list with the matching id.
	 * 
	 * @param id value to match to existing ids
	 * @return true for task found and updated, false if not found
	 */
	public boolean updateDescription(final String id, final String description) {
		boolean updateComplete = false;
		for(Task task : tasks) {
			if (task.getTaskId() == id) {
				task.setDescription(description);
				updateComplete = true;
			}
		}
		return updateComplete;
	}
}
