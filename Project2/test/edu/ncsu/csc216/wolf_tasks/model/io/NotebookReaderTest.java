package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;


/**
 * Tests functionality of NotebookReader class
 */
public class NotebookReaderTest {

	/**
	 * Tests functionality of readNotebookFromFile
	 */
	@Test
	public void testReadNotebookFromFile() {
		
		try {
		
			File file = new File("test-files/expected_out.txt");
			
			Notebook notebook = NotebookReader.readNotebookFile(file);
			
			assertEquals(4, notebook.getTaskListsNames().length);
			assertEquals("Notebook", notebook.getNotebookName());
			
			NotebookReader.readNotebookFile(new File("test-files/notebook1.txt"));
		} catch(Exception e) {
			fail("Unexpected exception thrown while reading file.");
		}
		
    }
	
}
