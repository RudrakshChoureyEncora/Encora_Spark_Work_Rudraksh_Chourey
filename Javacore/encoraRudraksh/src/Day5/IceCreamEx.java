package Day5;

public class IceCreamEx {

	public static void main(String[] args) {
		IbacoIceCream ibaco=new IbacoIceCream();
//		IbacoIceCream icecream=ibaco.makeIceCream(new IbacoIceCream().new Nuts(), new IbacoIceCream().new Fruits());
//		System.out.println(icecream);
	}
}
//==============================================================================================
class IbacoIceCream{
	String name="Cream...:";
	int cost=10;
	
	public IbacoIceCream() {
		// TODO Auto-generated constructor stub
		
	}
	
	class Fruits{
		public int cost() {
			return 5;
		}
		@Override
		public String toString() {
			return "Fruits....";
		}
	}
	
	class Nuts{
		public int cost() {
			return 10;
		}
		@Override
		public String toString() {
			return "Nuts....";
		}
	}
	
}
//==============================================================================================
//class Ibaco{
//	public Cream makeIceCream(Nuts nuts,Fruits fruits) {
//		Cream iceCream=new Cream();
//		iceCream.add(nuts,fruits);
//		return iceCream;
//	}
//	
//	class Cream{
//		Nuts nuts;Fruits fruits;
//		public void add(Nuts nuts,Fruits fruits) {
//			this.nuts=nuts;
//			this.fruits=fruits;
//		}
//		@Override
//		public String toString() {
//			return "Cream...:"+nuts+":"+fruits+"Cost is..:"+(this.cost()+nuts.cost()+fruits.cost());
//			
//		}
//		public int cost() {
//			return 10;
//		}
//	}
//	class Nuts{
//		public int cost() {
//			return 10;
//		}
//		@Override
//		public String toString() {
//			return "Nuts....";
//		}
//	}
//	class Fruits{
//		public int cost() {
//			return 5;
//		}
//		@Override
//		public String toString() {
//			return "Fruits....";
//		}
//	}
//}









