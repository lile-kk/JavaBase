package concurrent.programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/*
 * 多线程中安全遍历集合元素的示例
 */
public class SafeCollectionInterator {

	public static void main(String[] args){
		List wordlist = Collections.synchronizedList(new ArrayList());
		
		//wordlist中的add方法是同步方法，会获取wordList实例的对象锁
		wordlist.add("Iterators");
		wordlist.add("require");
		wordlist.add("special");
		wordlist.add("handing");
		
		//获取wordlist 实例的对象锁
		//迭代时，阻塞其他线程调用add或remove等方法修改元素
		synchronized (wordlist) {
			Iterator itor = wordlist.iterator();
			while(itor.hasNext()){
				String s = (String) itor.next();
				System.out.println("found string : " + s +", length = " + s.length());
			}
		}
	}
	
}
