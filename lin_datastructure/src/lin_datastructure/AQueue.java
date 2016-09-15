package lin_datastructure;

class AQueue<E> implements Queue<E> {
	private static final int defaultSize = 10;
	private int maxSize;
	private int front;
	private int rear;
	private E[] listArray;
	
	AQueue() {
		this(defaultSize);
	}
	
	@SuppressWarnings("unchecked")
	AQueue(int size) {
		maxSize = size + 1;
		front = 1;
		rear = 0;
		listArray = (E[])new Object[maxSize];
	}

	@Override
	public void clear() {
		front = 1;
		rear = 0;
	}

	@Override
	public void enqueue(E it) {
		assert (rear + 2) % maxSize != front : "Queue is full";
		rear = (rear+ 1) % maxSize;
		listArray[rear] = it;//careful!!!
	}

	@Override
	public E dequeue() {
		assert (rear + 1) % maxSize != front : "Queue is empty";//length() != 0
		E it = listArray[front];
		front = (front + 1) % maxSize;
		return it;
	}

	@Override
	public E frontValue() {
		assert (rear + 1) % maxSize != front : "Queue is empty";//length() != 0
		return listArray[front];
	}

	@Override
	public int length() {
		return (rear + maxSize - front + 1) % maxSize;//+ 1 !!!!!!
	}
}
