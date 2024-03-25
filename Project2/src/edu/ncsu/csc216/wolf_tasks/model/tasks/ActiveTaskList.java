package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * Task list class for active tasks
 * 
 * @author Brendan_Viscount
 */
public class ActiveTaskList extends AbstractTaskList {
	
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";

	/**
	 * ActiveTaskList constructor
	 * @param name
	 * @param numCompleted
	 */
	public ActiveTaskList(String name, int numCompleted) {
		super(name, numCompleted);
	}

	/**
	 * Returns the task list information as a String[][]
	 * @return task list info in String[][] form
	 */
	@Override
	public String[][] getTasksAsArray() {
		return null;
	}

	/**
	 * Add parameter task to the active list
	 * @param Task to add
	 */
	public void addTask(Task task) {
		
	}
	
	/**
	 * Sets the name of the active list to parameter name
	 * @param name to set for task list
	 */
	public void setTaskListName(String name) {
		
	}
	
	/**
	 * Empties the active task list
	 */
	public void clearTasks() {
		
	}
}
