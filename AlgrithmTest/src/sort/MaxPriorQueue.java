package sort;

public interface MaxPriorQueue<Key extends Comparable<Key>> {
	public void insert(Key v);
	public Key max();
	public Key delMax();
	boolean isEmpty();
	public int size();
	
}
