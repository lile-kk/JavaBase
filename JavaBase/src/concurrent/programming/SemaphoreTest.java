package concurrent.programming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
 *  Java并发包中的信号量Semaphore实际上是一个功能完毕的计数信号量，
 *  从概念上讲，它维护了一个许可集合，对控制一定资源的消费与回收有着很重要的意义。
 *  Semaphore可以控制某个资源被同时访问的任务数，它通过acquire（）获取一个许可，release（）释放一个许可。
 *  如果被同时访问的任务数已满，则其他acquire的任务进入等待状态，直到有一个任务被release掉，它才能得到许可。
 */
public class SemaphoreTest {

	public static void main(String[] args){
		ExecutorService executor = Executors.newCachedThreadPool();
		final Semaphore sm = new Semaphore(5);
		for(int i = 0; i< 10;i++){
			final int num = i;
			Runnable run = new Runnable() {
				
				@Override
				public void run(){
					try{
						sm.acquire();
						System.out.println("线程" +   
			                        Thread.currentThread().getName() + "获得许可："  + num);  
			            //模拟耗时的任务  
			            for (int i = 0; i < 999999; i++) ;  
			            //释放许可  
			            sm.release();
			            System.out.println("线程" +   
		                        Thread.currentThread().getName() + "释放许可："  + num);  
		               System.out.println("当前允许进入的任务个数：" +  
		                        sm.availablePermits());     
			                    
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					
					
				}
			};
			executor.execute(run);
		}
		
		executor.shutdown();
	}
}
