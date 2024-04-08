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
	/** Front of the linked list */
	private ListNode front;
	/** Constructor for the linked list */
	public SortedList() {
		size = 0;
	}
   /**
    * Removes an node from the linked list
    * @param idx the index of the node to be removed
    * @return E the value of the node that is removed
    */
	public E remove(int idx) {
		checkIndex(idx);
		if(idx == 0) {
			E value = front.data;
			front = front.next;
			size--;
			return value;
		} else {
			ListNode current = front;
			for(int i = 0; i < idx - 1; i++) {
				current = current.next;
			}
			E value = current.next.data;
			current.next = current.next.next;
			size--;
			return value;
		}
	}
   /**
    * Checks if the current index is valid
    * @param idx the index to be checked
    */
	private void checkIndex(int idx) {
		if(idx < 0 || idx > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		
	}
   /**
    * Retrives a value from a given node
    * @param idx index of the node to retrive a value from
    * @return E the object that is being retrived
    */
	public E get(int idx) {
		checkIndex(idx);
		ListNode current = front;
		for(int i = 0; i < idx; i++) {
			current = current.next;
		}
		return current.data;
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
    * @throws NullPointerException if the parameter is null
    */
	@Override
	public void add(E element) {
		if(element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		ListNode current = front;
		while(current != null) {
			if(current.data.equals(element)) {
				throw new IllegalArgumentException("Cannot add duplicate element.");
			}
			current = current.next;
		}
		if(size == 0) {
			front = new ListNode(element);
			size++;
		} else {
			current = front;
			if(current.data.compareTo(element) > 0) {
				front = new ListNode(element, current);
				size++;
			} else {
				boolean added = false;
				while(current.next != null) {
					if(current.next.data.compareTo(element) > 0) {
						ListNode temp = current.next;
						current.next = new ListNode(element, temp);
						size++;
						added = true;
						break;
					}
					current = current.next;
				}
				if(!added) {
					current.next = new ListNode(element);
					size++;
				}
			}
		}
	}
   /**
    * Checks if the current linked list contains a specific element
    * @return boolean true if the element is in the linkedlist, false otherwise
    */
	@Override
	public boolean contains(E element) {
		ListNode current = front;
		while(current != null) {
			if(current.data == element) {
				return true;
			} 
			current = current.next;
		}
		return false;
	}
	/**
	 * Implementation of a node that holds data and a next reference
	 * @author Aadhir Sandeep
	 * @author Sagnik Saha
	 */
	public class ListNode {
		/** Reference to the next node */
		public ListNode next;
		/** Data that is stored in the current node */
		public E data;
	   /** 
	    * Constructor for a ListNode
	    * @param data for the current node
	    * @param next reference for the next node
	    */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
		/**
		 * Alternate constructor for a ListNode with no next node
		 * @param data for the current node
		 */
		public ListNode(E data) {
			this.data = data;
			this.next = null;
		}

	}

}
