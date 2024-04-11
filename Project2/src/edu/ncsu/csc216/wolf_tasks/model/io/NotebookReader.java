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
	 * Reads Notebook information from File with parameter fileName
	 * @param fileName of File to read
	 * @return Notebook of TaskLists from File
	 * @throws IllegalArgumentException if file does not exist
	 */
	public static Notebook readNotebookFile(File fileName) {
		StringBuilder allInfo;
		try {
            Scanner fileReader = new Scanner(fileName);
            allInfo = new StringBuilder();
            while (fileReader.hasNextLine()) {
                allInfo.append(fileReader.nextLine()).append("\n");
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to load file.");
        }
		 Scanner allReader = new Scanner(allInfo.toString());
         allReader.useDelimiter("\\n[#]");

         String header = allReader.next();
         if (!header.startsWith("!")) {
             allReader.close();
             throw new IllegalArgumentException("Unable to load file.");
         }
         else {
	         header = header.substring(1).trim();
	         Notebook notebook = new Notebook(header);
	         try {
		         while (allReader.hasNextLine()) {
		             notebook.addTaskList(processTaskList(allReader.next()));
		         }
	         allReader.close();
	         } catch(Exception e) {
	        	 return notebook;
	         }
	         return notebook;
         }
	}
	
	/**
	 * Processes the information in a TaskList
	 * @param listInfo of TaskList to process
	 * @return TaskList of tasks in the file
	 */
	private static TaskList processTaskList(String listInfo) {
		Scanner listReader = new Scanner(listInfo);
	    String first = listReader.nextLine().trim();
	    String[] split = first.split(",");
	    
	    if(split.length != 2) {
	    	listReader.close();
	    	return null;
	    }
	    else {
		    String listName = split[0];
		    String count = split[1];
		    
		    if(count == null || count.isEmpty() || Integer.parseInt(count) < 0 || listName == null || listName.isEmpty()) {
		    	listReader.close();
		    	throw new IllegalArgumentException("Unable to load file.");
		    }
		    else {
			    TaskList list = new TaskList(listName, Integer.parseInt(count));
		
			    listReader.useDelimiter("\\r?\\n?[*]");
		
			    while (listReader.hasNext()) {
			        list.addTask(processTask(list, listReader.next()));
			    }
			    listReader.close();
		
			    return list;
		    }
	    }
	}
	
	/**
	 * Processes Task information from String parameter
	 * @param taskInfo String holds Task information
	 * @param list to add task to
	 * @return a Task object with the information from parameter
	 */
	private static Task processTask(AbstractTaskList list, String taskInfo) {
		Scanner taskScanner = new Scanner(taskInfo);
	    taskScanner.useDelimiter("&!@");
	    String first = taskScanner.nextLine();
	    String description = taskScanner.next();
	    
	    Scanner firstScanner = new Scanner(first);
	    firstScanner.useDelimiter(",");

	    String name = firstScanner.next().substring(1).trim(); 
	    
	    if(name == null || name.isEmpty()) {
	    	taskScanner.close();
	    	firstScanner.close();
	    	throw new IllegalArgumentException("Unable to load file.");
	    }
	    else {
		    boolean recurring = false;
		    boolean active = false;
	
		    while (firstScanner.hasNext()) {
		        String token = firstScanner.next().trim();
		        if ("recurring".equalsIgnoreCase(token)) {
		            recurring = true;
		        } else if ("active".equalsIgnoreCase(token)) {
		            active = true;
		        }
		    }
		    firstScanner.close();
		    taskScanner.close();
	
		    return new Task(name, description.trim(), recurring, active);
	    }
    }
}
