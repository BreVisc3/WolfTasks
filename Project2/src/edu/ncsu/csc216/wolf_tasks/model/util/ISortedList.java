package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * Provides methods for a SortedList class
 * @param <E>
 * 
 * @author Brendan_Viscount
 */
public interface ISortedList<E> extends Comparable<E> {
	
	void add(E element);
	
	E remove(int index);
	
	boolean contains(E element);
	
	E get(int index);
	
	int size();
}
