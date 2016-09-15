package list;

public interface List<E> {
	
	public void clear();
	
	public int size();
	public boolean isEmpty();
	public void trimToSize();
	public void ensureCapacity(int newCapacity);
	

	public boolean add(E e);
	public void add(int idx, E e);
	public E remove(int idx);
	public E get(int idx);
	public E set(int idx, E e);
	
//	public java.util.Iterator<E> iterator()
//	private class ArrayListIterator implements java..util.Iterator<E>

}
