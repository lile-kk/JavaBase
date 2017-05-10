package concurrent.programming;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
 *    CyclicBarrier���ֽ��ϰ�����ͬ����Java 5�м���������ԣ�
 *    ʹ��ʱ��Ҫ����Java.util.concurrent.CylicBarrier��
 *    ������������һ���������ϣ������һ���������ǲ�����ִ�й�����
 *    �����һ����������һ�����񲢷�ִ�н���ǰһֱ�����ȴ���
 *    ֱ����������ȫ��ִ�н������������ŵ���ִ�С�
 */
public class CyclicBarrierTest {

	public static void main(String[] args){
		CyclicBarrier cb = new CyclicBarrier(5, new MainTask());
		new SubTask("A", cb).start();
		new SubTask("B", cb).start();
		new SubTask("C", cb).start();
		new SubTask("D", cb).start();
		new SubTask("E", cb).start();
		
	}
}

class MainTask implements Runnable{
	public void run(){
		System.out.println("...The last task.......");
	}
}

class SubTask extends Thread{
	private String name;
	private CyclicBarrier cb;
	
	public SubTask(String name,CyclicBarrier cb) {
		this.name = name;
		this.cb = cb;
	}
	
	public void run(){
		System.out.println("��������" + name + "��ʼִ��");
		for(int i = 0; i<10000000;i++);
		System.out.println("��������" + name + "ִ����ɣ�֪ͨ�ϰ���");
		try{
			cb.await();
		}catch(InterruptedException e){
			e.printStackTrace();
		}catch (BrokenBarrierException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}