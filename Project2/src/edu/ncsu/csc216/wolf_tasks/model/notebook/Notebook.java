package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

/**
 * Notebook class manages TaskLists on a larger scale
 * 
 * @author Brendan_Viscount
 */
public class Notebook {

	/** Name of the notebook */
	private String notebookName;
	/** Flag for whether or not the notebook is changed */
	private boolean isChanged;
	/** Holds the active tasks in the notebook */
	AbstractTaskList activeTaskList;
	/** Holds current task list */
	AbstractTaskList currentTaskList;
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
		
		NotebookWriter.writeNotebookFile(filename, getNotebookName(), taskLists);
		isChanged = false;
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
		notebookName = name;
	}
	
	/**
	 * Returns whether or not the notebook is changed
	 * @return flag for whether or not the notebook is changed
	 */
	public boolean isChanged() {
		return isChanged;
	}
	
	/**
	 * Sets the value of isChanged to parameter boolean
	 * @param boolean value to set isChanged to
	 */
	public void setChanged(boolean changed) {
		isChanged = changed;
	}
	
	/**
	 * Adds a task list to the notebook
	 * @param task list to add
	 */
	@SuppressWarnings("unchecked")
	public void addTaskList(TaskList list) {
		if(list.getTaskListName() == "Active Tasks" || taskLists.contains(list.getTaskListName())) {
			throw new IllegalArgumentException("Invalid name.");
		}
		
		taskLists.add(list);
	}
	
	/**
	 * Returns the name of all task lists in the notebook as a String[]
	 * @return String[] representation of all task list names
	 */
	public String[] getTaskListNames() {
		String[] names = new String[taskLists.size()];
		names[0] = "Active Tasks";
		for(int i = 0; i < taskLists.size(); i++) {
			names[i] = taskLists.get(i).toString();
		}
		
		return names;
	}
	
	/**
	 * Addresses the active task list of the notebook
	 */
	private void getActiveTaskList() {
		AbstractTaskList temp = new ActiveTaskList("Active Tasks", 0);
		for(int i = 0; i < taskLists.size(); i++) {
			for(int j = 0; j < ((AbstractTaskList)taskLists.get(i)).getTasks().size(); j++) {
				if(((AbstractTaskList)taskLists.get(i)).getTasks().get(j).isActive()) {
					temp.addTask(((AbstractTaskList)taskLists.get(i)).getTasks().get(j));
				}
			}
		}
		activeTaskList = temp;
	}
	
	/**
	 * Sets task list with parameter name to the active list
	 * @param name of the task list so set current
	 */
	public void setCurrentTaskList(String name) {
		boolean flag = false;
		for(int i = 0; i < taskLists.size(); i++) {
			if(name.equals(taskLists.get(i).toString())) {
				flag = true;
				currentTaskList = (TaskList) taskLists.get(i);
			}
		}
		
		if(!flag) {
			currentTaskList = activeTaskList;
		}
	}
	
	/**
	 * Returns the current task list
	 * @return the current task list
	 */
	public AbstractTaskList getCurrentTaskList() {
		return currentTaskList;
	}
	
	/**
	 * Selects the task list with parameter name to edit
	 * @param name of task list to edit
	 */
	public void editTaskList(String name) {
		if("Active Tasks".equalsIgnoreCase(name) || taskLists.contains(name) || currentTaskList instanceof ActiveTaskList) {
			throw new IllegalArgumentException("Invalid information.");
		}
		
		
		isChanged = true;
	}
	
	/**
	 * Removes task list from the notebook
	 */
	public void removeTaskList() {
		if(currentTaskList instanceof ActiveTaskList) {
			throw new IllegalArgumentException("The Active Tasks list may not be deleted.");
		}
		for(int i = 0; i < taskLists.size(); i++) {
			if(currentTaskList.getTaskListName().equals(taskLists.get(i).toString())) {
				activeTaskList = (AbstractTaskList) taskLists.get(i);
				taskLists.remove(i);
				isChanged = true;
			}
		}
		
	}
	
	/**
	 * Adds a task to the taskList
	 * @param task to add
	 */
	public void addTask(Task task) {
		if(currentTaskList instanceof TaskList) {
			if(task.isActive()) {
				getActiveTaskList(); //WHAT
			}
			currentTaskList.addTask(task);
			isChanged = true;
		}
		
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
		if(currentTaskList instanceof TaskList) {
			
			if(currentTaskList.getTask(index).isActive()) {
				getActiveTaskList();
			}
			Task task = new Task(name, description, isRecurring, isActive);
			currentTaskList.removeTask(index);
			currentTaskList.addTask(task);
		}
	}
}
