package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * Provides methods for a SortedList class
 * @param <E>
 * 
 * @author Brendan_Viscount
 */
public interface ISortedList<E> extends Comparable<E> {
	
	public void add(E element);
	
	public E remove(int index);
	
	public boolean contains(E element);
	
	public E get(int index);
	
	public int size();
}
