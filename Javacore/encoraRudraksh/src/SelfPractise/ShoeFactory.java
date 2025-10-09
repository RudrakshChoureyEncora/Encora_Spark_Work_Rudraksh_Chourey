package SelfPractise;

/*
 * Solved 
 */

public class ShoeFactory {
	public static void main(String[] args) {
		ShoeSeller seller=new ShopA();
		
		
		ShoeMaker maker= new Lakhani();
		Shoe shoe = new SportsShoe();
		seller.setOrder(maker,shoe);
		Shoe shoe2=seller.sellShoe();
		System.out.println(shoe2);
	}
}


interface Seller{
	public Shoe sellShoe();
}

interface Manufacturer{
	public Shoe makeShoe(ShoeMaker shoemaker,Shoe shoe);
}

abstract class ShoeSeller implements Seller{
	ShoeMaker shoemaker;
	Shoe shoe;
	public void setOrder(ShoeMaker shoemaker,Shoe shoe) {
//		System.out.println("Setting order   "+shoemaker+"   "+shoe);
		this.shoemaker=shoemaker;
		this.shoe=shoe;
	}
	public ShoeMaker getMaker() {
		return this.shoemaker;
	}
	public Shoe getShoe(){
		return this.shoe;
	}
	
}

class ShopA extends ShoeSeller{
	@Override
	public Shoe sellShoe() {
		// TODO Auto-generated method stub
		return getMaker().makeShoe(getMaker(),getShoe());
	}
}

abstract class ShoeMaker implements Manufacturer{
	 String Name;
}

class Lakhani extends ShoeMaker{
	Lakhani(){
		this.Name="Lakhani";
	}
	@Override
	public Shoe makeShoe(ShoeMaker shoemaker, Shoe shoe) {
		// TODO Auto-generated method stub
//		System.out.println("Making order   "+Name+"   "+shoe);
		return shoe.shoeMade(shoemaker);
	}
	
}

class Bata extends ShoeMaker{
	Bata(){
		this.Name="Bata";
	}
	@Override
	public Shoe makeShoe(ShoeMaker shoemaker, Shoe shoe) {
		// TODO Auto-generated method stub
//		System.out.println("Making order   "+Name+"   "+shoe);
		return shoe.shoeMade(shoemaker);
	}
}

abstract class Shoe{
	public abstract Shoe shoeMade(ShoeMaker shoemaker);
}

class SportsShoe extends Shoe{
	String Company;
	String ShoeType="Sports";
	@Override
	public Shoe shoeMade(ShoeMaker shoemaker) {
		return new SportsShoe(shoemaker);
	}
	public SportsShoe() {
		
	}
	public SportsShoe(ShoeMaker shoemaker){
		this.Company = shoemaker.Name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ShoeType+" Shoe...From: "+Company;
	}
}

class LeatherShoe extends Shoe{
	String Company;
	String ShoeType="Leather";
	@Override
	public Shoe shoeMade(ShoeMaker shoemaker) {
		return new LeatherShoe(shoemaker);
	}
	public LeatherShoe() {
		
	}
	public LeatherShoe(ShoeMaker shoemaker){
		this.Company = shoemaker.Name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ShoeType+" Shoe...From: "+Company;
	}
}