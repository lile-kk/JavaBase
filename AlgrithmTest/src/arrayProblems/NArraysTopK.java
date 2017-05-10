package arrayProblems;
/*
 * ��ӡN��������������TopK
 * ��N�����Ȳ�һ�����飬���е����鶼������ģ���Ӵ�С��ӡ��N��������������ǰK����
 * :
 * 	����һ����СΪN�Ĵ����heap
 */
public class NArraysTopK {
	public static void  main(String[] args){
		NArraysTopK top = new NArraysTopK();
		int[][] matrix= {
				{219,405,538,845,971},
				{999,1000},
				{52,99,348,691}
		};
		top.printTopK(matrix, 5);
	}
	
	public void printTopK(int[][] matrix,int topK){
		//�ж��ٸ�����
		int N = matrix.length;
		int heapSize = N;
		HeapNode[] heap = new HeapNode[N];
		for(int i = 0; i < N; i++){
			int index = matrix[i].length - 1;
			heap[i] = new HeapNode(matrix[i][index], i, index);
			heapInsert(heap, i);
		}
		
		System.out.println("Top" + topK + " : ");
		for(int i = 0; i< topK;i++){
			if(heapSize == 0)
				break;
			System.out.println(heap[0].value + " ");
			if(heap[0].index != 0){
//				int indexTmp = heap[0].index - 1;
//				heap[0].value = matrix[heap[0].arrNum][indexTmp];
//				heap[0].index = indexTmp;
				heap[0].value = matrix[heap[0].arrNum][--heap[0].index];
			}else{
				swap(heap, 0, --heapSize);
			}
			heapify(heap, 0, heapSize);
		}
	}
	
	
	//����СΪN�Ķ�
	public void heapInsert(HeapNode[] heap, int index){
		while(index != 0){
			int parent = (index - 1) / 2;
			if(heap[index].value > heap[parent].value){
				swap(heap, index, parent);
				index = parent;
			}else{
				break;
			}
		}
	}
	
	//ȡ�ߴ���Ѹ�����ֵ����Ѷ�������
	public void heapify(HeapNode[] heap, int index, int heapsize){
		int left = index * 2 + 1;
		int right = index*2 + 2;
		int largest = index;
		while(left < heapsize){
			if(heap[left].value > heap[index].value){
				largest = left;
			}
			if(right < heapsize && heap[right].value > heap[largest].value)
				largest = right;
			if(largest != index)
				swap(heap, largest, index);
			else
				break;
			index = largest;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}
	}

	public void swap(HeapNode[] arr,int index1,int index2){
		HeapNode tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
	//��¼max����ʲô�����ʲôλ��
	class HeapNode{
		public int value;
		public int arrNum;
		public int index;
		
		public HeapNode(int value, int arrNum, int index){
			this.value = value;
			this.arrNum = arrNum;
			this.index = index;
		}
	}
}
