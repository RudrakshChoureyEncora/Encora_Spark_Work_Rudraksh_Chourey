package Day13082025;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class PoliceExampleClassAPI {
	public static void main(String[] args) throws Exception{
		Politician ramu=new Politician();
		PoliceStation p1=new PoliceStation();
		p1.arrest(ramu);
	}
}
class Politician{
	public String publicName="good man";
	public void publicService(String s, int i) {
		System.out.println("noble services done.....");
	}
	
	private String secretName="gunda...";
	private void secretService(String s) {
		System.out.println("looting people....");
	}
}
class PoliceStation{
	public void arrest(Object suspect)throws Exception {
		Class c=suspect.getClass();
		System.out.println("The Object is of Class Name:"+c.getName());
		System.out.print("it has these Properties: ");
		for(Field x :c.getDeclaredFields()) {
			System.out.print(x.getName()+" " );
		}
		System.out.println();
		System.out.println("Choose From These Properties:");
		Scanner sc = new Scanner(System.in);
		String fStr=sc.nextLine();
//		Field f=c.getField("publicName");
//		System.out.println(f.get(suspect));

		Field f=c.getDeclaredField(fStr);
		f.setAccessible(true);
		System.out.println(f.get(suspect));
		
		
		System.out.print("it has these Actions: ");
		for(Method x :c.getDeclaredMethods()) {
			System.out.println(x.getName()+" " );
			Parameter p[]=x.getParameters();
			for(Parameter y:p) {
				System.out.println(y);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Choose From These Actions:");
		String mStr=sc.nextLine();
		
		
		
		Method m=c.getDeclaredMethod(mStr,String.class);
//		Method m=c.getDeclaredMethod(mStr, String.class);
		m.setAccessible(true);
		m.invoke(suspect, "aa");
		
		m=c.getDeclaredMethod("secretService", String.class);
		m.setAccessible(true);
		m.invoke(suspect, "aaa");
	}
}









