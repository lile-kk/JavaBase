package xh.javaNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;

/**
 * Java NIO中的DatagramChannel是一个能收发UDP包的通道。
 * 因为UDP是无连接的网络协议，所以不能像其它通道那样读取和写入。
 * 它发送和接收的是数据包。
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
			//receive()方法会将接收到的数据包内容复制到指定的Buffer.
			//如果Buffer容不下收到的数据，多出的数据将被丢弃。
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
