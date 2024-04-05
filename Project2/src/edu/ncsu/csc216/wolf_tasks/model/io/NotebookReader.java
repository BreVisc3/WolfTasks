package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.FileNotFoundException;
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
            Scanner fileReader = new Scanner(fileName);
            StringBuilder allInfo = new StringBuilder();
            while (fileReader.hasNextLine()) {
                allInfo.append(fileReader.nextLine()).append("\n");
            }
            fileReader.close();

            Scanner allReader = new Scanner(allInfo.toString());
            allReader.useDelimiter("\\n[#]");

            String header = allReader.next();
            if (!header.startsWith("!")) {
                allReader.close();
                throw new IllegalArgumentException("Unable to load file: Invalid header.");
            }
            header = header.substring(1).trim();
            Notebook notebook = new Notebook(header);

            while (allReader.hasNext()) {
                notebook.addTaskList(processTaskList(allReader.next()));
            }
            allReader.close();

            return notebook;
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to load file: File not found.");
        }
	}
	
	/**
	 * Processes the information in a TaskList
	 * @param listName of TaskList to process
	 * @return TaskList of tasks in the file
	 */
	private static TaskList processTaskList(String listInfo) {
		Scanner listReader = new Scanner(listInfo);
	        String listName = listReader.nextLine().trim();
	        TaskList list = new TaskList(listName, 0);

	        while (listReader.hasNext()) {
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
		Scanner taskReader = new Scanner(taskInfo);
        taskReader.useDelimiter(",");
        String name = taskReader.next().trim();
        boolean recurring = false;
        boolean active = false;
        StringBuilder description = new StringBuilder();
        
        while (taskReader.hasNext()) {
            String flag = taskReader.next().trim();
            if ("recurring".equalsIgnoreCase(flag)) {
                recurring = true;
            } else if ("active".equalsIgnoreCase(flag)) {
                active = true;
            } else {
                description.append(flag);
            }
        }
        taskReader.close();

        return new Task(name, description.toString(), recurring, active);
    }
}
