package edu.ncsu.csc216.wolf_tasks.model.util;

public class SwapList<E> implements ISwapList<E> {
	
	/** Constant for intitial capacity of underlying array */
	private static final int INITIAL_CAPACITY = 10;
	/** Underlying array for storage */
	private E[] list;
	/** Number of elements stored in the List */
	private int size = 0;
	
	/**
	 * SwapList constructor
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		
		Object[] s = new Object[INITIAL_CAPACITY];
		list = (E[])s;
	}

	/**
	 * Adds an element to the list
	 * @param element to add to the list
	 */
	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Removes element in index parameter
	 * @param index to remove
	 * @return element that was removed
	 */
	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Move an element up in the list
	 * @param index of element to move
	 */
	@Override
	public void moveUp(int index) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Move an element down in the list
	 * @param index of element to move
	 */
	@Override
	public void moveDown(int index) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Move an element to the front of the list
	 * @param index of element to move
	 */
	@Override
	public void moveToFront(int index) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Move an element to the back of the list
	 * @param index of element to move
	 */
	@Override
	public void moveToBack(int index) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Returns the element in the parameter index
	 * @param index of element to get
	 * @return the element in parameter index
	 */
	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the size of the list
	 * @return the size of the list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Ensures the capacity of the array can hold another element before adding
	 * @param index where the element is to be added
	 */
	private void checkCapacity(int index) {
		
	}
	
	/**
	 * Checks the contents of parameter index
	 * @param index to check
	 */
	private void checkIndex(int index) {
		
	}
	

}
