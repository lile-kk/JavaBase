package xh.concurrentThread;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


//java多线程学习,创建线程后，调用start()方法即可执行

/*
 * 扩展java.lang.Thread类，Thread类也实现了Runnable接口
 * 继承类必须重写run()方法，该方法是新线程入口点，也必须调用start()方法才能执行。
 */
class ThreadBase extends Thread{
	private String name;
	public ThreadBase(String name){
		this.name = name;
	}
	
	public void run(){
		for(int i = 0;i < 50;i++){
			System.out.println(name + "运行 ： " + i);
			if(i== 30){
				this.yield();
			}
//			try{
//				sleep(10);
//			}catch(InterruptedException e){
//				e.printStackTrace();
//				
//			}
		}
	}
	
}

/*
 * 实现java.lang.Runnable接口
 */
class ThreadRunnable implements Runnable{
	private String name;
	
	 public ThreadRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0;i < 5;i++){
			System.out.println(name + "运行 ： "+i);
			try{
				Thread.sleep((int)Math.random()*10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
}

/*
 * 测试wait(),notify()
 */
class ThreadWait implements Runnable{
	
	private String name;
	private Object pre;
	private Object self;
	
	public ThreadWait(String name,Object pre,Object self){
		this.name = name;
		this.pre = pre;
		this.self = self;
	}
	
	public void run(){
		int count = 5;
		while(count > 0){
			synchronized (pre) {
				synchronized(self){
					System.out.print(name);
					count--;
					
					self.notify();
				}
				try {
					pre.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}


/*
 *通过Callable和Future创建线程
 *1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。
2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。
3. 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。
 */

class CallableThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int i = 0;
		for(;i < 50;i++){
			System.out.println(Thread.currentThread().getName() + " " +i);
		}
		return null;
	}
	
}

public class Main{
	public static void main(String[] args) throws InterruptedException{
//		new Thread(new ThreadRunnable("c")).start();
//		new Thread(new ThreadRunnable("D")).start();
//		new ThreadBase("C").start();
//		new ThreadBase("D").start();
		
//		//使用callable创建线程
//		CallableThread callTh = new CallableThread();
//		FutureTask<Integer> ft = new FutureTask<Integer>(callTh);
//		for(int i = 0 ;i < 50;i++){
//			System.out.println(Thread.currentThread().getName()+"的循环变量i的值" + i);
//			if(i == 20){
//				new Thread(ft,"有返回值的线程").start();
//			}
//		}
//		
//		try{
//			System.out.println("子线程的返回值："+ft.get());
//		}catch(InterruptedException e){
//			e.printStackTrace();
//		}catch (ExecutionException e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
		
		
/**
 * 

	//测试锁
	Object a = new Object();
	Object b = new Object();
	Object c = new Object();
	
	ThreadWait tw1 = new ThreadWait("A", b, a);
	ThreadWait tw2 = new ThreadWait("B", c, b);
	ThreadWait tw3 = new ThreadWait("C", a,c);
	
	new Thread(tw1).start();
	Thread.sleep(100);
	new Thread(tw2).start();
	Thread.sleep(100);
	new Thread(tw3).start();
	Thread.sleep(100);
	
	 */
	
		List<OOMobject> list= new ArrayList<OOMobject>();
		while(true){
			list.add(new OOMobject());
		}

		
	}
	
	static class OOMobject{}
	
}
