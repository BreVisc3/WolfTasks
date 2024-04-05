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
	private AbstractTaskList activeTaskList;
	/** Holds current task list */
	private AbstractTaskList currentTaskList;
	/** Other task lists */
	public SortedList taskLists;
	
	/**
	 * Notebook constructor
	 * @param name of the notebook
	 */
	public Notebook(String name) {
		taskLists = new SortedList();
		activeTaskList = new ActiveTaskList("Active Tasks", 0);
		currentTaskList = new TaskList("Current Tasks", 0);
		setNotebookName(name);
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
		if(name == null || name.isEmpty() || name == "Active Tasks") {
			throw new IllegalArgumentException("Invalid name.");
		}
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
		if("Active Tasks".equals(list.getTaskListName()) || taskLists.contains(list)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		
		taskLists.add(list);
		currentTaskList = list;
	}
	
	/**
	 * Returns the name of all task lists in the notebook as a String[]
	 * @return String[] representation of all task list names
	 */
	public String[] getTaskListNames() {
		if(taskLists.size() != 0) {
			String[] names = new String[taskLists.size()];
			names[0] = "Active Tasks";
			for(int i = 0; i < taskLists.size(); i++) {
				names[i] = taskLists.get(i).toString();
			}
			
			return names;
		}
		else {
			return new String[0];
		}
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
			TaskList list = (TaskList) taskLists.get(i);
			if (list.getTaskListName().equals(name)) {
	            currentTaskList = list;
	            flag = true;
	            break;
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
		
		if (currentTaskList instanceof ActiveTaskList || "Active Tasks".equalsIgnoreCase(name)) {
	        throw new IllegalArgumentException("Invalid information.");
	    }
	    int currentIndex = -1;
	    for (int i = 0; i < taskLists.size(); i++) {
	        if (currentTaskList.equals(taskLists.get(i))) {
	            currentIndex = i;
	        }
	        if (name.equalsIgnoreCase(((AbstractTaskList) taskLists.get(i)).getTaskListName())) {
	            throw new IllegalArgumentException("Duplicate task list name.");
	        }
	    }
	    if (currentIndex != -1) {
	        taskLists.remove(currentIndex);
	    } else {
	        throw new IllegalArgumentException("Current task list not found.");
	    }
	    currentTaskList.setTaskListName(name);
	    taskLists.add((TaskList) currentTaskList);
	    setChanged(true);
	}
	
	/**
	 * Removes task list from the notebook
	 */
	public void removeTaskList() {
		if (currentTaskList instanceof ActiveTaskList) {
	        throw new IllegalArgumentException("The Active Tasks list may not be deleted.");
	    }
	    
	    String currentName = currentTaskList.getTaskListName();
	    
	    int indexToRemove = -1;
	    for (int i = 0; i < taskLists.size(); i++) {
	        TaskList list = (TaskList) taskLists.get(i);
	        if (list.getTaskListName().equals(currentName)) {
	            indexToRemove = i;
	            break;
	        }
	    }
	    if (indexToRemove != -1) {
	        taskLists.remove(indexToRemove);
	        activeTaskList = currentTaskList;
	        isChanged = true;
	    } else {
	        throw new IllegalArgumentException("Task list not found in the notebook.");
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
