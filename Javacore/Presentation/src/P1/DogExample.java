package P1;

import java.util.Scanner;

public class DogExample {
	public static void main(String[] args)throws Exception {
		System.out.println("Working");
		Child child=new Child();
		Dog dog=new Dog();
		Scanner sc = new Scanner(System.in);
		String str=sc.nextLine();
		Item item =(Item)Class.forName("P1."+str).getConstructor().newInstance();
		child.doPlay(item, dog);
		
	}
}



class Child{
	public void doPlay(Item item, Dog dog) throws Exception{
		
		try{dog.dogReacts(item);}
		catch(DogReactionException d) {
			System.out.println(d);
			d.whatToDo();
		}
	}
}


class Dog{
	public void dogReacts(Item item) throws Exception{
		item.ReactionOfDogAsPerItem();
	}
}

abstract class Item{
	public abstract void ReactionOfDogAsPerItem() throws Exception;
}

class StoneItem extends Item{
	public StoneItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void ReactionOfDogAsPerItem() throws Exception {
		// TODO Auto-generated method stub
		
		throw new DogBiteException("I will Bite");
	}
}

class BiscuitItem extends Item{
	public BiscuitItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void ReactionOfDogAsPerItem() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("I am Happy");
		throw new DogHappyException();
	}
}

class FishItem extends Item{
	public FishItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void ReactionOfDogAsPerItem() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Agey Badh");
		throw new DogNoReactException();
	}
}


abstract class DogReactionException extends Exception{
	public abstract void whatToDo();
}


class DogHappyException extends  DogReactionException{
	@Override
	public void whatToDo() {
		// TODO Auto-generated method stub
		new HelpLine().help(this);
		
	}
}


class DogBiteException extends  DogReactionException{
	String msg;
	public DogBiteException(String s) {
		// TODO Auto-generated constructor stub
		this.msg=s;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Exception: "+msg;
	}
	@Override
	public void whatToDo() {
		// TODO Auto-generated method stub
		new HelpLine().help(this);
		
	}
}


class DogNoReactException extends  DogReactionException{
	public DogNoReactException() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void whatToDo() {
		// TODO Auto-generated method stub
		new HelpLine().help(this);
		
	}
}


class HelpLine{
	public void help(DogNoReactException d) {
		System.out.println("Please Dont Call ");
	}
	public void help(DogHappyException d) {
		System.out.println("Please Dont Call");
	}
	public void help(DogBiteException d) {
		System.out.println("Sending Medical HElp");
	}
	
}
