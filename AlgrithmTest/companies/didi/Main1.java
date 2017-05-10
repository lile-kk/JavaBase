package didi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main1 {
	public static Character[] c2 = {'a','b','c'};
	public static Character[] c3 = {'d','e','f'};
	public static Character[] c4 = {'g','h','i'};
	public static Character[] c5 = {'j','k','l'};
	public static Character[] c6 = {'m','n','o'};
	public static Character[] c7 = {'p','q','r','s'};
	public static Character[] c8 = {'t','u','v'};
	public static Character[] c9 = {'w','x','y','z'};
	public static Map<Integer, Character[]> map= new HashMap<Integer, Character[]>();
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String num = in.nextLine();
		String[] dic = line.split(" ");
		char[] nums = num.toCharArray();
		map.put(2, c2);
		map.put(3, c3);
		map.put(4, c4);
		map.put(5, c5);
		map.put(6, c6);
		map.put(7, c7);
		map.put(8, c8);
		map.put(9, c9);
		Character[] arr1 = null;
		Character[] arr2 = null;
		Character[] arr3 = null;
		
		for(int i = 2; i < 10; i++){
			if((nums[0]-'0') == i){
				arr1 = map.get(i);
			}
			if((nums[1]-'0') == i){
				arr2 = map.get(i);
			}
			if((nums[2]-'0') == i){
				arr3 = map.get(i);
			}
		}
		int length = 0;
		int index = 0;
		int tmp = 0;
		String[] dikaer = getDiKaer(arr1, arr2, arr3);
		for(int i = 0; i < dikaer.length;i++){
			for(int j = 0; j< dic.length;j++){
				
				tmp = maxCommomSubSequence2(dic[j], dikaer[i]);
				if(length < tmp){
					length = tmp;
					index = j;
				}
			}
		}
		System.out.println(dic[index]);
		
	}
	
	//三个数字的笛卡尔乘积
	public static String[] getDiKaer(Character[] arr1,Character[] arr2,Character[] arr3){
		String[] res = new String[arr1.length * arr2.length * arr3.length];
		int index = 0;
		for(int i = 0; i < arr1.length;i++){
			for(int j = 0; j < arr2.length; j++){
				for(int k = 0; k<arr3.length;k++){
					char[] arr = {arr1[i],arr2[j],arr3[k]};
					res[index++] = new String(arr);
				}
			}
		}
		return res;
	}
	
	public static int maxCommomSubSequence2(String s1,String s2){  
	    //用于保存Xi Yj 两个字符串的最大公共子序列长度  
	    int[][] commonSubSqsLen=new int[s1.length()][s2.length()];  
	    int maxLen=0;//表示两个字符串的最大公共子序列长度  
	    for(int i=0;i<s1.length();i++){  
	        for(int j=0;j<s2.length();j++){  
	            if(s1.charAt(i)==s2.charAt(j)){  
	                if(i-1>=0&&j-1>=0){  
	                    commonSubSqsLen[i][j]=1+commonSubSqsLen[i-1][j-1];  
	                }else{  
	                    commonSubSqsLen[i][j]=1;  
	                }  
	            }else{  
	                if(i-1>=0){  
	                    if(j-1>=0){  
	                        commonSubSqsLen[i][j]=Math.max(commonSubSqsLen[i][j-1],commonSubSqsLen[i-1][j]);  
	                    }else{  
	                        commonSubSqsLen[i][j]=commonSubSqsLen[i-1][j];  
	                    }  
	                }else{  
	                    if(j-1>=0){  
	                        commonSubSqsLen[i][j]=commonSubSqsLen[i][j-1];  
	                    }else{  
	                        commonSubSqsLen[i][j]=0;  
	                    }  
	                }                 
	            }  
	            if(commonSubSqsLen[i][j]>maxLen)  
	                maxLen=commonSubSqsLen[i][j];  
	        }  
	    }  
	   
	    return maxLen;  
	}  
}
