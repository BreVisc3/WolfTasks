package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * Task list class for active tasks
 * 
 * @author Brendan_Viscount
 */
public class ActiveTaskList extends AbstractTaskList {
	
	/** Default ActiveTaskList name */
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";

	/**
	 * ActiveTaskList constructor
	 */
	public ActiveTaskList() {
		super(ACTIVE_TASKS_NAME, 0);
	}

	/**
	 * Returns the task list information as a String[][]
	 * @return task list info in String[][] form
	 */
	@Override
	public String[][] getTasksAsArray() {
		String[][] info = new String[getTasks().size()][2];
		for(int i = 0; i < getTasks().size(); i++) {
			info[i][0] = getTasks().get(i).getTaskListName();
			info[i][1] = tasks.get(i).getTaskName();
		}
		
		return info;
	}

	/**
	 * Add parameter task to the active list
	 * @param task to add
	 * @throws IllegalArgumentException if task parameter is not active
	 */
	@Override
	public void addTask(Task task) {
		if(!task.isActive()) {
			throw new IllegalArgumentException("Cannot add task to Active Tasks.");
		}
		else {
			super.addTask(task);
		}
	}
	
	/**
	 * Sets the name of the active list to parameter name
	 * @param name to set for task list
	 */
	@Override
	public void setTaskListName(String name) {
		if(name != ACTIVE_TASKS_NAME) {
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		}
		
		super.setTaskListName(ACTIVE_TASKS_NAME);
	}
	
	/**
	 * Empties the active task list
	 */
	public void clearTasks() {
		while(tasks.size() != 0) {
			tasks.remove(0);
		}
	}
}
