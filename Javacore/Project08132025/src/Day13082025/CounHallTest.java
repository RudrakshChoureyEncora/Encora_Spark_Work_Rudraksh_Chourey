package Day13082025;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class CounHallTest {
	public static void main(String[] args) {
		ExecutorService es= Executors.newFixedThreadPool(3);
		CHall chall= new CHall();
		CHall chall2= new CHall();
		es.execute(()->{
			synchronized(chall) {
			Thread.currentThread().setName("Ram");
			chall.secdesk.performTask();
			chall.docdesk.performTask();
			chall.iddesk.performTask();
			}
		});
		es.execute(()->{
			synchronized(chall) {
			Thread.currentThread().setName("Shyam");
			chall2.secdesk.performTask();
			chall2.docdesk.performTask();
			chall2.iddesk.performTask();
			}
		});
		es.execute(()->{
			
			Thread.currentThread().setName("Raju");
			chall.water.haveWater();
		});
		
		
		System.out.println(chall);
		System.out.println(chall2);
		System.out.println(chall.water);
		System.out.println(chall2.water);
		System.out.println(chall.secdesk);
		System.out.println(chall2.secdesk);
		System.out.println(chall.gv);
		System.out.println(chall2.gv);
	}
}


class CHall{
	static governingbody gv = new governingbody();
	WaterPot water=new WaterPot();
	SecDesk secdesk=new SecDesk();
	DocDesk docdesk = new DocDesk();
	IdDesk iddesk = new IdDesk();
	public void doSec() {
		secdesk.performTask();
	}
	public void subDoc() {
		docdesk.performTask();
	}
	public void getId() {
		iddesk.performTask();
	}
	public void drinkWater() {
		water.haveWater();
	}
	
}
abstract class Desk{
	public abstract  void performTask();
}

class SecDesk extends Desk{
	@Override
	 public void performTask() {
		// TODO Auto-generated method stub
		try {
			System.out.println(Thread.currentThread().getName()+" is Doing Sec...");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+" Sec Completed...");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

class DocDesk extends Desk{
	@Override
	 public void performTask() {
		// TODO Auto-generated method stub
		try {
			System.out.println(Thread.currentThread().getName()+" is Submiting Docs...");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+" Doc Submitted...");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

class IdDesk extends Desk{
	@Override
	 public void performTask() {
		// TODO Auto-generated method stub
		try {
			System.out.println(Thread.currentThread().getName()+" is Collecting id...");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+" Id Collected...");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

class WaterPot {
	public  void haveWater() {
	try {
		System.out.println(Thread.currentThread().getName()+" is Drinking the water...");
		Thread.sleep(1000);
		System.out.println(Thread.currentThread().getName()+" Drank Water...");
	} catch (Exception e) {
		// TODO: handle exception
	}	
	}
}

class governingbody{
	
}