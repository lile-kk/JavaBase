package xh.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 网络编程客户端，通过socket创建
 */
public class SocketClient {

	public static void main(String[] args){
		try {
			Socket socket = new Socket("127.0.0.1", 8000);
			OutputStream out = socket.getOutputStream();
			String data = "hello,I'm client";
			out.write(data.getBytes());
			byte[] b = new byte[1024];
			InputStream in = socket.getInputStream();
			in.read(b);
			System.out.println(new String(b));
			
			in.close();
			out.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
