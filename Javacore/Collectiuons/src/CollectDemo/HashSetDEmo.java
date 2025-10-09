package CollectDemo;

import java.util.Set;


import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;

//public class HashSetDEmo {
//	
//}
//
//
//class abc implements Comparable<abc>{
//	String name;
//	int age;
//	
//	@Override
//	public int compareTo(abc o) {
//		// TODO Auto-generated method stub
//		
//		
//		return 0;
//	}
//	
//}




class Employees implements Comparable<Employees>{
	String name;
	int age;
	public Employees(String name,int age) {
		this.name=name;this.age=age;
	}
	@Override
	public int compareTo(Employees o) {
		int result=this.name.compareTo(o.name);
		int r=this.name.compareTo(o.name);
		int i=Optional.ofNullable(r).filter(new MyPredicate()).orElseGet(()->{return this.age-o.age;});
		return i;
		
	}
	
	class MyPredicate implements Predicate<Integer>{
		@Override
		public boolean test(Integer t) {
			// TODO Auto-generated method stub
			return t==0;
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
		Employees other = (Employees) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
}









