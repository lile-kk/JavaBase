package concurrent.programming;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Executor执行Runnable任务
    通过Executors的以上四个静态工厂方法获得 ExecutorService实例，
    而后调用该实例的execute（Runnable command）方法即可。
    一旦Runnable任务传递到execute（）方法，该方法便会自动在一个线程上执行。
 */
public class ExecutorCachedTreadPool {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		/**
		 * 
		
		for(int i = 0; i < 5; i++){
			executorService.execute(new TestRunnable());
			//Thread.sleep(500);
			System.out.println("************** a" + i + " ************");
		}
		executorService.shutdown();
		 */
		//执行callable任务
		List<Future<String>> list = new ArrayList<Future<String>>();
		
		//创建10个任务并执行
		for(int i = 0; i < 10; i++){
			Future<String> future= executorService.submit(new TaskWithResult(i));
			list.add(future);
		}
		
		//遍历任务结果
		for (Future<String> future : list) {
			try {
				while(!future.isDone());//future返回如果没有完成，则循环等待，知道future完成
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}catch(ExecutionException e){
				e.printStackTrace();
			}finally{
				executorService.shutdown();
			}
		}
	}
}

class TaskWithResult implements Callable<String>{
	private int id;
	public TaskWithResult(int id){
		this.id = id;
	}
	/**  
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法， 
     * 则该方法自动在一个线程上执行 
     */   
	public String call(){
		System.out.println("call()方法被自动调用！！！" + Thread.currentThread().getName());
		//该返回结果被Future的get方法得到
		return "call()方法被自动调用，任务返回的结果是： " + id + " " + Thread.currentThread().getName();
	}
	
}

class TestRunnable implements Runnable{
	public void run(){
		System.out.println(Thread.currentThread().getName()+"线程被调用了");
	}
}