package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import services.Task;
import services.TaskService;

class TaskServiceTest {
	private TaskService testTaskService;

	/**
	 * Setup of TaskService for use with the tests.
	 */
	@BeforeEach
	void setUp() {
		testTaskService = new TaskService();
		testTaskService.addTask(new Task("1", "name1", "description1"));
		testTaskService.addTask(new Task("2", "name2", "description2"));
	}

	/**
	 * Tests adding a task to a list of tasks.
	 */
	@Test
	void testAddTask(){
		assertAll(
			() -> assertTrue(testTaskService.addTask(new Task("3", "name3", "description3"))),
			() -> assertTrue(testTaskService.getTasks().size() == 3)
		);
	}
	
	/**
	 * 
	 */
	@Test
	void testAddTaskThatAlreadyExists() {
		assertAll(
			() -> assertFalse(testTaskService.addTask(new Task("2", "name2", "description2"))),
			() -> assertTrue(testTaskService.getTasks().size() == 2)
		);
	}

	/**
	 * Tests deleting a task looking for a valid taskId.
	 */
	@Test
	void testDeleteTaskWithValidId() {
		assertAll(
			() -> assertTrue(testTaskService.deleteContact("2")),
			() -> assertTrue(testTaskService.getTasks().size() == 1)
		);
	}

	/**
	 * Tests deleting a task looking for an invalid taskId.
	 */
	@Test
	void testDeleteTasktWithInvalidId() {
		assertAll(
			() -> assertFalse(testTaskService.deleteContact("5")),
			() -> assertTrue(testTaskService.getTasks().size() == 2)
		);
	}

	/**
	 * Test updating a tasks name using a valid id and name.
	 */
	@Test
	void testUpdateNameWithValidIdAndName() {
		assertAll(
			() -> assertTrue(testTaskService.updateName("2", "Dwight's Task")),
			() -> assertTrue(testTaskService.getTasks().get(1).getName() == "Dwight's Task")
		);
	}

	/**
	 * Test updating a tasks name using an invalid id and valid name.
	 */
	@Test
	void testUpdateNameWithInvalidId() {
		assertFalse(testTaskService.updateName("5", "Dwight's Task"));
	}
	
	/**
	 * Test updating a tasks name using a valid id and invalid name.
	 */
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    ",
			"012345678901234567890" })
	void testUpdateNameWithInvalidName(String testName) {
		assertThrows(IllegalArgumentException.class, () -> testTaskService.updateName("2", testName));
	}
	
	/**
	 * Test updating a tasks description using a valid id and description.
	 */
	@Test
	void testUpdateDescriptionWithValidIdAndDescription() {
		assertAll(
			() -> assertTrue(testTaskService.updateDescription("2", "Description of Dwight's task.")),
			() -> assertTrue(testTaskService.getTasks().get(1).getDescription() == "Description of Dwight's task.")
		);
	}
	
	/**
	 * Test updating a tasks description using an invalid id and valid description.
	 */
	@Test
	void testUpdateDescriptionWithInvalidId() {
		assertFalse(testTaskService.updateName("5", "Description of Dwight's task."));
	}
	
	/**
	 * Test updating a tasks description using a valid id and invalid description.
	 */
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    ",
			"012345678901234567890123456789012345678901234567890" })
	void testUpdateDescriptionWithInvalidDescription(String testName) {
		assertThrows(IllegalArgumentException.class, () -> testTaskService.updateDescription("2", testName));
	}
}
