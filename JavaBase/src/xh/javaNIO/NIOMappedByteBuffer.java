package xh.javaNIO;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ͨ������ByteBuffer��MappedByteBuffer�ֱ��ȡ��СԼΪ5M���ļ���src/1.ppt�����Ƚ�����֮�������
 * method3()�ǲ���MappedByteBuffer��ȡ�ģ�method4()��Ӧ����ByteBuffer��
 * @author Administrator
 *
 */
public class NIOMappedByteBuffer {
	
	public static void main(String[] args){
		methodByteBuffer();
		System.out.println("=======================");
		methodMappedByteBuffer();
	}

	public static void methodByteBuffer(){
		RandomAccessFile aFile = null;
		FileChannel fc = null;
		try{
			aFile = new RandomAccessFile("F:\\b.txt", "rw");
			fc = aFile.getChannel();
			long timeBegin = System.currentTimeMillis();
			ByteBuffer buf = ByteBuffer.allocate((int)aFile.length());
			buf.clear();
			fc.read(buf);
			System.out.println((char)buf.get((int)(aFile.length()/2 - 1)));
			long timeEnd = System.currentTimeMillis();
			System.out.println("Read time : " + (timeEnd -timeBegin));
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(aFile != null){
					aFile.close();
				}
				if(fc != null){
					fc.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
	
	//��MappedByteBuffer
	public static void methodMappedByteBuffer(){
		RandomAccessFile aFile = null;
		FileChannel fc = null;
		try {
			aFile = new RandomAccessFile("F:\\b.txt", "rw");
			fc= aFile.getChannel();
			
			long timeBegin = System.currentTimeMillis();
			MappedByteBuffer mappedbuf = fc.map(FileChannel.MapMode.READ_ONLY, 0, aFile.length());
			System.out.println((char)mappedbuf.get((int )(aFile.length() / 2 -1)));
			long timeEnd = System.currentTimeMillis();
			System.out.println("Read Time with MappedByteBuffer " + (timeEnd - timeBegin));
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				if(aFile != null){
					aFile.close();
				}
				if(fc != null){
					fc.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
}
