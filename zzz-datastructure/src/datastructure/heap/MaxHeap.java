package datastructure.heap;

import util.DSutil;


public class MaxHeap<E extends Comparable<? super E>> {
	private E[] Heap;
	private int size;
	private int n;
	
	/** Constructor supporting preloading of heap contents */
	public MaxHeap(E[] h, int num, int max) {
		Heap = h; n = num; size = max; buildheap();
	}
	
	public int heapsize() { return n; }
	public boolean isLeaf(int pos) {
		return (pos >= n/2) && (pos < n);
	}
    public int leftchild(int pos) {
    	assert pos < n/2 : "Position has no left child";
    	return 2 * pos + 1;
    }
    public int rightchild(int pos) {
    	assert pos < (n - 1) / 2 : "Position has no right child";
    	return 2 * pos + 2;// 这里pos的判断不算直接
    }
    
    public int parent(int pos) {
    	assert pos > 0 : "Position has no parent";
    	return (pos - 1) / 2;
    }
    
    public void insert(E val) {
    	assert n < size : "Heap is full";
    	int curr = n++;
    	Heap[curr] = val;
    	while ((curr != 0) && 
    			(Heap[curr].compareTo(Heap[parent(curr)]) > 0)) {
    		DSutil.swap(Heap, curr, parent(curr));
    		curr = parent(curr);
    	}
    }
    
    public void buildheap() {
    	for (int i = n/2- 1; i >= 0; i--) {//最后一个非叶结点
    		siftdown(i);
    	}
    }
    
    private void siftdown(int pos) {
    	assert (pos >= 0) && (pos < n) : "Illegal heap position";
    	while (!isLeaf(pos)) {
    		int j = leftchild(pos);
    		if ((j<(n-1)) && (Heap[j].compareTo(Heap[j+1]) < 0))
    			j++;
    		if (Heap[pos].compareTo(Heap[j]) >= 0) return;
    		DSutil.swap(Heap,  pos,  j);
    		pos = j;
    	}
    }
    
    public E removemax() {
    	assert n > 0 : "Removing from empty heap";
    	DSutil.swap(Heap,  0,  --n);
        if (n != 0)
        	siftdown(0);
        return Heap[n];
    }
    
    public E remove(int pos) {
    	assert (pos>=0) && (pos<n) : "Illegal heap position";
    	if (pos == (n - 1)) n--;
    	else {
    		DSutil.swap(Heap,  pos,  --n);
    		while ((pos>0) &&
    				(Heap[pos].compareTo(Heap[parent(pos)]) > 0)) {
    			DSutil.swap(Heap,  pos, parent(pos));
    			pos = parent(pos);
    		}
    		if (n != 0) siftdown(pos);
    	}
    	return Heap[n];
    }
}
