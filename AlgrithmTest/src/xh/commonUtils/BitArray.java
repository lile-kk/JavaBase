package xh.commonUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;



/**
 * 用byte数组来实现bit数组
 * @author Administrator
 *
 */
public class BitArray {
	public static void main(String[] args){
		Deque<Integer> deque = new LinkedList<Integer>();
		deque.addFirst(1);
		deque.add(2);
		deque.add(3);
		deque.addLast(5);
		System.out.println(deque.getLast());
		
	}
}
