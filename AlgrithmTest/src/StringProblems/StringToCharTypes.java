package StringProblems;
/**
 * 数字字符串转换为字母组合的种数
 * 给定一个字符串str,str全部有数字字符组成，如果str中某一个或某相邻两个字符组成的子串值在1~26之间，则这个子串可以转换为一个字母
 * "1" -> "A"
 * @author Administrator
 *
 */
public class StringToCharTypes {
	
	public static void main(String[] args){
		String str = "10";
		System.out.println(new StringToCharTypes().sumNun(str));
	}

	
	public int sumNun(String str){
		if(str == null || str.equals("")){
			return 0;
		}
		char[] arr = str.toCharArray();
		int cur = arr[arr.length - 1] == '0' ? 0 : 1;
		int next = 1;
		int tmp2 = 0;
		for(int i = arr.length - 2; i >= 0; i--){
			if(arr[i] == '0'){
				next = cur;
				cur = 0;
				
			}else{
				tmp2= cur;
				if(((arr[i] - '0')*10 + (arr[i + 1] - '0')) < 27){
					cur += next;
				}
				next = tmp2;
			}
		}
		return cur;
	}
}
