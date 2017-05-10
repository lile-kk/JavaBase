package jianzhiOffer;

public class FindIn2WeiArray {
	
	public static void main(String[] args){
		//int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		int[][] arr= {{}};
		System.out.print(arr.length);
		System.out.println(arr[0].length);
		//System.out.println(new FindIn2WeiArray().Find(15, arr));
	}

	
	/**
	 * ���ö�ά�������ϵ��£������ҵ����Ĺ��ɣ�
��ôѡȡ���Ͻǻ������½ǵ�Ԫ��a[row][col]��target���бȽϣ�
��targetС��Ԫ��a[row][col]ʱ����ôtarget�ض���Ԫ��a�����е����,
��col--��
��target����Ԫ��a[row][col]ʱ����ôtarget�ض���Ԫ��a�����е��±�,
��row++��
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean Find(int target,int[][] array){
		 int row=0;
	        int col=array[0].length-1;
	        while(row<=array.length-1&&col>=0){
	            if(target==array[row][col])
	                return true;
	            else if(target>array[row][col])
	                row++;
	            else
	                col--;
	        }
	        return false;
	}
	
	public boolean Find1(int target, int [][] array) {
		boolean result = false;
		int row= array.length;
		int column = array[0].length;
		if(row == 0){
			return false;
		}
		if(target < array[0][0] || target > array[row-1][column-1]){
			return false;
		}
		for(int i= 0;i < array.length;i++){
			if(target < array[i][0] || target > array[i][column-1]){
				continue;
			}
			result = partFind(target, array[i], 0, column-1);
			if(result){
				return result;
			}
		}
		
		return result;
		
    }
	public boolean partFind(int target,int[] row,int l,int r){
		boolean result = false;
		if(l <= r){
			
			int mid = (l + r)/2;
			if(target < row[mid]){
				result = partFind(target, row, l, mid -1);
			}else if(target > row[mid]){
				result = partFind(target, row, mid + 1, r);
			}else {
				result= true;
			}
			
		}
		return result;
		
	}
}
