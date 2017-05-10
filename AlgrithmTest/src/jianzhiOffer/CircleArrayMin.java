package jianzhiOffer;

public class CircleArrayMin {

	public static void main(String[] args){
		int[] arr = {3,4,5,1,2};
		System.out.print(new CircleArrayMin().minNumberInRotateArray(arr));
	}
	
	 public int minNumberInRotateArray(int [] array) {
	    	int index = 0;
	    	if(array.length == 0){
	    		return 0;
	    	}
	    	for(int i = 0;i < array.length -2;i++){
	    		if(array[i + 1] < array[i]){
	    			index = i+1;
	    		}
	    	}
	    	return array[index];
	    }
}
