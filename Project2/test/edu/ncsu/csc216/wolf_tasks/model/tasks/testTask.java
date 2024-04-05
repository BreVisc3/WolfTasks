package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Tests the functionality of the Task object which is core to the program structure
 */
public class testTask {
	
	/**
	 * Tests functionality of Task constructor
	 */
	@Test
	public void testValidTask() {
		
		try {
			
			Task task = new Task("Homework", "CSC216", true, true);
			assertEquals(task.getTaskName(), "Homework");
			assertEquals(task.getTaskDescription(), "CSC216");
			assertTrue(task.isActive());
			assertTrue(task.isRecurring());
			task = new Task("Class", "CSC226", true, false);
			assertEquals(task.getTaskName(), "Class");
			assertEquals(task.getTaskDescription(), "CSC226");
			assertFalse(task.isActive());
			assertTrue(task.isRecurring());
		} catch(Exception e) {
			fail("Unexpected exception thrown for valid Task constructor call.");
		}
	}
	
	/**
	 * Tests functionality of Task constructor when faced with invalid parameters
	 */
	@Test
	public void testInvalidTask() {
		
		Exception e1 = assertThrows(IllegalArgumentException.class, 
				() -> new Task("", "CSC216", true, true));
		assertEquals(e1.getMessage(), "Incomplete task information.");
		Exception e2 = assertThrows(IllegalArgumentException.class, 
				() -> new Task(null, "CSC216", true, true));
		assertEquals(e2.getMessage(), "Incomplete task information.");
		
		Exception e3  = assertThrows(IllegalArgumentException.class, 
				() -> new Task("Homework", null, true, true));
		assertEquals(e3.getMessage(), "Incomplete task information.");
	}
	
	/**
	 * Tests functionality of addTaskList 
	 */
	@Test
	public void testAddTaskList() {
		
		AbstractTaskList list = new TaskList("4/1", 0);
		AbstractTaskList list1 = new TaskList("4/8", 0);
		
		try {
			Task task = new Task("Homework", "CSC216", true, true);
			task.addTaskList(list);
			//assertEquals("4/1", task.getTaskListName());
			
			task.addTaskList(list1);
			//assertEquals("4/8", task.getTaskListName());
			task.addTaskList(list);
			//assertEquals("4/8", task.getTaskListName());
			
			
			task = new Task("Class", "CSC226", true, false);
			task.addTaskList(list);
			assertEquals("4/1", task.getTaskListName());
			
			task.addTaskList(list1);
			//assertEquals("4/8", task.getTaskListName());
			task.addTaskList(list);
			//assertEquals("4/8", task.getTaskListName());
			
		} catch(Exception e) {
			e.printStackTrace();
			fail("Unexpected exception thrown adding TaskList with valid parameters.");
		}
		
	}
	
	/**
	 * Tests functionality of clone
	 */
	@Test
	public void testClone() {
		
		try {
			Task task = new Task("Homework", "CSC216", true, true);
			task.addTaskList(new TaskList("4/1", 0));
			Task clone = (Task) task.clone();
			
			assertEquals(task.getTaskName(), clone.getTaskName());
			assertEquals(task.getTaskDescription(), clone.getTaskDescription());
			assertEquals(task.isActive(), clone.isActive());
			assertEquals(task.isRecurring(), clone.isRecurring());
			//assertEquals(task.getTaskListName(), clone.getTaskListName());
		} catch(Exception e) {
			fail("Unexpected exception thrown when cloning.");
		}
	}
	
	/**
	 * Tests the functionality of toString
	 */
	@Test
	public void testToString() {
		try {
			Task task = new Task("Homework", "CSC216", true, true);
			assertEquals(task.toString(), "* Homework,recurring,active\nCSC216");
			
			task = new Task("Class", "CSC226", true, false);
			assertEquals(task.toString(), "* Class,recurring\nCSC226");
		} catch (Exception e) {
			fail("Unexpected error trying to test toString");
		}
	}
	
	/**
	 * Tests functionality of completeTask
	 */
	@Test
	public void testCompleteTask() {
		try {
			Task task = new Task("Homework", "CSC216", false, false);
			
			task.completeTask();
			assertEquals("", task.getTaskListName());
			
			
		} catch (Exception e) {
			fail("Unexpected error trying to test completeTask");
		}
	}

}
