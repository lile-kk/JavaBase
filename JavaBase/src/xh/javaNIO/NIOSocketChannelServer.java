package xh.javaNIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * TCP服务端代码改写成NIO的方式
 * @author Administrator
 * Java NIO中的 ServerSocketChannel 是一个可以监听新进来的TCP连接的通道,
 *  就像标准IO中的ServerSocket一样。
 *  ServerSocketChannel类在 java.nio.channels包中。
 *
 */

public class NIOSocketChannelServer {
	private static final int BUF_SIZE = 1024;
	private static final int PORT = 8080;
	private static final int TIMEOUT = 3000;
	
	public static void main(String[] args){
		selector();
	}
	public static void handleAccept(SelectionKey key)throws IOException{
		ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
		SocketChannel sc = ssChannel.accept();
		sc.configureBlocking(false);
		sc.register(key.selector(), SelectionKey.OP_READ,ByteBuffer.allocateDirect(BUF_SIZE));
		
	}
	
	public static void handleRead(SelectionKey key) throws IOException{
		SocketChannel sc = (SocketChannel)key.channel();
		ByteBuffer buf = (ByteBuffer)key.attachment();
		long bytesRead = sc.read(buf);
		while(bytesRead > 0){
			buf.flip();
			while(buf.hasRemaining()){
				System.out.print((char)buf.get());
			}
			System.out.println();
			buf.clear();
			bytesRead = sc.read(buf);
		}
		if(bytesRead == -1){
			sc.close();
		}
	}
	
	public static void handleWriter(SelectionKey key) throws IOException{
		ByteBuffer buf = (ByteBuffer)key.attachment();
		buf.flip();
		SocketChannel sc = (SocketChannel)key.channel();
		while(buf.hasRemaining()){
			sc.write(buf);
		}
		buf.compact();
		
	}
	
	public static void selector(){
		Selector selector = null;
		ServerSocketChannel ssc = null;
		try{
			selector = Selector.open();
			ssc = ServerSocketChannel.open();
			ssc.socket().bind(new InetSocketAddress(PORT));
			ssc.configureBlocking(false);
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			
			while(true){
				if(selector.select(TIMEOUT) == 0){
					System.out.println("==");
					continue;
				}
				Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
				while(iter.hasNext()){
					SelectionKey key = iter.next();
					if(key.isAcceptable()){
						handleAccept(key);
					}
					if(key.isReadable()){
						handleAccept(key);
					}
					if(key.isWritable()&&key.isValid()){
						handleWriter(key);
					}
					if(key.isConnectable()){
						System.out.println("isConnectable = true");
					}
					iter.remove();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(selector != null){
					selector.close();
				}
				if(ssc != null){
					ssc.close();
				}
			}catch(IOException e1){
				e1.printStackTrace();
			}
		}
	}
	
}
