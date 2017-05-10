package concurrent.programming;

import java.util.Random;

/*
 * 利用happen-before规则分析DCL
 */
public class HappenBeforeDCL {

	private int someField;
	
	private static HappenBeforeDCL instance;
	
	private HappenBeforeDCL(){
		this.someField = new Random().nextInt(200) + 1;
	}
	
	public static HappenBeforeDCL getInstance(){
		if(instance == null){
			synchronized (HappenBeforeDCL.class) {
				if(instance == null)
					instance = new HappenBeforeDCL();
			
			}
		}
		return instance;
	}
	
	public int getSomeField(){
		return this.someField;
	}
	
	public static void main(String[] args){
		Runnable runA = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				HappenBeforeDCL hb = HappenBeforeDCL.getInstance();
				System.out.println(hb.getSomeField());
			}
		};
		Thread threaA = new Thread(runA,"ThreadA");
		threaA.start();
		
		Runnable runB = new Runnable() {
			public void run() {
				HappenBeforeDCL hbb = HappenBeforeDCL.getInstance();
				System.out.println(hbb.getSomeField());
			}
		};
		Thread threaB = new Thread(runB,"ThreadB");
		threaB.start();
	}
}
