package datastructure;

import java.util.Collection;
import java.util.ListIterator;

public interface List<E> extends Collection<E>{
	void add(int idx, E e);
	void remove(int idx);
	E get(int idx);
	E set(int idx, E e);
	
	ListIterator<E> listIterator(int pos);
}
