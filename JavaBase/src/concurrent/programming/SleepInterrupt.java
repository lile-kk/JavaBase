package concurrent.programming;

import static java.lang.System.out;
/*
 * 休眠线程的中断
 */
public class SleepInterrupt extends Object implements Runnable{

	public void run(){
		
		try {
			out.println("in run()");
			Thread.sleep(2000);
			out.println("in run -woke up");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			out.println("in run - intterpt while sleeping");
			//return;
		}
		out.println("in run() - leaving normaly");
		
	}
	
	public static void main(String[] args){
		/**
		SleepInterrupt si = new SleepInterrupt();
		Thread t = new Thread(si);
		t.start();
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		out.println("in main()");
		t.interrupt();
		out.println("in main()-leaving");
		*/
		//使用isInterrupt()方法判断中断状态
		Thread t = Thread.currentThread();
		out.println("Point A: t.isInterrupted = " + t.isInterrupted());
		//待决中断，中断自身
		t.interrupt();
		out.println("Point B: t.isInterrupted = " + t.isInterrupted());
		out.println("Point C: t.isInterrupted = " + t.isInterrupted());
		
		try{
			Thread.sleep(2000);
			out.println("was Not interrupted");
		}catch(InterruptedException e){
			out.println("was interrupted");
		}
		out.println("Point C: t.isInterrupted = " + t.isInterrupted());
	}
}

//
