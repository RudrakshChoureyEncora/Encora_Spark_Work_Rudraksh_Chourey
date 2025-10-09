package Week3;

public class InterfaceImplementation {
	public static void main(String[] args) {
		new InterfaceImplementation().new MyInterfaceImpl().met();
		class MyInterfaceImpl1 implements MyInterface{
			@Override
			public void met() {
				System.out.println("Rajiv gandhis way....Local Inner Class Implementation");
			}
		}
		new MyInterfaceImpl1().met();
		//anonymous - sonia gandhis way
		MyInterface miImpl=new MyInterface() {
			@Override
			public void met() {
				System.out.println("sonia gandhis way.... Anonymous Class Implementation");
			}
		};
		miImpl.met();
		//Rahul gandhis ways - lambda
		miImpl=()->{
			System.out.println("rahul gandhis way....Lambda Expression");
		};
		miImpl.met();
		//Method referencing - priyanka gandhis way
		miImpl=InterfaceImplementation::vadhra;
		miImpl.met();
	}
	public static void vadhra() {
		System.out.println("vadhras way...Method Refrencing");
	}
	
	class MyInterfaceImpl implements MyInterface{
		@Override
		public void met() {
			System.out.println("Indra gandhis way.... Non-static Inner Class Implementation");
		}
	}
}

//Gandhis way
class MyInterfaceImpl implements MyInterface{
	
	@Override
	public void met() {
		System.out.println("gandhis way called...Top-Level Class Implementation ");
	}
}
interface MyInterface{
	public void met();
}









