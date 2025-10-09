package mindGymDay1;

public class ExceptionHandilng {
	public static void main(String[] args) {
		System.out.println("before exception....");
		if(args.length==0) {
			System.out.println("Please enter a command line argument...");
		}
		else {
			String a=args[0];
			if(Character.isDigit(a.charAt(0))) {
				int x=Integer.parseInt(args[0]);
				if(x==0) {
					System.out.println("Please enter a non zero value...");
				}
				else {
					int i=1/x;
				}
			}
			else {
				System.out.println("please enter a number value...");
			}
		}
		System.out.println("after exception...");
	}
}

//	public static void main(String[] args) {
//		System.out.println("before exception....");
//		try {
//			int i=1/Integer.parseInt(args[0]);
//		}catch(ArithmeticException e) {
//			
//		}catch(ArrayIndexOutOfBoundsException ae) {
//			
//		}catch(NumberFormatException ne) {
//			
//		}catch(Exception ee) {
//			
//		}
//		System.out.println("after exception...");
//	}
//}


abstract class CheckConditions{
	public abstract void ifTrue();
	public abstract void ifFalse();
	
}
class PerformOP extends CheckConditions {
	@Override
	public void ifFalse() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ifTrue() {
		// TODO Auto-generated method stub
		
	}
}

class LengthIsZero extends CheckConditions {
	@Override
	public void ifFalse() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ifTrue() {
		// TODO Auto-generated method stub
		
	}
}

class  IsNotDigit extends CheckConditions {
	@Override
	public void ifFalse() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ifTrue() {
		// TODO Auto-generated method stub
		
	}
	
}

class IsZero extends CheckConditions {
	@Override
	public void ifFalse() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ifTrue() {
		// TODO Auto-generated method stub
		
	}
	
}






