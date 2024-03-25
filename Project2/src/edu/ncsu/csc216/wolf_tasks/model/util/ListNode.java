package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * Implementation of a node that holds data and a next reference
 * @author Aadhir Sandeep
 * @author Sagnik Saha
 */
public class ListNode<E> {
	/** Reference to the next node */
	public ListNode next;
	/** Data that is stored in the current node */
	public E data;
   /** 
    * Constructor for a ListNode
    * @param E data for the current node
    * @param next reference for the next node
    */
	public ListNode(E data, ListNode next) {
		this.data = data;
		this.next = next;
	}


}
