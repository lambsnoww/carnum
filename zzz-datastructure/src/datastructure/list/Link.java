package datastructure.list;

/* Singly linked list node */
class Link<E> {
	private E element;
	private Link<E> next;
	
	// Constructors
	Link(E it, Link<E> nextval) {
		element = it;
		next = nextval;
	}
	Link(Link<E> nextval) { next = nextval; }
	
	Link<E> next() { return next; }
	Link<E> setNext(Link<E> nextval) {
		return next = nextval;
	}
	E element() { return element; }
	E setElement(E it) { return element = it; }
}


