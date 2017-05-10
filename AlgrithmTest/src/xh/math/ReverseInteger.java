package xh.math;
/*
 * 7.Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 */
public class ReverseInteger {

	public static void main(String[] args){
		int s = 123;
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(s));
	}
	public int reverse(int x)
	{
	    int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        if ((newResult - tail) / 10 != result)
	        { return 0; }
	        result = newResult;
	        x = x / 10;
	    }

	    return result;
	}
}
