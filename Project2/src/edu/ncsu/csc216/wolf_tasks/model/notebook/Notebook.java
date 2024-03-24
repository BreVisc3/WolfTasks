package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

public class Notebook {

	/** Name of the notebook */
	private String notebookName;
	/** Flag for whether or not the notebook is changed */
	private boolean isChanged;
	/** Holds the active tasks in the notebook */
	ActiveTaskList activeTaskList;
	/** Holds current task list */
	TaskList currentTaskList;
	/** Other task lists */
	SortedList taskLists;
	
	/**
	 * Notebook constructor
	 * @param name of the notebook
	 */
	public Notebook(String name) {
		notebookName = name;
	}
	
	/**
	 * Save the contents of notebook into parameter filename
	 * @param filename to save notebook contents to
	 */
	public void saveNotebook(File filename) {
		
	}
	
	/**
	 * Returns the name of the notebook
	 * @return notebook name
	 */
	public String getNotebookName() {
		return notebookName;
	}
	
	/**
	 * Sets the name of the notebook to the parameter name
	 * @param name to set for the notebook
	 */
	private void setNotebookName(String name) {
		
	}
	
	/**
	 * Returns whether or not the notebook is changed
	 * @return flag for whether or not the notebook is changed
	 */
	public boolean isChanged() {
		return true;
	}
	
	/**
	 * Sets the value of isChanged to parameter boolean
	 * @param boolean value to set isChanged to
	 */
	public void setChanged(boolean changed) {
		
	}
	
	/**
	 * Adds a task list to the notebook
	 * @param task list to add
	 */
	public void addTaskList(TaskList list) {
		
	}
	
	/**
	 * Returns the name of all task lists in the notebook as a String[]
	 * @return String[] representation of all task list names
	 */
	public String[] getTaskListNames() {
		return null;
	}
	
	/**
	 * Addresses the active task list of the notebook
	 */
	private void getActiveTaskList() {
		
	}
	
	/**
	 * Sets task list with parameter name to the active list
	 * @param name of the task list so set current
	 */
	public void setCurrentTaskList(String name) {
		
	}
	
	/**
	 * Returns the current task list
	 * @return the current task list
	 */
	public AbstractTaskList getCurrentTaskList() {
		return null;
	}
	
	/**
	 * Selects the task list with parameter name to edit
	 * @param name of task list to edit
	 */
	public void editTaskList(String name) {
		
	}
	
	/**
	 * Removes task list from the notebook
	 */
	public void removeTaskList() {
		
	}
	
	/**
	 * Adds a task to the taskList
	 * @param task to add
	 */
	public void addTask(Task task) {
		
	}
	
	/**
	 * Alters task in given index
	 * 
	 * @param index of task to edit
	 * @param name to set for task
	 * @param description to set for task
	 * @param isRecurring to set for task
	 * @param isActive to set for task
	 */
	public void editTask(int index, String name, String description, boolean isRecurring, boolean isActive) {
		
	}
}
