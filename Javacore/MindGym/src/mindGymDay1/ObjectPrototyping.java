package mindGymDay1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ObjectPrototyping {
	
	public static void main(String[] args) throws Exception{
		ExecutorService es=Executors.newFixedThreadPool(2);
		MySingleTonn a=MySingleTonn.newInstance();
		es.execute(()->{
			MySingleTonn obj = null;
			try {
				obj = a.getClone();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(obj);
			
		});
		es.execute(()->{
			MySingleTonn obj2 = null;
			try {
				obj2 = a.getClone();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(obj2);
			
		});
		es.shutdown();
	}
}
class MySingleTonn implements Cloneable{
	private MySingleTonn() {
			//initialization logic i can keep here...
	}
	private static MySingleTonn obj;
	synchronized public static MySingleTonn newInstance() {
		if(obj==null) {
			obj=new MySingleTonn();
		}
		return obj;
	}
	
	public MySingleTonn getClone() throws Exception{
		return (MySingleTonn)super.clone();
	}
	
}

	
	
//=====My Code1===================================================================================================
//	public static void main(String[] args) throws Exception{
//		A a = new A();
//		A b = a.getClonee();
//		System.out.println(a+a.Name);
//		System.out.println(b+b.Name);
//		b = new A();
//		System.out.println(a+a.Name);
//		System.out.println(b+b.Name);
//		a.Name="Check";
//		System.out.println(a+a.Name);
//		System.out.println(b+b.Name);
//	}
//}
//
//
//class A implements Cloneable
//{
//	String Name;
//	public A() {
//		// TODO Auto-generated constructor stub
//		System.out.println("Object Created");
//	}
//	
//	public A getClonee() throws Exception{
//		return (A)super.clone();
//	}
//	
//	
//}
//=====Slack Code==============================================================================================
//
//class newclass{
//{
//	public static void main(String[] args) throws Exception{
//}
//	//First Scenario - multiton - more memory
////	Sheep obj1=new Sheep();
////	Sheep obj2=new Sheep();
////	obj1.name="sheep1";obj2.name="sheep2";
////	System.out.println(obj1+":"+obj2);
////	System.out.println(obj1.name+":"+obj2.name);
//	
//	//second scenario - singleton - data not safe
////	Sheep sobj1=new Sheep();
////	Sheep sobj2=sobj1;
////	sobj1.name="sheep 1111."; sobj2.name="sheep 222..";
////	System.out.println(sobj1.name+":"+sobj2.name);
//	
//	//third scenario - prototype - memory and data both are safe
//	Sheep mothersheep=new Sheep();
//	Sheep dolly=mothersheep.getClone();
//	mothersheep.name="iam the mother...";
//	dolly.name="iam the clone dolly..";
//	System.out.println(mothersheep.name+":"+dolly.name);
//	
//}
//}
//class Sheep implements Cloneable{
//public Sheep() {
//	System.out.println("sheep cons called...");
//}
//String name;
//
//public Sheep getClone() throws Exception{
//	return (Sheep)super.clone();
//}
//}