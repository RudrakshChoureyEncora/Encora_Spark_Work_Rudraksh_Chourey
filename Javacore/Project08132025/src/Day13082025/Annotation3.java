package Day13082025;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class Annotation3 {
	public static void main(String[] args)throws Exception {
		Bhai salmanbhai=new Bhai();
		salmanbhai.buyRakhee(new Dukaandaar());
	}
}
class Bhai{
	public void buyRakhee(Dukaandaar nukkadshop)throws Exception {
		Rakhee rakhee=nukkadshop.sellRakhee();
		Rakhee2 r2=nukkadshop.selRakhee2();
		System.out.println(rakhee);
		System.out.println();
		System.out.println("For Rakhee 2");
		System.out.println(r2);
	}
}
class Dukaandaar{
	public Rakhee sellRakhee()throws Exception {
		Rakhee rakhee=new Rakhee();
		Class c=rakhee.getClass();
		Field f=c.getDeclaredField("diamonds");
		f.setAccessible(true);
		Inject inject=(Inject)f.getAnnotation(Inject.class);
		if(inject!=null) {
			String value=inject.moneyValue();
			rakhee.diamonds="diamonds set with value..:"+value;
		}
		f=c.getDeclaredField("gold");
		f.setAccessible(true);
		inject=(Inject)f.getAnnotation(Inject.class);
		if(inject!=null) {
			String value=inject.moneyValue();
			rakhee.gold="gold set with value..:"+value;
			System.out.println("this Code Ran");
		}
		f=c.getDeclaredField("moti");
		f.setAccessible(true);
		inject=(Inject)f.getAnnotation(Inject.class);
		if(inject!=null) {
			String value=inject.moneyValue();
			rakhee.moti="moti set with value..:"+value;
		}
		return rakhee;
	}
	
	public Rakhee2 selRakhee2() {
		Rakhee2 rakhee2=new Rakhee2();
		Class r2=rakhee2.getClass();
		inject2 inj2=(inject2)r2.getAnnotation(inject2.class);
		if(inj2!=null) {
			rakhee2.diamonds="Diamond's Value is: "+inj2.DVal();
			rakhee2.gold="Gold's Value is: "+inj2.GVal();
		}
		return rakhee2;
	}
}
@Retention(RetentionPolicy.RUNTIME)
@interface Inject{
	String moneyValue();
}


class Rakhee{
	@Inject(moneyValue="million dollor")
	String diamonds;
	
	String moti;
	
	@Inject(moneyValue="2 million")
	String gold;
	public String toString() {
		return diamonds+":"+moti+":"+gold;
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface inject2{
	String DVal();
	String GVal();
}


@inject2(DVal="Million Dollar",GVal="2 Million")
class Rakhee2{
	public String diamonds;
	public String moti;
	public String gold;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return diamonds+"\n"+moti+"\n"+gold;
	}
}








