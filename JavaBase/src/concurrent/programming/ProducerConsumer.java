package concurrent.programming;
/*
 *  生产者消费者问题是线程模型中的经典问题：
 *  生产者和消费者在同一时间段内共用同一存储空间，生产者向空间里生产数据，而消费者取走数据。
 */
public class ProducerConsumer {

	public static void main(String[] args){
		Info info = new Info();
		Producer pro = new Producer(info);
		Consumer con = new Consumer(info);
		new Thread(pro).start();
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		new Thread(con).start();
	}
}

class Producer implements Runnable{
	private Info info= null;
	public Producer(Info info){
		this.info = info;
	}
	public void run(){
		boolean flag = true;
		for(int i = 0; i < 10; i++){
			if(flag){
				this.info.set("name--1", "content--1");
				flag = false;
			}else {
				this.info.set("name--2", "content--2");
				flag = true;
			}
		}
	}
}

class Consumer implements Runnable{
	private Info info= null;
	public Consumer(Info info){
		this.info = info;
	}
	public void run(){
		for(int i = 0; i< 10; i++){
			this.info.get();
		}
	}
}

//定义信息类
class Info{
	 private String name = "name";//定义name属性，为了与下面set的name属性区别开  
	    private String content = "content" ;// 定义content属性，为了与下面set的content属性区别开  
	    private boolean flag = true ;   // 设置标志位,初始时先生产  ,true->表示生产，false->表示消费
	    public synchronized void set(String name,String content){  
	        while(!flag){  
	            try{  
	                super.wait() ;  
	            }catch(InterruptedException e){  
	                e.printStackTrace() ;  
	            }  
	        }  
	        this.setName(name) ;    // 设置名称  
	        try{  
	            Thread.sleep(300) ;  
	        }catch(InterruptedException e){  
	            e.printStackTrace() ;  
	        }  
	        this.setContent(content) ;  // 设置内容  
	        flag  = false ; // 改变标志位，表示可以取走  
	        super.notify();  
	    }  
	    public synchronized void get(){  
	        while(flag){  
	            try{  
	                super.wait() ;  
	            }catch(InterruptedException e){  
	                e.printStackTrace() ;  
	            }  
	        }  
	        try{  
	            Thread.sleep(300) ;  
	        }catch(InterruptedException e){  
	            e.printStackTrace() ;  
	        }  
	        System.out.println(this.getName() +   
	            " --> " + this.getContent()) ;  
	        flag  = true ;  // 改变标志位，表示可以生产  
	        super.notify();  
	    }  
	    public void setName(String name){  
	        this.name = name ;  
	    }  
	    public void setContent(String content){  
	        this.content = content ;  
	    }  
	    public String getName(){  
	        return this.name ;  
	    }  
	    public String getContent(){  
	        return this.content ;  
	    }  
}