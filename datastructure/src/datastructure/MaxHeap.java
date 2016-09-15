package datastructure;

public class MaxHeap<E extends Comparable<? super E>> {
	private E[] Heap;
	private int size;
	private int n;
	
	public MaxHeap(E[] h, int num, int max) {
		Heap = h;
		n = num;
		size = max;
//		buildheap();
	}
	
	public int heapsize() {
		return n;
	}
	
	public boolean isLeaf(int pos) {
		return pos >= n / 2 && pos < n;
	}
	
	public int leftchild(int pos) {
		assert pos < n / 2 : "Position has no left child";
		return 2 * pos + 1;
	}
	
	public int rightchild(int pos) {
		assert pos > 0 : "Position has no parent";
		return (pos - 1) / 2;
	}
	
	public int parent(int pos) {
		assert pos > 0 : "Position has no parent";
		return (pos - 1) / 2;
	}
	
	public void insert(E val) {
		assert n < size : "Heap is full";
		int curr = n++;
		Heap[curr] = val;
		while (( curr != 0) && (Heap[curr].compareTo(Heap[parent(curr)]) > 0)) {
			DSutil.swap(Heap, curr, parent(curr));
			curr = parent(curr);
		}
	}

}
