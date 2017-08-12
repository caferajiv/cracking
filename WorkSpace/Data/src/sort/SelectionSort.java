package sort;

public class SelectionSort {

	public static int[] sort(int[] a){
		int n= a.length;
		int min=0;
		for (int i=0;i<n-1; i++)
		{ min = i;
			for (int j=i+1;j<n;j++)
			{
				if(a[min]>a[j])
				{
				//	swap(a, i, j);
					min = j;
					
				}
			}
			swap(a, min, i);
		}
		return a;
	}
	
	private static void swap(int []arr, int i , int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]= temp;
	}
	
	public static void main(String[] args) {
	int[] sortedArray =	sort(new int[]{3, 5, 7, 14, 89, 4, 56, 67, 34, 24, 17, 9 , 23});
	for(int i: sortedArray)
	{
		System.out.println(i);
	}
	}
}
