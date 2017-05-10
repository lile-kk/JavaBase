package dynamic.programming;

import java.util.zip.CRC32;

/**
 * 跳跃游戏
 * 给定数组arr,arr[i]==k代表可以从位置向右跳1~k个距离。比如，arr[2]==3,代表从位置2可以跳到位置3、位置4或位置5.
 * 如果从位置0出发，返回最少跳几次能跳到arr最后的位置上。
 * arr={3,2,3,1,1,4}
 * arr[0]==3,选择跳到位置2，arr[2]==3,可以跳到最后位置。所以返回2
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

	//优化方法
	//时间复杂度O(N)，额外空间复杂度O(1)
	public int jump(int[] arr){
		if(arr== null || arr.length == 0){
			return 0;
		}
		int jump = 0;//jump 表示目前跳了多少步
		int cur = 0;//cur 表示如果只能跳jump步，最远能够达到的位置
		int next = 0;//next 表示如果在多跳一步，最远能够达到的位置
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
