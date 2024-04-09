package edu.ncsu.csc216.wolf_tasks.model.io;


import java.io.File;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * IO file file input class that reads in a Notebook
 * 
 * @author Aadhir Sandeep
 * @author Sagnik Saha
 */
public class NotebookReader {
	/**
	 * Reads notebook from a file and returns a notebook object
	 * 
	 * @param file directory of file
	 * @return Notebook object
	 */
	public static Notebook readNotebookFile(File file) {
		String input = "";

		Notebook n = null;
		try {
			Scanner fileReader = new Scanner(new FileInputStream(file));

			while (fileReader.hasNextLine()) {
				input += fileReader.nextLine() + "\n";
			}
			
			//System.err.println(input);

			if (input.charAt(0) != '!') {
				throw new IllegalArgumentException("Unable to load file.");
			}
			
			
			

			Scanner scan = new Scanner(input);

			String name = scan.nextLine().trim().substring(2);
			
			n = new Notebook(name);
					


			scan.useDelimiter("\\r?\\n?[#]");

			while (scan.hasNext()) {
				try {
				
				n.addTaskList(processTaskList(scan.next()));
				}catch(Exception e) {
					continue;
				}
				
			}
			

			scan.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");

		}
		
		
		n.setCurrentTaskList("Active Tasks");

		return n;
	}

	/**
	 * Helper method to process multiple TaskLists in a Notebook
	 * 
	 * @param line of file
	 * @return TaskList object
	 */
	private static TaskList processTaskList(String line) {
		Scanner scan = new Scanner(line);
		
		String firstLine = scan.nextLine();
		
		//System.out.println(firstLine);
		
		Scanner scan1 = new Scanner(firstLine);

		scan1.useDelimiter(",");

		TaskList a1 = null;
		
		String name = scan1.next().trim();
		
		//System.out.println(name);

		//scan.useDelimiter("\\r?\\n?[*]");
		
		scan1.useDelimiter(",");
			
		String completedCount = "";
		
			
		if(scan1.hasNext()) {
			completedCount = scan1.next();
		}
		
		scan.useDelimiter("\\r?\\n?[*]");
				
			
		
		a1 = new TaskList(name, Integer.parseInt(completedCount));
	
			
		//System.out.println(a1.getTaskListName());

		while (scan.hasNext()) {
			
			try {
				a1.addTask(processTask(a1, scan.next()));
			}catch(Exception e) {
				continue;
			}
			
		}
			
		scan.close();

		return a1;
	}

	/**
	 * Helper method to process multiple Tasks in a TaskList
	 * 
	 * @param l    List of Task
	 * @param line Line of file
	 * @return Task object
	 */
	private static Task processTask(AbstractTaskList l, String line) {
		// System.out.println(line);Scanner scan2 = new Scanner(line);
		Scanner scan = new Scanner(line);
		Task t = null;

		String name = "";
		String active = "";
		String recurring = "";
		String description = "";

		boolean isRecurring = false;
		boolean isActive = false;

		try {
			String name1 = "";
			String active1 = "";
			String recurring1 = "";
			String firstLine = scan.nextLine();
			
			

			Scanner scan1 = new Scanner(firstLine);
			



			scan1.useDelimiter(",");

			// System.out.println(scan1.next());

			int count = 0;

			while (scan1.hasNext()) {
				if (count == 0) {
					name = scan1.next().trim();
					name1 = name;
					count++;
				}
				if (scan1.hasNext() && count == 1) {

					recurring = scan1.next();
					
					if(recurring.equals("recurring")) {
						recurring1 = recurring;						
					}
					
					if(recurring.equals("active")) {
						active1 = recurring;
					}
				
					count++;
				}
				if (scan1.hasNext() && count == 2) {
					active = scan1.next();
					
					if(active.equals("recurring")) {
						recurring1 = active;						
					}
					
					if(active.equals("active")) {
						active1 = active;
					}
				}
			}

			
			if ("recurring".equals(recurring1)) {
				isRecurring = true;
			}

			if ("active".equals(active1)) {
				isActive = true;
			}
							 
			 while(scan.hasNextLine()) {
				 description += scan.nextLine() + "\n"; 
			 }
			 			

			t = new Task(name1, description, isRecurring, isActive);
			
			System.out.println(t.toString());
			
			
			
			scan1.close();

			scan.close();

		} catch (NoSuchElementException e) {
			// scan2.close();
			
			throw new IllegalArgumentException("Unable to load file.");
		}

		return t;
	}

}
