package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Tests the functionality of the Notebook class object
 */
public class NotebookTest {
	
	/** Testing notebook */
	Notebook notebook;
	
	/**
	 * Prepares a Notebook for testing
	 */
	@Before
	public void setUp() {
		notebook = new Notebook("Stuff");
		notebook.addTaskList(new TaskList("List", 0));
		notebook.addTaskList(new TaskList("Work", 5));
		notebook.addTaskList(new TaskList("School", 10));
		notebook.addTaskList(new TaskList("Things", 20));
	}
	
	/**
	 * Tests the functionality of the Notebook constructor
	 */
	@Test
	public void testNotebook() {
		
		try {
			notebook = new Notebook("Stuff");
			notebook = new Notebook("Different");
			notebook = new Notebook("Name");
		} catch(Exception e) {
			fail("Unexpected exception thrown on valid constructor call.");
		}
		
		Exception e1 = assertThrows(IllegalArgumentException.class,
				() -> new Notebook("Active Tasks"));
		assertEquals(e1.getMessage(), "Invalid name.");
		
		Exception e2 = assertThrows(IllegalArgumentException.class,
				() -> new Notebook(""));
		assertEquals(e2.getMessage(), "Invalid name.");
		
		Exception e3 = assertThrows(IllegalArgumentException.class,
				() -> new Notebook(null));
		assertEquals(e3.getMessage(), "Invalid name.");
	}
	
	/**
	 * Tests functionality of addTaskList
	 */
	@Test
	public void testAddTaskList() {
		
		assertEquals(5, notebook.getTaskListsNames().length);
		
		Exception e1 = assertThrows(IllegalArgumentException.class,
				() -> notebook.addTaskList(new TaskList("Active Tasks", 0)));
		assertEquals(e1.getMessage(), "Invalid name.");
		Exception e2 = assertThrows(IllegalArgumentException.class,
				() -> notebook.addTaskList(new TaskList("Things", 0)));
		assertEquals(e2.getMessage(), "Invalid name.");
	}
	
	/**
	 * Tests functionality of removeTaskList
	 */
	@Test
	public void testRemoveTaskList() {
		
		assertEquals(5, notebook.getTaskListsNames().length);
		
		try {
			notebook.removeTaskList();
			assertEquals(4, notebook.getTaskListsNames().length);
			
			notebook.setCurrentTaskList("School");
			notebook.removeTaskList();
			assertEquals(3, notebook.getTaskListsNames().length);
			
			notebook.setCurrentTaskList("Work");
			notebook.removeTaskList();
			assertEquals(2, notebook.getTaskListsNames().length);
			
		} catch(Exception e) {
			fail("Unexpected exception thrown removing valid index.");
		}
	}
	
	/**
	 * Tests functionality of addTask
	 */
	@Test
    public void testAddTask() {

        Task task = new Task("Task 1", "Description 1", false, true);
        notebook.addTask(task);
        assertTrue(notebook.isChanged());
    }

	/**
	 * Tests functionality of editTask
	 */
    @Test
    public void testEditTask() {
        Task task = new Task("Task 1", "Description 1", false, true);
        notebook.addTask(task);
        notebook.editTask(0, "Task 1 Edited", "Description 1 Edited", true, false);
        assertEquals("Task 1 Edited", notebook.getCurrentTaskList().getTask(0).getTaskName());
        assertEquals("Description 1 Edited", notebook.getCurrentTaskList().getTask(0).getTaskDescription());
        assertTrue(notebook.getCurrentTaskList().getTask(0).isRecurring());
        assertFalse(notebook.getCurrentTaskList().getTask(0).isActive());
        assertTrue(notebook.isChanged());
    }
    
    /**
     * Tests functionality of editTaskList
     */
    @Test
    public void testEditTaskListValid() {

        notebook.addTaskList(new TaskList("Task List 1", 0));
        notebook.setCurrentTaskList("Task List 1");
        notebook.editTaskList("Task List 2");
        assertTrue(notebook.isChanged());
    }
    
    /**
     * Tests functionality of editTaskList when faced with invalid parameters
     */
    @Test
    public void testEditTaskListInvalid() {

    	notebook.setCurrentTaskList("List");
        Exception e = assertThrows(IllegalArgumentException.class, 
        		() -> notebook.editTaskList("Active Tasks"));
        assertEquals("The Active Tasks list may not be edited.", e.getMessage());

        notebook.setCurrentTaskList("List");
        e = assertThrows(IllegalArgumentException.class,
        		() -> notebook.editTaskList("Work"));
        
        assertEquals("Duplicate task list name.", e.getMessage());

        e = assertThrows(IllegalArgumentException.class, 
        		() -> notebook.editTaskList("Active Tasks"));
        assertEquals("The Active Tasks list may not be edited.", e.getMessage());
    }

}
