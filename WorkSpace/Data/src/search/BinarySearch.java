package search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] sortedArray=new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		int low = 0;
		int high = sortedArray.length-1;
		int index=search(sortedArray, 13, low, high);
		System.out.println(index);
	}

	public static int search(int[] arr, int num, int low, int high) {

		if(num<arr[low] || num>arr[high])return -1;
		if(low>high) return -1;
		int mid = (low+high)/2;
		if(arr[mid]==num) return mid;
		if(num<arr[mid])
			return search(arr, num, low, mid-1);
		else
			return search(arr, num, mid+1, high);
		
	}
	
}
