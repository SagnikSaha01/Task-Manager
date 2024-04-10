package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 *Active List Class that extends Abstract Task List abstract class. Stores and keeps track of all active Tasks.
 *@author Aadhir Sandeep
 *@author Sagnik Saha
 */
public class ActiveTaskList extends AbstractTaskList {
	/**
	 * Default name of Active List
	 */
	public final static String ACTIVE_TASKS_NAME = "Active Tasks";
	
	/**
	 * Construct an Active TaskList with default name and completed Tasks as 0
	 */
	public ActiveTaskList() {
		super(ACTIVE_TASKS_NAME, 0);
	}

	
	/**
	 * Adds Task to the end of Active Task List
	 * @param t the task that is being added
	 * @throws IllegalArgumentException if user is attempting to add directly to active tasks
	 */
	@Override
	public void addTask(Task t) {
		boolean found = false;
		if(t.isActive()) {
			for(int i = 0; i < this.getTasks().size(); i++) {
				if(this.getTasks().get(i).equals(t)) {
					found = true;
				}
			}
			if(!found) {
				this.getTasks().add(t);
				t.addTaskList(this);
			}
		}
		else {
			throw new IllegalArgumentException("Cannot add task to Active Tasks.");
		}
	}
	
	/**
	 * Sets the Active Task List Name 
	 * @param name name of the active task list
	 * @throws IllegalArgumentException if active task list name is modified to a different name.
	 */
	@Override
	public void setTaskListName(String name) {
		if(name.equals(ACTIVE_TASKS_NAME)) {
			super.setTaskListName(ACTIVE_TASKS_NAME);
		}
		else {
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		}
	}
	
	/**
	 * Clears all Tasks in Active Task List
	 */
	public void clearTasks() {
		int size = getTasks().size();
		for(int i = size - 1; i >= 0; i--) {
			getTasks().remove(i);		
		}
	}
	/**
	 * Gets 2D array of all Tasks and its fields in Active Task List
	 * @return 2D array of tasks in Active Task List 
	 */
	public String[][] getTasksAsArray() {
		String [][] output = new String[getTasks().size()][2];
		
		for(int i = 0; i < output.length; i++) {
			output[i][0] = getTasks().get(i).getTaskListName();
			output[i][1] = getTasks().get(i).getTaskName();
		}
		return output;
	}
	
}
