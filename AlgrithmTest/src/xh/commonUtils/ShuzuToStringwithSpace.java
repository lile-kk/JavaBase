package xh.commonUtils;

public class ShuzuToStringwithSpace {
	
	public static void main(String[] arg){
		int[] arr = {1,1,2,6,58,9};
		System.out.println(new ShuzuToStringwithSpace().arratToString(arr));
	}

	//�������Կո������
	public String arratToString(int[] arr){
		String result = new String();
		for(int i = 0;i < arr.length -1;i++){
			result += arr[i] + " ";
		}
		result = result + arr[arr.length - 1];
		return result;
	}
}
