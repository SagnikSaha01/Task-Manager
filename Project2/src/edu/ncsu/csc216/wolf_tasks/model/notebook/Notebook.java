package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;
import java.util.Arrays;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;
/**
 * Class for managing a notebook object 
 * @author Aadhir Sandeep
 * @author Sagnik Saha
 */
public class Notebook {
	/** Name of the notebook */
	private String notebookName;
	/** Whether the notebook has changed or not */
	private boolean isChanged;
	/** Linked list that stores all the current task lists */
	private ISortedList<TaskList> taskLists;
	/** Array list that stores all the active tasks */
	private ActiveTaskList activeTaskList;
	/** Array list of the current task list */
	private AbstractTaskList currentTaskList;
	/**Default Active Task List Name **/
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";
	/**
	 * Constructor for the notebook object 
	 * @param name the name of the notebook
	 */
	public Notebook(String name) {
		if(name == null || "".equals(name) || ACTIVE_TASKS_NAME.equals(name)) {
			throw new IllegalArgumentException("Invalid Name.");
		}
		setChanged(false);
		setActiveTaskList(new ActiveTaskList());
		setNotebookName(name);
		taskLists = new SortedList<>();
		currentTaskList = activeTaskList;
		getActiveTaskList();
	}
   /** 
	* Saves the current notebook to a file
	* @param f the file to save the notebook to
	*/
	public void saveNotebook(File f) {
		NotebookWriter.writeNotebookFile(f, notebookName, taskLists);
		isChanged = false;
	}
   /**
    * Retrieves the name of the notebook
    * @return String name of the notebook
    */
	public String getNotebookName() {
		return notebookName;
	}
   /**
    * Sets the notebook name
    * @param name the name of the notebook to set
    */
	private void setNotebookName(String name) {
		this.notebookName = name;
	}
   /**
    * Whether the notebook has changed or not
    * @return boolean whether the notebook has changed or not
	*/
	public boolean isChanged() {
		return isChanged;
	}
   /**
    * Sets the notebook to be changed or not
    * @param change whether the notebook has changed or not
    */
	public void setChanged(boolean change) {
		this.isChanged = change;
	}
   /**
    * Adds another task list to the linked list of all the task lists
    * @param tl the task list to be added
    */
	public void addTaskList(TaskList tl) {
		if(tl.getTaskListName().equalsIgnoreCase(ActiveTaskList.ACTIVE_TASKS_NAME)){
			throw new IllegalArgumentException("Invalid name.");
		}
		isChanged = true;
		taskLists.add(tl);
		currentTaskList = tl;
	}
   /**
    * Gets the names of all the tasks lists as an array
    * @return String[] array consisting of all the task list names
    */
	public String[] getTaskListsNames() {
		String[] names = new String[taskLists.size() + 1];
		names[0] = ActiveTaskList.ACTIVE_TASKS_NAME;
		for(int i = 0; i < taskLists.size(); i++) {
			names[i + 1] = taskLists.get(i).getTaskListName();
		}
		return names;
	}
   /**
    * Retrieves the list of active lists
    */
	private void getActiveTaskList() {
		//TODO
	}
   /**
    * Sets the current task list name
    * @param tl the name of the task list
    */
	public void setCurrentTaskList(String tl) {
		boolean found = false;
		for(int i = 0; i < taskLists.size(); i++) {
			if(taskLists.get(i).getTaskListName().equalsIgnoreCase(tl)) {
				found = true;
				currentTaskList = taskLists.get(i);
			}
		}
		if(!found) {
			currentTaskList = activeTaskList;
		}
		
	}
   /**
    * Retrieves the current task list
    * @return AbstractTaskList the current task list
    */
	public AbstractTaskList getCurrentTaskList() {
		return currentTaskList;
	}
   /**
    * Edits a specific task list
    * @param taskListName the name of the task list to edit
    */
	public void editTaskList(String taskListName) {
		if(currentTaskList == activeTaskList || taskListName.equalsIgnoreCase(ActiveTaskList.ACTIVE_TASKS_NAME)) {
			throw new IllegalArgumentException("Invalid name."); 
		}
		for(int i = 0; i < taskLists.size(); i++) {
			if(taskLists.get(i).getTaskListName().equalsIgnoreCase(taskListName)) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		AbstractTaskList temp = currentTaskList;
		for(int i = 0; i < taskLists.size(); i++) {
			if(taskLists.get(i).equals(currentTaskList)) {
				temp = taskLists.remove(i);
			}
		}
		temp.setTaskListName(taskListName);
		taskLists.add((TaskList) temp);
	}
   /**
    * Removes a task list from the linked list of task lists
    */
	public void removeTaskList() {
		if(currentTaskList == activeTaskList) {
			throw new IllegalArgumentException("The Active Tasks list may not be deleted.");
		}
		for(int i = 0; i < taskLists.size(); i++) {
			if(taskLists.get(i).equals(currentTaskList)) {
				taskLists.remove(i);
			}
		}
		currentTaskList = activeTaskList;
		isChanged = true;
	}
   /**
    * Adds a task to a task list
    * @param t the task to be added
    */
	public void addTask(Task t) {
		if(currentTaskList != activeTaskList) {
			currentTaskList.addTask(t);
			if(t.isActive()) {
				activeTaskList.addTask(t);
			}
			isChanged = true;
		}
		
	}
	
	/**
	 * Edits Task in a specific task List in the Notebook
	 * @param idx index of Task in List
	 * @param taskName name of Task
	 * @param taskDescription description of Task
	 * @param recurring whether task is recurring
	 * @param active whether task is active
	 */
	public void editTask(int idx, String taskName, String taskDescription, boolean recurring, boolean active) {
		if(currentTaskList != activeTaskList) {
			Task t = currentTaskList.getTask(idx);
			t.setTaskName(taskName);
			t.setTaskDescription(taskDescription);
			t.setRecurring(recurring);
			t.setActive(active);
			isChanged = true;
			if(active) {
				t = activeTaskList.getTask(idx);
				t.setTaskName(taskName);
				t.setTaskDescription(taskDescription);
				t.setRecurring(recurring);
				t.setActive(active);
			}
		}
	}
	/**
	 * Sets the active task list
	 * @param activeTaskList the task list that is being set
	 */
	public void setActiveTaskList(ActiveTaskList activeTaskList) {
		this.activeTaskList = activeTaskList;
	}
	
	

}
