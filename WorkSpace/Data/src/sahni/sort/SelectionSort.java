package sahni.sort;

public class SelectionSort {
	
	public static void main(String args[]){
		int []a=new int[]{6,2,3,5,7,2,4,5,8,9};
		//int index=findMaxIndex(new int[]{6,2,3,5,7},4);
		//System.out.println(index);
		selectionSort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	
	public static void selectionSort(int []a){
		int size=a.length;
		for (int i=size-1;size>1;size--){
			int index=findMaxIndex(a,size);
			swap(a,size-1,index);
		}
	}
	
	public static int findMaxIndex(int []a,int size){
		int max=a[0];
		int index=0;
		for(int i=1;i<size;i++){
			if(max<a[i]){
				max=a[i];
				index=i;
			}
		}
		return index;
	}
	
	public static void swap(int a[],int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}

}
