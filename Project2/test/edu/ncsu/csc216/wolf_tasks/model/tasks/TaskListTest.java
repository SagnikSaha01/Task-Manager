/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *TaskList Test
 *@author Aadhir Sandeep
 *@author Sagnik Saha
 */
public class TaskListTest {

	/**
	 * Test method for TaskList.getTasksAsArray()
	 */
	@Test
	void testGetTasksAsArray() {
		TaskList l = new TaskList("Daily HW Assignments", 1);
		Task t1 = new Task("PY 205", "Do the WileyPlus assignment", true, false);
		l.addTask(t1);
		
		String[][] arr = l.getTasksAsArray();
		
		assertEquals("1", arr[0][0]);
		assertEquals("PY 205", arr[0][1]);
	}

	
	/**
	 * Test method for TaskList.compareTo()
	 */
	@Test
	void testCompareTo() {
		TaskList l1 = new TaskList("Daily HW Assignments", 1);
		
		TaskList l2 = new TaskList("Daily HW Assignments", 1);
		
		TaskList l3 = new TaskList("My To Do List", 3);
		
		assertEquals(0, l1.compareTo(l2));
		assertEquals(-1, l1.compareTo(l3));
		assertEquals(1, l3.compareTo(l1));
	}

}
