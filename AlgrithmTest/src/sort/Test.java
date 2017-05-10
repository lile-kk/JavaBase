package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Date;
import java.util.Deque;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
public class Test {

	public static void main(String[] args){
		Test ts = new Test();
		
		String fileName = "C:\\Users\\Administrator\\Desktop\\DMCompetition\\�ڱ�Ԥ��\\dataset\\result_tmp\\total_table3.txt";
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();
		int i = 1;
		String[] city = ts.cityToArr();
		
		System.out.println("��¼�����ǣ� " + city.length);
		
		 
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
			
			//ѭ����ȡ�ļ���ÿһ�У�����Ҫ�޸ĵ��н����޸ģ����뻺��������
			
			while((line = br.readLine()) != null){
				String[] parts = line.split(",");
				//������ת��Ϊ����
				//String week = String.valueOf(ts.weekToNum(ts.getWeek(parts[1])));
				
				//����Ʒ����ת��Ϊ��ֵ��
//				int cate1Name = ts.cate1Name(parts[10]);
//				parts[10] = String.valueOf(cate1Name);
//				parts[11] = String.valueOf(ts.cate2Name(parts[11]));
//				parts[12] = String.valueOf(ts.cate3Name(parts[12]));
				
				//ת��cityId
				//parts[4] =  String.valueOf(ts.cityId(city, parts[4]));
				//����Ƿ�Ϊ���ҷ����ڼ���
				String date = parts[1];
				int isHoliday = ts.holiday(date);
				
				//��������Ϊ�յ����ݶ�ת��Ϊ0
				int j = 0;
				while(j < parts.length){
					if(parts[j].equals("")){
						parts[j] = String.valueOf(0);
					}
					j++;
				}
				
				
				
				String lineResult = StringUtils.join(parts,",");
				//lineResult = lineResult +","+week +"\n";
				lineResult = lineResult + ","+isHoliday ;
				buf.append(lineResult + "\n");
				i++;
				System.out.println("������¼������ �� " +  i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e2) {
					br = null;
				}
			}
		}
		
		
		//д���ļ�
		BufferedWriter bw = null;
		String fileNameOutput =  "C:\\Users\\Administrator\\Desktop\\DMCompetition\\�ڱ�Ԥ��\\dataset\\result_tmp\\total_table4.txt";

		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileNameOutput) , "UTF-8"));
			bw.write(buf.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bw != null){
				try {
					bw.close();
					System.out.println( i );
					System.out.println("д����,total line: " + i );
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					bw = null;
				}
			}
		}
		
		
		
		
	}
	
	//ת��cityID
	//��ȡ�ļ�����city��������
	public String[] cityToArr(){
		String[] arr = new String[122];
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Administrator\\Desktop\\city_id.csv"),"gbk"));
			
			while((line= br.readLine()) != null){
				arr= line.split(",");
			}
			if(br != null){
				br.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	public int cityId(String[] arr,String name){
		int result = 0;
		int i = 0;
		while(i < arr.length){
			if(name.equals(arr[i])){
				result  = i+1;
				System.out.println( name + " ת��Ϊ�� ��" + i);
				break;
			}
			i++;
		}
		return result;
	}

	//ת�������ڼ���
	public int holiday(String name){
		int result = 0;
		String[] arr = {"2015-09-03","2015-09-04","2015-09-05","2015-09-26","2015-09-27","2015-10-01","2015-10-02",
				"2015-10-03","2015-10-04","2015-10-05","2015-10-06","2015-10-07","2016-01-01","2016-01-02","2016-01-03",
				"2016-02-07","2016-02-08","2016-02-09","2016-02-10","2016-02-11","2016-02-12","2016-02-13","2016-02-07",
				"2016-04-02","2016-04-03","2016-04-04","2016-04-30","2016-05-01","2016-05-02","2016-06-09","2016-06-10",
				"2016-06-11","2016-09-15","2016-09-16","2016-09-17","2016-10-01","2016-10-02",
				"2016-10-03","2016-10-04","2016-10-05","2016-10-06","2016-10-07"};
		
		int i = 0;
		while(i<arr.length){
			if(name.equals(arr[i])){
				result = 1;
				break;
			}
			i++;
		}
		return result;
	}
	
	//ת��cate1name
	public int cate1Name(String name){
		int result = 0;
		String[] arr = {"��ʳ","����","��������","ҽ�ƽ���","���б�����","����/����/����"};
		
		int i = 0;
		while(i<arr.length){
			if(name.equals(arr[i])){
				result = i + 1;
				break;
			}
			i++;
		}
		return result;
	}
	
	
	//ת��cate2Name
	public int cate2Name(String name){
		int result = 0;
		String[] arr = {"��������","���˻���","���","С��","���ع���","ҩ��","��/��/��/ɰ��/����","������ʳ","���","����",
				"�տ�","��������","�決���","������","�в�","���в���","����ʳƷ"};
		int i = 0;
		while(i<arr.length){
			if(name.equals(arr[i])){
				result = i + 1;
				break;
			}
			i++;
		}
		return result;
	}
	
	//ת��cate3Name
	public int cate3Name(String name){
		int result = 0;
		String[] arr = {"","�����決���","�����ط���","���","�����","�̲�","����","����","������","�����տ�","�������","��ζ/������",
				"ɰ��/����/����","̨���","������","��ʳ","��������ʳƷ","������","����ˮ��","��ʳ�ز�","������/������",
				"���/����","�׷�/����","����","��ʽ�տ�","��Ʒ/���","����","�պ�����","����","������","����С��",
				"�������","������","����","�Ϻ������","����","����������ʳ","���","���","��","������","��ʳ",
				"��ʽ���","��ʽ���"};
			int i = 0;
		
			while(i<arr.length){
				if(name.equals(arr[i])){
					result = i + 1;
					break;
				}
				i++;
			}
		
		
		return result;
	}
	
	public int weekToNum(String week){
		int result = 0;
		switch (week) {
		case "����һ":
			result = 1;
			break;
		case "���ڶ�":
			result = 2;
			break;
		case "������":
			result = 3;
			break;
		case "������":
			result = 4;
			break;
		case "������":
			result = 5;
			break;
		case "������":
			result = 6;
			break;
		case "������":
			result = 7;
			break;
		default:
			break;
		}
		return result;
	}
	public String getWeek(String sdate) {  
	    // ��ת��Ϊʱ��  
	     Date date = strToDate(sdate);  
	     Calendar c = Calendar.getInstance();  
	     c.setTime(date);  
	     int hour=c.get(Calendar.DAY_OF_WEEK);  
	     // hour�д�ľ������ڼ��ˣ��䷶Χ 1~7  
	     // 1=������ 7=����������������  
	     return new SimpleDateFormat("EEEE").format(c.getTime());  
	 }  
	  
	 public Date strToDate(String strDate) {  
	     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	     ParsePosition pos = new ParsePosition(0);  
	     Date strtodate = formatter.parse(strDate, pos);  
	     return strtodate;  
	 }  
	
}
