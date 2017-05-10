package sort;

import java.util.Collection;

/*
 * ѡ������
 */
/**
public class Selection extends Example {

	public static void sort(Comparable[] a)
	{
		//a[]����������
		int N = a.length;
		for( int i = 0;i < N;i++)
		{
			int min = i;
			for(int j = i + 1;j < N;j++)
			{
				if(less(a[j],a[min]))
					min = j;
			}
			exch(a, i, min);
		}
	}
}

class Insertion extends Example{
	public static void sort(Comparable[] a)
	{
		//a[]����������
		int N = a.length;
		for(int i = 1 ; i< N ;i++)
		{
			for(int j = i;j > 0 && less(a[j],a[j-1]);j--)
				exch(a, j, j-1);
		}
	}
	
}

class Shell extends Example{
	public static void sort(Comparable[] a){
		//a[]����������
		int N = a.length;
		int h =1;
		while(h < N/3)
			h = h*3 + 1;
		while(h >=1){
			//��������h����
			for(int i = h;i < N;i++){
				for(int j = i;j >=h && less(a[j],a[j-h]);j -=h )
					exch(a, j, j-h);
			}
			h = h/3;
		}
	}
}

class Merge extends Example{
	//ԭ�س���鲢
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		int  i = lo;
		int j = mid+1;
		Comparable[] aux = new Comparable[hi+1];
		for (int k = lo; k < hi;k++)
			aux[k] = a[k];
		for(int k = lo;k < hi;k++){
			if(i > mid)
				a[k] = aux[k++];
			if(j > hi)
				a[k] = aux[i++];
			if(less(aux[j],aux[i]))
				a[k] = aux[j++];
			else 
				a[k] = aux[i++];
		}
		
		
		
	}
	
	
}

//�Զ����¹鲢����
class MergeUB extends Merge{
	private static Comparable[] aux;
	public static void sort(Comparable[] a)
	{
		aux = new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a,lo,mid);
		sort(a,mid + 1,hi);
		merge(a,lo,mid,hi);
	}
}

//�Ե����ϵĹ鲢����
class MergeBU extends Merge{
	private static Comparable[] aux;
	public static void sort(Comparable[] a){
		//����lgN�������鲢
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1;sz < N;sz = sz + sz){
			for(int lo = 0;lo < N - sz;lo += sz + sz){
				merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
			}
		}
	}
}

//��������
class Quick extends Example{
	public static void sort(Comparable[] a){
		//StdRandom.shuffle(a);
		sort(a,0,a.length-1);
		
	}
	
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a,lo,j-1);//����벿������
		sort(a,j+1,hi);//���а벿������
	}
	//�����з�
	public static int partition(Comparable[] a,int lo,int hi){
		//�������з�Ϊa[lo,...i-1],a[i],a[i+1..hi]
		 int i = lo,j = hi + 1;
		 Comparable v = a[lo];
		 while(true){
			 while(less(a[++i],v)) 
				 if(i == hi)
					 break;
			 while(less(v,a[--j]))
				 if(j == lo)
					 break;
			 if(j<=i)
				 break;
			 exch(a, i, j);
		 }
		 
		 exch(a, lo, j);
		 return j;
		 
	}
}
*/