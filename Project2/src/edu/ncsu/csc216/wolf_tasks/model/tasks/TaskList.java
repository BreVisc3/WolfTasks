package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * TaskList is a collection class for general Tasks
 * 
 * @author Brendan_Viscount
 */
public class TaskList extends AbstractTaskList{

	/**
	 * Task List constructor
	 */
	public TaskList(String name, int numCompleted) {
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
	 * Provides functionality for comparing task lists
	 * @param task list to compare to
	 * @return integer representation of comparison -1 for before, 0 for equals, 1 for after
	 */
	public int compareTo(TaskList list) {
		return 0;
	}
}
