package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * TaskList is a collection class for general Tasks
 * 
 * @author Brendan_ViscountS
 */
public class TaskList extends AbstractTaskList implements Comparable<TaskList> {

	/**
	 * Task List constructor
	 * @param name of TaskList
	 * @param numCompleted int number of completed tasks
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
		String[][] info = new String[super.getTasks().size()][2];
		for(int i = 0; i < super.getTasks().size(); i++) {
			info[i][0] = Integer.toString(i + 1);
			info[i][1] = tasks.get(i).getTaskName();
		}
		return info;
	}
	
	/**
	 * Provides functionality for comparing task lists
	 * @param list to compare to
	 * @return integer representation of comparison -1 for before, 0 for equals, 1 for after
	 */
	public int compareTo(TaskList list) {
		if (list == null) {
	        throw new NullPointerException("Cannot compare to null");
	    }
	    AbstractTaskList otherList = (AbstractTaskList) list;
	    return this.getTaskListName().compareTo(otherList.getTaskListName());
	    
	}

}
