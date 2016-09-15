package lin_datastructure;

import java.util.Scanner;

class Sort {
	public static void main(String args[]) {
		System.out.println("Please enter the array(-1 to end): ");
		Scanner in = new Scanner(System.in);
		int[] a = new int[1000];
		int i = 0;
		int cnt = 0;
		int x = Integer.parseInt(in.next());
		while (x != -1) {
			a[i++] = x;
			x = Integer.parseInt(in.next());
			cnt++;
		}
		int[] array = new int[cnt];
		for (i = 0; i < cnt; i++) {
			array[i] = a[i];
		}

		int[] b = new int[cnt];
		init(b, array);

		printline1();/////
		System.out.println("The original array: ");
		printout(array);

		printline1();/////
		System.out.println("Inssort: ");
		Inssort(b);
		printout(b);

		printline1();/////
		init(b, array);
		System.out.println("Bubsort: ");
		Bubsort(b);
		printout(b);

		printline1();/////
		init(b, array);
		System.out.println("Selsort: ");
		Selsort(b);
		printout(b);
		
		printline1();/////
		init(b, array);
		System.out.println("Shellsort: ");
		Shellsort(b);
		printout(b);

		printline1();/////
		init(b, array);
		System.out.println("Mergesort: ");
		Mergesort(b, 0, b.length - 1);
		printout(b);
		
		printline1();/////
		init(b, array);
		System.out.println("Quickesort: ");
		Quicksort(b, 0, b.length - 1);
		printout(b);
		
		printline1();/////
		init(b, array);
		System.out.println("Heapsort: ");
		Heapsort(b);
		printout(b);
	}
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	public static void Inssort(int[] A) {
		
		for (int i = 1; i < A.length; i++) {
			int tmp = A[i];
			int j = i;
			for (j = i; j > 0; j--) {
				if (A[j - 1] > tmp) {
					A[j] = A[j - 1];
				}
				else
					break;
			}
			A[j] = tmp;
		}
	}

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	public static void Bubsort(int[] A) {
		for (int i = 1; i < A.length; i++) {
			for (int j = i; j > 0; j--) {
				if (A[j - 1] > A[j])
					swap(A, j - 1, j);
				else
					break;
			}
		}
	}
	
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	public static void Selsort(int[] A) {
		int minIndex = 0;
		for (int i = 0; i < A.length; i++) {
			minIndex = selectmin(A, i , A.length - 1);
			swap(A, i , minIndex);
		}
	}
	public static int selectmin(int[] a, int b, int e) {
		int min = a[b];
		int minIndex = b;
		while(b <= e) {
			if(a[b] < min) {
				min = a[b];
				minIndex = b;
			}
			b++;
		}
		return minIndex;
	}
	
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	public static void Shellsort(int[] A) {
		int[] seq = { 12, 9, 6, 3, 2, 1};
		for (int i  = 0; i < 6; i++) {
			for (int j = 0; j < seq[i]; j++) {
				Inssort2(A, seq[i], j);
			}
		}
		
	}
	public static void Inssort2(int[] A, int step, int start) {
		
		for (int i = start; i < A.length; i += step) {
			int tmp = A[i];
			int j = i;
			for (j = i; j - step >= 0; j -= step) {
				if (A[j - step] > tmp) {
					A[j] = A[j - step];
				}
				else
					break;
			}
			A[j] = tmp;
		}
	}
	
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	public static void Mergesort(int[] A, int s, int e) {
		if (s >= e)	return;
		int mid = (s + e) / 2;
		int[] B = new int[e + 1];
		Mergesort(A, s, mid);
		Mergesort(A, mid + 1, e);
		int c = s;
		int i = s;
		int j = mid + 1;
		for (i = s, j = mid + 1; i <= mid && j <= e;) {
			if (A[i] < A[j]) {
				B[c++] = A[i++];
			} else {
				B[c++] = A[j++];
			}
		}
		while (i <= mid) {
			B[c++] = A[i++];
		}
		while (j <= e) {
			B[c++] = A[j++];
		}
		
		for (i = s; i <= e; i++) {
			A[i] = B[i];
		}
	}
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	public static void Quicksort(int[] A, int s, int e) {
		if ( s >= e)	return;
		int mid = A[s];
		int l = s + 1;
		int r = e;
		while(A[r] >= mid && r > s) r--;	//do while更简洁
		while(A[l] <= mid && l < e) l++;
		while( r > l) {	//无“=”
			swap(A, l, r);
			while(A[r] >= mid && r > s) r--;
			while(A[l] <= mid && l < e) l++;
		}
		swap(A, s, r);
		Quicksort(A, s, r - 1);	//减一，范围缩小
		Quicksort(A, l, e);
	}
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	public static void Heapsort(int[] A) {
		Heap h = new Heap(A.length);
		for (int i = 0; i < A.length; i++) {
			h.heapArray[i] = A[i];
		}
		h.heapSize = A.length;
		h.adjustHeap();
		
		int i = 0;
		do {
			h.adjustNode(0);
			A[i] = h.popTop();
			i++;
		} while(!h.isEmpty());
	}
	
	public static class Heap {	//static静态，不依赖于实例
		public static final int defaultSize = 100;
		public int maxSize;
		public int heapSize;
		public int[] heapArray;
		Heap() {
			this(defaultSize);
		}
		Heap(int size) {
			maxSize = size;
			heapSize =  0;
			heapArray = new int[size];
		}	
		
		public boolean isEmpty() {
			return heapSize == 0;
		}
		
		public int popTop() {
			int i = heapArray[0];
			heapArray[0] = heapArray[heapSize - 1];
			heapSize--;
			return i;
		}
		
		public void adjustNode(int from) {
			int r  = from;
			while (2 * r + 1 < heapSize) {
				int m = minIndex(heapArray, 2*r + 1, 2*r + 2);
				if (heapArray[r] > heapArray[m]) {
					swap(heapArray, r, m);
					r = m;
				} else
					break;
			}
		}
		
		public void adjustHeap(){
			int r = (heapSize - 1) / 2;
			while (r >= 0) {
				adjustNode(r);
				r--;
			}
		}
		
	}
		  
		public static int minIndex(int[] A, int a, int b) {
			if (b >= A.length) return a;
			if (A[a] > A [b])	return b;
			else	return a;
		}
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
		
	
	
//????????????????????????????????????????????????????	
	public static void swap(int[] A, int i, int j) {
		if (i == j)
			return;
		int a = A[i];
		A[i] = A[j];
		A[j] = a;
	}

	public static void init(int[] b, int[] a) {
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
	}

	public static void printout(int[] a) {
		System.out.println("Size is: " + a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void printline1() {
		System.out.println("----------------------------------------");
	}

}
