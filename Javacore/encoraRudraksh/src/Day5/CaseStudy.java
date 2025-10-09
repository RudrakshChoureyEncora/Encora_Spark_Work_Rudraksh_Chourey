package Day5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CaseStudy {
	public static void main(String[] args) {
//		Testing singleTon Objects
//		MyResource ob1 = MyResource.newInst();
//		MyResource ob2 = MyResource.newInst();
//		System.out.println(ob1);
//		System.out.println(ob2);
//		System.out.println("now using threads to access the same object concurrently and in non-serialized");
		// using threads to access the same object concurrently and in non-serialized
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{//thread 1
			MyResource obj3=MyResource.newInstSync();
			System.out.println(obj3);
		});
		es.execute(()->{//thread 2
			MyResource obj4=MyResource.newInstSync();
			System.out.println(obj4);
		});
		es.shutdown();
//		System.out.println("Now using synchronised keyword");
//		ExecutorService es2=Executors.newFixedThreadPool(2);
//		es2.execute(()->{//thread 1
//			MyResource obj=MyResource.newInstSync();
//			System.out.println(obj);
//		});
//		es2.execute(()->{//thread 2
//			MyResource obj2=MyResource.newInstSync();
//			System.out.println(obj2);
//		});
//		es2.shutdown();
	}
}

// SingleTon Objects (Not more than one Object) // Checking how if else couses problem


class MyResource{
	private MyResource() {// 
		// TODO Auto-generated constructor stub
	}
	private static MyResource obj;
	
	/*
	 * Rules of static:
	 * 
	 */
	
//	public static MyResource newInst() {
//				if (obj==null) {obj=new MyResource();}// threads can execute so fast that more than one thread passes the condition and makes more than one instatance and breaks the properties of singleton and static 
//		return obj;
//	}
	synchronized public static MyResource newInstSync() {
		/*
		 * synchronized keyword allows only thread at a time to access the obj 
		 * and others are kept in semaphore waiting process 
		 * 
		 * usage: to solve double dip problem and let only one thread use the object
		 */
		if (obj==null) obj=new MyResource();
		return obj;
	}
}