package Day5;

public class IceCreamSol {

	public static void main(String[] args) {
		IceCream myIceCream=new Vanila(new Nuts(new DryFruits(new Choclate(new Nuts(new Plate())))));
		System.out.println("Cost..:"+myIceCream.cost());
	}
}
abstract class IceCream{
	public abstract int cost();
}
abstract class Cream extends IceCream{
	
}
abstract class Toppings extends IceCream{
	
}
class Vanila extends Cream{
	public Vanila() {
		// TODO Auto-generated constructor stub
	}
	IceCream cream;
	public Vanila(IceCream cream) {
		this.cream=cream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
			return 10+cream.cost();
	}
}
class Strawberry extends Cream{
	public Strawberry() {
		// TODO Auto-generated constructor stub
	}
	IceCream cream;
	public Strawberry(IceCream cream) {
		this.cream=cream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
			return 20+cream.cost();
	}
}
class Choclate extends Cream{
	public Choclate() {
		// TODO Auto-generated constructor stub
	}
	IceCream cream;
	public Choclate(IceCream cream) {
		this.cream=cream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
			return 30+cream.cost();
	}
}
class Nuts extends Toppings{
	public Nuts() {
		// TODO Auto-generated constructor stub
	}
	IceCream cream;
	public Nuts(IceCream cream) {
		this.cream=cream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
			return 5+cream.cost();
	}
}
class DryFruits extends Toppings{
	public DryFruits() {
		// TODO Auto-generated constructor stub
	}
	IceCream cream;
	public DryFruits(IceCream cream) {
		this.cream=cream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
			return 20+cream.cost();
	}
}
class Plate extends IceCream{
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		return 0;
	}
}






