package Week3;

public class DemonThread {
	public static void main(String[] args) {
		Thread t=new Thread(()->{
			while(true) {
				System.out.println("daemon thread running...");
				try {Thread.sleep(500);}catch(Exception e) {}
			}
		});
		t.setDaemon(true);
		t.start();
		
		Thread t2=new Thread(()->{
			while(true) {
				System.out.println("non deamon thread...");
				try {Thread.sleep(500);}catch(Exception e) {}
			}
		});
		t2.start();
		
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("main thread completed....");
		System.exit(0);
	}
}
