package CollectDemo;



import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ColDemo4 {
	public static void main(String[] args) {
		System.out.println("hello");
		Set<Empl3> myset=new HashSet<Empl3>();
		Set<Empl3> myset1=new TreeSet<Empl3>();
		myset.add(new Empl3("ramu",20));
		myset.add(new Empl3("ramu",20));
		myset.add(new Empl3("amitabh",70));
		myset.add(new Empl3("kishore",50));
		myset.add(new Empl3("amitabh",20));
		myset1.add(new Empl3("ramu",20));
		myset1.add(new Empl3("ramu",20));
		myset1.add(new Empl3("amitabh",70));
		myset1.add(new Empl3("kishore",50));
		myset1.add(new Empl3("amitabh",20));
		
		System.out.println(myset1);
		System.out.println(myset);
		
		
		
	}
}

class Empl3 implements Comparable<Empl3>{
	String name;
	int age;
	public Empl3(String name,int age) {
		this.name=name;this.age=age;
	}
	@Override
	public String toString() {
		return this.name+":"+this.age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empl3 other = (Empl3) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	@Override
	public int compareTo(Empl3 o) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.name.compareTo(o.name)).filter((n)->{return n!=0;}).orElseGet(()->{return this.age-o.age;});
	}
	
}


class Empl2 implements Comparable<Empl2>{
	String name;
	int age;
	public Empl2(String name,int age) {
		this.name=name;this.age=age;
	}
	@Override
	public int compareTo(Empl2 o) {
//		int result=this.name.compareTo(o.name);
//		if(result==0) {
//			return this.age-o.age;
//		}
//		else {
//			return result;
//		}
		

		return Optional.of(this.name.compareTo(o.name))
		//return Optional.of(o)
		.filter((n)->n!=0)
		.orElseGet(()->this.age-o.age);
		//.filter(new MyPredicate(this,o))
		//.orElseGet(new MySupplier(this,o));
	}
	class MyPredicate implements Predicate<Empl2>{
		Empl2 e1,e2;
		public MyPredicate(Empl2 e1,Empl2 e2) {
			this.e1=e1;
			this.e2=e2;
		}
		@Override
		public boolean test(Empl2 t) {
			return e1.name.compareTo(e2.name)!=0;
		}
	}
	class MySupplier implements Supplier<Integer>{
	Empl2 e1,e2;
	public MySupplier(Empl2 e1,Empl2 e2) {
		this.e1=e1;
		this.e2=e2;
	}
	@Override
		public Integer get() {
			// TODO Auto-generated method stub
			return e1.age-e2.age;
		}
}
	@Override
	public String toString() {
		return this.name+":"+this.age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empl2 other = (Empl2) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
}




