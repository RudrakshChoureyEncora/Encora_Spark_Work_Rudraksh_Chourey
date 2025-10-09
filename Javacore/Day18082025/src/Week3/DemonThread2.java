package Week3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DemonThread2 {
	
	public static void main(String[] args) {
		System.out.println("Start");
		ExecutorService es=Executors.newFixedThreadPool(1);
		ExecutorService es2=
				Executors.newSingleThreadExecutor
				((r)->{
					Thread t=new Thread(r);
					t.setDaemon(true);
					return t;
				});
		es2.execute(()->{	
			while(true) {
				System.out.println("daemon thread running...");
				try {Thread.sleep(500);}catch(Exception e) {}
			}
		});
		
		
		es.execute(()->{
			while(true) {
				System.out.println("non deamon thread...");
				try {Thread.sleep(500);}catch(Exception e) {}
			}
		});
		
		
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("main thread completed....");
		//System.exit(0);
	}
}






