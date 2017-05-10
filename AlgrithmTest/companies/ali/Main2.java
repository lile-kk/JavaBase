package ali;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int[] res;
		String doc = in.nextLine();
		int m = in.nextInt();
		int n = in.nextInt();
		in.nextLine();
		String[] filter = new String[m];
		String[] count = new String[n];
		int i = 0;
		while(i < m){
			filter[i++] = in.nextLine();
		}
		i= 0;
		while(i < n){
			count[i++] = in.nextLine();
		}
		int[] result = wordCount(doc, m, n, filter, count);
		for (int j : result) {
			System.out.println(j);
		}
		
	}
	
	public static int[] wordCount(String doc, int m, int n, String[] filter, String[] count){
		int[] res = new int[n];
		//判断过滤词是否有包含，如果有，则删除，用一个Treemap存结果
		ArrayList<String> filterTmp = new ArrayList<String>();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < m;j++){
				if( j!= i)
					if(getIndexOf(filter[i], filter[j]) != -1){
					filter[i] = null;
				}
			}
		}
		for(int i = 0; i < m; i++){
			if(filter[i] != null){
				filterTmp.add(filter[i]);
			}
		}
		
		//用一个数组存filter中对应的匹配的子串的下标位置
//		int m1 = filterTmp.size();
//		int[] arrfilter = new int[m1];
//		int index = 0;
//		for (String s : filterTmp) {
//			arrfilter[index++] = getIndexOf(doc, s); 
//		}
		
		ArrayList<String> out = new ArrayList<String>();
		split(doc, out, filterTmp);
		System.out.print(out.size());
		
		for(int i = 0;i < n; i++){
			for(int j = 0; j < out.size();j++){
				if(getIndexOf(out.get(j), count[i])!= -1)
					res[i] ++;
			}
		}
		return res;
	
		
		
	}
	
	public static void split(String doc,ArrayList<String> out,ArrayList<String> filter){
		int[] result = getIndex(doc, filter);
		if(result[1] == 100000){
			return;
		}else{
			out.add(doc.substring(0, result[1]));
			split(doc.substring(result[1] + filter.get(result[0]).length(), doc.length()), out, filter);
		}
	}
	
	
	//获取字符串的截取的下标位置
	public static int[] getIndex(String str,ArrayList<String> filter){
		int min = 100000 ;
		String fil = null;
		int index = -1;
		int[] result = new int[2];
		for(int i = 0; i < filter.size(); i++){
			fil = filter.get(i);
			index = getIndexOf(str, fil);
			if(index != -1)
				if(min > index)
				{
					result[0] = i;
					result[1] = min;
				}
		}
		return result;
	}
	
	public static int[] getNextArray(char[] ms){
		if(ms.length == 1){
			return new int[] {-1};
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;//cn为next[pos-1]的值
		while(pos < ms.length){
			if(ms[pos - 1] == ms[cn]){
				next[pos++] = ++cn;
			}else if(cn > 0){
				cn = next[cn];
			}else {
				next[pos++] = 0;
			}
			
		}
		return next;
	}
	
	public static int getIndexOf(String s, String m){
		if(s== null||m==null||m.length() < 1 || s.length() < m.length()){
			return -1;
		}
		char[] strArr = s.toCharArray();
		char[] matchArr = m.toCharArray();
		int si = 0;//记录str移动到的位置
		int mi = 0;// 记录match匹配到的位置
		int[] next = getNextArray(matchArr);
		while(si < strArr.length && mi < matchArr.length){
			if(strArr[si] == matchArr[mi]){
				si++;
				mi++;
			}else if(next[mi] == -1){
				si++;
			}else {
				mi = next[mi];
			}
		}
		return mi == matchArr.length  ? si - mi : -1;
	}
	
}
