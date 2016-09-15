package lin_datastructure;

class LList2<E> implements List<E> {
	
	private Link<E> head;
	private Link<E> tail;
	private Link<E> curr;
	int cnt;
	
	LList2(int size) {
		this();
	}
	
	LList2(){
		head = tail = curr = new Link<E>(null);
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
		curr.setNext(new Link<E>(item,curr.next()));
		if (tail == curr)
			tail = curr.next();
		cnt++;
	}

	@Override
	public void append(E item) {
		tail = tail.setNext(new Link<E>(item, null));
		cnt++;
	}

	@Override
	public E remove() {
		if (curr.next() == null)
			return null;
		E temp = curr.next().element();
		if (tail == curr.next())
			tail = curr;
		curr.setNext(curr.next().next());//注意顺序，这个在后
		cnt--;
		return temp;
		
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
		Link<E> temp;
		for (temp = head; temp.next() != curr; temp = temp.next());
		curr = temp;
	}

	@Override
	public void next() {
		if (curr == tail) return;
		curr = curr.next();
	}

	@Override
	public int length() {
		return cnt;
	}

	@Override
	public int currPos() {
		int i;
		Link<E> temp = head;
		for (i = 0; temp != curr; temp = temp.next())
			i++;
		return i;
	}

	@Override
	public void moveToPos(int pos) {
		assert(pos >= 0) && (pos <= cnt): "Position out of range";//补充这一句
		int i;
		curr = head;
		for(i = 0; i < pos; i++) {
			curr = curr.next();
		}
	}

	@Override
	public E getValue() {
		if (curr == tail)	return null;//if (curr.next() == null)	return null;
		return curr.next().element();
	}
}
