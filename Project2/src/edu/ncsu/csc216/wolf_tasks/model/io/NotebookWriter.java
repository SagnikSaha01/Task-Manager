package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.PrintStream;
import java.io.IOException;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;

/**
 * IO file class that writes a notebook to a file
 * @author Aadhir Sandeep
 * @author Sagnik Saha
 */
public class NotebookWriter {
	/**
	 * Writes the notebook data to a file
	 * 
	 * @param file      the file where the data is saved
	 * @param name      the name of the notebook
	 * @param taskLists the list of task lists to save
	 * @throws IllegalArgumentException if the file does not exist
	 */
	public static void writeNotebookFile(File file, String name, ISortedList<TaskList> taskLists) {
		try {
			PrintStream fileWriter = new PrintStream(file);

			int size = 0;
			
			fileWriter.print("! " + name + "\n");

			for (int i = 0; i < taskLists.size(); i++) {
				String[][] getLength = taskLists.get(i).getTasksAsArray();
				size = getLength.length;
				
				fileWriter.print("# " + taskLists.get(i).getTaskListName() + "," + taskLists.get(i).getCompletedCount() + "\n");
				

				for (int j = 0; j < size; j++) {
					
					fileWriter.print(taskLists.get(i).getTask(j).toString() + "\n");
				}
			}
			fileWriter.close();

		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}

	}

}
