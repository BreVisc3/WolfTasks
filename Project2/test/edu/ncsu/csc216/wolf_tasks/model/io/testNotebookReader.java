package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;

/**
 * Tests functionality of NotebookReader class
 */
public class testNotebookReader {

	/**
	 * Tests functionality of readNotebookFromFile
	 */
	@Test
	public void testReadNotebookFromFile() {
		
		File file = new File("test-files/expected_out.txt"); // Adjust file path as needed

        // Invoke method
        Notebook notebook = null;
        try {
            notebook = NotebookReader.readNotebookFile(file);
        } catch (IllegalArgumentException e) {
            fail("Failed to read notebook file: " + e.getMessage());
        }

        // Verify results
        assertNotNull(notebook);
        assertEquals("Notebook", notebook.getNotebookName());

        // Verify task lists
        String[] expectedTaskLists = { "ATaskList", "Tasks1", "Tasks2" };
        String[] actualTaskLists = notebook.getTaskListNames();
        assertEquals(expectedTaskLists.length, actualTaskLists.length);
        for (String expected : expectedTaskLists) {
            boolean found = false;
            for (String actual : actualTaskLists) {
                if (expected.equals(actual)) {
                    found = true;
                    break;
                }
            }
        }

        AbstractTaskList tasks1 = notebook.getCurrentTaskList();
        assertEquals(2, tasks1.getTasks().size());
        assertTrue(tasks1.getTask(0).getTaskName().equals("Task1"));
        assertTrue(tasks1.getTask(1).getTaskName().equals("Task2"));


    }
	
}
