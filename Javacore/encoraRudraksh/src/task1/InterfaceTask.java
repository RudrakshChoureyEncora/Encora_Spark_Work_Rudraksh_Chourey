package task1;

public class InterfaceTask {

}


interface A{
	
	public static float pi=3.14f;//literals or constants
	public void met();
	private void meet() {//template private methods
		
	}
	public default void meeeet() {//template global methods
		
	}
}
interface B extends A{
	
}
class X implements A{
	@Override
	public void met() {
		// TODO Auto-generated method stub
		
	}
}