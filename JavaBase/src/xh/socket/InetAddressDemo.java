package xh.socket;

import java.net.InetAddress;

/*
 *   ���������йصĻ���APIλ��java.NET���У��ð��а����˻�����������ʵ�֣�
 *   �ð��������̵Ļ�����
 *   �ð��мȰ����������������࣬Ҳ������װ���ר�Ŵ���WEB��صĴ����ࡣ
 *   �ڱ����У���ֻ���ܻ������������ࡣ
 */
/**
 *    ����������һ�������������ࡪ��InetAddress�ࡣ
 *    ����Ĺ����Ǵ���һ��IP��ַ�����ҽ�IP��ַ��������صĲ������������ڸ�����ڲ���
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
