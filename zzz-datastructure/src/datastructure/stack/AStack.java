package datastructure.stack;

class AStack<E> implements Stack<E> {
	
	private static final int defaultSize = 10;
	
	private int maxSize;
	private int top;
	private E [] listArray;
	
	/** Constructors */
	AStack() { this(defaultSize); }
	@SuppressWarnings("unchecked")
	AStack(int size) {
		maxSize = size;
		top = 0;
		listArray = (E[])new Object[size];
	}
	
	public void clear() { top = 0; }
	
	public void push(E it) {
		assert top != maxSize : "Stack is full";
		listArray[top++] = it;
	}
	public E pop() {
		assert top != 0 : "Stack is empty";
		return listArray[--top];
	}
	public E topValue() {
		assert top != 0 : "Stack is empty";
		return listArray[top - 1];
	}
	
	public int length() { return top; }
}
