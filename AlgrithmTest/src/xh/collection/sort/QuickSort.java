package xh.collection.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args){
		 int[] arr = {1, 2, 55, 55, 66, 77, 999 ,3, 4, 5, 34, 44,8};
		 QuickSort qs = new QuickSort();
		 qs.quickSort(arr, 0, arr.length - 1);
		 System.out.println(Arrays.toString(arr));
	}
	public void quickSort(int[] arr,int lo,int hi){
		if(hi <= lo)
			return;
		int j = partition(arr,lo,hi);
		quickSort(arr,lo,j-1);
		quickSort(arr,j+1,hi);
		
		
		
	}
	
	public int partition(int[] arr,int lo,int hi){
		int i = lo,j = hi + 1 ;
		int key = arr[lo];
		while(true){
			while(arr[++i] < key)
				if(i == hi) 
					break;
			while(arr[--j] > key)
				if(j == lo)
					break;
			if(i >= j)
				break;
			exch(arr,i,j);
		}
		exch(arr,lo,j);
		return j;
	}
	
	public void exch(int[] arr,int i,int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
