package encoraRudraksh;
/*
 * public : Global Scope
 * Private : Class Scope
 * Protected : Relation Scope
 * default/blank : Package Scope
 * refer accessiblityModifier2 for different package example.
 * */
public class accessiblityModifier {
	public int pub;
	private int pri;
	protected int pro;
	int nomod;
	void test() {
		System.out.println(pub);
		System.out.println(pri);
		System.out.println(pro);
		System.out.println(nomod);
	}
	
	
}


class subClass extends accessiblityModifier {
	void test() {
		System.out.println(pub);
//		System.out.println(pri);
		System.out.println(pro);
		System.out.println(nomod);
	}
}

class notSubClass{
	void test() {
		accessiblityModifier obj = new accessiblityModifier();
		System.out.println(obj.pub);
//		System.out.println(obj.pri);
		System.out.println(obj.pro);
		System.out.println(obj.nomod);
	}
}