package datastructure;

public class AnList<E> implements List<E> {
	
	private static int defaultSize = 10;
	private int maxSize;
	private int listSize;
	private int curr;
	private E[] listArray;
	
	AnList() {
		this(defaultSize);
	}
	@SuppressWarnings("unchecked")
	AnList(int size){
		maxSize = size;
		listSize = 0;
		curr = 0;
		listArray = (E[])new Object[size];
	}
	
	public void clear() {
		curr = 0;
	}
	public void insert(E e) {
		assert listSize < maxSize : "Not enough capacity!";
		for(int i = listSize; i > curr; i--){
			listArray[i] = listArray[i - 1];
		}
		listArray[curr] = e;
		listSize++;
	}
	public void append(E e) {
		assert listSize < maxSize : "Not enough capacity!";
		listArray[listSize] = e;
		listSize++;
	}
	public E remove(int pos) {
		assert pos >= 0 && pos < listSize : "Invalid pos!";
		E e = listArray[pos];
		for (int i = pos; i < listSize - 1; i++) {
			listArray[i] = listArray[i + 1];
		}
		listSize--;
		return e;
	}
	public void moveToStart() {
		curr = 0;
	}
	public void moveToEnd() {
		curr = listSize - 1;
	}
	public void prev() {
		assert curr > 0;
		curr--;
	}
	public void next() {
		assert curr < listSize;
		curr++;
	}
	public int length() {
		return listSize;
	}
	public int currPos() {
		return curr;
	}
	public void moveToPos(int pos) {
		assert pos >= 0 && pos <= listSize;
		curr = pos;
	}
	public E getValue() {
		return listArray[curr];
	}
	@Override
	public E remove() {
		return remove(curr);
	}
	
}
