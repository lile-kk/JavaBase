package xh.javaNIO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Java NIO �ܵ���2���߳�֮��ĵ����������ӡ�
 * Pipe��һ��sourceͨ����һ��sinkͨ����
 * ���ݻᱻд��sinkͨ������sourceͨ����ȡ��
 * @author Administrator
 *
 */
public class NIOPipe {
	
	public static void main(String[] args){
		methodPipe();
	}

	public static void methodPipe(){
		Pipe pipe = null;
		ExecutorService exec = Executors.newFixedThreadPool(2);
		try{
			pipe = Pipe.open();
			final Pipe pipeTemp = pipe;
			exec.submit(new Callable<Object>() {

				@Override
				public Object call() throws Exception {
					Pipe.SinkChannel sinkChannel = pipeTemp.sink();//��ͨ����д����
					while(true){
						TimeUnit.SECONDS.sleep(1);
						String newData = "Pipe Test At time " + System.currentTimeMillis();
						ByteBuffer buf = ByteBuffer.allocate(1024);
						buf.clear();
						buf.put(newData.getBytes());
						buf.flip();
						
						while(buf.hasRemaining()){
							System.out.println(buf);
							sinkChannel.write(buf);
						}
					}
				}
				
			});
			exec.submit(new Callable<Object>() {

				@Override
				public Object call() throws Exception {
					Pipe.SourceChannel sourceChannel = pipeTemp.source();//��ͨ���ж�����
					while(true){
						TimeUnit.SECONDS.sleep(1);
						ByteBuffer buf = ByteBuffer.allocate(1024);
						buf.clear();
						int byteRead = sourceChannel.read(buf);
						System.out.println("bytesRead = " + byteRead);
						while(byteRead > 0){
							buf.flip();
							byte[] b = new byte[byteRead];
							int i = 0;
							while(buf.hasRemaining()){
								b[i] = buf.get();
								System.out.printf("%X",b[i]);
								i++;
							}
							String s = new String(b);
							System.out.println("==============" + s);
							byteRead = sourceChannel.read(buf);
						}
					}
				}
				
			});
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			exec.shutdown();
		}
	}
}
