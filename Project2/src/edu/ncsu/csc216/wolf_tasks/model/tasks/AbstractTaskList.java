package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;
/**
 *Abstract class that is used for the creation of TaskLists
 *@author Aadhir Sandeep
 *@author Sagnik Saha
 */
public abstract class AbstractTaskList {
	/** Name of TaskList **/
	private String taskListName;
	/** Completed Task Count **/
	private int completedCount;
	
	/** ISwapList List of Tasks **/
	private SwapList<Task> tasks;
	
	public AbstractTaskList() {
		tasks = null;
	}

	/**Gets the taskList Name
	 * @return the taskListName
	 */
	public String getTaskListName() {
		return taskListName;
	}

	/**sets the Task List Name
	 * @param taskListName the taskListName to set
	 */
	public void setTaskListName(String taskListName) {
		this.taskListName = taskListName;
	}
	
	/**
	 * Gets the TaskList
	 * @return the SwapList 
	 */
	public ISwapList<Task> getTasks() {
		return null;
	}

	/**Gets the completedCount of a Task
	 * @return the completedCount of a Task
	 */
	public int getCompletedCount() {
		return completedCount;
	}

	/**Sets the completed count 
	 * @param completedCount the completedCount to set
	 */
	public void setCompletedCount(int completedCount) {
		this.completedCount = completedCount;
	}
	
	/**
	 * Adds Task to end of the List
	 * @param t Task to be added 
	 */
	public void addTask(Task t) {
		
	}
	/**
	 * Remove Task from List 
	 * @param index of Task to be removed
	 * @return Task removed
	 */
	public Task removeTask(int index) {
		return null;
	}
	/**
	 * Gets Task from List
	 * @param index of task
	 * @return Task from List
	 */
	public Task getTask(int index) {
		return null;
	}
	/**
	 * Allows for task to be completed
	 * @param t Task to be completed
	 */
	public void completeTask(Task t) {
		
	}
	/**
	 * Abstract method that gets TaskList as a 2D array and ensures implementation in sub classes.
	 * @return Tasks and fields as a 2D array
	 */
	public abstract String[][] getTasksAsArray();

}
