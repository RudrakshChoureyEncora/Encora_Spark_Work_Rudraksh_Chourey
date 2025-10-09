package Day5;

//public class FactoryEx {
//
//	public static void main(String[] args) {
//		ShoeExample se=new ShoeExample();
//		se.sellShoe(FactoryChoice.lakhaniShoeFactory,ShoeChoice.sportsShoe);
//	}
//}

//interface FactoryChoice{
//	public final static int bataShoeFactory=1;
//	public final static int lakhaniShoeFactory=2;
//}
//interface ShoeChoice{
//	public final static int leatherShoe=1;
//	public final static int sportsShoe=2;
//}

//class ShoeExample{
//	public void sellShoe(int choice,int shoechoice) {
//			Shoe shoe=makeShoe(choice,shoechoice);
//			System.out.println(shoe);
//		
//	}
//	public Shoe makeShoe(int choice,int shoechoice) {
//		
//		if(choice==1) {
//			return bataFactoryMakeShoe(shoechoice);
//		}
//		else if(choice==2) {
//			return lakhaniFactoryMakeShoe(shoechoice);
//		}
//		else {
//			return null;
//		}
//	}
//	
//	public Shoe bataFactoryMakeShoe(int choice) {
//		if(choice==1) {
//			return new LeatherShoe("bata");
//		}
//		else if(choice==2) {
//			return new SportsShoe("bata");
//		}
//		else {
//			return null;
//		}
//	}
//	public Shoe lakhaniFactoryMakeShoe(int choice) {
//		if(choice==1) {
//			return new LeatherShoe("lakhani");
//		}
//		else if(choice==2) {
//			return new SportsShoe("lakhani");
//		}
//		else {
//			return null;
//		}
//	}
//	
////=======================================================================================================================================================
//	
//	abstract class Company{
//		public abstract Shoe makeshoe(Shoe shoe);
//	}
//	
//	class Lakhani extends Company{
//		@Override
//		public Shoe makeshoe(Shoe shoe) {
//			// TODO Auto-generated method stub
//			return new LeatherShoe("lakhani");
//			
//		}
//		
//		
//		abstract class ShoeType{
//			public abstract void returnShoe();
//		}
//		
//		class mySportsShoe extends ShoeType{
//			@Override
//			public void returnShoe() {
//				// TODO Auto-generated method stub
//				
//			}
//		}
//		class myLeatherShoe extends ShoeType{
//			@Override
//			public void returnShoe() {
//				// TODO Auto-generated method stub
//				
//			}
//		}
//	}
//	
//	
//	class Bata extends Company{
//		@Override
//		public Shoe makeshoe(Shoe shoe) {
//			// TODO Auto-generated method stub
//			
//			return null;
//		}
//	}
//	
//	
//
////=======================================================================================================================================================
//	
//	class Shoe{}
//	class LeatherShoe extends Shoe{
//			String company;
//			public LeatherShoe(String company) {
//				this.company=company;
//			}
//			@Override
//			public String toString() {
//				return "Leather Shoe...From:"+company;
//			}
//		
//	}
//	class SportsShoe extends Shoe{
//		String company;
//		public SportsShoe(String company) {
//			this.company=company;
//		}
//		@Override
//		public String toString() {
//			return "Sport Shoe...From:"+company;
//		}
//	}
//}
//
//
//
//













/*
 * 
 * 
 * 1. Identify the nouns and identify the classes 
 * Shoe
 * Leather shoe 
 * 
 * 2. Group them into the hierarchy
 * 
 * 
 */

public class FactoryEx {

	public static void main(String[] args) {
		ShoeFactory factory=new BataShoeFactory();
		Shoe shoe = new LeatherShoe();
		ShoeShop shop=new KlaShoeShop();
		//dependency injection
		shop.setFactory(factory);
		shop.setShoe(shoe);
		Shoe shoe2=shop.sellShoe(shoe);
		
		System.out.println(shoe2);
	}
}

interface Seller{
	public Shoe sellShoe(Shoe shoe);
}


interface Manufacturer{
	public Shoe makeShoe(String Nam,String Snamee);
}

abstract class ShoeFactory implements Manufacturer {
	static String Name;
}

class LakhaniShoeFactory extends ShoeFactory {
	static String Name="Lakhani";
	@Override
	public Shoe makeShoe(String CName,String Sname) {
		// TODO Auto-generated method stub
		
		return null;
	}
}

class BataShoeFactory extends ShoeFactory {
	static String Name="Bata";
	@Override
	public Shoe makeShoe(String CName,String Sname) {
		// TODO Auto-generated method stub
		System.out.println(CName+"   "+Sname);
		
		return null;
	}
}

abstract class ShoeShop implements Seller{
	private ShoeFactory shoefactory;
	private Shoe shoe;
	public void setShoe(Shoe shoe) {
		this.shoe=shoe;
		}
	public Shoe getShoe() {
		return this.shoe;
	}
	public void setFactory(ShoeFactory shoefactory) {
		this.shoefactory=shoefactory;
		}
	public ShoeFactory getFactory() {
		return this.shoefactory;
	}
	
}

class KlaShoeShop extends ShoeShop {
	@Override
	public Shoe sellShoe(Shoe shoe) {
		// TODO Auto-generated method stub
		return getFactory().makeShoe(getFactory().Name,getShoe().name);
	}
}






abstract class Shoe{static String name;}
class LeatherShoe extends Shoe{
		String name= "Leather";
}
class SportsShoe extends Shoe{
	String name= "Sports Shoe";
}


