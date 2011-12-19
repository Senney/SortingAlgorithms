public class HeapSort {
	private int heapSize;
	
	public HeapSort()
	{
		heapSize = 0;
	}

	public void sort(int[] A)
	{
		heapSize = 1;
		int i = 1;
		while (i < A.length) {
			insert(A, A[i]);
			i++;
		}
		
		i = A.length - 1;
		while (i > 0)
		{
			int max = deleteMax(A);
			A[i] = max;
			i--;
		}
	}

	private void insert(int[] A, int key)
	{
		if (heapSize > A.length)
			throw new RuntimeException("Error: Full heap");
			
		A[heapSize] = key;
		
		// reheap the heap.
		int j = heapSize;
		heapSize++;
		while (j > 0 && A[j] > A[parent(j)])
		{
			int tmp = A[j];
			A[j] = A[parent(j)];
			A[parent(j)] = tmp;
			
			j = parent(j);
		}		
	}
	
	private int deleteMax(int[] A)
	{
		if (heapSize > 0) {
			int max = A[0];
			A[0] = A[heapSize - 1];
			heapSize--;
			
			int j = 0;
			while (j < heapSize) {
				int l = left(j);
				int r = right(j);
				int largest = j;
				
				if (l < heapSize && A[l] > A[largest])
					largest = l;
				if (r < heapSize && A[r] > A[largest])
					largest = r;
				if (largest != j) {
					int tmp = A[j];
					A[j] = A[largest];
					A[largest] = tmp;
					
					j = largest;
				}		
				else
					j = heapSize;			
			}
			
			return max;
		} else {
			return -1;
		}
	}
	
	private int parent(int j) 
	{
		return (int)Math.floor((j - 1)/2);
	}
	
	private int left(int j)
	{
		return (int)Math.floor(2 * j + 1);
	}
	
	private int right(int j)
	{
		return (int)Math.floor(2 * j + 2);
	}

	public static void main(String[] args)
	{
		long start = System.currentTimeMillis();
		HeapSort sort = new HeapSort();
		for (int i = 0; i < 100; i++) {
			java.util.Random rand = new java.util.Random();
			int[] A = new int[16384];
			for (int j = 0; j < 16384; j++)
				A[j] = rand.nextInt();
		
			sort.sort(A);
		}
		System.out.println("Time: " + (System.currentTimeMillis() - start) / 100 + "ms per Sort.");
	}
}
