/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *Active TaskList Test
 *@author Aadhir Sandeep
 *@author Sagnik Saha
 */
public class ActiveTaskListTest {

	/**
	 * Test method for ActiveTaskList.addTask()
	 */
	@Test
	void testAddTask() {
		ActiveTaskList l1 = new ActiveTaskList();
		
		Task t1 = new Task("My task", "This is an active task", true, true);
		l1.addTask(t1);
		
		assertEquals(t1, l1.getTask(0));
		
		String[][] arr = l1.getTasksAsArray();
		
		assertEquals(ActiveTaskList.ACTIVE_TASKS_NAME, arr[0][0]);
		assertEquals("My task", arr[0][1]);
		
	}



	/**
	 * Test method for {@link edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList#clearTasks()}.
	 */
	@Test
	void testClearTasks() {
		ActiveTaskList l1 = new ActiveTaskList();
		
		Task t1 = new Task("My task", "This is an active task", true, true);
		Task t2 = new Task("My other task", "This is also an active task", true, true);
		l1.addTask(t1);
		l1.addTask(t2);
		
		assertEquals(t1, l1.getTask(0));
		assertEquals(t2, l1.getTask(1));
		
		l1.clearTasks();
		
		Exception e = assertThrows(IndexOutOfBoundsException.class, () -> l1.getTask(0));
		assertEquals("Invalid index.", e.getMessage());
		
		String[][] arr = l1.getTasksAsArray();
		assertEquals(0, arr.length);
	}

}
