package sort;

public class ShellSort {


	public static int[] sort(int[] a){
		int n= a.length;
		int j=0;
		int h=0;
		for(h=1; h<=n/9;h=h*3+1);
		for(;h>0;h=h/3){
		for (int i=h+1;i<n; i++)
		{ //indexVal = a[i];
			for (j=i;j>0;j=j-h)
			{
				if(j>=h+1 && a[j]<a[j-h] )
				{//a[j-1]=a[j];
				swap(a, j-h, j);	
				}
			}
			//a[j]=indexVal;
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
	//int[] sortedArray =	sort(new int[]{3, 5, 7, 14, 89, 4, 56, 67, 34, 24, 17, 9 , 23});
	//for(int i: sortedArray)
	//{
	//	System.out.println(i);
	//}
		int h=0;
		int n=14;
		for(h=1; h<=n/9;h=h*3+1);
		System.out.println(h);
	}


}
