/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;

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
		Notebook n = new Notebook("School");
		
		File f = new File("test-files/notebook1.txt");
		
		//assertEquals(n, NotebookReader.readNotebookFile(f));
	}

}
