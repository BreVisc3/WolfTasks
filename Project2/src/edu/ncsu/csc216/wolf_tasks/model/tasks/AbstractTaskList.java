package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * AbstractTaskList provides basic methods for functionality of a TaskList
 * 
 * @author Brendan_Viscount
 */
public abstract class AbstractTaskList {

	/** Name of the task list */
	private String taskListName;
	/** Number of completed tasks */
	private int completedCount;
	/** SwapList for functionality */
	SwapList<Task> tasks = new SwapList<>();
	 
	 
	
	/**
	 * AbstractTaskList Constructor
	 */
	public AbstractTaskList(String name, int numCompleted) {
		taskListName = name;
		completedCount = numCompleted;
	}
	
	/**
	 * Returns the name of the task list
	 * @return the name of the task list
	 */
	public String getTaskListName() {
		return taskListName;
	}

	/**
	 * Sets the name of the task list to the parameter
	 * @param name to set for the task list
	 */
	public void setTaskListName(String listName) {
		
	}
	
	/**
	 * Return a list of all the tasks
	 * @return the list of tasks
	 */
	public ISwapList<Task> getTasks(){
		return null;
		
	}
	
	/**
	 * Returns the number of completed tasks
	 * @return the number of completed tasks
	 */
	public int getCompletedCount() {
		return completedCount;
	}

	/**
	 * Adds parameter task to the list
	 * @param task to add
	 */
	public void addTask(Task task) {
		
	}
	
	/**
	 * Removes to element in parameter index
	 * @param index of element to remove
	 * @return removed element in parameter index
	 */
	public Task removeTask(int index) {
		return null;
	}
	
	/**
	 * Returns the task in parameter index
	 * @param index of task to get
	 * @return task in index parameter
	 */
	public Task getTask(int index) {
		return null;
	}
	
	/**
	 * Sets a task to completed and adds task to completed list
	 * @param Task to mark completed
	 */
	public void completeTask(Task task) {
		
	}
	
	public abstract String[][] getTasksAsArray();
}
