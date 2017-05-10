package concurrent.programming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
 *  Java�������е��ź���Semaphoreʵ������һ��������ϵļ����ź�����
 *  �Ӹ����Ͻ�����ά����һ����ɼ��ϣ��Կ���һ����Դ��������������ź���Ҫ�����塣
 *  Semaphore���Կ���ĳ����Դ��ͬʱ���ʵ�����������ͨ��acquire������ȡһ����ɣ�release�����ͷ�һ����ɡ�
 *  �����ͬʱ���ʵ�������������������acquire���������ȴ�״̬��ֱ����һ������release���������ܵõ���ɡ�
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
						System.out.println("�߳�" +   
			                        Thread.currentThread().getName() + "�����ɣ�"  + num);  
			            //ģ���ʱ������  
			            for (int i = 0; i < 999999; i++) ;  
			            //�ͷ����  
			            sm.release();
			            System.out.println("�߳�" +   
		                        Thread.currentThread().getName() + "�ͷ���ɣ�"  + num);  
		               System.out.println("��ǰ�����������������" +  
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
