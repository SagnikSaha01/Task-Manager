package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * Class for creating and updating task objects
 * @author Aadhir Sandeep
 * @author Sagnik Saha
 */
public class Task {
	/**
	 * Name of a Task
	 */
	private String taskName;
	
	/**
	 * Description of Task
	 */
	private String taskDescription;
	
	/**
	 * Whether task is recurring
	 */
	private boolean recurring;
	
	/**
	 * Whether task is active
	 */
	private boolean active;
	
	/**
	 * Task knows the List it exists in
	 */
	private ISwapList<AbstractTaskList> taskLists;
	
	/**
	 * Task Constructor 
	 * @param name Task's Name
	 * @param description Task's description
	 * @param recurring Whether the Task is recurring
	 * @param active  Whether the Task is active
	 */
	public Task(String name, String description, boolean recurring, boolean active) {
		taskLists = new SwapList<>();
		setTaskName(name);
		setTaskDescription(description);
		setRecurring(recurring);
		setActive(active);
	}

	/**Gets the task name
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**Sets the Task name
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		if(taskName == null || taskName.length() == 0) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskName = taskName;
	}

	/**Gets the task description
	 * @return the task description
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**Sets the Task Description
	 * @param taskDescription the taskDescription to set
	 */
	public void setTaskDescription(String taskDescription) {
		if(taskDescription == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDescription = taskDescription;
	}

	/**Gets whether task is recurring
	 * @return the recurring
	 */
	public boolean isRecurring() {
		return recurring;
	}

	/**Sets whether Task is recurring
	 * @param recurring the recurring to set
	 */
	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	/**Gets whether Task is active
	 * @return whether task is active
	 */
	public boolean isActive() {
		return active;
	}

	/**Sets whether Task is active
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Gets TaskList Name of Task
	 * @return taskList Name
	 */
	public String getTaskListName() {
		if(taskLists == null || taskLists.size() == 0) {
			return "";
		}
		return taskLists.get(0).getTaskListName();
	}
	
	/**
	 * If the AbstractTaskList is not associated with a Task, then it is added to the end of the TaskList field.
	 * @throws IllegalArgumentException if the parameter is null
	 * @param list list of Tasks
	 */
	public void addTaskList(AbstractTaskList list) {
		if(list == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		boolean found = false;
		for(int i = 0; i < taskLists.size(); i++) {
			if(taskLists.get(i).equals(list)) {
				found = true;
			}
		}
		if(!found) {
			taskLists.add(list);
		}
	}
	
	/**
	 * Whether Task has been completed 
	 * @throws CloneNotSupportedException if no AbstractTaskList associated with a Task 
	 */
	public void completeTask() {
		
		for(int i = 0; i < taskLists.size(); i++) {
			taskLists.get(i).completeTask(this);
		}
		if(recurring) {
			try {
				Task t = (Task) clone();
				for(int i = 0; i < taskLists.size(); i++) {
					taskLists.get(i).addTask(t);
				}
			} catch (Exception e) {
				throw new IllegalArgumentException();
			}
			
		}
	}
	
	/**
	 * Returns a copy of the Task
	 * @throws CloneNotSupportedException if no AbstractTaskList associated with a Task
	 * @return returns a Task object
	 */
	public Object clone() throws CloneNotSupportedException {
		if(taskLists.size() == 0 || taskLists == null) {
			throw new CloneNotSupportedException("Cannot clone.");
		}
		
		Task clone = new Task(this.getTaskName(), this.getTaskDescription(), this.isRecurring(), this.isActive());
		return clone;
	}
	/**
	 * Lists Task attributes as a String
	 * @return String of Task attributes
	 */
	public String toString() {
		String out = "* " + taskName;
		if(recurring) {
			out = out + ",recurring";
		}
		if(active) {
			out = out + ",active";
		}
		out = out + "\n" + taskDescription;
		return out;
	}
	
}
