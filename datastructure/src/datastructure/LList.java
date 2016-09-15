package datastructure;

class LList<E> implements List<E> {
	private Link<E> head;
	private Link<E> tail;
	protected Link<E> curr;
	int cnt;
	
	LList(int size) { this(); }
	LList() {
		curr = tail = head = new Link<E>(null);
		cnt = 0;
	}
	
	public void clear() {
		head.setNext(null);
		curr = tail = head = new Link<E>(null);
		cnt = 0;
	}
	public void insert(E it) {
		curr.setNext(new Link<E>(it, curr.next()));
		if (tail == curr) tail = curr.next();
		cnt++;
	}
	public void append(E it) {
		tail = tail.setNext(new Link<E>(it, null));
		cnt++;
	}
	public E remove() {
		if (curr.next() == null) return null;
		E it = curr.next().element();
		if (tail == curr.next()) tail = curr;
		curr.setNext(curr.next().next());
		cnt--;
		return it;
	}
	public void moveToStart() {
		curr = head;
	}
	public void moveToEnd() {
		curr = tail;
	}
	public void prev() {
		if (curr == head) return;
		Link<E> temp = head;
		while (temp.next() != curr) temp = temp.next();
		curr = temp;
	}
	public void next() {
		if (curr != tail) curr = curr.next();
	}
	public int length() { return cnt; }
	public int currPos() {
		Link<E> temp = head;
		int i;
		for (i = 0; curr != temp; i++)
			temp = temp.next();
		return i;
	}
	public void moveToPos(int pos) {
		assert (pos>=0) && (pos<=cnt) : "Position out of range";
		curr = head;
		for(int i = 0; i < pos; i++)	curr = curr.next();
	}
	public E getValue() {
		if(curr.next() == null)	return null;
		return curr.next().element();
	}
	
}
