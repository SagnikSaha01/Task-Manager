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
	public SwapList() {
		//TODO implementation
	}
   /**
	* Adds an object to the array
	* @param obj the object that is being added 
	*/
	public void add(E obj) {
		checkCapacity(0);
		
	}
   /**
	* Checks if the curren array has enough capacity
	* @param size the current size of the array
	*/
	private void checkCapacity(int size) {
		//TODO implementation
	}
   /**
    * Removes an object from the array
    * @param idx the index from whcih the object is being removed from
    * @return E the object that was removed
    */
	public E remove(int idx) {
		checkIndex(idx);
		
		return null;
	}
   /**
	* Checks if the current index is valid
	* @param idx the index to check 
	*/
	private void checkIndex(int idx) {
		//TODO implementation
	}
   /**
    * Moves an object up one spot in the array
    * @param idx the index of the object that is being moved
    */
	public void moveUp(int idx) {
		//TODO implementation
	}
   /**
    * Moves an object down one spot in the array
    * @param idx the index of the object that is being moved
    */
	public void moveDown(int idx) {
		//TODO implementation
	}
   /**
    * Moves an object to the front of the array
    * @param idx the index of the object that is being moved
    */
	public void moveToFront(int idx) {
		//TODO implementation
	}
   /**
    * Moves an object to the back of the array
    * @param idx the index of the object that is being moved
    */
	public void moveToBack(int idx) {
		//TODO implementation
	}
   /**
    * Retrives a specific value from the array
    * @param idx the index of the object that is being retrived
    * @return E the object that is being retrived
    */
	public E get(int idx) {
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
