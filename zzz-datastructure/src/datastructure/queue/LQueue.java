package datastructure.queue;

import util.Link;

class LQueue<E> implements Queue<E> {
	private Link<E> front;
	private Link<E> rear;
	int size;
	
	/** Constructors */
	LQueue() { init(); }
	LQueue(int size) { init(); }
	
    private void init() {
		front = rear = new Link<E>(null);
		size = 0;
	}
    public void clear() { init(); }
    
    public void enqueue(E it) {
    	rear = rear.setNext(new Link<E>(it, null)); //diff
    	size++;
    }
	public E dequeue() {
		assert size != 0 : "Queue is empty";
		E it = front.next().element();
        front.setNext(front.next().next());
		if (front.next() == null) rear = front; //Last Object
		size--;
		return it;
	}
	
	public E frontValue() {
		assert size != 0 : "Queue is empty";
		return front.next().element();
	}
	
	public int length() { return size; }

}
