package datastructure;

class LQueue<E> implements Queue<E> {
	private Link<E> front;
	private Link<E> rear;
	int size;
	
	public LQueue() { init(); }
	public LQueue(int size) { init(); }
	private void init() {
		front = rear = new Link<E>(null);
		size = 0;
	}
	
	public void clear() {
		init();
	}
	public void enqueue(E it) {
		rear.setNext(new Link<E>(it, null));
		rear = rear.next();
		size++;
	}
	
	public E dequeue(){
		assert size != 0 : "Queue is empty";
		E it = front.next().element();
		front.setNext(front.next().next());
		if (front.next() == null)
			rear = front;
		size--;
		return it;
	}
	
	public E frontValue() {
		assert size != 0 : "Queue is empty";
		return front.next().element();
	}
	
	public int length() {
		return size;
	}
	
	
	 
}
