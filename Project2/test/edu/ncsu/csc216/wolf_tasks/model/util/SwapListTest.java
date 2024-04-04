/**
 * 
 */
package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *Swap List Test
 *@author Aadhir Sandeep
 *@author Sagnik Saha
 */
public class SwapListTest {

	/**
	 * Test method for SwapList.add()
	 */
	@Test
	void testAdd() {
		SwapList<String> l = new SwapList<>();
		assertEquals(0, l.size());
		
		l.add("element1");
		assertEquals(1, l.size());
		assertEquals("element1", l.get(0));
		
		l.add("element2");
		assertEquals(2, l.size());
		assertEquals("element1", l.get(0));
		assertEquals("element2", l.get(1));
	}

	/**
	 * Test method for SwapList.remove()
	 */
	@Test
	void testRemove() {
		SwapList<String> l = new SwapList<>();
		assertEquals(0, l.size());
		
		l.add("element1");
		assertEquals(1, l.size());
		assertEquals("element1", l.get(0));
		
		l.add("element2");
		assertEquals(2, l.size());
		assertEquals("element1", l.get(0));
		assertEquals("element2", l.get(1));
		
		assertEquals("element1", l.remove(0));
		assertEquals(1, l.size());
		
		assertEquals("element2", l.remove(0));
		assertEquals(0, l.size());
		
		Exception e = assertThrows(IndexOutOfBoundsException.class, () -> l.remove(4));
		assertEquals("Invalid index.", e.getMessage());
	}

	/**
	 * Test method for moving elements.
	 */
	@Test
	void testMove() {
		SwapList<String> l = new SwapList<>();
		
		l.add("element1");
		l.add("element2");
		l.add("element3");
		
		assertEquals(3, l.size());
		
		l.moveToFront(2);
		assertEquals("element3", l.get(0));
		assertEquals("element1", l.get(1));
		assertEquals("element2", l.get(2));
		assertEquals(3, l.size());
		
		l.moveToBack(1);
		assertEquals("element3", l.get(0));
		assertEquals("element2", l.get(1));
		assertEquals("element1", l.get(2));
		assertEquals(3, l.size());
		
		l.moveUp(1);
		assertEquals("element2", l.get(0));
		assertEquals("element3", l.get(1));
		assertEquals("element1", l.get(2));
		
		l.moveDown(1);
		assertEquals("element2", l.get(0));
		assertEquals("element1", l.get(1));
		assertEquals("element3", l.get(2));
	}



}
