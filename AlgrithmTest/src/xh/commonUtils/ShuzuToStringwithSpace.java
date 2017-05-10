package xh.commonUtils;

public class ShuzuToStringwithSpace {
	
	public static void main(String[] arg){
		int[] arr = {1,1,2,6,58,9};
		System.out.println(new ShuzuToStringwithSpace().arratToString(arr));
	}

	//将数组以空格间隔输出
	public String arratToString(int[] arr){
		String result = new String();
		for(int i = 0;i < arr.length -1;i++){
			result += arr[i] + " ";
		}
		result = result + arr[arr.length - 1];
		return result;
	}
}
