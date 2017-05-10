package xh.javaNIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Java Nio SocketChannel server¶Ë
 * @author Administrator
 *
 */
public class IOSocketcChannelServer {
	public static void main(String[] args){
		IOSocketcChannelServer.server();
	}

	public static void server(){
		ServerSocket serverSocket= null;
		InputStream in = null;
		try {
			serverSocket = new ServerSocket(8088);
			int recvMsgSize = 0;
			byte[] recvBuf = new byte[1024];
			while(true){
				Socket clntSocket = serverSocket.accept();
				SocketAddress clientAddress = clntSocket.getRemoteSocketAddress();
				System.out.println("Handing client at " + clientAddress);
				in = clntSocket.getInputStream();
				while((recvMsgSize = in.read(recvBuf)) != -1){
					byte[] tmp = new byte[recvMsgSize];
					System.arraycopy(recvBuf, 0, tmp, 0, recvMsgSize);
					System.out.println(new String(tmp));
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				if(serverSocket != null){
					serverSocket = null;
				}
				if(in != null){
					in.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
		}
	}
}
