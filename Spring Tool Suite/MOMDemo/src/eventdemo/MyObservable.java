package eventdemo;

import java.util.Observable;

public class MyObservable extends Observable{
	String msg="still";
	
	public void alarm(String msg) {
		this.msg=msg;
		setChanged();
		notifyObservers(msg);
	}
}