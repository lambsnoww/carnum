package lin_datastructure;

class LQueue<E> implements Queue<E> {
	private Link<E> front;
	private Link<E> rear;
	private int size;
	
	public LQueue() {
		init();
	}
	
	public LQueue(int size) {
		init();
	}
	
	public void init() {
		front = rear = new Link<E>(null);
		size = 0;
	}

	@Override
	public void clear() {
		init();
	}

	@Override
	public void enqueue(E it) {
		rear.setNext(new Link<E>(it,null));
		rear = rear.next();
		size++;
	}

	@Override
	public E dequeue() {
		assert size > 0 : "Queue is empty";
		E it = front.next().element();
		if (rear == front.next())
			rear = front;
		front.setNext(front.next().next());
		size--;
		return it;
	}

	@Override
	public E frontValue() {
		assert size > 0 : "Queue is empty"; 
		return front.next().element();
	}

	@Override
	public int length() {
		return size;
	}
}
