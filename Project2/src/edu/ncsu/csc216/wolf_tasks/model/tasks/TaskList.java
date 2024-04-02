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
		String[][] info = new String[super.getTasks().size()][4];
		for(int i = 0; i < super.getTasks().size(); i++) {
			info[i][0] = Integer.toString(i + 1);
			info[i][1] = tasks.get(i).getTaskName();
		}
		return info;
	}
	
	/**
	 * Provides functionality for comparing task lists
	 * @param task list to compare to
	 * @return integer representation of comparison -1 for before, 0 for equals, 1 for after
	 */
	public int compareTo(TaskList list) {

		if(getTaskListName().compareTo(list.getTaskListName()) == 0) {
			return 0;
		}
		if(getTaskListName().compareTo(list.getTaskListName()) > 0) {
			return 1;
		}
		if(getTaskListName().compareTo(list.getTaskListName()) < 0) {
			return -1;
		}
		return -105;
		
	}
}
