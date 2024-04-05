package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests functionality of ActiveTaskList
 */
public class ActiveTaskListTest {

ActiveTaskList list;
	
	/**
	 * Prepare list for testing
	 */
	@Before
	public void setUp() {
		list = new ActiveTaskList();
		
		list.addTask(new Task("Homework", "CSC216", true, true));
		list.addTask(new Task("Class", "CSC226", true, true));
		list.addTask(new Task("Meeting", "CSC217", true, true));
		list.addTask(new Task("Homework", "ST370", true, true));
		
	}
	
	/**
	 * Tests functionality of TaskList constructor
	 */
	@Test
	public void testTaskList() {
		
		try {
			
			new ActiveTaskList();
			new ActiveTaskList();
			new ActiveTaskList();
			new ActiveTaskList();
			new ActiveTaskList();
		} catch(Exception e) {
			fail("Unexpected exception thrown for valid TaskList constructors");
		} finally {
		
			Exception e1 = assertThrows(IllegalArgumentException.class,
					() -> list.setTaskListName("Name"));
			assertEquals(e1.getMessage(), "The Active Tasks list may not be edited.");
		}
	}
	
	/**
	 * Tests functionality of addTask
	 */
	@Test
	public void testAddTask() {
		
		assertEquals(4, list.getTasks().size());
		
		list.addTask(new Task("Homework", "CSC216", true, true));
		list.addTask(new Task("Class", "CSC226", true, true));
		list.addTask(new Task("Meeting", "CSC217", true, true));
		list.addTask(new Task("Homework", "ST370", true, true));
		assertEquals(8, list.getTasks().size());
		
		list.addTask(new Task("Homework", "CSC216", true, true));
		list.addTask(new Task("Class", "CSC226", true, true));
		list.addTask(new Task("Meeting", "CSC217", true, true));
		list.addTask(new Task("Homework", "ST370", true, true));
		assertEquals(12, list.getTasks().size());
		

		Exception e1 = assertThrows(IllegalArgumentException.class,
				() -> list.addTask(new Task("Homework", "CSC216", false, false)));
		assertEquals(e1.getMessage(), "Cannot add task to Active Tasks.");
	}
	
	/**
	 * Tests functionality of removeTask
	 */
	@Test
	public void testRemoveTask() {
		
		assertEquals(4, list.getTasks().size());
		
		list.removeTask(0);
		assertEquals(3, list.getTasks().size());
		assertEquals("Class", list.getTask(0).getTaskName());
		
		list.removeTask(2);
		assertEquals(2, list.getTasks().size());
		
		list.removeTask(1);
		assertEquals(1, list.getTasks().size());
	}

	/**
	 * Tests functionality of completeTask
	 */
	@Test
	public void testCompleteTask() {
		
		assertEquals(4, list.getTasks().size());
		
		list.completeTask(list.getTask(0));
		assertEquals(3, list.getTasks().size());
		assertEquals(1, list.getCompletedCount());
		
		list.completeTask(list.getTask(2));
		assertEquals(2, list.getTasks().size());
		assertEquals(2, list.getCompletedCount());
		
		list.completeTask(list.getTask(0));
		assertEquals(1, list.getTasks().size());
		assertEquals(3, list.getCompletedCount());
	}
	
	/**
	 * Tests functionality of getTasksAsArray
	 */
	@Test
	public void testGetTasksAsArray() {
		String[][] info = new String[list.getTasks().size()][2];
		
		try {
			info = list.getTasksAsArray().clone();
		} catch(Exception e) {
			fail("Unexpected exception converting list to information array");
		}
		
		assertEquals(info[0][0], "");
		assertEquals(info[0][1], "Homework");
		assertEquals(info[3][0], "");
		assertEquals(info[3][1], "Homework");
	}
	
	/**
	 * Tests the functionality of compareTo
	 */
	@Test
	public void testCompareTo() {
		
		TaskList task1 = new TaskList("Homework", 0);
		TaskList task2 = new TaskList("Class", 0);
		TaskList task3 = new TaskList("Meeting", 0);
		TaskList task4 = new TaskList("Homework", 0);
		
		assertTrue(task1.compareTo(task2) > 0);
		assertTrue(task3.compareTo(task1) > 0);
		assertEquals(task1.compareTo(task4), 0);
		
		assertTrue(task2.compareTo(task3) < 0);
		assertTrue(task1.compareTo(task3) < 0);
		
	}
	
	/**
	 * Tests the functionality of clearTasks
	 */
	@Test
	public void testClearTasks() {
		
		assertEquals(4, list.getTasks().size());
		try {
			list.clearTasks();
			assertEquals(0, list.getTasks().size());
		} catch(Exception e) {
			fail("Unexpected exception thrown when clearing ActiveTaskList.");
		}
	}
}
