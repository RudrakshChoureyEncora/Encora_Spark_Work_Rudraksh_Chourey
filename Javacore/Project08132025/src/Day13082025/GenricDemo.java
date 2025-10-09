package Day13082025;
public class GenricDemo {
	public static void main(String[] args) {
		Gen<A2> obj=new Gen<>();
		A2 a=new A2();
		B2 b=new B2();
		obj.accept(a);
		
		a=obj.get();
		
	}
}

class Gen<T>{
//	Object o;
//	public void accept(Object o) {
//		this.o=o;
//	}
//	A o;
//	public void accept(A obj) {
//		this.o=obj;
//	}
	public T get() {
		return o;
	}
	T o;
	public void accept(T obj) {
		this.o=obj;
	}
}

class A2{
	
}
class B2{
	
}
