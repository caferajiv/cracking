package sort;

public class InsertionSort {


	public static int[] sort(int[] a){
		int n= a.length;
		int indexVal=0;
		int j=0;
		for (int i=1;i<n; i++)
		{ //indexVal = a[i];
			for (j=i;j>0;j--)
			{
				if(j>=1 && a[j]<a[j-1] )
				{//a[j-1]=a[j];
				swap(a, j-1, j);	
				}
			}
			//a[j]=indexVal;
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
