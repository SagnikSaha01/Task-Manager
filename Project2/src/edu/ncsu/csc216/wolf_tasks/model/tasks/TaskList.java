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
		super(name, completedCount);
	}
	
	/**
	 * Outputs Task List as a 2D String array
	 * @return 2D array of Tasks
	 */
	public String[][] getTasksAsArray() {
		String [][] output = new String[getTasks().size()][2];
		int count = 1;
		for(int i = 0; i < output.length; i++) {
			output[i][0] = String.valueOf(count);
			output[i][1] = getTasks().get(i).getTaskName();
			count++;
		}
		return output;
	    	
	}

	
    /**
     * Compares two TaskLists alphabetically based on name
     * @param o TaskList object that is being compared
     * @return positive or negative value based on ordering
     */
	@Override
	public int compareTo(TaskList o) {
		if(this.getTaskListName().compareTo(o.getTaskListName()) > 0) {
			return 1;			
		}
		else if(this.getTaskListName().compareTo(o.getTaskListName()) < 0) {
			return -1;
			
		} else {
			return 0;
		}
		
	}
}
