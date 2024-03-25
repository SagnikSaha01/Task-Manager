package edu.ncsu.csc216.wolf_tasks.model.util;


/**
 * Implmentation of a Linked List
 * @param <E> Generic Object
 * @author Aadhir Sandeep
 * @author Sagnik Saha
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {
	/** Current size of the linked list */
	private int size;
	/** Constructor for the linked list */
	public SortedList() {
		//TODO implementation
	}
   /**
    * Removes an node from the linked list
    * @param idx the index of the node to be removed
    * @return E the value of the node that is removed
    */
	public E remove(int idx) {
		checkIndex(idx);
		return null;
	}
   /**
    * Checks if the current index is valid
    * @param idx the index to be checked
    */
	private void checkIndex(int idx) {
		//TODO implementation
		
	}
   /**
    * Retrives a value from a given node
    * @param idx index of the node to retrive a value from
    * @return E the object that is being retrived
    */
	public E get(int idx) {
		return null;
	}
   /**
    * Gives the current size of the linked list
    * @return int the size of the linked list
    */
	public int size() {
		return size;
	}
   /**
    * Adds an element to the linked list
    * @param element the element that is being added
    */
	@Override
	public void add(E element) {
		//TODO implementation
	}
   /**
    * Checks if the current linked list contains a specific element
    * @return boolean true if the element is in the linkedlist, false otherwise
    */
	@Override
	public boolean contains(E element) {
		return false;
	}

}
