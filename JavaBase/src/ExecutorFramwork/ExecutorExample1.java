package ExecutorFramwork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample1 {

	public static int a=  0;
	public int c = 0;
	public void f(){
		int b = a;
	}
	public static void main(String[] args){
		ExecutorService exec = Executors.newFixedThreadPool(2);
		for(int i = 0; i < 5; i++){
			exec.execute(new MyThread(i));
		}
		exec.shutdown();
	}
}

class MyThread implements  Runnable {
	private int number;
	public MyThread(int num){
		this.number = num;
		System.out.println("Create Thread: " + number);
	}
	public void run(){
		System.out.println("Thread: " + number + " is running");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Thread: " + number + " end");
	}
}