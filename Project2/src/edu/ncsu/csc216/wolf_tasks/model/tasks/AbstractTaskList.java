package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

public abstract class AbstractTaskList {
	private String taskListName;
	
	private int completedCount;
	
	private ISwapList<Task> tasks;
	
	public AbstractTaskList() {
		
	}

	/**
	 * @return the taskListName
	 */
	public String getTaskListName() {
		return taskListName;
	}

	/**
	 * @param taskListName the taskListName to set
	 */
	public void setTaskListName(String taskListName) {
		this.taskListName = taskListName;
	}
	
	public ISwapList<Task> getTasks() {
		return null;
	}

	/**
	 * @return the completedCount
	 */
	public int getCompletedCount() {
		return completedCount;
	}

	/**
	 * @param completedCount the completedCount to set
	 */
	public void setCompletedCount(int completedCount) {
		this.completedCount = completedCount;
	}
	public void addTask(Task t) {
		
	}
	public Task removeTask(int index) {
		return null;
	}
	public Task getTask(int index) {
		return null;
	}
	public void completeTask(Task t) {
		
	}
	public abstract String[][] getTasksAsArray();

}
