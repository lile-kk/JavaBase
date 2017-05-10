package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class ShopPrediction {
	
	public static void main(String[] args){
		BufferedReader br = null;
		Test ts = new Test();
		String[] city = ts.cityToArr();
		
		String fileName = "C:\\Users\\Administrator\\Desktop\\DMCompetition\\口碑预测\\dataset\\prediction_data.txt";
		
		String line = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			br= new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
			
			while((line= br.readLine())!= null){
				String[] parts = line.split(",");
				/**
				parts[1] = String.valueOf(ts.cityId(city, parts[1]));
				parts[7] = String.valueOf(ts.cate1Name(parts[7]));
				parts[8] = String.valueOf(ts.cate2Name(parts[8]));
				String cate3Name = String.valueOf(0);
				if(parts.length == 10){
					cate3Name = String.valueOf(ts.cate3Name(parts[9]));
				}
				
				int j = 0;
				while(j < parts.length){
					if(parts[j].equals("")){
						parts[j] = String.valueOf(0);
					}
					j++;
				}
						
				String resultLine = parts[0] + "," + parts[1] + "," +parts[2] + "," +parts[3] + "," +parts[4] + "," +
					
						parts[5] + "," +parts[6] + "," +parts[7] + "," +parts[8] + "," +cate3Name+"\n";
				sb.append(resultLine);
				
				*/
				
		
				 
				String resultLine = line;
				String str1 = resultLine + "," + "2" + "," + "0" + "\n";
				sb.append(str1);
				String str2 = resultLine + "," + "3" + "," + "0" + "\n";
				sb.append(str2);
				String str3 = resultLine + "," +"4" +"," + "0" + "\n";
				sb.append(str3);
				String str4 = resultLine + "," +"5" +"," + "0" + "\n";
				sb.append(str4);
				String str5 = resultLine +"," + "6" + "," +"0" + "\n";
				sb.append(str5);
				String str6 = resultLine + "," +"7" + "," +"0" + "\n";
				sb.append(str6);
				String str7 = resultLine + "," +"1" +"," + "0" + "\n";
				sb.append(str7);
				String str8 = resultLine + "," +"2" +"," + "0" + "\n";
				sb.append(str8);
				String str9 = resultLine + "," +"3" + "," +"0" + "\n";
				sb.append(str9);
				String str10 = resultLine + "," +"4" + "," +"0" + "\n";
				sb.append(str10);
				String str11 = resultLine + "," +"5" + "," +"0" + "\n";
				sb.append(str11);
				String str12 = resultLine + "," +"6" + "," +"0" + "\n";
				sb.append(str12);
				String str13 = resultLine +"," + "7" +"," + "0" + "\n";
				sb.append(str13);
				String str14 = resultLine + "," +"1" +"," + "0" + "\n";
				sb.append(str14);
			
						
				
						
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
		
		//写到文件shop_info1
		String output = "C:\\Users\\Administrator\\Desktop\\DMCompetition\\口碑预测\\dataset\\prediction_data1.txt";
		BufferedWriter bw = null;
		
		try {
			bw= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output),"UTF-8"));
			bw.write(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(bw != null){
				try {
					bw.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					bw = null;
				}
			}
		}
		
		
	}

}
