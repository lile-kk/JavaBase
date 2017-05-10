package xh.javaNIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * ʹ��Buffer��д����һ����ѭ�����ĸ����裺

	д�����ݵ�Buffer
	����flip()����//һ��Ҫ��ȡ���ݣ���Ҫͨ��flip()������Buffer��дģʽ�л�����ģʽ
	��Buffer�ж�ȡ����
	����clear()��������compact()����
	һ�����������е����ݣ�����Ҫ��ջ����������������ٴα�д�롣
	�����ַ�ʽ����ջ�����������clear()��compact()������clear()���������������������
	compact()����ֻ������Ѿ����������ݡ��κ�δ�������ݶ����Ƶ�����������ʼ������д������ݽ��ŵ�������δ�����ݵĺ��档
 * @author Administrator
 *
 */
public class NIOBuffer {

	public static void main(String[] args){
		NIOBuffer nioBuffer = new NIOBuffer();
		nioBuffer.FileChannelTransfer();
		
	}
	
	
	//Scatter/Gather
	/**
	 * ע��buffer���ȱ����뵽���飬Ȼ���ٽ�������Ϊchannel.read() �����������
	 * read()��������buffer�������е�˳�򽫴�channel�ж�ȡ������д�뵽buffer��
	 * ��һ��buffer��д����channel����������һ��buffer��д��
	 */
	public void readScatter(FileChannel channel){
		ByteBuffer header = ByteBuffer.allocate(128);
		ByteBuffer body = ByteBuffer.allocate(1024);
		ByteBuffer[] bufferArr = {header,body};
		try {
			channel.read(bufferArr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����ͨ�������һ����FileChannel�������ֱ�Ӵ�������
	//ʹ��FileChannel֮ǰ�������ȴ��������ǣ������޷�ֱ�Ӵ�һ��FileChannel����Ҫͨ��ʹ��һ��InputSteam��outputStream
	//��RandomAccessFile����ȡһ��FileChannelʵ����
	public void FileChannelTransfer(){
		try{
			RandomAccessFile accessFile = new RandomAccessFile("F:\\a.txt", "rw");
			FileChannel fromChannel = accessFile.getChannel();
			RandomAccessFile toFile = new RandomAccessFile("F:\\b.txt", "rw");
			FileChannel toChannel = toFile.getChannel();
			long position = 0;
			long count = fromChannel.size();
			toChannel.transferFrom(fromChannel, count, position);
			accessFile.close();
			toFile.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	//selector
	public void nioSelect(Channel channel){
		
		try {
			Selector selector = Selector.open();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
