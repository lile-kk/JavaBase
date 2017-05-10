package xh.collection.sort;

import java.util.LinkedList;

public class test {

	public static void main(String[] args){
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addLast(7);
		while(ll.getFirst()!=null){
			System.out.println(ll.removeFirst());
		}
	}
}
