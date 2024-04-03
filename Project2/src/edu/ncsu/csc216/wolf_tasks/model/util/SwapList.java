package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * Array based List that implements the ISwapListInterface
 * @param <E> Generic object 
 * @author Aadhir Sandeep
 * @author Sagnik Saha
 */
public class SwapList<E> implements ISwapList<E> {
	/** Initial size of the array */
	public static final int INITIAL_CAPACITY = 10;
	/** A generic array to hold values */
	private  E[] list;
	/** Current size of the array */
	private int size;	
	/**
	* Constructor for the SwapList
	*/
	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}
   /**
	* Adds an object to the array
	* @param obj the object that is being added 
	*/
	public void add(E obj) {
		checkCapacity(size);
		list[size] = obj;
		size++;
	}
   /**
	* Checks if the current array has enough capacity
	* @param size the current size of the array
	*/
	private void checkCapacity(int size) {
		if(size == list.length - 1) {
			@SuppressWarnings("unchecked")
			E[] tempList = (E[]) new Object[2 * list.length];
			for(int i = 0; i < list.length; i++) {
				tempList[i] = list[i];
			}
			list = tempList;
		}
	}
   /**
    * Removes an object from the array
    * @param idx the index from which the object is being removed from
    * @return E the object that was removed
    */
	public E remove(int idx) {
		checkIndex(idx);
		E value = list[idx];
		for(int i = idx; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size] = null;
		return value;
	}
   /**
	* Checks if the current index is valid
	* @param idx the index to check 
	* @throws IndexOutOfBoundsException if the index is out of bounds
	*/
	private void checkIndex(int idx) {
		if(idx < 0 || idx > size - 1) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}
   /**
    * Moves an object up one spot in the array
    * @param idx the index of the object that is being moved
    */
	public void moveUp(int idx) {	
		checkIndex(idx);
		if(idx != 0) {
			E temp = list[idx - 1];
			list[idx - 1] = list[idx];
			list[idx] = temp;
	  }
	}
	
   /**
    * Moves an object down one spot in the array
    * @param idx the index of the object that is being moved
    */
	public void moveDown(int idx) {
		checkIndex(idx);
		if(idx != size - 1) {
			E temp = list[idx + 1];
			list[idx + 1] = list[idx];
			list[idx] = temp;
		}
    }
   /**
    * Moves an object to the front of the array
    * @param idx the index of the object that is being moved
    */
	public void moveToFront(int idx) {
		checkIndex(idx);
		E temp = list[idx];
		remove(idx);
		
		for(int i = size; size >= 0; i--) {
			list[i] = list[i - 1];
		}
		list[0] = temp;
		
		size++;
		
		
	}
   /**
    * Moves an object to the back of the array
    * @param idx the index of the object that is being moved
    */
	public void moveToBack(int idx) {
		checkIndex(idx);
		E temp = list[idx];
		remove(idx);
		size++;
		list[size - 1] = temp;
	}
   /**
    * Retrives a specific value from the array
    * @param idx the index of the object that is being retrieved
    * @return E the object that is being retrieved
    */
	public E get(int idx) {
		checkIndex(idx);
		return list[idx];
	}
   /**
    * Gets the current size of the array 
    * @return int the size of the array
    */
	public int size() {
		return size;
	}
	
	
}
