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
	 * @param file directory of file
	 * @return Notebook object
	 */
	public static Notebook readNotebookFile(File file) {
		String input = "";
		
		Notebook n = null;
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file));
			
			while(fileReader.hasNextLine()) {
				input += fileReader.nextLine() + "\n";
			}
			
			if(input.charAt(0) != '!') {
				throw new IllegalArgumentException("Unable to load file.");				
			}
			
			Scanner scan = new Scanner(input);
			
			String name = scan.nextLine().trim().substring(2);
			
			n = new Notebook(name);
			
			scan.useDelimiter("\\r?\\n?[#]");
			
			while(scan.hasNext()) {
				n.addTaskList(processTaskList(scan.next()));			
			}		
			
			scan.close();
		} catch(FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
			
		}

		return n;
	}
	/**
	 * Helper method to process multiple TaskLists in a Notebook
	 * @param line of file
	 * @return TaskList object
	 */
	private static TaskList processTaskList(String line) {
		Scanner scan = new Scanner(line);
		
		scan.useDelimiter(",");
		
		TaskList a1 = null;
		
		try {
			
			
			String name = scan.next().trim();
			
			scan.useDelimiter("\\r?\\n?[*]");

			String completedCount = scan.next().substring(1);
			
			
			a1 = new TaskList(name, Integer.parseInt(completedCount));
			
			
			while(scan.hasNext()) {
				a1.addTask(processTask(a1, scan.next()));			
			}
			
			scan.close();
			
			
		} catch(NoSuchElementException e) {
			scan.close();
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		
		return a1;
	}
	
	/**
	 * Helper method to process multiple Tasks in a TaskList
	 * @param l List of Task
	 * @param line Line of file
	 * @return Task object
	 */
	private static Task processTask(AbstractTaskList l, String line) {
		//System.out.println(line);
		Scanner scan = new Scanner(line);
		Task t = null;
		
		String name = "";
		String active = "";
		String recurring = "";
		
		boolean isRecurring = false;
		boolean isActive = false;
		boolean isComma = false;
		
			
		try { 
			
			String firstLine = scan.nextLine();
			
			String desc = "";
			while(scan.hasNextLine()) {
				desc += scan.nextLine() + "\n";						
			}
						
			
			Scanner scan1 = new Scanner(firstLine);
			
			
			
			
			
			scan1.useDelimiter(",");
			
			int count = 0;
			

			while(scan1.hasNext()) {
				if(count == 0) {
					name = scan1.next().trim();
					count++;
				}
				if(count == 1) {
					recurring = scan1.next().trim();
					count++;
				}
				if(count == 2) {
					active = scan1.next().trim();
				}
			}
						
			if("recurring".equals(recurring)) {
				isRecurring = true;								
			}
			
			if("active".equals(active)) {
				isActive = true;
			}
		
			
				
						
			t = new Task(name, desc, isRecurring, isActive);	
			
		
			scan1.close();
			
			scan.close();
			
		} catch (NoSuchElementException e){
			scan.close();
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		return t;
	}
	

}
