package xh.design.pattern;

import java.security.Signature;

/*
 * ����ģʽ
 */
//����ʽ������.�ڵ�һ�ε��õ�ʱ��ʵ�����Լ�
public class Singleton {

	private Singleton(){}
	private static Singleton single = null;
	//��̬��������
	public static Singleton getInstance(){
		if(single == null){
			new Singleton();
		}
		return single;
	}
	
	//��֤�̰߳�ȫ���ַ�ʽ��1.����
	public static synchronized Singleton getInstance1(){
		if(single == null){
			new Singleton();
		}
		return single;
	}
	
	//2��˫�ؼ������
	public static Singleton getInstance2(){
		if(single == null){
			synchronized (Singleton.class) {
				if(single ==null){
					single = new Singleton();
				}
			}
		}
		return single;
	}
	//��̬�ڲ���
	private static class LazyHolder{
		private static final Singleton INSTANCE = new Singleton();
	} 
	public static final Singleton getInstance3(){
		return LazyHolder.INSTANCE;
	}
}

//����ʽ����
 class Singleton1{
	private Singleton1(){}
	private static final Singleton1 single = new Singleton1();
	//��̬��������
	public static Singleton1 getInstance(){
		return single;
	}
}
