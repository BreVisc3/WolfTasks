package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * The task object is a core piece of the program, it will be used
 * to make up task lists. A task knows its name, description, whether
 * it is recurring or active and the list it is on
 * 
 * @author Brendan Viscount
 */
public class Task {
	
	/** Name of the task */
	private String taskName;
	/** Description of the task */
	private String taskDescription;
	/** Flag for whether or not the task is recurring */
	private boolean recurring;
	/** Flag for whether or not the task is active */
	private boolean active;
	/** List of tasks */
	private AbstractTaskList taskLists;
	
	/**
	 * Task constructor
	 */
	public Task(String name, String description, boolean recurring, boolean active) {
		taskName = name;
		taskDescription = description;
		this.recurring = recurring;
		this.active = active;
	}

	/**
	 * Returns the name of the task
	 * @return the name of the task
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the name of the task to the parameter
	 * @param taskName to set to
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	/**
	 * Returns the description of the task
	 * @return the description of the task
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * Sets the description of the task to the parameter
	 * @param taskDescription to set to
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	/**
	 * Returns a boolean value representing whether or not the task is recurring
	 * @return boolean true if task is recurring, false if not
	 */
	public boolean isRecurring() {
		return recurring;
	}

	/**
	 * Sets the value of recurring to parameter
	 * @param recurring boolean value to set to
	 */
	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	/**
	 * Returns a boolean value representing whether or not the task is active
	 * @return boolean true if task is active, false if not
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the value of active to parameter
	 * @param active boolean value to set to
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Returns the name of the task list the task is a part of
	 * @return String of the name of the task list
	 */
	public String getTaskListName() {
		return "";
	}
	
	/**
	 * Task list to add task to
	 * @param list to add
	 */
	public void addTaskList(AbstractTaskList list) {
		
	}
	
	/**
	 * Set task to completed, add to completed list
	 */
	public void completeTask() {
		
	}
	
	/**
	 * Create a copy of the task
	 * @return a copy of the task
	 */
	public Object clone() {
		Object s = 0;
		return s;
	}
	
	/**
	 * Returns a string representation of the task
	 * @Return the task written as a string
	 */
	public String toString() {
		return "";
	}

}
