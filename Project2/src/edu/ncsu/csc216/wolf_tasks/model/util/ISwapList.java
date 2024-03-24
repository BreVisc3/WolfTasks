package edu.ncsu.csc216.wolf_tasks.model.util;

public interface ISwapList<E> {

	public void add(E element);
	
	public E remove(int index);
	
	public void moveUp(int index);
	
	public void moveDown(int index);
	
	public void moveToFront(int index);
	
	public void moveToBack(int index);
	
	public E get(int index);
	
	public int size();
}
