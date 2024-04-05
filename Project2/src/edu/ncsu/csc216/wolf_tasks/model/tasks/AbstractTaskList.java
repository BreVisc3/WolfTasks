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
	ISwapList<Task> tasks = new SwapList<>();
	 
	 
	
	/**
	 * AbstractTaskList Constructor
	 */
	public AbstractTaskList(String name, int numCompleted) {
		if(numCompleted < 0) {
			throw new IllegalArgumentException("Invalid completed count.");
		}
		setTaskListName(name);
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
	 * @throws IllegalArgumentException if parameter listName is null or empty
	 */
	public void setTaskListName(String listName) {
		if(listName == null || listName.isEmpty()) {
			throw new IllegalArgumentException("Invalid name.");
		}
		
		this.taskListName = listName;
	}
	
	/**
	 * Return a list of all the tasks
	 * @return the list of tasks
	 */
	public ISwapList<Task> getTasks(){
		return tasks;
		
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
		
		tasks.add(task);
		task.addTaskList(this);
	}
	
	/**
	 * Removes to element in parameter index
	 * @param index of element to remove
	 * @return removed element in parameter index
	 */
	public Task removeTask(int index) {
		Task task = tasks.get(index);
		tasks.remove(index);
		
		return task;
	}
	
	/**
	 * Returns the task in parameter index
	 * @param index of task to get
	 * @return task in index parameter
	 */
	public Task getTask(int index) {
		return tasks.get(index);
	}
	
	/**
	 * Sets a task to completed and adds task to completed list
	 * @param Task to mark completed
	 */
	public void completeTask(Task task) {
		
		for(int i = 0; i < tasks.size(); i++) {
			if(tasks.get(i) == task) {
				tasks.remove(i);
				completedCount++;
			}
		}
		
	}
	
	public abstract String[][] getTasksAsArray();
}
