package xh.javaNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class NIODatagramChannelClient {
	public static void main(String[] args){
		sendUDP();
	}

	public static void sendUDP(){
		DatagramChannel channel;
		try{
			String newData = "New String to write to file .. "+ System.currentTimeMillis();
			
			ByteBuffer buf = ByteBuffer.allocate(48);
			buf.clear();
			buf.put(newData.getBytes());
			buf.flip();
			
			channel = DatagramChannel.open();
			channel.configureBlocking(false);
			int bytesSent = channel.send(buf, new InetSocketAddress("115.156.162.102",80));
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
}
