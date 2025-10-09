package day2;

public class ClassAndObj {
//	Classes and constructor 
	public static void main(String args[]) {
//		resource r = resource.newobj();	
//		Class.forName(args[0]);
//		resource r = new resource();
		
		}

}


class animal{
	String name;
	public animal() {
		System.out.println("Animal first Constructor");
	}
	
	public animal(String name ) {// constructor overloading 
		this.name=name;// refers to current object
		System.out.println("constructor with string parameter");
	}
}



class resource{
	
	static {// Static Block called once for intialisation of static methods 
		System.out.println("Static block");
	}
	
	private resource() {
		System.out.println("");
		
	}
	
	
	public static resource newobj() {//Factory Method to create a object to create a object without directly using the constructor
		System.out.println("Object created using factory method");
		return new resource();
	}
	
	public static void newobj2() {
		System.out.println("New class");
		
	}
}