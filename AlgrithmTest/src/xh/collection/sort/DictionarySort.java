package xh.collection.sort;
/**
 * 将整数按字典排序
 * @author Administrator
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class  DictionarySort {
	static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

	public static void main(String[] args) throws IOException {
		long n = nextLong(), m = nextLong();
		long result = rec(0, n + 1, m);
		System.out.println(result);
	}

	/**
	 * @param current
	 * @param top:
	 *            < top
	 * @param rank
	 * @return
	 */
	static long rec(long current, long limit, long rank) {
		// System.out.println(current + "," + limit + "," + rank);
		if (rank == 0)
			return current;
		rank -= 1;
		long digit = 1, next = -1;
		for (digit = 0; digit < 10; digit++) {
			if (current == 0 && digit == 0)
				continue;
			next = current * 10 + digit;
			long base = 1;
			long gap = 0;
			while (true) {
				long lower = next * base;
				long upper = (next + 1) * base;
				if (limit <= lower)
					break;
				gap += Math.min(upper, limit) - lower;
				base = base * 10;
			}
			// System.out.println(rank + " bi " + gap);
			if (rank < gap)
				break;
			rank -= gap;
		}
		return rec(next, limit, rank);
	}

	static long nextLong() throws IOException {
		in.nextToken();
		return (long) in.nval;
	}
}