package datastructure;

class Sort {
	
//////////////////////////////////////////////////////////////////	
	
	public void inssort(int[] A) {
		for (int i = 0; i < A.length; i++)
			for (int j = i; j > 0 && A[j] < A[j - 1]; j--)
				swap(A, j, j - 1);
	}
//////////////////////////////////////////////////////////////////	
	
	public void  bubsort(int[]A) {
		for (int i = 0; i < A.length - 1; i++) {
			for (int j = A.length - 1; j > i; j--)
				if (A[j] < A[j - 1])
					swap(A, j, j-1);
		}
	}
//////////////////////////////////////////////////////////////////	
	
	public void selsort(int[] A) {
		for (int i = 0; i < A.length - 1; i++) {
			int lowindex = i;
			for (int  j= A.length - 1; j > i; j--) {
				if (A[j] < A[lowindex])
					lowindex = j;
				swap(A, i, lowindex);
			}
		}
	}
//////////////////////////////////////////////////////////////////	
	
	public void shellsort(int[] A) {
		for (int i = A.length/2; i > 2; i /= 2) 
			for (int j = 0; j < i; j++)
				inssort2(A, j, i);
		inssort2(A, 0, 1);
	}
	
	public void inssort2(int[] A, int start, int incr) {
		for (int i = start + incr; i < A.length; i += incr)
			for (int j = i; j >= incr && A[j] > A[j - incr]; j -= incr)
				swap(A, j, j - incr);
	}
	
//////////////////////////////////////////////////////////////////	
	
	public void mergesort(int[] A, int[] temp, int l, int r) {
		int mid = (l + r) / 2;
		if (l == r) return;
		mergesort(A, temp, l, mid);
		mergesort(A, temp, mid + 1, r);
		for (int i = l; i <= r; i++)
			temp[i] = A[i];
		int i1 = l; int i2 = mid + 1;
		for (int curr = l; curr <= r; curr++) {
			if (i1 == mid + 1)
				A[curr] = temp[i2++];
			else if (i2 > r)
				A[curr] = temp[i1++];
			else if (temp[i1] < temp[i2])
				A[curr] = temp[i1++];
			else A[curr] = temp[i2++];
		}
	}
//////////////////////////////////////////////////////////////////	
	public void quicksort(int[] A, int i, int j) {
		int pivotindex = findpivot(A, i, j);
		swap(A, pivotindex, j);
		int k = partition(A, i - 1, j, A[j]);
		swap(A, k, j);
		if ((k - i) > 1) quicksort(A, i, k - 1);
		if ((j - k) > 1) quicksort(A, k + 1, j);
	}
	
	int partition(int[] A, int l, int r, int pivot) {
		do {
			while (A[++l] < pivot);
			while ((r != 0) && A[--r] > pivot);
			swap(A, l, r);
		} while (l < r);
		swap(A, l, r);
		return l;
	}
	
	int findpivot(int[] A, int i, int j) {
		return (i + j) / 2;
	}
//////////////////////////////////////////////////////////////////	
	public void heapsort(int[] A) {
		MaxHeap<int> H = new MaxHeap<int>(A, A.length, A.length);
		for (int i = 0; i < A.length; i++)
			H.removemax();
	}
	
//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	
	public static void swap(int[] A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}

}
