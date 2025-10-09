package Day13082025;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test {
public static void main(String[] args) {
//	A obj=new A();
//	Method m[]=obj.getClass().getDeclaredMethods();
//	Method m1=m[0];
//	System.out.println(m1);
//	Parameter p[]=m1.getParameters();
//	
//	for(Parameter pp:p) {
//		System.out.println(pp);
//	}
	
	
	System.out.println("=================================");
	A a1=new A();
	A a2=new A();
	System.out.println(a1.getA());
	System.out.println(a2.getA());
	System.out.println(a1);
	System.out.println(a2);
}
}

class A{
	
//	public void met(String s, int n) {
//		System.out.println("hello..");
//	}
	static b a=new b();
	public b getA() {
		return this.a;
	}
}

class b{
	
}