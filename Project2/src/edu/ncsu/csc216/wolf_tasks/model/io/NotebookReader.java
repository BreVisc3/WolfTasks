package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * NotebookReader class is in charge of reading properly formatted Notebook files and
 * creating a related Notebook object
 * 
 * @author Brendan_Viscount
 */
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
	 * @throws IllegalArgumentException if file does not exist
	 */
	public static Notebook readNotebookFile(File fileName) {
		try {
			Notebook notebook;
			Scanner fileReader = new Scanner(fileName + ".txt");
			String allInfo = "";
			while(fileReader.hasNextLine()) {
				allInfo += fileReader.next() + "\n";
			}
			fileReader.close();
			
			Scanner allReader = new Scanner(allInfo);
			allReader.useDelimiter("\n");

			String header = allReader.nextLine();
			if(!header.startsWith("!")) {
				allReader.close();
				throw new IllegalArgumentException("Unable to load file.");
			}
			header.substring(1);
			notebook = new Notebook(header.trim());
			
			allReader.useDelimiter("\\r?\\n?[#]");
			while(allReader.hasNextLine()) {
				notebook.addTaskList(processTaskList(allReader.nextLine()));
			}
			allReader.close();
			
			return notebook;
		} catch(Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
	}
	
	/**
	 * Processes the information in a TaskList
	 * @param listName of TaskList to process
	 * @return TaskList of tasks in the file
	 */
	private static TaskList processTaskList(String listInfo) {
		Scanner listReader = new Scanner(listInfo);
		TaskList list = new TaskList(listReader.next(), 0);
		listReader.useDelimiter("\\r?\\n?[*]");
		
		while(listReader.hasNextLine()) {
			list.addTask(processTask(list, listReader.nextLine()));
		}
		listReader.close();
		
		return list;
	}
	
	/**
	 * Processes Task information from String parameter
	 * @param taskInfo String holds Task information
	 * @param list 
	 * @return a Task object with the information from parameter
	 */
	private static Task processTask(AbstractTaskList list, String taskInfo) {

		Task task;
		Scanner taskReader = new Scanner(taskInfo);
		taskReader.useDelimiter(",");
		String name = taskReader.next();
		boolean recurring = false;
		boolean active = false;
		String description = "";
		while(taskReader.hasNext()) {
			if("recurring".equalsIgnoreCase(taskReader.next())) {
				recurring = true;
			}
			if("active".equalsIgnoreCase(taskReader.next())) {
				active = true;
			}
		}
		
		//QUESTIONABLE
		if(taskReader.hasNextLine()) {
			description += taskReader.nextLine();
		}
		
		return new Task(name, description, recurring, active);
	}
}
