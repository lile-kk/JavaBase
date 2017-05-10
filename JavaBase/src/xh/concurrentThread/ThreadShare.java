package xh.concurrentThread;

/**
 * 用Runnable接口实现线程之间数据共享
 * @author Administrator
 *
 */
public class ThreadShare {

	public static void main(String[] args){
		Thread1 runTh = new Thread1();
		
		new Thread(runTh,"A").start();
		new Thread(runTh,"B").start();
		new Thread(runTh,"C").start();
		
	}
	
}

class Thread1 implements Runnable{
	private int count = 50;
	private String threadName;
	
	

	@Override
	public void run() {
		for(int i = 0;i < 5;i++){
			System.out.println(Thread.currentThread().getName() + " count值为 ： "+count);
			count--;
			try {
				Thread.sleep((int)Math.random()*100);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
	}
	
}