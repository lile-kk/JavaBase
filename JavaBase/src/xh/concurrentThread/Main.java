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


//java���߳�ѧϰ,�����̺߳󣬵���start()��������ִ��

/*
 * ��չjava.lang.Thread�࣬Thread��Ҳʵ����Runnable�ӿ�
 * �̳��������дrun()�������÷��������߳���ڵ㣬Ҳ�������start()��������ִ�С�
 */
class ThreadBase extends Thread{
	private String name;
	public ThreadBase(String name){
		this.name = name;
	}
	
	public void run(){
		for(int i = 0;i < 50;i++){
			System.out.println(name + "���� �� " + i);
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
 * ʵ��java.lang.Runnable�ӿ�
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
			System.out.println(name + "���� �� "+i);
			try{
				Thread.sleep((int)Math.random()*10);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
}

/*
 * ����wait(),notify()
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
 *ͨ��Callable��Future�����߳�
 *1. ���� Callable �ӿڵ�ʵ���࣬��ʵ�� call() �������� call() ��������Ϊ�߳�ִ���壬�����з���ֵ��
2. ���� Callable ʵ�����ʵ����ʹ�� FutureTask ������װ Callable ���󣬸� FutureTask �����װ�˸� Callable ����� call() �����ķ���ֵ��
3. ʹ�� FutureTask ������Ϊ Thread ����� target �������������̡߳�
4. ���� FutureTask ����� get() ������������߳�ִ�н�����ķ���ֵ��
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
		
//		//ʹ��callable�����߳�
//		CallableThread callTh = new CallableThread();
//		FutureTask<Integer> ft = new FutureTask<Integer>(callTh);
//		for(int i = 0 ;i < 50;i++){
//			System.out.println(Thread.currentThread().getName()+"��ѭ������i��ֵ" + i);
//			if(i == 20){
//				new Thread(ft,"�з���ֵ���߳�").start();
//			}
//		}
//		
//		try{
//			System.out.println("���̵߳ķ���ֵ��"+ft.get());
//		}catch(InterruptedException e){
//			e.printStackTrace();
//		}catch (ExecutionException e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
		
		
/**
 * 

	//������
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
