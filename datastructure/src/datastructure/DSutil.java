package datastructure;

public class DSutil {
	public static <E> void swap(E[] arr, int a, int b) {
		E temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
