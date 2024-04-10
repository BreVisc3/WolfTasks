package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * Provides methods for a SortedList class
 * @param <E>
 * 
 * @author Brendan_Viscount
 */
public interface ISortedList<E> extends Comparable<E> {
	
	/** Add an element to the list
	 * @param element to add
	 */
	void add(E element);
	/** Remove an element from the list 
	 * @param index of element to remove
	 * @return E removed element
	 */
	E remove(int index);
	/** Check if the list contains an element
	 * @param element to check for 
	 * @return boolean if element is in list
	 */
	boolean contains(E element);
	/**
	 * Returns element in param index
	 * @param index of element to get
	 * @return element in param index
	 */
	E get(int index);
	/**
	 * Returns the number of elements in the list
	 * @return int size of the list
	 */
	int size();
}
