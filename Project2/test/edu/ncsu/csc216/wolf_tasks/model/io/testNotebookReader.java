package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;


/**
 * Tests functionality of NotebookReader class
 */
public class testNotebookReader {

	/**
	 * Tests functionality of readNotebookFromFile
	 */
	@Test
	public void testReadNotebookFromFile() {
		
		try {
		
			File file = new File("test-files/expected_out.txt");
	
			NotebookReader read = new NotebookReader(); //Constructor coverage
			
			Notebook notebook = NotebookReader.readNotebookFile(file);
			
			assertEquals(3, notebook.getTaskListsNames().length);
			assertEquals("Notebook", notebook.getNotebookName());
		} catch(Exception e) {
			fail("Unexpected exception thrown while reading file.");
		}
		
    }
	
}
