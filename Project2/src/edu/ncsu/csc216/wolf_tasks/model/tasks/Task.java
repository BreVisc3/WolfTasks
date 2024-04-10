package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * The task object is a core piece of the program, it will be used
 * to make up task lists. A task knows its name, description, whether
 * it is recurring or active and the list it is on
 * 
 * @author Brendan_Viscount
 */
public class Task implements Cloneable {
	
	/** Name of the task */
	private String taskName;
	/** Description of the task */
	private String taskDescription;
	/** Flag for whether or not the task is recurring */
	private boolean recurring;
	/** Flag for whether or not the task is active */
	private boolean active;
	/** List of tasks */
	private ISwapList<AbstractTaskList> taskLists;
	
	/**
	 * Task constructor
	 * @param name of task
	 * @param description of task
	 * @param recurring boolean if task recurs
	 * @param active boolean if task is active
	 */
	public Task(String name, String description, boolean recurring, boolean active) {
		setTaskName(name);
		setTaskDescription(description);
		setRecurring(recurring);
		setActive(active);
		taskLists = new SwapList<AbstractTaskList>();
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
	 * @throws IllegalArgumentException if parameter description is null or empty
	 */
	public void setTaskName(String taskName) {
		if(taskName == null || taskName.isEmpty()) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
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
	 * @throws IllegalArgumentException if parameter description is null
	 */
	public void setTaskDescription(String taskDescription) {
		if(taskDescription == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
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
		if(taskLists == null || taskLists.size() == 0) {
			return "";
		}
		
		return taskLists.get(0).getTaskListName();
	}
	
	/**
	 * Task list to add task to
	 * @param list to add
	 */
	public void addTaskList(AbstractTaskList list) {
		if(list == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		
		boolean duplicate = false;
		for(int i = 0; i < taskLists.size(); i++) {
			if(taskLists.get(i).getTaskListName().equals(list.getTaskListName())) {
				duplicate = true;
			}
		}
		
		if(!duplicate) {
			taskLists.add(list);
		}
	}
	
	/**
	 * Set task to completed, add to completed list
	 */
	public void completeTask() {
		
		for(int i = 0; i < taskLists.size(); i++) {
			taskLists.get(i).completeTask(this);
		}
		if(recurring) {
			for(int i = 0; i < taskLists.size(); i++) {
				taskLists.get(i).addTask(this);
			}
		}
	}
	
	/**
	 * Create a copy of the task
	 * @return a copy of the task
	 * @throws CloneNotSupportedException if there is no task to clone
	 */
	public Object clone() throws CloneNotSupportedException {
		if(taskLists == null || taskLists.size() == 0) {
			throw new CloneNotSupportedException("Cannot clone.");
		}
		return new Task(taskName, taskDescription, recurring, active);
	}
	
	/**
	 * Returns a string representation of the task
	 * @return String the task written as a string
	 */
	public String toString() {
		String[] description = getTaskDescription().split("\n");
		String desc = "";
		for(int i = 0; i < description.length; i++) {
			if(i == description.length - 1) {
				desc += description[i];
			}
			else {
				desc += description[i] + "\n";
			}
		}
		
		String info = "* " + getTaskName() +
                 ( isRecurring() ? ",recurring" : "") +
                 ( isActive() ? ",active" : "") +
                 "\n" + desc;

		return info;
	}

}
