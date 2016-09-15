package datastructure;

public class List<E> { /*array list*/
	private static int DEFAULT_SIZE = 10;
    private int size;
    private int maxSize;
    private E[] elemArr;
    
    
    public void clear() {
    	elemArr = (E[])new Object[DEFAULT_SIZE];
    	size = 0;
    	maxSize = DEFAULT_SIZE;
    }
 
    public void insert(int idx, E elem) {
    	if (size >= maxSize) {
    		trimToSize(maxSize * 2);
    	}
    	for (int i = size; i > idx; i--) {
    		elemArr[i] = elemArr[i - 1];
    	}
    	elemArr[idx] = elem;
    }
    public void trimToSize(int ms) {
    	E[] temp = elemArr;
    	elemArr = (E[])new Object[ms];
    	for (int i = 0; i < size; i++) {
    		elemArr[i] = temp[i];
    	}
    	maxSize = ms;
    }
    
    public boolean delete(int idx) {
    	if (idx < 0 || idx >= size)
    		return false;
    	for (int i = idx; i < size - 1; i--) {
    		elemArr[i] = elemArr[i + 1];
    	}
    	size = size - 1;
    	if (size < maxSize / 2) {
    		trimToSize(maxSize / 2);
    	}
    	return true;
    }
    
    public int search(E e) { 
    	for (int i = 0; i < size; i++) {
    		if (elemArr[i].equals(e))
    			return i;
    	}
    	return -1;
    }
    
    public E get(int idx) {
    	if (idx < 0 || idx >= size) {
    		String msg = String.format("List.get fail, idx=%s, valid range [0,%s]", idx, size-1);
    		throw new ArrayIndexOutOfBoundsException(msg);
    	}
    	return elemArr[idx];
    }
    
    public boolean change(int idx, E e) {
    	if (idx < 0 || idx >= size)
    		return false;
    	elemArr[idx] = e;
    	return true;
    }
}
