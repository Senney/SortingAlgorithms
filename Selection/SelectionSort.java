public class SelectionSort {
	public static void main(String[] main)
	{
		int[] A = {10, 4, 16, 2, 1, 13, 4};
		sort(A);
		
		for (int i = 0; i < A.length; i++)
			System.out.println(A[i]);
	}
	
	public static void sort(int[] A) 
	{
		for (int i = 0; i < A.length - 2; i++)
		{
			int min = i;
			for (int j = i + 1; j < A.length; j++)
				if (A[j] < A[min])
					min = j;
			if (min != i)
			{
				int tmp = A[i];
				A[i] = A[min];
				A[min] = tmp;
			}
		}
	}
}
