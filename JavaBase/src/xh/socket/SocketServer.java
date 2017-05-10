package xh.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args){
		try {
			ServerSocket server = new ServerSocket(8000);
			Socket so = server.accept();
			InputStream in = so.getInputStream();
			byte[] b = new byte[1024];
			in.read(b);
			System.out.println(new String(b));
			OutputStream out = so.getOutputStream();
			out.write("Hello,I already send message".getBytes());
			out.close();
			in.close();
			so.close();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
