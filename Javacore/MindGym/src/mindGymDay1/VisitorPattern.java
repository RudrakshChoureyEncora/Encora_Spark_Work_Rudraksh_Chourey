package mindGymDay1;
import java.util.Scanner;

// when the behavior changes as per the visitor Object 
public class VisitorPattern {
	public static void main(String[] args) throws Exception{
		Childd baby=new Childd();
		Dog tiger=new Dog();
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Type the Item class name..:");
		String itemclass=scan.next();
		Itemm item=(Itemm)Class.forName("mindGymDay1."+itemclass).getConstructor().newInstance();
		baby.playWithDog(item, tiger);
	}
}

class Childd{
	public void playWithDog(Itemm item,Dog dog) {
		System.out.println("Before Exception...");
		try {
			dog.play(item);
		}
		catch(DogExceptions dd) {
			//System.out.println("unknown dog exception...:"+dd);
			dd.visit();
		}
		System.out.println("After Exception...");
	}
}
class Dog{
	public void play(Itemm item)throws DogExceptions {
		item.execute();
	}
}

abstract class Itemm{
	public abstract void execute()throws DogExceptions;
}
class StoneItemm extends Itemm{
	public StoneItemm() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute()throws DogExceptions {
		throw new DogBarkException("you throw I bark...");
	}
}
class StickItemm extends Itemm{
	public StickItemm() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute()throws DogExceptions {
		throw new DogBiteException("You beat I bite.....");
	}
}
class BiscuitItemm extends Itemm{
	public BiscuitItemm() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute()throws DogExceptions {
		throw new DogHappyException("I love biscuits.......");
	}
}
abstract class DogExceptions extends Exception{
	public abstract void visit();
}
class DogBiteException extends DogExceptions{
	String msg;
	public DogBiteException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception...:"+msg;
	}
	@Override
	public void visit() {
		new HelpLine911().help(this);
	}
}
class DogBarkException extends DogExceptions{
	String msg;
	
	
	public DogBarkException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception...:"+msg;
	}
	@Override
	public void visit() {
		new HelpLine911().help(this);
	}
}
class DogHappyException extends DogExceptions{
	String msg;
	public DogHappyException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception...:"+msg;
	}
	@Override
	public void visit() {
		new HelpLine911().help(this);
	}
}
class HelpLine911{
	public void help(DogBiteException dbe) {
		System.out.println("Take him to hospital...ambulance is on the way...");
	}
	public void help(DogBarkException dbr) {
		System.out.println("barking dogs seldom bite...dont worry....be calm...");
	}
	public void help(DogHappyException dbr) {
		System.out.println("dog is happy,....play and enjoy......");
	}
}









