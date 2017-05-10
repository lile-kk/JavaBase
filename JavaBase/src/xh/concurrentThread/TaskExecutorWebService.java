package xh.concurrentThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/*
 * 基于executor的web服务器
 */
public class TaskExecutorWebService {

	private static final int NTHREADS = 100;
	private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);
	
	public static void main(String[] args) throws IOException{
		ServerSocket socket = new ServerSocket(80);
		while(true){
			final Socket connection = socket.accept();
			Runnable task = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("hanle connection");
				}
			};
			exec.execute(task);
		}
	}
}
