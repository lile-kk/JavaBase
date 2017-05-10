package xh.design.pattern;

import java.security.Signature;

/*
 * 单例模式
 */
//懒汉式单例类.在第一次调用的时候实例化自己
public class Singleton {

	private Singleton(){}
	private static Singleton single = null;
	//静态工厂方法
	public static Singleton getInstance(){
		if(single == null){
			new Singleton();
		}
		return single;
	}
	
	//保证线程安全三种方式，1.加锁
	public static synchronized Singleton getInstance1(){
		if(single == null){
			new Singleton();
		}
		return single;
	}
	
	//2。双重检查锁定
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
	//静态内部类
	private static class LazyHolder{
		private static final Singleton INSTANCE = new Singleton();
	} 
	public static final Singleton getInstance3(){
		return LazyHolder.INSTANCE;
	}
}

//饿汉式单例
 class Singleton1{
	private Singleton1(){}
	private static final Singleton1 single = new Singleton1();
	//静态工厂方法
	public static Singleton1 getInstance(){
		return single;
	}
}
