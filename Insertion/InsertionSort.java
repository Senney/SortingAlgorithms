public class InsertionSort<K extends Comparable<K>> {
	public InsertionSort() { }

	public void sort(K A[]) {
		for (int i = 1; i < A.length; i++)
		{
			int j = i;
			
			while (j > 0 && (A[j].compareTo(A[j - 1])) < 0) {
				// Swap the two.
				K tmp = A[j];
				A[j] = A[j - 1];
				A[j - 1] = tmp;
				j--;
			}
		}
	}
	
	public static void main(String[] args)
	{
		InsertionSort<Integer> is = new InsertionSort();
		
		for (int j = 0; j < 100; j++) {
			Integer[] test = new Integer[16384];
			java.util.Random rand = new java.util.Random();
			for (int i = 0; i < test.length; i++)
				test[i] = rand.nextInt(1000);
		
			is.sort(test);
			System.out.println(j);
		}
	}
}
