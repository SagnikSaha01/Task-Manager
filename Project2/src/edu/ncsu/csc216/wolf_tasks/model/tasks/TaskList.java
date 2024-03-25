package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * Class for maintaining multiple Task objects, extends AbstractTaskList and implements Comparable.
 * @author Aadhir Sandeep
 * @author Sagnik Saha
 */
public class TaskList extends AbstractTaskList implements Comparable<TaskList> {
	
	/**
	 * Initializes TaskList fields using AbstractList constructor.
	 * @param name name of TaskList
	 * @param completedCount completed count of TaskList
	 */
	public TaskList(String name, int completedCount) {
		//TODO implementation
	}
	
	/**
	 * Outputs Task List as a 2D String array
	 * @return 2D array of Tasks
	 * 
	 */
	public String[][] getTasksAsArray() {
		// TODO Auto-generated method stub
		return null;
	}

	
    /**
     * Compares two TaskLists alphabetically
     * @param o TaskList object that is being compared
     * @return positive or negative value based on ordering
     */
	@Override
	public int compareTo(TaskList o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
