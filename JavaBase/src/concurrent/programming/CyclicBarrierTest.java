package concurrent.programming;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
 *    CyclicBarrier（又叫障碍器）同样是Java 5中加入的新特性，
 *    使用时需要导入Java.util.concurrent.CylicBarrier。
 *    它适用于这样一种情况：你希望创建一组任务，它们并发地执行工作，
 *    另外的一个任务在这一组任务并发执行结束前一直阻塞等待，
 *    直到该组任务全部执行结束，这个任务才得以执行。
 */
public class CyclicBarrierTest {

	public static void main(String[] args){
		CyclicBarrier cb = new CyclicBarrier(5, new MainTask());
		new SubTask("A", cb).start();
		new SubTask("B", cb).start();
		new SubTask("C", cb).start();
		new SubTask("D", cb).start();
		new SubTask("E", cb).start();
		
	}
}

class MainTask implements Runnable{
	public void run(){
		System.out.println("...The last task.......");
	}
}

class SubTask extends Thread{
	private String name;
	private CyclicBarrier cb;
	
	public SubTask(String name,CyclicBarrier cb) {
		this.name = name;
		this.cb = cb;
	}
	
	public void run(){
		System.out.println("并发任务" + name + "开始执行");
		for(int i = 0; i<10000000;i++);
		System.out.println("并发任务" + name + "执行完成，通知障碍器");
		try{
			cb.await();
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch (BrokenBarrierException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}