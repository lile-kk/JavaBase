package arrayProblems;
/*
 * 数组中未出现的最小正整数
 * 给定一个无序数组arr，找到数组中未出现的最小正整数
 */

public class NotAppearMinNum {
	
	public static void main(String[] args){
		int[] arr = {-1,1,2,3,4,5,2};
		System.out.println(new NotAppearMinNum().missNum(arr));
	}
	
	public int missNum(int[] arr){
		int  l = 0;
		int r = arr.length;
		while(l < r){
			if(arr[l] == l + 1){
				l++;
			}else if(arr[l] <= l || arr[l] > r|| arr[arr[l] - 1] == arr[l]){
					arr[l] = arr[--r];
			}else {
				swap(arr,l,arr[l] - 1);
			}
		}
		return l + 1;
	}
	
	public void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
