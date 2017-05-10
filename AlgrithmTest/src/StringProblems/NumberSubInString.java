package StringProblems;
/**
 * 字符串中数字子串的求和
 * 给定一个字符串str，求其中全部数字串所代表的数字之和
 * @author Administrator
 *
 */
public class NumberSubInString {
	public static void main(String[] args){
		 char a=  '-';
		 int b = a - '0';
		 System.out.println(b);
		String str = "A-1B--2C--D6E";
		System.out.println(new NumberSubInString().Sum(str));
	}

	public int Sum(String str){
		if(str== null){
			return 0;
		}
		char[] arr = str.toCharArray();
		int res = 0;
		int num = 0;
		int cur = 0;
		boolean fuhao = true;
		for(int i = 0;i < arr.length;i++){
			cur  = arr[i] - '0';
			if(cur < 0 || cur > 9){
				res= res + num;
				num = 0;
				if(arr[i] == '-'){
					if((i - 1) > -1 && arr[i - 1] == '-'){
						fuhao = !fuhao;
					}else{
						fuhao = false;
					}
				}else{
					fuhao = true;
				}
			}else{
				num = num * 10 + (fuhao ? cur: -cur);
			}
		}
		res += num;
		return res;
	}
}
