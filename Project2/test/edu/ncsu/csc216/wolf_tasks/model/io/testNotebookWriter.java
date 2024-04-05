package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;

/**
 * Tests the functionality of NotebookWriter
 */
public class testNotebookWriter {
	 
	
	/**
	 * Tests functionality of writeNotebookToFile
	 */
	@Test
	public void testWriteNotebookToFile() {
		
		try {
		
			NotebookWriter write = new NotebookWriter();
			
			Notebook notebook = new Notebook("Notebook");
			
			TaskList list = new TaskList("ATaskList", 0);
			notebook.addTaskList(list);
			
			list = new TaskList("Tasks1", 0);
			list.addTask(new Task("Task1", "Task1Description", true, false));
			list.addTask(new Task("Task2", "Task2Description", true, true));
			notebook.addTaskList(list);
			
			list = new TaskList("Tasks2", 0);
			list.addTask(new Task("Task3", "Task3Description", false, false));
			list.addTask(new Task("Task4", "Task4Description", false, true));
			list.addTask(new Task("Task5", "Task5Description", true, false));
			notebook.addTaskList(list);
			
			notebook.saveNotebook(new File("test-files/actual_out.txt"));
			
			checkFiles("test-files/actual_out.txt", "test-files/expected_out.txt");
		} catch(Exception e) {
			fail("Unexpected exception thrown while writer Notebook.");
		}
	}
	
	/**
	 * Helper method to compare two files for the same contents
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
			 Scanner actScanner = new Scanner(new File(actFile));) {
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}
}
