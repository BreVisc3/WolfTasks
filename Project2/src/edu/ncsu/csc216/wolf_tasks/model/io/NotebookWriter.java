package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.PrintStream;

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
			PrintStream writer = new PrintStream(fileName);
			
			writer.print("! " + notebookName + "\n");
			
			for(int i = 0; i < list.size(); i++) {
				writer.print("# " + list.get(i).getTaskListName() + "," + list.get(i).getCompletedCount() + "\n");
				for(int j = 0; j < list.get(i).getTasks().size(); j++) {
					writer.print("* " + list.get(i).getTask(j).toString() + "\n");
				}
			}
		} catch(Exception e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
}
