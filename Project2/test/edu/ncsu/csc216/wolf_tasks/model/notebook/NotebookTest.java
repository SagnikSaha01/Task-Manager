/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 *Notebook Test
 *@author Aadhir Sandeep
 *@author Sagnik Saha
 */
public class NotebookTest {

	/**
	 * Test method for Notebook.addTaskList()
	 */
	@Test
	void testAddTaskList() {
		Notebook n = new Notebook("My notebook");
		
		TaskList tl = new TaskList("A new TaskList", 1);
		n.addTaskList(tl);
		
		assertTrue(n.isChanged());
		String[] arr = n.getTaskListsNames();
		
		assertEquals(2, arr.length);
		assertEquals(ActiveTaskList.ACTIVE_TASKS_NAME, arr[0]);
		assertEquals("A new TaskList", arr[1]);
	}

	/**
	 * Test method for Notebook.setCurrentTest()
	 */
	@Test
	void testSetCurrent() {
		Notebook n = new Notebook("My notebook");
		assertEquals(ActiveTaskList.ACTIVE_TASKS_NAME, n.getCurrentTaskList().getTaskListName());
		
		TaskList tl = new TaskList("A new TaskList", 1);
		n.addTaskList(tl);
		n.setCurrentTaskList("A new TaskList");
		
		assertEquals("A new TaskList", n.getCurrentTaskList().getTaskListName());
		
	}
	/**
	 * Test method for Notebook.editTaskList()
	 */
	@Test
	void testEditTaskList() {
		Notebook n = new Notebook("My notebook");		
		TaskList tl = new TaskList("A new TaskList", 1);
		n.addTaskList(tl);
		n.setCurrentTaskList("A new TaskList");
		n.editTaskList("New TaskList name");
		
		assertEquals("New TaskList name", n.getCurrentTaskList().getTaskListName());
		
	}

	/**
	 * Test method for Notebook.removeTask()
	 */
	@Test
	void testRemoveTaskList() {
		Notebook n = new Notebook("My notebook");
		TaskList tl = new TaskList("A new TaskList", 1);
		TaskList tl2 = new TaskList("Another TaskList", 2);
		n.addTaskList(tl);
		n.addTaskList(tl2);
		
		String[] arr = n.getTaskListsNames();
		
		assertEquals(3, arr.length);
		assertEquals(ActiveTaskList.ACTIVE_TASKS_NAME, arr[0]);
		assertEquals("A new TaskList", arr[1]);
		assertEquals("Another TaskList", arr[2]);
		
		n.setCurrentTaskList("A new TaskList");
		
		n.removeTaskList();
		
		arr = n.getTaskListsNames();
		assertEquals(2, arr.length);
		assertEquals(ActiveTaskList.ACTIVE_TASKS_NAME, arr[0]);
		assertEquals("Another TaskList", arr[1]);
		
	}
	/**
	 * Test method for Notebook.editTask();
	 */
	@Test
	void testEditTask() {
		Notebook n = new Notebook("My notebook");
		TaskList tl = new TaskList("A new TaskList", 1);
		n.addTaskList(tl);
		n.setCurrentTaskList("A new TaskList");
		Task t = new Task("Test task", "Just for testing purposes", false, false);
		n.addTask(t);
		assertEquals("A new TaskList", n.getCurrentTaskList().getTaskListName());
		assertEquals(t, n.getCurrentTaskList().getTasks().get(0));
		
		n.editTask(0, "Changed Task Name", "Changed Task Descirption", true, false);
		assertEquals("Changed Task Name", n.getCurrentTaskList().getTasks().get(0).getTaskName());
		assertEquals("Changed Task Descirption", n.getCurrentTaskList().getTasks().get(0).getTaskDescription());
		assertTrue(n.getCurrentTaskList().getTasks().get(0).isRecurring());
		assertFalse(n.getCurrentTaskList().getTasks().get(0).isActive());
		
	}
	

	
}
