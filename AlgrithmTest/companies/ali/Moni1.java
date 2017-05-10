package ali;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Moni1 {
	 static ArrayList<String> getMatch(String str) {
		 ArrayList<String> res = new ArrayList<String>();
		 String[] arr = str.split(";");
		 int n2 = arr.length;
		 int[][] map = new int[n2][2];
		 for(int i = 0; i < n2; i++){
			 String[] tmp = arr[i].split(":");
			 int key = Integer.valueOf(tmp[0]);
			 int value = Integer.valueOf(tmp[1]);
			 map[i][0] = key;
			 map[i][1] = value;
		 }
		 sort(map);
		 for(int i = 0;i < n2 - 1; i += 2){
			 res.add(map[i][0] + " vs " + map[i + 1][0]);
		 }
		 return res;
		 
		 
		 
	    }

	 public static void sort(int[][] arr) {

	        int j = 0;
	        int[] target = new int[2];
	        for (int i = 1; i < arr.length; i++) {
	            j = i;
	            target[0] = arr[i][0];
	            target[1] = arr[i][1];
	            while (j > 0 && target[1] < arr[j-1][1]) {
	                arr[j][0] = arr[j - 1][0];
	                arr[j][1] = arr[j - 1][1];
	                j--;
	            }
	            arr[j][0] = target[0];
	            arr[j][1] = target[1];
	        }
	    }
	    public static void main(String[] args){

	        String s = new Scanner(System.in).next();  	
	    	ArrayList<String> res = getMatch (s);
	    	
	    	for(int i=0; i<res.size(); i++) {
	            System.out.println(res.get(i));
	        }
	    }
}
