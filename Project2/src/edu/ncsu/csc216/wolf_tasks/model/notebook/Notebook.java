package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

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
	/**
	 * Constructor for the notebook object 
	 * @param name the name of the notebook
	 */
	public Notebook(String name) {
		isChanged = false;
		setActiveTaskList(new ActiveTaskList());
		setNotebookName(name);
		taskLists = new SortedList<>();
		
	}
   /** 
	* Saves the current notebook to a file
	* @param f the file to save the notebook to
	*/
	public void saveNotebook(File f) {
		//TODO implementation
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
		//TODO implementation
		
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
		//TODO implementation
	}
   /**
    * Adds another task list to the linked list of all the task lists
    * @param tl the task list to be added
    */
	public void addTaskList(TaskList tl) {
		taskLists.add(tl);
	}
   /**
    * Gets the names of all the tasks lists as an array
    * @return String[] array consisting of all the task list names
    */
	public String[] getTaskListsNames() {
		return null;
	}
   /**
    * Retrieves the list of active lists
    */
	public void getActiveTaskList() {
		//TODO implementation
	}
   /**
    * Sets the current task list name
    * @param tl the name of the task list
    */
	public void setCurrentTaskList(String tl) {
		//TODO implementation
	}
   /**
    * Retrieves the current task list
    * @return AbstractTaskList the current task list
    */
	public AbstractTaskList getCurrentTaskList() {
		return activeTaskList;
	}
   /**
    * Edits a specific task list
    * @param taskListName the name of the task list to edit
    */
	public void editTaskList(String taskListName) {
		//TODO implementation
	}
   /**
    * Removes a task list from the linked list of task lists
    */
	public void removeTaskList() {
		//TODO implementation
	}
   /**
    * Adds a task to a task list
    * @param t the task to be added
    */
	public void addTask(Task t) {
		//TODO implementation
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
		//TODO implementation
	}
	/**
	 * Sets the active task list
	 * @param activeTaskList the task list that is being set
	 */
	public void setActiveTaskList(ActiveTaskList activeTaskList) {
		this.activeTaskList = activeTaskList;
	}
	
	

}
