package datastructure.stack;

public class LStack<E> implements Stack<E>{
	
	private Link<E> top;
	private int size;
    
	/** Constructors */
	public LStack() { top = null; size = 0; }
	public LStack(int size) { top = null; size = 0; }
	
	public void clear() { top = null; size = 0; }
	
	public void push(E it) {
		top = new Link<E>(it, top);
		size++;
	}   
	public E pop() {
		assert top != null : "Stack is empty";
		E it = top.element();
		top = top.next();
		size--;
		return it;
	}
	public E topValue() {
		assert top != null : "Stack is empty";
		return top.element();
	}
	public int length() { return size; }
}
