/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 *Notebook Reader Test
 *@author Aadhir Sandeep
 *@author Sagnik Saha
 */

public class NotebookReaderTest {
	


	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.io.NotebookReader#readNotebookFile(java.io.File)}.
	 */
	@Test
	void testReadNotebookFile() {
		
		//assertArrayEquals(names, NotebookReader.readNotebookFile(f).getTaskListsNames());
		
		Notebook n = new Notebook("School");
		
		NotebookReader r = new NotebookReader();
		
		assertTrue(r instanceof NotebookReader);
		
		TaskList tList = new TaskList("CSC 216", 35);
		tList.addTask(new Task("Read Project 2 Requirements", "Read Project 2 requirements \r\n"
				+ "(https://pages.github.ncsu.edu/engr-csc216-staff/CSC216-SE-Materials/projects/project2/project2-part1.html)\r\n"
				+ "and identify candidate classes and methods., isRecurring, isActive", true, true));
		
		tList.addTask(new Task("Create CRC Cards", "Identify the key classes and create CRC cards. Note\r\n"
				+ "responsibilities, collaborators, and possible state.", true, true));
		
		tList.addTask(new Task("Transfer CRC Cards to UMLetino", "Start creating a UML class diagram from the requirements.", true, true));
		
		tList.addTask(new Task("Download design proposal and rational template", "See (https://pages.github.ncsu.edu/engr-csc216-staff/CSC216-SE-Materials/projects/project2/project2-part1.html)\r\n"
				+ "for template link", true, true));
		
		n.addTaskList(tList);
		
		File s = new File("test-files/testing.txt");
		NotebookReader.readNotebookFile(s);
		
		//assertArrayEquals(names, NotebookReader.readNotebookFile(f).getTaskListsNames());
		
	}

}
