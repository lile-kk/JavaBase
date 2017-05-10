package xh.javaNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Administrator
 *NIO的强大功能部分来自于Channel的非阻塞特性，套接字的某些操作可能会无限期地阻塞。
 *在非阻塞式信道上调用一个方法总是会立即返回。这种调用的返回值指示了所请求的操作完成的程度
 *。例如，在一个非阻塞式ServerSocketChannel上调用accept()方法，
 *如果有连接请求来了，则返回客户端SocketChannel，否则返回null。
 *Java NIO中的SocketChannel是一个连接到TCP网络套接字的通道。可以通过以下2种方式创建SocketChannel：

打开一个SocketChannel并连接到互联网上的某台服务器。
一个新连接到达ServerSocketChannel时，会创建一个SocketChannel。

 */

public class NIOSocketChannel {
	
	public static void main(String[] args){
		NIOSocketChannel.client();
	}

	public static void client(){
		ByteBuffer buffer= ByteBuffer.allocate(1024);
		SocketChannel socketC = null;
		try {
			socketC = SocketChannel.open();
			socketC.configureBlocking(false);
			socketC.connect(new InetSocketAddress("115.156.162.102",8080));
			
			if (socketC.finishConnect()) {
				int i = 0;
				while(true){
					TimeUnit.SECONDS.sleep(1);
					String info = "I'm " + i++ +"-th information from client";
					buffer.clear();
					buffer.put(info.getBytes());
					buffer.flip();
					while(buffer.hasRemaining()){
						System.out.println(buffer);
						socketC.write(buffer);
					}
				}
			}
		} catch (IOException | InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if (socketC != null) {
					socketC.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
}
