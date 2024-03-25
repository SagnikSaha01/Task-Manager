package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

public class Notebook {
	private String notebookName;
	
	private boolean isChanged;
	
	private ISortedList<TaskList> taskLists;
	
	private ActiveTaskList activeTaskList;
	
	public Notebook(String name) {
		
	}
	public void saveNotebook(File f) {
		
	}
	public String getNotebookName() {
		return notebookName;
	}
	private void setNotebookName(String name) {
		
	}
	public boolean isChanged() {
		return true;
	}
	public void setChanged(boolean change) {
		
	}
	public void addTaskList(TaskList tl) {
		
	}
	public String[] getTaskListsNames() {
		return null;
	}
	public void getActiveTaskList() {
		
	}
	public void setCurrentTaskList(String tl) {
		
	}
	public AbstractTaskList getCurrentTaskList() {
		return null;
	}
	public void editTaskList(String taskListName) {
		
	}
	public void removeTaskList() {
		
	}
	public void addTask(Task t) {
		
	}
	public void editTask(int i, String s, String t, boolean a, boolean b) {
		
	}
	
	

}
