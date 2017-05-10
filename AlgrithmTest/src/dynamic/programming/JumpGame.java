package dynamic.programming;

import java.util.zip.CRC32;

/**
 * ��Ծ��Ϸ
 * ��������arr,arr[i]==k������Դ�λ��������1~k�����롣���磬arr[2]==3,�����λ��2��������λ��3��λ��4��λ��5.
 * �����λ��0��������������������������arr����λ���ϡ�
 * arr={3,2,3,1,1,4}
 * arr[0]==3,ѡ������λ��2��arr[2]==3,�����������λ�á����Է���2
 * @author Administrator
 *
 */
public class JumpGame {
	public static void main(String[] args){
		int arr[] = {3,2,3,1,1,4,1,3,1,1,1};
		System.out.print(new JumpGame().jumSum(arr, 0));
	}
	public int jumSum(int[] arr,int start){
		if((start + arr[start]) >= arr.length - 1){
			return 1;
		}
			int k = arr[start];
			int max = start + 1;
			for(int j = 2; (j <= k)&&(j < arr.length - 1);j++){
				if(arr[j + start] > arr[max])
					max= j + start;
			}
			return jumSum(arr, max) + 1;
		
	}

	//�Ż�����
	//ʱ�临�Ӷ�O(N)������ռ临�Ӷ�O(1)
	public int jump(int[] arr){
		if(arr== null || arr.length == 0){
			return 0;
		}
		int jump = 0;//jump ��ʾĿǰ���˶��ٲ�
		int cur = 0;//cur ��ʾ���ֻ����jump������Զ�ܹ��ﵽ��λ��
		int next = 0;//next ��ʾ����ڶ���һ������Զ�ܹ��ﵽ��λ��
		for(int i = 0; i < arr.length;i++){
			if(cur < i){
				jump++;
				cur= next;
			}
			next = Math.max(next, i + arr[i]);
		}
		return jump;
	}
}
