package concurrent.programming;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 生产者-消费者改为条件变量实现
 */
public class ProducerConsumerWithLocks {

	public static void main(String[] args){
		Info1 info= new Info1();
		Producer1 pro = new Producer1(info);
		Consumer1 con = new Consumer1(info);
		
		new Thread(pro).start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		new Thread(con).start();
	}
}

class Info1{
	private String name = "name";
	private String content = "content";
	private boolean flag = true;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public void set(String name,String content) {
		lock.lock();
		try {
			while(!flag)
				condition.await();
			this.setName(name);
			Thread.sleep(500);
			this.setContent(content);
			flag = false;
			condition.signal();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void get(){
		lock.lock();
		try{
			while(flag)
				condition.await();
			Thread.sleep(500);
			System.out.println(this.getName() + " --> " + this.getContent());
			flag = true;
			condition.signal();
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	 public void setName(String name){  
	        this.name = name ;  
	    }  
	    public void setContent(String content){  
	        this.content = content ;  
	    }  
	    public String getName(){  
	        return this.name ;  
	    }  
	    public String getContent(){  
	        return this.content ;  
	    }  
}

class Producer1 implements Runnable{
	private Info1 info= null;
	public Producer1(Info1 info){
		this.info = info;
	}
	public void run(){
		boolean flag = true;
		for(int i = 0; i < 10; i++){
			if(flag){
				 this.info.set("姓名--1","内容--1") ;    // 设置名称  
	                flag = false ;  
	            }else{  
	                this.info.set("姓名--2","内容--2") ;    // 设置名称  
	                flag = true ;  
	            }  
		}
	}
}

class Consumer1 implements Runnable{
	private Info1 info= null;
	
	public Consumer1(Info1 info){
		this.info = info;
	}
	
	public void run(){
		for(int i = 0; i < 10; i++){
			this.info.get();
		}
	}
}