package datastructure;

class AStack<E> {
	
	private static final int defaultSize = 10;
	
	private int maxSize;
	private int top;
	private E [] listArray;
	
	AStack() { this(defaultSize); }
	
	@SuppressWarnings("unchecked")
	AStack(int size) {
		maxSize = size;
		top = 0;
		listArray = (E[]) new Object[size];//数组中存的都是指针，大小一定
	}
	
	public void clear() { top = 0; }
	
	public void push(E it) {
		assert top != maxSize :  "Stack is full";
		listArray[top++] = it;
	}
	
	public E pop(){
		assert top != 0 : "Stack is empty";
		return listArray[--top];
	}
	
	public E topValue() {
		assert top != 0 : "Stack is empty";
		return listArray[top - 1];
	}
	
	public int length() { return top; }
	

}
