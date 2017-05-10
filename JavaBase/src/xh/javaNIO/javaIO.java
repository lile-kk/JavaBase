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
 * java IO ��������
 */
public class javaIO {
	public static void main(String[] args){
		javaIO jIo= new javaIO();
		String fileName = "F:\\a.txt";
		jIo.bufferedRead();
		
		
	}

	
	//ʹ��FileWrite
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
	//ʹ��FileReader��ȡ�ַ���
	public void fileReader(String fileName){
		try {
			FileReader fr = new FileReader(fileName);
			 //����һ���ַ����顣���ڴ洢�����ַ���
	        //��read(char[])���ص��Ƕ����ַ�������
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
	�ַ���ȡ����������
	�û������ṩ��һ��һ�ζ�һ�еķ��� readLine�������ڶ��ı����ݵĻ�ȡ��
	������nullʱ����ʾ�����ļ�ĩβ��
	readLine�������ص�ʱ��ֻ���ػس���֮ǰ���������ݡ��������ػس�����
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
	
	//�ļ�����
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
			throw new RuntimeException("��дʧ�ܣ�");
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
