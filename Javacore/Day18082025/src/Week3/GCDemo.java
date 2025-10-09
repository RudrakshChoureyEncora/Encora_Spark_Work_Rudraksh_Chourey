package Week3;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
//-XX:+UseParallelGC
public class GCDemo {
	public static void main(String[] args) {
		Runtime rt=Runtime.getRuntime();
		System.out.println("Memory before daddu..:"+rt.freeMemory());
		GrandFather daddu=new GrandFather();
		System.out.println("Memory after daddu...:"+rt.freeMemory());
		//SoftReference<GrandFather> soft=new SoftReference<>(daddu);
//		WeakReference<GrandFather> weakref=new WeakReference<>(daddu);
		daddu=null;
		System.out.println("After daddus death...:"+rt.freeMemory());
		rt.gc();
		System.out.println("After daddus kriyakaram...:"+rt.freeMemory());
		//System.out.println("daddu comes back....");
		//daddu=soft.get();
		//System.out.println(daddu);
	}
}
class GrandFather{
	String age;
	private String gold="under the tree....";
	public GrandFather() {
		for(int i=0;i<10000;i++) {
			age=new String(".."+i);
		}
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("the gold is...:"+gold);
	}
}





