package concurrent.programming;

import java.util.concurrent.CountDownLatch;

/*
 * 闭锁的使用案例
 * await指的是当前调用的线程等待
 */
public class CountDownLatchTest {
	
	public void timeTasks(int nThreads,Runnable task)throws InterruptedException{
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		
		for(int i = 0; i < nThreads;i++){
			Thread thread = new Thread(){
				public void run(){
					try {
						startGate.await();
						try{
							task.run();
						}finally{
							endGate.countDown();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			};
			
			thread.start();
		}
		
		long start = System.nanoTime();
		System.out.println("打开闭锁");
		
		startGate.countDown();
		
		endGate.await();
		long end = System.nanoTime();
		System.out.println("闭锁退出，耗时 ： "+(end - start));
	}
	
	public static void main(String[] args)throws InterruptedException{
		CountDownLatchTest test= new CountDownLatchTest();
		test.timeTasks(5, test.new RunnableTask());
	}
	
	class RunnableTask implements Runnable{
		public void run(){
			System.out.println("当前线程为： " + Thread.currentThread().getName());
		}
	}
}

