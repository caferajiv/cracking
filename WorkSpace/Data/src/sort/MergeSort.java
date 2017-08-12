package sort;

public class MergeSort {


	public static void mergesort(int[] a, int[] temp, int low, int high){
		int n= a.length;
        int mid;
        if(low<high)
        {
        	mid = low+(high-low)/2;
        	mergesort(a, temp, low, mid);
        	mergesort(a, temp, mid+1,high);
        	merge(a, temp, low, mid+1, high);
        }
	}
	
	private static void merge(int[] a, int[] temp, int low, int mid, int high) {
		int low_end= mid-1;
		int i;
		int size=high-low+1;
		int temp_pos=low;
		for(;low<=low_end && mid<=high;)
		{
			if(a[low]<=a[mid])
			{
				temp[temp_pos++]=a[low];
				low++;
			}
			else{
				temp[temp_pos++]=a[mid];
				mid++;
			}
		}
		while(low<=low_end)
		{
			temp[temp_pos++]=a[low++];
		}
		while(high>=mid)
		{
			temp[temp_pos++]=a[mid++];
		}
		
		for(i=0;i<size;i++){
			a[high]=temp[high];
			high--;
		}
		
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
		int[] temp = new int[unsortedArray.length]; 
		int low=0;
		int high= unsortedArray.length-1;
		mergesort(unsortedArray,temp, low, high);
		for (int i : unsortedArray) {
			System.out.println(i);
		}
	}


}
