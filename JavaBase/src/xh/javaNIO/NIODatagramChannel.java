package xh.javaNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;

/**
 * Java NIO�е�DatagramChannel��һ�����շ�UDP����ͨ����
 * ��ΪUDP�������ӵ�����Э�飬���Բ���������ͨ��������ȡ��д�롣
 * �����ͺͽ��յ������ݰ���
 * @author Administrator
 *
 */
public class NIODatagramChannel {
	public static void main(String[] args){
		DatagramChannel channel;
		try {
			channel = DatagramChannel.open();
			channel.socket().bind(new InetSocketAddress(80));
			ByteBuffer buf = ByteBuffer.allocate(48);
			buf.clear();
			//receive()�����Ὣ���յ������ݰ����ݸ��Ƶ�ָ����Buffer.
			//���Buffer�ݲ����յ������ݣ���������ݽ���������
			channel.receive(buf);
			while(buf.hasRemaining()){
				System.out.println(buf.getChar());
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
