package datastructure.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import datastructure.List;

public class MyArrayList<E> implements Iterable<E>{
	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private E [] theItems;
	
	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	public void ensureCapacity(int newCapacity){
		if(newCapacity < theSize)
			return;
		
	}
}