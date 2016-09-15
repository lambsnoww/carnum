package list.impl;

import java.util.Iterator;

import list.List;

public class AList<E> implements Iterable<E>, List<E> {

	private static final int DEFAULT_CAPACITY = 10;
	
	private int theSize;
	private E[] theItems;
	
	public AList() {
		clear();
	}
	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public int size() {
		return theSize;
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	public void trimToSize() {//no blank array elem
		ensureCapacity(size());
	}
	
	public boolean add(E e) { 
		add(size(), e);
		return true;
	}
	public void add(int idx, E e) {
		if(theItems.length == theSize)
			ensureCapacity(theSize * 2 + 1);
		for(int i = theSize; i > idx; i--) {
			theItems[i] = theItems[i - 1];
		}
		theItems[idx] = e;
		
		theSize++;
	}
	
	public E remove(int idx) {
		if(idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		E e = theItems[idx];
		for(int i = idx; i < size() - 1; i++)
			theItems[i] = theItems[i + 1];
		
		theSize--;
		return e;
	}
    
	public void ensureCapacity(int size) {
		if(theSize >= size)
			return;
        
		E[] old = theItems;
		theItems = (E[])new Object[size];
		for(int i = 0; i < size; i++) {
			theItems[i] = old[i];
		}
	}
	@Override
	public E get(int idx) {
		// TODO Auto-generated method stub
        if(idx < 0 || idx >= size())
        	throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
	}
	@Override
	public E set(int idx, E e) {
		// TODO Auto-generated method stub
        if(idx < 0 || idx >= size())
        	throw new ArrayIndexOutOfBoundsException();
        E old = theItems[idx];
        theItems[idx] = e;
        return old;  
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	
	//ArrayListIterator
	private class ArrayListIterator implements java.util.Iterator<E> {
		private int current = 0;
		
		public boolean hasNext(){
			return current < size();
		}
		
		public E next() {
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			return theItems[current++];
		}
		
		public void remove() {
			AList.this.remove(--current);
		}
	}
	
}