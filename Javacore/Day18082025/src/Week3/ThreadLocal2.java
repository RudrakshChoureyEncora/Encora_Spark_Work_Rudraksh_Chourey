package Week3;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadLocal2 {

	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		ClockRoom cr=new ClockRoom();
		es.execute(()->{
			Thread.currentThread().setName("Salman Khan");
			cr.setLuggage(new Luggage("salman khan's Luggage"));
			try {Thread.sleep(5000);}catch(Exception e) {}
//			Luggage lug=cr.getLuggage();
//			System.out.println(lug);
			cr.getLuggage();
			cr.setLuggage(new Luggage("salman khan's Luggage"));
//			System.out.println(cr.getLuggage());
			cr.setLuggage(new Luggage("salman khan's Luggage"));
		});
		es.execute(()->{
			Thread.currentThread().setName("Shahrukh Khan");
			cr.setLuggage(new Luggage("sharukh khan's Luggage"));
			try {Thread.sleep(1000);}catch(Exception e) {}
//			Luggage lug=cr.getLuggage();
//			System.out.println(lug);
			cr.getLuggage();
			cr.getLuggage();
		});
		es.shutdown();
	}
}
class ClockRoom{
	private static ThreadLocal<Luggage> tlocal=new ThreadLocal<Luggage>();
	public void setLuggage(Luggage luggage) {
		Luggage lg=tlocal.get();
		
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(lg==null) {
			tlocal.set(luggage);
			System.out.println(Thread.currentThread().getName()+" Giving luggage"+luggage);
		}
		else {
			System.out.println(Thread.currentThread().getName()+" already luggage set...");
		}
	}
	public void getLuggage() {
		Luggage lg=tlocal.get();
		if(lg==null) {
			System.out.println(Thread.currentThread().getName()+" asking for luggage"+" no luggage for this thread...");
//			return null;
		}
		else {
			tlocal.remove();
//			return lg;
//		
			System.out.println(Thread.currentThread().getName()+" asking for luggage"+lg);
		}
	}
}

class Luggage{
	String name;
	public Luggage(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return " Luggage..:"+name;
	}
}

