package SelfPractise;

public class Ibaco {
public static void main(String[] args) {
		IceCream fav=new ChocoChips(new Vanila(new IceCreamPlate()));
		System.out.println(fav.cost());
	}
}


abstract class IceCream{
	public abstract int cost();
}

abstract class Cream extends IceCream{
	
}

class Vanila extends Cream{
	IceCream iceCream;
	public Vanila(IceCream iceCream) {
		System.out.println("Vanila Cream Added");
		this.iceCream=iceCream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 10+iceCream.cost();
	}
}

class Choco extends Cream{
	IceCream iceCream;
	
	
	public Choco(IceCream iceCream) {
		System.out.println("Choco Cream Added");
		// TODO Auto-generated constructor stub
		this.iceCream=iceCream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 10+iceCream.cost();
	}
}

abstract class Topings extends IceCream{

}


class Almonds extends Topings{
	IceCream iceCream;
	public Almonds(IceCream iceCream) {
		System.out.println("Almonds Added");
		this.iceCream=iceCream;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 10+iceCream.cost();
	}
}

class TootyFruty extends Topings{
	IceCream iceCream;
	public TootyFruty(IceCream iceCream) {
		System.out.println("TootyFruty Added");
		this.iceCream=iceCream;
		// TODO Auto-generated constructor stub
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 10+iceCream.cost();
	}
}

class ChocoChips extends Topings{
	IceCream iceCream;
	public ChocoChips(IceCream iceCream) {
		System.out.println("ChocoChips Added");
		this.iceCream=iceCream;
		// TODO Auto-generated constructor stub
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 10+iceCream.cost();
	}
}

class IceCreamPlate extends IceCream{
	public IceCreamPlate() {
		// TODO Auto-generated constructor stub
		System.out.println("Plate Taken For iceCream");
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 10;
	}
}