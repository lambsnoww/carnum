package lin_datastructure;

class LList<E> implements List<E>{
	
	private Link<E> head;
	private Link<E> tail;
	protected Link<E> curr;
	int cnt;
	
	LList(int size) {
		this();
	}
	
	LList() {
		curr = tail = head = new Link<E>(null);
		cnt = 0;
	}
	@Override
	public void clear() {
		head.setNext(null);
		head = tail = curr = new Link<E>(null);
		cnt = 0;
	}
	@Override
	public void insert(E item) {
		curr.setNext(new Link<E>(item, curr.next()));
		if (tail == curr) tail = curr.next();
		cnt++;
	}
	@Override
	public void append(E item) {
		tail = tail.setNext(new Link<E>(item, null));
		cnt++;
	}
	@Override
	public E remove() {
		if (curr.next() == null) return null;
		E it = curr.next().element();
		if (tail == curr.next()) tail = curr;
		curr.setNext(curr.next().next());
		cnt--;
		return it;
	}
	@Override
	public void moveToStart() {
		curr = head;
	}
	@Override
	public void moveToEnd() {
		curr = tail;
	}
	@Override
	public void prev() {
		if (curr == head) return;
		Link<E> temp = head;
		for (; temp.next() != curr; temp = temp.next());
		curr = temp;
	}
	@Override
	public void next() {
		if (curr == tail) return;
		curr.setNext(curr.next());
	}
	@Override
	public int length() {
		return cnt;
	}
	@Override
	public int currPos() {
		if (curr == head) return 0;
		int i = 0;
		Link<E> temp = head;
		for (i = 0; temp != curr; temp = temp.next())
			i++;
		return i;
	}
	@Override
	public void moveToPos(int pos) {
		assert(pos >=0) && (pos <=cnt) : "Position out or range";
		curr = head;
		for (int i = 0; i < pos; i++) curr = curr.next();
	}
	@Override
	public E getValue() {
		if(curr.next() == null) return null;
		return curr.next().element();
	}
	
	

}
