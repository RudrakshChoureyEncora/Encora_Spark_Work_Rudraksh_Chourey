package Day5;
import java.util.Scanner;
public class FanEx {

	public static void main(String[] args) {
//		Fan shaitan=new Fan();
//		while(true) {
//			//Scanner scan=new Scanner(System.in);
//			//System.out.println("Press a key and press enter...");
//			//scan.next();
//			shaitan.pull();
//		}
		Fan khaitan=new Fan();
		System.out.println("Start");
		I0 i0= new I0();
		I1 i1= new I1();
		I2 i2= new I2();
		I3 i3= new I3();
		while(true) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Press a key and press enter...");
			scan.next();
			khaitan.switc=i0;
			khaitan.pull2();
			System.out.println("Press a key and press enter...");
			scan.next();
			khaitan.switc=i1;
			khaitan.pull2();
			System.out.println("Press a key and press enter...");
			scan.next();
			khaitan.switc=i2;
			khaitan.pull2();
			System.out.println("Press a key and press enter...");
			scan.next();
			khaitan.switc=i3;
			khaitan.pull2();
		}
	}
	
	
}


//
//class Fan{
//	int i=0;
//	public void pull() {
//		if(i==0) {
//			i=1;
//			System.out.println("switch on state....");
//		}
//		else if(i==1) {
//			i=2;
//			System.out.println("medium speed state....");
//		}
//		else if(i==2) {
//			i=3;
//			System.out.println("high speed state....");
//		}
//		else if(i==3) {
//			i=0;
//			System.out.println("switch off state.....");
//		}
//	}
//		
//}

class Fan{
	Switch switc=new I0();
	void pull2 (){
		switc.pull();
	}
}


abstract class Switch{
	public abstract void pull();
}

class I0 extends Switch{
	@Override
	public void pull() {
		// TODO Auto-generated method stub
		System.out.println("switch on state....");
	}
}

class I1 extends Switch{
	@Override
	public void pull() {
		// TODO Auto-generated method stub
	System.out.println("medium speed state....");	
	}
	
}

class I2 extends Switch{
	@Override
	public void pull() {
		// TODO Auto-generated method stub
	System.out.println("high speed state....");	
	}
}

class I3 extends Switch{
	@Override
	public void pull() {
		// TODO Auto-generated method stub
	System.out.println("switch off state.....");	
	}
}