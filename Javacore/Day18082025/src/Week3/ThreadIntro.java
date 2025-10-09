package Week3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadIntro {
	public static void main(String[] args)throws Exception {
		ExecutorService es=Executors.newFixedThreadPool(3);
		es.execute(()->{
			System.out.println("First thread started");
			try{met();}catch(Exception e) {}
		});
		es.execute(new Thread1Work());
		es.execute(new Thread2Work());
		System.out.println("Sending main thread to idle");
		Thread.currentThread().sleep(3000);
//		met();//first line
		//new Thread(new Thread1Work());
		
		es.shutdown();
	}
static void met() throws Exception{
	System.out.println("Before first interuption");
//	Thread.currentThread().sleep(3000);
	System.out.println("After first interuption");
}
static int met2()throws Exception {
//	Thread.currentThread().sleep(3000);
	return 1;
}
}

class Thread1Work implements Runnable{
	@Override
	public void run() {
		try{
			System.out.println("Second thread started");
			System.out.println("second line..:");
			System.out.println("Second thread ended");
		}catch(Exception e) {}
		}
}
class Thread2Work implements Runnable{
	@Override
	public void run() {
		System.out.println("Second thread started");
		System.out.println("second line..:");
		System.out.println("Second thread ended");
//		System.out.println("third line....Before intruption");
////		try{int i =ThreadIntro.met2();}catch(Exception e) {}
//		System.out.println("third line....after intruption");
	}
}








