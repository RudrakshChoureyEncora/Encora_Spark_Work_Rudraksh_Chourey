package Day13082025;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class interlinkedThreads {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		Gun bofors=new Gun();
		es.execute(()->{
			for(int i=0;i<5;i++) {
				bofors.fillGun();
			}
		});
		es.execute(()->{
			for(int i=0;i<5;i++) {
				bofors.shootGun();
			}
		});
		es.shutdown();
	}
}

class Gun{
	boolean Ball_is_There=false;
	synchronized public void fillGun() {
		if(Ball_is_There) {
			System.out.println("Ball is there");
			try{wait();}catch(Exception e) {}
		}
		System.out.println("Fill the gun.....");
		Ball_is_There=true;
		notify();
	}
	synchronized public void shootGun() {
		if(!Ball_is_There) {
			System.out.println("Ball is not there");
			try{wait();}catch(Exception e) {}
		}
		System.out.println("shoot the gun.....");
		Ball_is_There=false;
		notify();
	}
}






