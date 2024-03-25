package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
/**
 *IO file file input class that reads in a Notebook 
 *@author Aadhir Sandeep
 *@author Sagnik Saha
 */
public class NotebookReader {
	/**
	 * Reads notebook from a file and returns a Notebook object
	 * @param f directory of file
	 * @return Notebook object
	 */
	public static Notebook readNotebookFile(File f) {
		processTaskList(null);
		processTask(null, null);
		return null;
	}
	/**
	 * Helper method to process multiple TaskLists in a Notebook
	 * @param line of file
	 * @return TaskList object
	 */
	private static TaskList processTaskList(String line) {
		return null;
	}
	
	/**
	 * Helper method to process multiple Tasks in a TaskList
	 * @param l List of Task
	 * @param line Line of file
	 * @return Task object
	 */
	private static Task processTask(AbstractTaskList l, String line) {
		return null;
	}
	

}
