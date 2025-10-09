package Week3;

public class Lambda2 {

	public Lambda2() {
		System.out.println("cons called....");
	}
	
	public static void main(String[] args) {
		//LAMBDA
		MyInter mi=()->{
			System.out.println("met called....");
			return "aa";
		};
		
		MyInter2 mi2=(x,y)->{return x+":"+y;};
		
		System.out.println(mi2.met("encora",100));
		mi.met();
		myMet(mi);
		
		//METHOD REFERENCING
		mi=Lambda2::add;
		mi.met();
		
		mi=new Lambda2()::add2;
		mi.met();
		
		MyInter3 mi3=Lambda2::new;
		mi3.met();
		
	}
	public static String add() {
		System.out.println("add method logic called...");
		return "1";
	}
	public  String add2() {
		System.out.println("add 2222 method logic called...");
		return "1";
	}
	public static void myMet(MyInter mi) {
		mi.met();
	}
	
}
//rule - lambda works only with interfaces
//and the interface should have only one abstract method - FUNCTIONAL INTERFACE
@FunctionalInterface
interface MyInter{
	public String met();
	//public void meat();
	public default void meet() {}
	private void meeeeeet() {}
}
interface MyInter2{
	public String met(String s,int i);
}
interface MyInter3{
	public void met();
}

@FunctionalInterface
interface testing{
	public void abstractMethod();
}





/*
 * 
 * Marker interface which has no methods 
 * Functional Interface :
 */
