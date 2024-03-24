package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

public class NotebookReader {

	/**
	 * NotebookReader constructor
	 */
	public NotebookReader() {
		
	}
	
	/**
	 * Reads Notebook information from File with parameter fileName
	 * @param filename of File to read
	 * @return Notebook of TaskLists from File
	 */
	public static Notebook readNotebookFile(File fileName) {
		return null;
	}
	
	/**
	 * Processes the information in a TaskList
	 * @param listName of TaskList to process
	 * @return TaskList of tasks in the file
	 */
	private static TaskList processTaskList(String listInfo) {
		return null;
	}
	
	/**
	 * Processes Task information from String parameter
	 * @param taskInfo String holds Task information
	 * @param list 
	 * @return a Task object with the information from parameter
	 */
	private static Task processTask(AbstractTaskList list, String taskInfo) {
		return null;
	}
}
