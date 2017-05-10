package xh.socket;

import java.net.InetAddress;

/*
 *   和网络编程有关的基本API位于java.NET包中，该包中包含了基本的网络编程实现，
 *   该包是网络编程的基础。
 *   该包中既包含基础的网络编程类，也包含封装后的专门处理WEB相关的处理类。
 *   在本章中，将只介绍基础的网络编程类。
 */
/**
 *    首先来介绍一个基础的网络类——InetAddress类。
 *    该类的功能是代表一个IP地址，并且将IP地址和域名相关的操作方法包含在该类的内部。
 * @author Administrator
 *b  
 */
public class InetAddressDemo {

	public static void main(String[] args){
		try{
			InetAddress inet1 = InetAddress.getByName("www.baidu.com");
			System.out.println(inet1);
			String hosts = inet1.getHostAddress();
			System.out.println(hosts);
		}catch(Exception e){
			
		}
		
	}
}
