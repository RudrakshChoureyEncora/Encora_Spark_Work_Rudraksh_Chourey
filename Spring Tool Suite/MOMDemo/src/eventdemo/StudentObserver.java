package eventdemo;

import java.util.Observable;
import java.util.Observer;

public class StudentObserver implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		String msg=(String)arg;
		System.out.println(msg);
		bhago(msg);
	}
	
	public void bhago(String msg) {
		System.out.println("Students running...."+msg);
	}
}