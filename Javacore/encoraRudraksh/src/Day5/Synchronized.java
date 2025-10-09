package Day5;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Synchronized {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{//thread 1
			//TrainingRoom t1=new TrainingRoom();
			Thread.currentThread().setName("salman khan");
			synchronized(Toilet.class) {
				TrainingRoom.sulab.useToilet();
			}
		});
		es.execute(()->{//thread 2
			//TrainingRoom t2=new TrainingRoom();
			Thread.currentThread().setName("sharukh khan");
			synchronized(Toilet.class) {
				TrainingRoom.sulab.useToilet();
			}
		});
		es.shutdown();
			}
}
class TrainingRoom{
	Projector sony=new Projector();
	static Toilet sulab=new Toilet();
}
class Projector{
	public Projector() {
		System.out.println("projector object created....");
	}
}
class Toilet{
	public Toilet() {
		System.out.println("toilet object created...");
	}
	public void useToilet() {
		String name=Thread.currentThread().getName();
		System.out.println(name+" using the toilet....");
		try {Thread.sleep(2000);}catch(Exception e) {}
		System.out.println(name+ " is out of the toilet...");
	}
}






