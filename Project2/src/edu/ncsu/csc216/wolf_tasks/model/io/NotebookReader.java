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

			String completed = scan.next().substring(1);
			

			
			
			
			System.out.println(completed);
			System.out.println(completed.length());
			
			
			
			while(scan.hasNext()) {
				//System.out.println(scan.next());
			}
			//System.out.println(scan.next() + "A");
			
			String completedCount = scan.next();
			
			
			System.out.println(completedCount);
			
			
									
			//int c1 = Integer.parseInt(newcount);
			
			
			//a1 = new TaskList(name, Integer.parseInt(newcount));
			
			
			
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
		Scanner scan = new Scanner(line);
		scan.useDelimiter(",");
		Task t = null;
		try {
			String name = scan.next().trim();
			
			boolean isRecurring = false;
			boolean isActive = false;
			
			while(scan.hasNext()) {
				if(scan.next().trim().equals("recurring")) {
					isRecurring = true;			
					
				}
				if(scan.next().trim().equals("active")) {
					isActive = true;
				}
				scan.next();
			}
			
			scan.useDelimiter("\r?\n?[-]");
			
			String description = "";
			
			while(scan.hasNext()) {
				description += scan.next().trim();						
			}
			

			t = new Task(name, description, isRecurring, isActive);		
			
			scan.close();
			
		} catch (NoSuchElementException e){
			scan.close();
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		return t;
	}
	

}
