package edu.ncsu.csc216.wolf_tasks.model.util;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

public class ListNode<E> {
	public ListNode next;
	
	public E data;
	
	public ListNode(E data, ListNode next) {
		this.data = data;
		next = null;
	}


}
