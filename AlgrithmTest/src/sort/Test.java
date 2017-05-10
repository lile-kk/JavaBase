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
		
		String fileName = "C:\\Users\\Administrator\\Desktop\\DMCompetition\\口碑预测\\dataset\\result_tmp\\total_table3.txt";
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();
		int i = 1;
		String[] city = ts.cityToArr();
		
		System.out.println("记录行数是： " + city.length);
		
		 
		
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
			
			//循环读取文件的每一行，对需要修改的行进行修改，放入缓冲对象汇总
			
			while((line = br.readLine()) != null){
				String[] parts = line.split(",");
				//将日期转换为星期
				//String week = String.valueOf(ts.weekToNum(ts.getWeek(parts[1])));
				
				//将商品种类转换为数值型
//				int cate1Name = ts.cate1Name(parts[10]);
//				parts[10] = String.valueOf(cate1Name);
//				parts[11] = String.valueOf(ts.cate2Name(parts[11]));
//				parts[12] = String.valueOf(ts.cate3Name(parts[12]));
				
				//转换cityId
				//parts[4] =  String.valueOf(ts.cityId(city, parts[4]));
				//添加是否为国家法定节假日
				String date = parts[1];
				int isHoliday = ts.holiday(date);
				
				//将数据中为空的数据都转换为0
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
				System.out.println("处理到记录行数是 ： " +  i);
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
		
		
		//写回文件
		BufferedWriter bw = null;
		String fileNameOutput =  "C:\\Users\\Administrator\\Desktop\\DMCompetition\\口碑预测\\dataset\\result_tmp\\total_table4.txt";

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
					System.out.println("写完啦,total line: " + i );
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					bw = null;
				}
			}
		}
		
		
		
		
	}
	
	//转换cityID
	//读取文件，将city存入数组
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
				System.out.println( name + " 转换为了 ：" + i);
				break;
			}
			i++;
		}
		return result;
	}

	//转换法定节假日
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
	
	//转换cate1name
	public int cate1Name(String name){
		int result = 0;
		String[] arr = {"美食","购物","休闲娱乐","医疗健康","超市便利店","美发/美容/美甲"};
		
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
	
	
	//转换cate2Name
	public int cate2Name(String name){
		int result = 0;
		String[] arr = {"美容美发","个人护理","火锅","小吃","本地购物","药店","汤/粥/煲/砂锅/炖菜","其他美食","快餐","超市",
				"烧烤","网吧网咖","烘焙糕点","便利店","中餐","休闲茶饮","休闲食品"};
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
	
	//转换cate3Name
	public int cate3Name(String name){
		int result = 0;
		String[] arr = {"","其它烘焙糕点","其它地方菜","湘菜","江浙菜","奶茶","粤菜","蛋糕","西北菜","其它烧烤","其它快餐","川味/重庆火锅",
				"砂锅/煲类/炖菜","台湾菜","冰激凌","熟食","其它休闲食品","咖啡厅","生鲜水果","美食特产","麻辣烫/串串香",
				"香锅/烤鱼","米粉/米线","川菜","中式烧烤","饮品/甜点","西餐","日韩料理","咖啡","东北菜","其它小吃",
				"其它火锅","湖北菜","海鲜","上海本帮菜","闽菜","其他餐饮美食","面包","面点","粥","自助餐","零食",
				"中式快餐","西式快餐"};
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
		case "星期一":
			result = 1;
			break;
		case "星期二":
			result = 2;
			break;
		case "星期三":
			result = 3;
			break;
		case "星期四":
			result = 4;
			break;
		case "星期五":
			result = 5;
			break;
		case "星期六":
			result = 6;
			break;
		case "星期日":
			result = 7;
			break;
		default:
			break;
		}
		return result;
	}
	public String getWeek(String sdate) {  
	    // 再转换为时间  
	     Date date = strToDate(sdate);  
	     Calendar c = Calendar.getInstance();  
	     c.setTime(date);  
	     int hour=c.get(Calendar.DAY_OF_WEEK);  
	     // hour中存的就是星期几了，其范围 1~7  
	     // 1=星期日 7=星期六，其他类推  
	     return new SimpleDateFormat("EEEE").format(c.getTime());  
	 }  
	  
	 public Date strToDate(String strDate) {  
	     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	     ParsePosition pos = new ParsePosition(0);  
	     Date strtodate = formatter.parse(strDate, pos);  
	     return strtodate;  
	 }  
	
}
