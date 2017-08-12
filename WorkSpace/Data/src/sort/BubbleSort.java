package sort;

public class BubbleSort {
	
	public static int[] sort(int[] a){
		int n= a.length;

		for (;n>0; n--)
		{
			for (int j=0;j<n-1;j++)
			{
				if(a[j]>a[j+1])
				{
					swap(a, j, j+1);
				}
			}
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
		System.out.print(i+" ");
	}
	}

}
