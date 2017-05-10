package xh.javaNIO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * java IO 基本操作
 */
public class javaIO {
	public static void main(String[] args){
		javaIO jIo= new javaIO();
		String fileName = "F:\\a.txt";
		jIo.bufferedRead();
		
		
	}

	
	//使用FileWrite
	public void fileWriter(String fileName){
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write("gbdjughg");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//使用FileReader读取字符流
	public void fileReader(String fileName){
		try {
			FileReader fr = new FileReader(fileName);
			 //定义一个字符数组。用于存储读到字符。
	        //该read(char[])返回的是读到字符个数。
			char[] buf= new char[1024];
			int num = 0;
			while((num = fr.read(buf) )!= -1){
				System.out.print(new String(buf));
			}
			fr.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//BufferedReader
	/*
	字符读取流缓冲区：
	该缓冲区提供了一个一次读一行的方法 readLine，方便于对文本数据的获取。
	当返回null时，表示读到文件末尾。
	readLine方法返回的时候只返回回车符之前的数据内容。并不返回回车符。
	*/
	public void bufferedRead(){
		try {
			FileReader fr = new FileReader("F:\\a.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//文件拷贝
	public void copyFile(){
		
		FileWriter fw = null;
		FileReader fr = null;
		try{
			fw = new FileWriter("F:\\b.txt");
			fr = new FileReader("F:\\a.txt");
			char[] buf = new char[1024];
			int len = 0;
			while((len= fr.read(buf))!= -1){
				fw.write(buf,0,len);
			}
		}catch(IOException e){
			throw new RuntimeException("读写失败！");
		}finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}
