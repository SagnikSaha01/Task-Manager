/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *Task Test
 *@author Aadhir Sandeep
 *@author Sagnik Saha
 */
public class TaskTest {

	/**
	 * Test method for Task constructor
	 */
	@Test
	void testTask() {
		Task t = new Task("Do Homework", "Remember to finish the homework", false, false);
		assertEquals("Do Homework", t.getTaskName());
		assertEquals("Remember to finish the homework", t.getTaskDescription());
		assertFalse(t.isActive());
		assertFalse(t.isRecurring());
		assertEquals("", t.getTaskListName());
	}

	/**
	 * Test method for Task.addTaskList()
	 */
	@Test
	void testAddTaskList() {
		Task t = new Task("Do Homework", "Remember to finish the homework", false, false);
		AbstractTaskList l = new TaskList("Assignments", 0);
		t.addTaskList(l);
		assertEquals("Assignments", l.getTaskListName());
		
		t.addTaskList(l);
	}
	
	

	/**
	 * Test method for Task.clone()
	 */
	@Test
	void testClone() {
		Task t = new Task("Do Homework", "Remember to finish the homework", false, false);
		try {
			t.clone();
			fail("Should have thrown exception");
		} catch (Exception e) {
			assertTrue(e instanceof CloneNotSupportedException);
		}
		AbstractTaskList l = new TaskList("Assignments", 0);
		t.addTaskList(l);
		
		try {
			t = (Task) t.clone();
			assertEquals("Do Homework", t.getTaskName());
			assertEquals("Remember to finish the homework", t.getTaskDescription());
			assertFalse(t.isActive());
			assertFalse(t.isRecurring());
		} catch (CloneNotSupportedException e) {
			fail("Should not reach here");
		}
	}
	/**
	 * Test method for Task.completeTask();
	 */
	@Test
	void testComplete() {
		Task t = new Task("Do Homework", "Remember to finish the homework", true, false);
		AbstractTaskList l = new TaskList("Assignments", 0);
		t.addTaskList(l);
		l.addTask(t);
		t.completeTask();
		assertEquals(1, l.getCompletedCount());
		assertEquals(1, l.getTasksAsArray().length);
		t.completeTask();
		assertEquals(2, l.getCompletedCount());
		assertEquals(1, l.getTasksAsArray().length);
		Task r = new Task("A test task", "Testing for non recurring tasks", false, false);
		l.addTask(t);
		r.addTaskList(l);
		assertEquals(2, l.getTasksAsArray().length);
		r.completeTask();
		assertEquals(1, l.getTasksAsArray().length);
		assertEquals(3, l.getCompletedCount());
	}



}
