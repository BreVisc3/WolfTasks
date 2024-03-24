package edu.ncsu.csc216.wolf_tasks.model.util;

public class SortedList<E> implements ISortedList<E> {
	
	/** Number of elements in the list */
	private int size = 0;
	/** First element in the list*/
	public ListNode front;
	
	/** SortedList constructor */
	public SortedList() {
		
	}

	/**
	 * Adds an element to the list
	 * @param element to add 
	 */
	@Override
	public void add(E element) {
		
		
	}

	/**
	 * Removes an element from the list 
	 * @param index of element to remove
	 * @return removed element
	 */
	@Override
	public E remove(int index) {
		
		return null;
	}
	
	/**
	 * Checks parameter index
	 * @param index to check
	 */
	private void checkIndex(int index) {
		
	}

	/**
	 * Returns whether or not parameter element is in the list
	 * @param element to check for
	 * @return whether or not element was found
	 */
	@Override
	public boolean contains(E element) {
		
		return false;
	}

	/**
	 * Returns element in parameter index
	 * @param index of element to return
	 * @return element in parameter index
	 */
	@Override
	public E get(int index) {
		
		return null;
	}

	/**
	 * Returns the number of elements in the list
	 * @return size of the list
	 */
	@Override
	public int size() {
		return size;
	}
	
	public class ListNode {
		
		/** The information the ListNode index holds */
		public E data;
		/** A reference to the next ListNode in the list */
		private ListNode next;
		
		/**
		 * ListNode constructor
		 * @param data in the ListNode
		 * @param next ListNode in the list
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
	}

}
