package eventdemo;

import java.util.Observable;
import java.util.Observer;

public class TeacherObserver implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		String msg=(String)arg;
		System.out.println(msg);
		bhago(msg);
	}
	
	public void bhago(String msg) {
		System.out.println("Teacher thinking whether to run or not...");
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("Teacher running...."+msg);
	}
}
