package lin_datastructure;

class AStack<E> implements Stack<E> {
	
	private static final int defaultSize = 10;
	private int maxSize;
	private int top;
	private E[] listArray;
	
	AStack() {
		this(defaultSize);
	}
	
	@SuppressWarnings("unchecked")
	AStack(int size) {
		maxSize = size;
		top = 0;
		listArray = (E[])new Object[size];
	}
	
	@Override
	public void clear() {
		top = 0;
	}

	@Override
	public void push(E it) {
		if(top == maxSize) return;
		listArray[top++] = it;
	}

	@Override
	public E pop() {
		if(top == 0) return null;
		E it = listArray[--top];//注意top与--的顺序
		return it;
	}

	@Override
	public E topValue() {
		if(top == 0) return null;
		return listArray[top - 1];
	}

	@Override
	public int length() {
		return top;
	}

}
