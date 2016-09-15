package datastructure.heap;

public interface Heap<E> {
    
	public int heapsize();
	public boolean isLeaf(int pos);
    
	public int leftchild(int pos);
	public int rightchild(int pos);
	public void parent(int pos);
    
	public void insert(E val);
	public void buildheap();
	
//	siftdown(int pos) is private 
	
	public E removemax();
	public E remove(int pos);
	
    

}
