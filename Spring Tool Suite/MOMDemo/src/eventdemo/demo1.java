package eventdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class demo1 {
	public static void main(String[] args) {
		MyObservable mo= new MyObservable();
		StudentObserver so=new StudentObserver();
		TeacherObserver to=new TeacherObserver();
		mo.addObserver(so);
		mo.addObserver(to);
		mo.alarm("fire fire bhago bhago");
	}

}
