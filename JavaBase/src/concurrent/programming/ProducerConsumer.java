package concurrent.programming;
/*
 *  �������������������߳�ģ���еľ������⣺
 *  �����ߺ���������ͬһʱ����ڹ���ͬһ�洢�ռ䣬��������ռ����������ݣ���������ȡ�����ݡ�
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

//������Ϣ��
class Info{
	 private String name = "name";//����name���ԣ�Ϊ��������set��name��������  
	    private String content = "content" ;// ����content���ԣ�Ϊ��������set��content��������  
	    private boolean flag = true ;   // ���ñ�־λ,��ʼʱ������  ,true->��ʾ������false->��ʾ����
	    public synchronized void set(String name,String content){  
	        while(!flag){  
	            try{  
	                super.wait() ;  
	            }catch(InterruptedException e){  
	                e.printStackTrace() ;  
	            }  
	        }  
	        this.setName(name) ;    // ��������  
	        try{  
	            Thread.sleep(300) ;  
	        }catch(InterruptedException e){  
	            e.printStackTrace() ;  
	        }  
	        this.setContent(content) ;  // ��������  
	        flag  = false ; // �ı��־λ����ʾ����ȡ��  
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
	        flag  = true ;  // �ı��־λ����ʾ��������  
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