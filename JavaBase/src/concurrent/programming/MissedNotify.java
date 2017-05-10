package concurrent.programming;
/*
 *  notify通知的遗漏很容易理解，即threadA还没开始wait的时候，threadB已经notify了，
 *  这样，threadB通知是没有任何响应的，当threadB退出synchronized代码块后，
 *  threadA再开始wait，便会一直阻塞等待，直到被别的线程打断。
 */

import static java.lang.System.out;

public class MissedNotify {
	//对象级别的锁，针对同一个对象
	private Object proceedL;

	
	public MissedNotify(){
		print("in MissedNotify()");
		proceedL = new Object();
	}
	
	public void waitToProceed() throws InterruptedException{
		print("in waitToProceed()--enterd");
		synchronized (proceedL) {
			print("in waitToProceed()-about to wait()");
			proceedL.wait();
			print("in waitToProceed()--back from wait()");
		}
		print("in waitToProceed - leaving");
	}
	
	public void proceed(){
		print("in proceed()--enterd");
		synchronized (proceedL) {
			print("in proceed()-about to notifyAll()");
			proceedL.notifyAll();
			print("in proceed()--back from notifyAll()");
		}
		print("in proceed - leaving");
	}
	
	 private static void print(String msg) {  
	        String name = Thread.currentThread().getName();  
	        out.println(name + ": " + msg);  
	    }  

	 public static void main(String[] args){
		 final MissedNotify mn = new MissedNotify();
		 
		 Runnable runA = new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					mn.waitToProceed();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					print("I'm sleeping");
					e.printStackTrace();
				}
			}
		};
		Thread threadA = new Thread(runA,"ThreadA");
		threadA.start();
		
		Runnable runB = new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(500);
					mn.proceed();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread threadB = new Thread(runB,"ThreadB");
		threadB.start();
		
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){}
		
		//try to interrupt wait
		print("about to invoke interrupt() on threadA");
		threadA.interrupt();
		
		
	 }

}
