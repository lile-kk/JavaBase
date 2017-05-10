package arrayProblems;
/**
 * 数组排序之后相邻数的最大差值
 * 时间复杂度O(N)，额外空间复杂度O(N)
 * @author Administrator
 *
 */
public class BucketSortToFinMaxGap {

	
	public static void main(String[] args){
		int[] arr = {9,3,1,10};
		System.out.println(new BucketSortToFinMaxGap().maxGap(arr));
	}
	
	public int maxGap(int[] num){
		if(num== null || num.length < 2)
			return 0;
		int len = num.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i< len;i++){
			min = Math.min(min, num[i]);
			max = Math.max(max, num[i]);
		}
		
		if(min== max)
			return 0;
		//记录N+1个桶中是否有数，将Max放在第N+1个桶中，min放在第一个桶中，所以至少有一个桶中是空的
		boolean[] hasNum = new boolean[len + 1];
		int[] maxs = new int[len + 1];//记录每个桶中的最大值
		int[] mins = new int[len + 1];
		int bid = 0;
		for(int i = 0; i < len; i++){
			bid = bucket(num[i], len, min, max);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], num[i]) : num[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], num[i]) : num[i];
			hasNum[bid] = true;
		}
		
		int res = 0;
		int lastMax = 0;
		int i = 0;
		while(i <= len){//找到第一个不为空的
			if(hasNum[i++]){
				lastMax = maxs[i - 1];
				break;
			}
		}
		for(; i <= len; i++){
			if(hasNum[i]){
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}
	
	//算出桶号，使用long是为了避免相乘时溢出
	public int bucket(long num,long len,long min,long max){
		return (int) ((num - min) * len /(max - min));
	}
}
