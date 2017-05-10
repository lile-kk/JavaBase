package xh.javaNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Administrator
 *NIO��ǿ���ܲ���������Channel�ķ��������ԣ��׽��ֵ�ĳЩ�������ܻ������ڵ�������
 *�ڷ�����ʽ�ŵ��ϵ���һ���������ǻ��������ء����ֵ��õķ���ֵָʾ��������Ĳ�����ɵĳ̶�
 *�����磬��һ��������ʽServerSocketChannel�ϵ���accept()������
 *����������������ˣ��򷵻ؿͻ���SocketChannel�����򷵻�null��
 *Java NIO�е�SocketChannel��һ�����ӵ�TCP�����׽��ֵ�ͨ��������ͨ������2�ַ�ʽ����SocketChannel��

��һ��SocketChannel�����ӵ��������ϵ�ĳ̨��������
һ�������ӵ���ServerSocketChannelʱ���ᴴ��һ��SocketChannel��

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
