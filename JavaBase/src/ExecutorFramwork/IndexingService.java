package ExecutorFramwork;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/*
 * 使用毒丸对象
 */

/**
 * 
 * @author Administrator
 *

public class IndexingService {

	private static final File POISION = new File("");
	private final IndexerThread consumer = new IndexerThread();
	private final CrawlerThread producer = new CrawlerThread();
	private final BlockingQueue<File> queue;
	private final FileFilter fileFilter;
	private final File root;
	
	
	public void start(){
		producer.start();
		consumer.start();
	}
	
	public void stop(){
		producer.interrupt();
	}
	public void awaitTermination() throws InterruptedException{
		consumer.join();
	}
	
	//IndexingService的生产者线程
	class CrawlerThread extends Thread{
		public void run(){
			try {
				crawl(root);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				while(true){
					try{
						queue.put(POISION);
						break;
					}catch(InterruptedException e1){
						
					}
				}
			}
		}
		
		private void crawl(File root) throws InterruptedException{
			
		}
	}
	
	class IndexerThread extends Thread{
		public void run(){
			try{
				while(true){
					File file= queue.take();
					if(file==POISION){
						break;
					}else {
						indexFile(file);
					}
				}
			}catch(InterruptedException e){
				
			}
		}
		
		private void indexFile(File root){
			
		}
	}
}
 */

