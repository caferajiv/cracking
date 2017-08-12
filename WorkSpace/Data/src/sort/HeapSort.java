package sort;


public class HeapSort {
	public static void main(String[] args) {
		int[] unsortedArray = new int[] { 3, 5, 7, 14, 89, 4, 56, 67, 34, 24,
				17, 9, 23 };
		Heap heap =	Heap.buildHeap(unsortedArray);
		int i=0;
		while(heap.count>0)
		{
			unsortedArray[i]=heap.deleteMax();
			i++;
		}
		
		for(int n: unsortedArray)
		{
			System.out.println(n);
		}
	}
}
