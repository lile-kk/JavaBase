package xh.collection.sort;

import java.util.Arrays;


/*
 * 堆排序中的建堆和调整堆的过程
 * 大根堆
 */
public class BuildMaxHeap {
	
	public static void main(String[] args){
		int[] arr = { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
		BuildMaxHeap heap = new BuildMaxHeap();
		int[] result = new int[arr.length];
		for(int i = 0 ; i< arr.length; i++){
			heap.heapInsert(result, arr[i], i);
		}
		System.out.println(Arrays.toString(result));
	}

	//建堆
	public void heapInsert(int[] arr,int value,int index){
		arr[index] = value;
		while(index != 0){
			int parent = (index - 1) / 2;
			if(arr[parent] < arr[index]){
				swap(arr, parent, index);
				index = parent;
			}else {
				break;
			}
		}
	}
	
	//调整堆
	public void heapify(int[] arr,int index,int heapSize){
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		while(left < heapSize){
			if(arr[left] > arr[index])
				largest = left;
			if(right < heapSize && arr[right] > arr[largest])
				largest = right;
			if(largest != index)
				swap(arr, largest, index);
			else {
				break;
			}
			index = largest;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}
	}
	
	 public static void swap(int[] data, int i, int j) {  
	        if (i == j) {  
	            return;  
	        }  
	        data[i] = data[i] + data[j];  
	        data[j] = data[i] - data[j];  
	        data[i] = data[i] - data[j];  
	    }  
}

