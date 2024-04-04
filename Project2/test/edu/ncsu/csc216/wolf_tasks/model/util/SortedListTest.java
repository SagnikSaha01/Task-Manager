/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *Sorted List Test
 *@author Aadhir Sandeep
 *@author Sagnik Saha
 */
public class SortedListTest {

	/**
	 * Test method for SortedList.add()
	 */
	@Test
	void testAdd() {
		SortedList<String> l = new SortedList<String>();
		assertEquals(0, l.size());
		
		l.add("gamma");
		assertEquals("gamma", l.get(0));
		assertEquals(1, l.size());
		
		l.add("beta");
		assertEquals("beta", l.get(0));
		assertEquals("gamma", l.get(1));
		assertEquals(2, l.size());
		
		l.add("phi");
		assertEquals("beta", l.get(0));
		assertEquals("gamma", l.get(1));
		assertEquals("phi", l.get(2));
		assertEquals(3, l.size());
		
		l.add("delta");
		assertEquals("beta", l.get(0));
		assertEquals("delta", l.get(1));
		assertEquals("gamma", l.get(2));
		assertEquals("phi", l.get(3));
		assertEquals(4, l.size());
		
	}

	/**
	 * Test method for SortedList.remove()
	 */
	@Test
	void testRemove() {
		SortedList<String> l = new SortedList<String>();
		
		l.add("gamma");
		l.add("delta");
		l.add("phi");
		
		assertEquals("delta", l.get(0));
		assertEquals("gamma", l.get(1));
		assertEquals("phi", l.get(2));
		assertEquals(3, l.size());
		
		
		assertEquals("gamma", l.remove(1));	
		assertEquals("delta", l.get(0));
		assertEquals("phi", l.get(1));
		assertEquals(2, l.size());
		
		assertEquals("delta", l.remove(0));
		assertEquals("phi", l.get(0));
		assertEquals(1, l.size());
	}



	

	/**
	 * Test method for SortedList.contains()
	 */
	@Test
	void testContains() {
		SortedList<String> l = new SortedList<String>();
		
		l.add("gamma");
		l.add("delta");
		l.add("phi");
		
		assertTrue(l.contains("gamma"));
		assertTrue(l.contains("delta"));
		assertTrue(l.contains("phi"));
		
		assertFalse(l.contains("doesnt exist!"));
	}

}
