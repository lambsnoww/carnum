package datastructure.list;

public class AList<E> implements List<E> {
	private static final int defaultSize = 10;
	private int maxSize;
	private int listSize;
	private int curr;
	private E[] listArray;
	
	/** Constructors */
	AList() { this(defaultSize); }
	@SuppressWarnings("unchecked")
	public//for UALdictionary
	AList(int size) {
		maxSize = size;
		listSize  = curr = 0;
		listArray = (E[])new Object[size];
	}
	
	public void clear() {
		listSize = curr = 0;
	}
	
	public void insert(E it) {
		assert listSize < maxSize : "List capacity exceeded";
		for (int i = listSize; i > curr; i--)
			listArray[i] = listArray[i - 1];
		listArray[curr] = it;
		listSize++;
	}
	
	public void append(E it) {
		assert listSize < maxSize : "List capacity exceeded";
		listArray[listSize++] = it;
	}
	
	public E remove() {
		if ((curr < 0) || (curr >= listSize))
			return null;
		E it = listArray[curr];
		for (int i = curr; i < listSize - 1; i++)
			listArray[i] = listArray[i + 1];
		listSize--;
		return it;
	}
	
	public void moveToStart() { curr = 0; }
	public void moveToEnd() { curr = listSize; }
	public void prev() { if (curr != 0) curr--; }
	public void next() {if (curr < listSize) curr++; }
	
	public int length() { return listSize; }
	public int currPos() { return curr; }
	public void moveToPos(int pos) {
		assert (pos >= 0) && (pos <= listSize) : "Pos out of range";
		curr = pos;
	}
	
	public E getValue() {
		assert (curr >= 0) && (curr < listSize) : "No current element";
		return listArray[curr];
	}

/** the method which I think to be necessary */	
	public void setValue(E it) {
		assert (curr >= 0) && (curr < listSize) : "No current element";
		listArray[curr] = it;
	}
	
}
