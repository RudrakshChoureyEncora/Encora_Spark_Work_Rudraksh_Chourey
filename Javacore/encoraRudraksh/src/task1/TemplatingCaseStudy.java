package task1;

public class TemplatingCaseStudy {

	public static void main(String[] args) {
		System.out.println("using Abstract");
		System.out.println();
		Dominos dominos=new ShobaDominos();
		dominos.sellPizza();
		System.out.println();
		System.out.println("now using Interface");
		System.out.println();
		DominosI dominosI=new ShobaDominosI();
		dominosI.sellPizza();
	}
	
}

abstract class Dominos{
	public abstract void delivery();
	public abstract void collectMoney();
	final public void makeDough() {
		System.out.println("make dough with secrecy...by dominos");
	}
	final public void addIngredients() {
		System.out.println("add ingredients with secrecy by dominos");
	}
	final public void bakePizza() {
		System.out.println("bake pizza with secrecy by dominos..");
	}
	final public void makePizza() {//template methods...
		makeDough();
		addIngredients();
		bakePizza();
	}
	final public void sellPizza() {//template methods...
		collectMoney();
		makePizza();
		delivery();
	}
}


class ShobaDominos extends Dominos{
	@Override
	public void collectMoney() {
		System.out.println("Collect money as per indian standard..");
	}
	@Override
	public void delivery() {
		System.out.println("deliver pizza in bike....");
	}
}


class RatnaDominos extends Dominos{
	@Override
	public void collectMoney() {
		System.out.println("Collect money as per indian standard..");
	}
	@Override
	public void delivery() {
		System.out.println("deliver pizza in bike....");
	}
}

/*
 * Abstract CLasses(Generalisation)(Common nouns of real life whose Objects cant be created)
 * 
 * Super class should be abstract by nature as per OOPS 
 * 
 * Variables dont have overriding 
 * 
 * Non-abstract methods should be compulsarly final
 * 
 * and abstract method should be empty 
 * 
 * compile time binding and run time binding 
 * 
 * A Role like teacher or exporter or importer should be interfaces 
 * 
 * classification or kind of should be abstract 
 * 
 * Wich means Abstract only does static binding and cant extend more than one class
 * 
 * interfaces does dynamic binding and can implement more than 1 interfaces 
 * 
 * 
 */




/*
 * same can be emplmented with an interface 
 * and the rules for converting abstract to interface 
 * 
 */


interface DominosI{
	public abstract void delivery();
	public abstract void collectMoney();
	private void makeDough() {
		System.out.println("make dough with secrecy...by dominos");
	}
	private void addIngredients() {
		System.out.println("add ingredients with secrecy by dominos");
	}
	private void bakePizza() {
		System.out.println("bake pizza with secrecy by dominos..");
	}
	private void makePizza() {//template methods...
		makeDough();
		addIngredients();
		bakePizza();
	}
	public default void sellPizza() {//template methods...
		collectMoney();
		makePizza();
		delivery();
	}
}



class ShobaDominosI implements DominosI {
	@Override
	public void collectMoney() {
		System.out.println("Collect money as per indian standard..");
	}
	@Override
	public void delivery() {
		System.out.println("deliver pizza in bike....");
	}
}