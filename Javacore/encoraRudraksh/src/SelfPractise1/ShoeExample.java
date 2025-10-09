package SelfPractise1;


public class ShoeExample {
	public static void main(String[] args) {
		ShoeShop shop = new Shop1();
		ShoeFactory factory = new Bata();
		Shoe shoe = new SportsShoe();
		System.out.println();
		shop.setOrder(factory,shoe);
		Shoe shoe2=shop.sellShoe();
		System.out.println(shoe2);
	}
}


interface seller{
	public Shoe sellShoe();
}

interface Maker{
	public Shoe makeShoe(ShoeFactory shoefactory, Shoe shoe);
}


abstract class ShoeShop implements seller{
	ShoeFactory shoefactory;
	Shoe shoe;
	
	public void setOrder(ShoeFactory factory,Shoe shoe) {
		this.shoefactory=factory;
		this.shoe=shoe;
	}
	
	@Override
	public Shoe sellShoe() {
		// TODO Auto-generated method stub
		return this.shoefactory.makeShoe(this.shoefactory, this.shoe);
	}
	
	
	
}

class Shop1 extends ShoeShop{
	
}



abstract class ShoeFactory implements Maker{
	String Name;
}

class Bata extends ShoeFactory{
	public Bata() {
		// TODO Auto-generated constructor stub
		this.Name="Bata";
	}
	@Override
	public Shoe makeShoe(ShoeFactory shoefactory, Shoe shoe) {
		// TODO Auto-generated method stub
		return shoe.setLabel(shoefactory);
	}
}

class Lakhani extends ShoeFactory{
	public Lakhani() {
		// TODO Auto-generated constructor stub
		this.Name="Lakhani";
	}
	@Override
	public Shoe makeShoe(ShoeFactory shoefactory, Shoe shoe) {
		// TODO Auto-generated method stub
		return shoe.setLabel(shoefactory);
	}
}

abstract class Shoe{
	public abstract Shoe setLabel(ShoeFactory shoefactory);
}

class SportsShoe extends Shoe{
	String Cname;
	String ShoeType="Sports Shoe";
	public SportsShoe() {
		// TODO Auto-generated constructor stub
	}
	public Shoe setLabel(ShoeFactory shoefactory) {
		// TODO Auto-generated method stub
		return new SportsShoe(shoefactory);
	}
	
	public SportsShoe(ShoeFactory shoefactory) {
		// TODO Auto-generated constructor stub
		this.Cname=shoefactory.Name;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "This is a "+ShoeType+" of Company: "+Cname;
	}
	
}

class LeatherShoe extends Shoe{
	String Cname;
	String ShoeType="Leather Shoe";
	public LeatherShoe() {
		// TODO Auto-generated constructor stub
	}
	public Shoe setLabel(ShoeFactory shoefactory) {
		// TODO Auto-generated method stub
		return new SportsShoe(shoefactory);
	}
	
	public LeatherShoe(ShoeFactory shoefactory) {
		// TODO Auto-generated constructor stub
		this.Cname=shoefactory.Name;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "This is a "+ShoeType+" of Company: "+Cname;
	}
}