package xh.collection.sort;

/**
 * ������
 * @author Administrator
 *
 */

public class HeapSort {
	
	public static void main(String[] args) {  
        int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };  
        print(data5);  
        heapSort(data5);  
        System.out.println("���������飺");  
        print(data5);  
    }  
  
    public static void swap(int[] data, int i, int j) {  
        if (i == j) {  
            return;  
        }  
        data[i] = data[i] + data[j];  
        data[j] = data[i] - data[j];  
        data[i] = data[i] - data[j];  
    }  
  
    public static void heapSort(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            createMaxdHeap(data, data.length - 1 - i);  
            swap(data, 0, data.length - 1 - i);  
            print(data);  
        }   
    }  
  
    public static void createMaxdHeap(int[] data, int lastIndex) {  
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {  
            // ���浱ǰ�����жϵĽڵ�  
            int k = i;  
            // ����ǰ�ڵ���ӽڵ����  
            while (2 * k + 1 <= lastIndex) {  
                // biggerIndex���Ǽ�¼�ϴ�ڵ��ֵ,�ȸ�ֵΪ��ǰ�жϽڵ�����ӽڵ�  
                int biggerIndex = 2 * k + 1;  
                if (biggerIndex < lastIndex) {  
                    // �����ӽڵ���ڣ������ʱbiggerIndexӦ�õ��� lastIndex  
                    if (data[biggerIndex] < data[biggerIndex + 1]) {  
                        // �����ӽڵ�ֵ�����ӽڵ�ֵ����biggerIndex��¼�������ӽڵ��ֵ  
                        biggerIndex++;  
                    }  
                }  
                if (data[k] < data[biggerIndex]) {  
                    // ����ǰ�ڵ�ֵ���ӽڵ����ֵС���򽻻�2�ߵ�ֵ��������biggerIndexֵ��ֵ��k  
                    swap(data, k, biggerIndex);  
                    k = biggerIndex;  
                } else {  
                    break;  
                }  
            }  
        }  
    }  
  
    public static void print(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            System.out.print(data[i] + "\t");  
        }  
        System.out.println();  
    }  
	
	/*
	 * 
	//������
	public void heapSort(int[] a,int n){
		int i;
		for(i = n ;i > 1;i--){
			swap(a,i,1);
			sink(a,i,1);
		}
	}
	
	//����,��һ����ͨ�����齨��һ�����أ��Ǿ���Ҫ�Ե�ǰ���еķ�Ҷ�ӽڵ����sink���������ﵽ�ѵ�Ҫ��
	public void buildHeap(int[] a,int n){
		int i;
		for(i = (n/2);i>=1;i--){
			sink(a,n,i);
		}
	}

	
	//����Ԫ��
	public void swim(int[] a,int k){
		int j = 0;
		while(k > 0){
			j = k /2;
			if(a[j] < a[k]){
				swap(a,j,k);
				k = j;
			}else
				break;
		}
	}
	
	//n�ǽڵ�������ɾ�����ǴӸ��ڵ㿪ʼ
	public void sink(int[] a, int n,int k){
		while(2*k < n){
			int j = 2*k;
			if(j < n && a[j] < a[j+1])
				j++;
			if(a[k] < a[j]){
				swap(a,k,j);
				k = j;
			}else
				break;
				
		}
	}
	
	//�������ݵ�����Ԫ��
	public void swap(int[] a,int i,int j){
		int tmp = a[i];
		a[i]  = a[j];
		a[j] = tmp;
	}
	
	public static void main(String[] args){
		//�����ܹ�Ϊ7��������Ϊ�˷��㣬��8������һλ����ֵ��Ϊ�˷��㣬����0��
		int[] a = {0,3,4,6,37,1,5,2};
		HeapSort hs = new HeapSort();
		hs.buildHeap(a, 7);
		hs.heapSort(a, 7);
		System.out.print(Arrays.toString(a));
	}
	
	*/
}
