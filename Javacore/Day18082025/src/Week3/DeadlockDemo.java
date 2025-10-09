package Week3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * When their is a circular dependency between two synchronized
 * blocks, then dead lock occurs...
 */

public class DeadlockDemo {
	public static void main(String[] args) {
		System.out.println("Start");
		ExecutorService es=Executors.newFixedThreadPool(2);
		Crane russia=new Crane();
		Frog ukraine=new Frog();
		es.execute(()->{
			russia.eat(ukraine);
		});
		es.execute(()->{
			ukraine.escape(russia);
		});		
		es.shutdown();
		
	}
}

class Crane{
	synchronized public void eat(Frog frog) {
		
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		frog.leave();
		System.out.println("swaha.........");
	}
	synchronized public void leave() {//will be called by frog
		System.out.println("Crane Leaving");
	}
}

class Frog{
	synchronized public void escape(Crane c) {
		
		c.leave();
		
	}
	synchronized public void leave() {//will be called by crane
		System.out.println("Frog Leaving");
	}
}




