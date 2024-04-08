package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * Provides methods to aid in the functionality of ActiveTaskList
 * @param <E> data type
 * 
 * @author Brendan_Viscount
 */
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
		size = 0;
	}

	/**
	 * Adds an element to the list
	 * @param element to add to the list
	 * @throws NullPointerException if element parameter is null
	 */
	@Override
	public void add(E element) {
		if(element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		checkCapacity(size - 1);
		list[size] = element;
		size++;
	}
	
	/**
	 * Removes element in index parameter
	 * @param index to remove
	 * @return element that was removed
	 * @throws IllegalArgumentException if index is negative or out of bounds of array
	 */
	@Override
	public E remove(int index) {
		checkIndex(index);
		
		E value = list[index];
		for(int i = index; i < size - 1; i++) {
			moveUp(i + 1);
		}
		list[size - 1] = null; //Remove duplicate at end
		size--; //Decrement size
		return value; //Return removed value
	}

	/**
	 * Move an element up in the list
	 * @param index of element to move
	 * @throws IllegalArgumentException if index is negative or out of bounds of array
	 */
	@Override
	public void moveUp(int index) {
		checkIndex(index);
		
		if (index == 0) {
			throw new IndexOutOfBoundsException("Invalid index.");
	    }
		
		E value = list[index];
		list[index] = list[index - 1];
		list[index - 1] = value;
	}

	/**
	 * Move an element down in the list
	 * @param index of element to move
	 * @throws IllegalArgumentException if index is negative or out of bounds of array
	 */
	@Override
	public void moveDown(int index) {
		checkIndex(index);
		
		if (index == size - 1) {
	        throw new IndexOutOfBoundsException("Invalid index.");
	    }
		
		E value = list[index];
		list[index] = list[index + 1];
		list[index + 1] = value;
	}

	/**
	 * Move an element to the front of the list
	 * @param index of element to move
	 * @throws IllegalArgumentException if index is negative or out of bounds of array
	 */
	@Override
	public void moveToFront(int index) {
		checkIndex(index);
		
		E value = list[index];
		for(int i = index; i > 0; i--) {
			list[i] = list[i - 1];
		}
		list[0] = value;
	}

	/**
	 * Move an element to the back of the list
	 * @param index of element to move
	 * @throws IllegalArgumentException if index is negative or out of bounds of array
	 */
	@Override
	public void moveToBack(int index) {
		checkIndex(index);
		
		E value = list[index];
		for(int i = index; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = value;
	}

	/**
	 * Returns the element in the parameter index
	 * @param index of element to get
	 * @return the element in parameter index
	 * @throws IllegalArgumentExcpetion if index is negative or out of bounds of the array
	 */
	@Override
	public E get(int index) {
		checkIndex(index);
		return list[index];
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
	@SuppressWarnings("unchecked")
	private void checkCapacity(int index) {
		if(index >= list.length - 1) {
			E[] temp = list.clone();
			list = (E[])new Object[list.length * 2];
			for(int i = 0; i < size; i++) {
				list[i] = temp[i];
			}
		}
	}
	
	/**
	 * Checks the contents of parameter index
	 * @param index to check
	 * @throws IndexOutOfBoundsException if index is out of the bounds of the array
	 */
	private void checkIndex(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}
	

}
