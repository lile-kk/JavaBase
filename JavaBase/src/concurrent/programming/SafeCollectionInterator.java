package concurrent.programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/*
 * ���߳��а�ȫ��������Ԫ�ص�ʾ��
 */
public class SafeCollectionInterator {

	public static void main(String[] args){
		List wordlist = Collections.synchronizedList(new ArrayList());
		
		//wordlist�е�add������ͬ�����������ȡwordListʵ���Ķ�����
		wordlist.add("Iterators");
		wordlist.add("require");
		wordlist.add("special");
		wordlist.add("handing");
		
		//��ȡwordlist ʵ���Ķ�����
		//����ʱ�����������̵߳���add��remove�ȷ����޸�Ԫ��
		synchronized (wordlist) {
			Iterator itor = wordlist.iterator();
			while(itor.hasNext()){
				String s = (String) itor.next();
				System.out.println("found string : " + s +", length = " + s.length());
			}
		}
	}
	
}
