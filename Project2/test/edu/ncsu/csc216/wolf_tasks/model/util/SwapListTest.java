package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the functionality of SwapList
 */
public class SwapListTest {
		
	/** Testing list */
	SwapList<String> list;
	
	/**
	 * Set up list for testing
	 */
	@Before
	public void setUp() {
		
		list = new SwapList<String>();
		list.add("apple");
		list.add("banana");
		list.add("can");
		list.add("dog");
	}
	
	/**
	 * Tests add method functionality
	 */
	@Test
	public void testAddValid() {
		
		assertEquals(4, list.size());
		
		list.add("abc");
		assertEquals(5, list.size());
		assertEquals("abc", list.get(4));
		
		list.add("aztec");
		assertEquals(6, list.size());
		assertEquals("aztec", list.get(5));
		
		list.add("zoo");
		assertEquals(7, list.size());
		assertEquals("abc", list.get(4));
		assertEquals("apple", list.get(0));
		assertEquals("aztec", list.get(5));
		assertEquals("banana", list.get(1));
		assertEquals("can", list.get(2));
		assertEquals("dog", list.get(3));
		assertEquals("zoo", list.get(6));
		
		try {
			list.add("zoo");
			list.add("zoo");
			list.add("zoo");
			list.add("zoo");
			list.add("zoo");
			list.add("zoo");
		} catch(Exception e) {
			fail("Unexpected exception thrown while adding valid elements.");
		}
		
	}
	
	/**
	 * Tests add method functionality when faced with invalid parameters
	 */
	@Test
	public void testAddInvalid() {
		
		assertEquals(4, list.size());
		
		Exception e1 = assertThrows(NullPointerException.class,
				() -> list.add(null));
		assertEquals(e1.getMessage(), "Cannot add null element.");
		
		
		assertEquals(4, list.size());
	}
	
	/**
	 * Tests remove method functionality
	 */
	@Test
	public void testValidRemove() {
		
		assertEquals(4, list.size());
		
		String value = list.remove(0);
		assertEquals(3, list.size());
		assertEquals("banana", list.get(0));
		assertEquals(value, "apple");
		
		value = list.remove(1);
		assertEquals(2, list.size());
		assertEquals("banana", list.get(0));
		assertEquals(value, "can");
		
		value = list.remove(1);
		assertEquals(1, list.size());
		assertEquals("banana", list.get(0));
		assertEquals(value, "dog");
		
	}
	
	/**
	 * Tests remove method functionality when faced with invalid parameters
	 */
	@Test
	public void testInvalidRemove() {
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class,
				() -> list.remove(-1));
		assertEquals(e1.getMessage(), "Invalid index.");
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class,
				() -> list.remove(10));
		assertEquals(e2.getMessage(), "Invalid index.");
		
	}
	
	/**
	 * Tests functionality of the moveUp method
	 */
	@Test
	public void testMoveUp() {
		
		list.moveUp(1);
		assertEquals("banana", list.get(0));
		assertEquals("apple", list.get(1));
		
		list.moveUp(3);
		assertEquals("dog", list.get(2));
		assertEquals("can", list.get(3));
		
		list.moveUp(2);
		assertEquals("dog", list.get(1));
		assertEquals("apple", list.get(2));
		
		list.moveUp(0);
		assertEquals("banana", list.get(0));
		
	}
	
	/**
	 * Tests functionality of the moveDown method
	 */
	@Test
	public void testMoveDown() {
		
		list.moveDown(2);
		assertEquals("dog", list.get(2));
		assertEquals("can", list.get(3));
		
		list.moveDown(1);
		assertEquals("dog", list.get(1));
		assertEquals("banana", list.get(2));
		
		list.moveDown(0);
		assertEquals("dog", list.get(0));
		assertEquals("apple", list.get(1));
		
		list.moveDown(list.size() - 1);
		assertEquals("can", list.get(3));
	}
	
	/**
	 * Tests functionality of the moveToFront method
	 */
	@Test
	public void testMoveToFront() {
		
		list.moveToFront(2);
		assertEquals("can", list.get(0));
		assertEquals("banana", list.get(2));
		
		list.moveToFront(3);
		assertEquals("dog", list.get(0));
		assertEquals("apple", list.get(2));
		
		list.moveToFront(2);
		assertEquals("apple", list.get(0));
		assertEquals("can", list.get(2));
	}
	
	/**
	 * Tests functionality of the moveToBack method
	 */
	@Test
	public void testMovetoBack() {
		
		list.moveToBack(0);
		assertEquals("banana", list.get(0));
		assertEquals("apple", list.get(3));
		
		list.moveToBack(2);
		assertEquals("banana", list.get(0));
		assertEquals("dog", list.get(3));
		
		list.moveToBack(0);
		assertEquals("can", list.get(0));
		assertEquals("banana", list.get(3));
	}
	

}

