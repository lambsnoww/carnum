package datastructure.queue;

public interface Queue<E> {
    public void clear();
    public void enqueue(E it);
    public E dequeue();
    
    public E frontValue();
    public int length();

}
