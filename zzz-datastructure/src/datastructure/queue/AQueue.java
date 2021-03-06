package datastructure.queue;

class AQueue<E> implements Queue<E> {
	private static final int defaultSize = 10;
	private int maxSize;
	private int front;
	private int rear;
	private E[] listArray;
    
	/** Constructors */
	AQueue() { this(defaultSize); }
	@SuppressWarnings("unchecked")
	AQueue(int size) {
		maxSize = size + 1; // One extra space is allocated
		rear = 0; front = 1;
		listArray = (E[])new Object[maxSize];
	}
	
	public void clear() {
		rear = 0; front = 1;
	}
	
	public void enqueue(E it) {
		assert ((rear + 2) % maxSize) != front : "Queue is full";
		rear = (rear + 1) % maxSize;
		listArray[rear] = it;
	}
	public E dequeue() {
//		assert ((rear + 1) % maxSize) != front : "Queue is empty";
        assert length() != 0 : "Queue is empty";
		E it = listArray[front];
		front = (front + 1) % maxSize;
        return it;
	}
	public E frontValue() {
		assert length() != 0 : "Queue is empty";
		return listArray[front];
	}
	
	public int length() {
		return (rear + maxSize - front + 1) % maxSize;
	}
}
