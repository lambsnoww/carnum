package datastructure;

class BSTNode<Key, E> implements BinNode<E> {
	private Key key;
	private E element;
	private BSTNode<Key, E> left;
	private BSTNode<Key, E> right;
	
	public BSTNode() {
		left = right = null;
	}
	
	public BSTNode(Key k, E val) {
		left = right = null;
		key = k;
		element = val;
	}
	
	public BSTNode(Key k, E val, BSTNode<Key, E> l, BSTNode<Key, E> r) {
		left = l;
		right = r;
		key = k;
		element = val;
	}
	
	public Key key() {
		return key;
	}
	
	public void setKey(Key k){
		key = k;
	}
	
	public E element() {
		return element;
	}
	
	public void setElement(E v) {
		element = v;
	}
	
	public BSTNode<Key, E> left() {
		return left;
	}
	public void setLeft(BSTNode<Key, E> p) {
		left = p;
	}
	
	public BSTNode<Key, E> right() {
		return right;
	}
	public void setRight(BSTNode<Key, E> p) {
		right  = p;
	}
	
	public boolean isLeaf() {
		return (left == null) && (right == null);
	}

}
