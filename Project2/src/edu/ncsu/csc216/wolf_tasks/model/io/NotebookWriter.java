package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.FileWriter;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

/**
 * NotebookWriter class is in charge of writing Notebook information into
 * files in the proper format for a Notebook
 * 
 * @author Brendan_Viscount
 */
public class NotebookWriter {

	/**
	 * NotebookWriter constructor
	 */
	public NotebookWriter() {
		
	}
	
	/**
	 * Writes the information stored in a taskList into a file
	 * @param fileName of File to save information into
	 * @param notebookName of notebook
	 * @param list taskLists in notebook
	 */
	public static void writeNotebookFile(File fileName, String notebookName, ISortedList<TaskList> list) {
		try {
			FileWriter write = new FileWriter(fileName):
		} catch(Exception e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
}
