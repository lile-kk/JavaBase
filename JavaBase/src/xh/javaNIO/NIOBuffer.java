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
 * 使用Buffer读写数据一般遵循以下四个步骤：

	写入数据到Buffer
	调用flip()方法//一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式
	从Buffer中读取数据
	调用clear()方法或者compact()方法
	一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。
	有两种方式能清空缓冲区：调用clear()或compact()方法。clear()方法会清空整个缓冲区。
	compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
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
	 * 注意buffer首先被插入到数组，然后再将数组作为channel.read() 的输入参数。
	 * read()方法按照buffer在数组中的顺序将从channel中读取的数据写入到buffer，
	 * 当一个buffer被写满后，channel紧接着向另一个buffer中写。
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
	
	//两个通道如果有一个是FileChannel，则可以直接传输数据
	//使用FileChannel之前，必须先打开它，但是，我们无法直接打开一个FileChannel，需要通过使用一个InputSteam、outputStream
	//或RandomAccessFile来获取一个FileChannel实例。
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
