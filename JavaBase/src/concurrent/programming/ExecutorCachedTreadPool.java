package concurrent.programming;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Executorִ��Runnable����
    ͨ��Executors�������ĸ���̬����������� ExecutorServiceʵ����
    ������ø�ʵ����execute��Runnable command���������ɡ�
    һ��Runnable���񴫵ݵ�execute�����������÷�������Զ���һ���߳���ִ�С�
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
		//ִ��callable����
		List<Future<String>> list = new ArrayList<Future<String>>();
		
		//����10������ִ��
		for(int i = 0; i < 10; i++){
			Future<String> future= executorService.submit(new TaskWithResult(i));
			list.add(future);
		}
		
		//����������
		for (Future<String> future : list) {
			try {
				while(!future.isDone());//future�������û����ɣ���ѭ���ȴ���֪��future���
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
     * ����ľ�����̣�һ�����񴫸�ExecutorService��submit������ 
     * ��÷����Զ���һ���߳���ִ�� 
     */   
	public String call(){
		System.out.println("call()�������Զ����ã�����" + Thread.currentThread().getName());
		//�÷��ؽ����Future��get�����õ�
		return "call()�������Զ����ã����񷵻صĽ���ǣ� " + id + " " + Thread.currentThread().getName();
	}
	
}

class TestRunnable implements Runnable{
	public void run(){
		System.out.println(Thread.currentThread().getName()+"�̱߳�������");
	}
}