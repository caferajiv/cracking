package sort;

public class QuickSort {


	public static void quicksort(int[] a, int low, int high){
		int n= a.length;
        int pivot;
        if(low<high)
        {
        	//mid = low+(high-low)/2;
        	pivot=partition(a, low, high);
        	quicksort(a, low, pivot-1);
        	quicksort(a, pivot+1,high);
        	
        }
	}
	
	public static int partition(int[] a, int low, int high) {
		int start=low;
		int end=high;
		int pivot=(high+low)/2;
		int pivotElement=a[pivot];
		while(start<end)
		{
			while(start<high && a[start]<=pivotElement)
			{
				start++;
			}
			while(start<high && a[end]>pivotElement)
			{
				end--;
			}
			if(start<end){
				swap(a,start,end);
			}
		}
		a[pivot]=a[end];
		a[end]=pivotElement;
		return end;
	}

	private static void swap(int []arr, int i , int j)
	{
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]= temp;
	}
	
	public static void main(String[] args) {
		int[] unsortedArray = new int[] { 3, 5, 7, 14, 89, 4, 56, 67, 34, 24,
				17, 9, 23 }; 
		int low=0;
		int high= unsortedArray.length-1;
		quicksort(unsortedArray,low, high);
		for (int i : unsortedArray) {
			System.out.println(i);
		}
	}


}
