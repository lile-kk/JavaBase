package xh.javaNIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
 * ʹ��FileChannel��ȡ�ļ�
 */

public class FileChannelDemo {
	
	public static void main(String[] args){
		//FileChannelDemo.method();
		FileChannelDemo.method1();
	}

	//����NIOͨ��RandomAccessFile���в���
	public static void method1(){
		RandomAccessFile aFile= null;
		
		try {
			aFile= new RandomAccessFile("F:\\a.txt", "rw");
			FileChannel fileChannel = aFile.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			int byteRead = fileChannel.read(buf);
			System.out.println(byteRead);
			
			while(byteRead != -1){
				buf.flip();
				while(buf.hasRemaining()){
					System.out.print((char)buf.get());
				}
				buf.compact();
				byteRead = fileChannel.read(buf);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(aFile != null ){
					aFile.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
	
	//���ô�ͳIO��ȡ�ļ�
	public static void method(){
		InputStream in = null;
		try {
			in= new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\DMCompetition\\�ڱ�Ԥ��\\prediction_example.csv"));
			
			byte[] buf = new byte[1024];
			int bytesRead = in.read(buf);
			while(bytesRead != -1){
				for(int i = 0;i< bytesRead;i++){
					System.out.print((char)buf[i]);
				}
				bytesRead = in.read(buf);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(in != null){
					in.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
