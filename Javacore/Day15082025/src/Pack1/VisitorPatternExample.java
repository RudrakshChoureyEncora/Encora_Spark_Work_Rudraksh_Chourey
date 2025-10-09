package Pack1;

public class VisitorPatternExample  {
	public static void main(String[] args) throws Exception{
		Child child = new Child();
		Dog dog = new Dog();
		System.out.println("We are Ready");
		Item item=(Item)  Class.forName("Pack1."+"BiscuitItem").getConstructor().newInstance();
		child.playWithDog(item, dog);
	}
}


class Child{
	
	public void playWithDog(Item item,Dog dog) throws Exception{
		try{dog.dogReacts(item);}
		catch(DogExceptions d) {
			d.actionOnDogsReaction();
		}
	}
}

class HelpLine101{
	public HelpLine101() {
		// TODO Auto-generated constructor stub
	}
	public void giveHelp(DogHappyException d){
		System.out.println("Dont call for stupid reasons Enjoy with dog");
	}
	
	public void giveHelp(DogBiteException d){
		System.out.println("Sending Help For Dog Bite");
	}
	
	public void giveHelp(DogWalkoutException )
	
}


abstract class DogExceptions extends Exception{
	public abstract void actionOnDogsReaction();
}




class DogHappyException extends DogExceptions{
	public DogHappyException() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionOnDogsReaction() {
		// TODO Auto-generated method stub
		HelpLine101 h1=new HelpLine101();
		h1.giveHelp(this);
	}
}


class DogBiteException extends DogExceptions{
	
	
	public DogBiteException() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionOnDogsReaction() {
		// TODO Auto-generated method stub
		
	}
	
}


class DogWalkoutException extends DogExceptions{
	public DogWalkoutException() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionOnDogsReaction() {
		// TODO Auto-generated method stub
		
	}
}

class Dog{
	public void dogReacts(Item item) throws Exception{	
		item.reactionBasedOnItem();
	}
}

abstract class Item{
	public abstract void reactionBasedOnItem()throws Exception;
}

class StoneItem extends Item{
	public StoneItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void reactionBasedOnItem() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Dog will bite");
		throw new DogBiteException();
	}
}

class BiscuitItem extends Item{
	public BiscuitItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void reactionBasedOnItem() {
		// TODO Auto-generated method stub
		System.out.println("Dog will not bite and is happy");
	}
}


class FishItem extends Item{
	public FishItem() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void reactionBasedOnItem() {
		// TODO Auto-generated method stub
		System.out.println("Chal na mujhe mtlb nhi");
	}
}
