package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * SortedList is a collection class that stores data in a sorted manner
 * @param <E> dataType of list
 * 
 * @author Brendan_Viscount
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {
	
	/** Number of elements in the list */
	private int size;
	/** First element in the list*/
	public ListNode front;
	
	/** SortedList constructor */
	public SortedList() {
		front = null;
		size = 0;
	}

	/**
	 * Adds an element to the list
	 * @param element to add 
	 * @throws NullPointerException if element parameter is null
	 * @throws IllegalArgumentException if the element is already on the list
	 */
	@Override
	public void add(E element) {
		if(element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		
		if (contains(element)) {
	        throw new IllegalArgumentException("Cannot add duplicate element.");
	    }
		
		if (front == null) {
		        front = new ListNode(element, null);
		    } 
		else {
		       if (element.compareTo(front.data) < 0) {
		            front = new ListNode(element, front);
		       } 
		       else {
		           ListNode current = front;
		           while (current.next != null && element.compareTo(current.next.data) >= 0) {
		               current = current.next;
		           }
		           current.next = new ListNode(element, current.next);
		       }
		}
	    size++;
	}

	/**
	 * Removes an element from the list 
	 * @param index of element to remove
	 * @return removed element
	 * @throws IllegalArgumentException if index is out of the bounds of the list
	 */
	@Override
	public E remove(int index) {
		checkIndex(index);
		
		 E value;
		    if (index == 0) { // Removing the front node
		        value = front.data;
		        front = front.next;
		    } else {
		        ListNode current = front;
		        for (int i = 0; i < index - 1; i++) {
		        	current = current.next;
		        }
		        value = current.next.data;
		        current.next = current.next.next;
		    }
		    size--;
		    return value;
	}
	
	/**
	 * Checks parameter index
	 * @param index to check
	 * @throws IllegalArgumentException if index is out of the bounds of the list
	 */
	private void checkIndex(int index) {
		if(index < 0 || index >= size) {
			throw new IllegalArgumentException("Invalid index.");
		}
	}

	/**
	 * Returns whether or not parameter element is in the list
	 * @param element to check for
	 * @return whether or not element was found
	 */
	@Override
	public boolean contains(E element) {
		ListNode current = front;
		for(int i = 0; i < size; i++) {
			if(current.data.compareTo(element) == 0) {
				return true;
			}
			current = current.next;
		}
		
		return false;
	}

	/**
	 * Returns element in parameter index
	 * @param index of element to return
	 * @return element in parameter index
	 * @throws IllegalArgumentException if index is out of the bounds of the list
	 */
	@Override
	public E get(int index) {
		checkIndex(index);
		ListNode current = front;
		for(int i = 0; i < index; i++) {
			current = current.next;
		}
		
		return current.data;
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

	/**
	 * Compares objects of generic type E
	 * @return value 0 - equal, -1 - less than, 1 - greater than
	 */
	@Override
	public int compareTo(E element) {
		char[] thisArray = this.toString().toCharArray();
	    char[] otherArray = element.toString().toCharArray();
	    
	    int minLength = Math.min(thisArray.length, otherArray.length);
	    
	    for (int i = 0; i < minLength; i++) {
	        if (thisArray[i] < otherArray[i]) {
	            return -1;
	        } else if (thisArray[i] > otherArray[i]) {
	            return 1;
	        }
	    }
	    
	    return Integer.compare(thisArray.length, otherArray.length);
	}

}
