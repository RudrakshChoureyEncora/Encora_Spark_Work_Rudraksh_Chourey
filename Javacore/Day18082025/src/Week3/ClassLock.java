package Week3;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClassLock {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		Theatre screen1=new Theatre();
		Theatre screen2=new Theatre();
		es.execute(()->{
			synchronized(Theatre.class) {
			Thread.currentThread().setName("sharukh khan");
			screen1.sulab.useToilet();
			}
		});
		es.execute(()->{
			synchronized(Theatre.class) {
			Thread.currentThread().setName("salman khan");
			screen2.sulab.useToilet();
			}
		});
		es.shutdown();
	}
}

class Theatre{
	static Toilet sulab=new Toilet();
}

class Toilet{
	public Toilet() {
		System.out.println("toilet object created...");
	}
	public void useToilet() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println(name+" is using the toilet..");
		try {Thread.sleep(3000);}catch(Exception e) {}
		System.out.println(name+" is out of toilet...");
	}
}






