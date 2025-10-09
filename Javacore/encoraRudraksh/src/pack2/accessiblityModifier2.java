package pack2;

import encoraRudraksh.accessiblityModifier;

public class accessiblityModifier2 extends accessiblityModifier{
//	void test() {
//		System.out.println(pub);
////		System.out.println(pri);
//		System.out.println(pro);
////		System.out.println(nomod);
//	}
}


class notSubClass{
	void test() {
		accessiblityModifier obj = new accessiblityModifier();
		System.out.println(obj.pub);
//		System.out.println(obj.pri);
//		System.out.println(obj.pro);
//		System.out.println(obj.nomod);
	}
}