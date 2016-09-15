package util;

public class DSutil<E> {
	public static <E> void swap(E[] array, int idx1, int idx2) {
		E temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
}
