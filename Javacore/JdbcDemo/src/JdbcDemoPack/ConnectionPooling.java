package JdbcDemoPack;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ConnectionPooling {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			try {
				Thread.sleep(1000);
				Thread.currentThread().setName("Thread 2");
				Connection con=ConnectionPool.getConnection();
				System.out.println("Thread2..:"+con);
				Thread.sleep(5000);
				System.out.println("Thread2..:"+con);
				
			}catch(Exception e) {e.printStackTrace();}
		});
		es.execute(()->{
			try {
				Thread.currentThread().setName("Thread 1");
				Connection con=ConnectionPool.getConnection();
				System.out.println("Thread1..:"+con);
				ConnectionPool.closeConnection();
				con=ConnectionPool.getConnection();
				System.out.println("Thread1..:"+con);
			}catch(Exception e) {e.printStackTrace();}
		});
		es.shutdown();
	}
}









