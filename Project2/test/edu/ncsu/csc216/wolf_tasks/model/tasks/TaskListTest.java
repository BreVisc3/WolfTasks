package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests functionality of AbstractTaskList
 */
public class TaskListTest {
	
	/** Testing list */
	TaskList list;
	
	/**
	 * Prepare list for testing
	 */
	@Before
	public void setUp() {
		list = new TaskList("List", 0);
		
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
			
			new TaskList("Work", 0);
			new TaskList("Labs", 20);
			new TaskList("Projects", 1000);
			new TaskList("Something else", 56);
		} catch(Exception e) {
			fail("Unexpected exception thrown for valid TaskList constructors");
		}
		
		Exception e1 = assertThrows(IllegalArgumentException.class,
				() -> new TaskList("", 0));
		assertEquals(e1.getMessage(), "Invalid name.");
		Exception e2 = assertThrows(IllegalArgumentException.class,
				() -> new TaskList(null, 0));
		assertEquals(e2.getMessage(), "Invalid name.");
		
		Exception e3 = assertThrows(IllegalArgumentException.class,
				() -> new TaskList("Something", -1));
		assertEquals(e3.getMessage(), "Invalid completed count.");
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
		
		assertEquals(info[0][0], "1");
		assertEquals(info[0][1], "Homework");
		assertEquals(info[3][0], "4");
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
}	
