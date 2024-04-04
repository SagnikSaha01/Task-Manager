package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
	public static Notebook readNotebookFile(File file) {
		String input = "";
		
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file));
			
			while(fileReader.hasNextLine()) {
				input += fileReader.nextLine() + "\n";
			}
			
			if(input.charAt(0) != '!') {
				throw new IllegalArgumentException("Unable to load file.");				
			}
			
			Scanner scan = new Scanner(input);
			
			scan.useDelimiter("\\r?\\n?[#]");
			
			while(scan.hasNext()) {
				processTaskList(scan.next());			
			}


			
			
			
		} catch(FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
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
		Scanner scan = new Scanner(line);
		
		scan.useDelimiter(",");
		
		try {
			String name = scan.next();
			name = name.substring(2);
			int completedCount = Integer.parseInt(scan.next().trim());
			
			AbstractTaskList a1 = new TaskList(name, completedCount);
			
			
			scan.useDelimiter("\\r?\\n?[*]");
			
			while(scan.hasNext()) {
				processTask(a1, scan.next());			
			}
			
			
		} catch(NoSuchElementException e) {
			
		}
		
		
		return null;
	}
	
	/**
	 * Helper method to process multiple Tasks in a TaskList
	 * @param l List of Task
	 * @param line Line of file
	 * @return Task object
	 */
	private static Task processTask(AbstractTaskList l, String line) {
		Scanner scan = new Scanner(line);
		scan.useDelimiter(",");
		String name = scan.next().trim();
		
		while(scan.hasNext()) {
			if(scan.next			
		}
		
		
		return null;
	}
	

}
