package xh.collection.linklist;

import java.util.LinkedList;
import java.util.Stack;

import javax.management.RuntimeErrorException;

public class Demo {

	public static void main(String[] args) {
		

	}
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();//±£´æÄæÐò
	public void push(int node) {
	    stack1.push(node);
	}

	public int pop() {
		if(stack1.isEmpty()){
			throw new RuntimeErrorException(null, "Stack is empty");
		}else if (stack2.isEmpty()) {
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
		
		
	}
	
}


