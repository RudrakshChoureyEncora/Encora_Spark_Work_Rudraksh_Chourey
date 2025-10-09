package Day5;

public class IfElseElimination {
	public static void main(String[] args) {
		PaintBrush brush=new PaintBrush();
		brush.paint=new RedPaint();//Dependencies Injection
		brush.doPaint();
	}

}

/* Steps
 * 1. Break the condition into the classes 
 * 2. establish a hirearchi with parent class
 * 2.2 Make it as abstract and insert abstract methods 
 * 2.3 overide the abstract methods in the child classes
 * 3. Make the association between the classses
 */
 class PaintBrush{
	 Paint paint;
	 void doPaint() {
		 paint.colour();
	 }
 }

abstract class Paint{
	public abstract void colour();
}


class RedPaint extends Paint{
	@Override
	public void colour() {
		// TODO Auto-generated method stub
		System.out.println("Red color painted");
	}
	
}

class BluePaint extends Paint{
	@Override
	public void colour() {
		// TODO Auto-generated method stub
		System.out.println("Blue color painted");
	}
	
}

class GreenPaint extends Paint{
	@Override
	public void colour() {
		// TODO Auto-generated method stub
		System.out.println("Green color painted");
		
	}
}