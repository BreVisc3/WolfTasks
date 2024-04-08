package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests functionality of SortedList Class collection
 */
public class SortedListTest {
	
	SortedList<String> list;
	
	/**
	 * Set up list for testing
	 */
	@Before
	public void setUp() {
		
		list = new SortedList<String>();
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
		assertEquals("abc", list.get(0));
		
		list.add("aztec");
		assertEquals(6, list.size());
		assertEquals("aztec", list.get(2));
		
		list.add("zoo");
		assertEquals(7, list.size());
		assertEquals("abc", list.get(0));
		assertEquals("apple", list.get(1));
		assertEquals("aztec", list.get(2));
		assertEquals("banana", list.get(3));
		assertEquals("can", list.get(4));
		assertEquals("dog", list.get(5));
		assertEquals("zoo", list.get(6));
		
	}
	
	/**
	 * Tests add method functionality when faced with invalid parameters
	 */
	@Test
	public void testAddInvalid() {
		
		assertEquals(4, list.size());
		
		Exception e1 = assertThrows(IllegalArgumentException.class,
				() -> list.add("apple"));
		assertEquals(e1.getMessage(), "Cannot add duplicate element.");
		
		Exception e2 = assertThrows(IllegalArgumentException.class,
				() -> list.add("can"));
		assertEquals(e2.getMessage(), "Cannot add duplicate element.");
		
		Exception e3 = assertThrows(NullPointerException.class,
				() -> list.add(null));
		assertEquals(e3.getMessage(), "Cannot add null element.");
		
		
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
	 * Tests functionality of the contains method
	 */
	@Test
	public void testContains() {
		
		assertTrue(list.contains("apple"));
		assertTrue(list.contains("banana"));
		assertTrue(list.contains("can"));
		assertTrue(list.contains("dog"));
		
		assertFalse(list.contains("bath"));
		assertFalse(list.contains("cat"));
		assertFalse(list.contains("appl"));
		assertFalse(list.contains("banan"));
	}

}
