package NewConcp;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class OptionalPrac {
	public static void main(String[] args) {
		List<Student1> list=new ArrayList<Student1>();
		list.add(new Student1("ramu",450));
		list.add(new Student1("somu",450));
		list.add(new Student1("salman",420));
		list.add(new Student1("sharukh",420));
		System.out.println(list);
		list.sort((s1,s2)->{return s1.compareTo(s2);});
		System.out.println(list);
		
		list.forEach(System.out::println);
		list.forEach((s)->System.out.println(s));
		
	}
}
class MySupplier implements Supplier<Integer>{
	@Override
	public Integer get() {
		// TODO Auto-generated method stub
		return null;
	}
}
class Student1 implements Comparable<Student1>{
	String name;
	int marks;
	public Student1(String name,int marks) {
		this.name=name;this.marks=marks;
	}
	 static int abc=0;
	@Override
	public int compareTo(Student1 o) {
//		int result=this.marks-o.marks;
//		if(result==0) {
//			result=this.name.compareTo(o.name);
//		}
//		return result;
		int result=this.marks-o.marks;
		
		Optional.of(result)
		.filter((n)->{return n!=0;})
		.ifPresent(c->{abc=40;})
		;	
		
		int a=(5<4)?8:8;
		return 1;
		
	}
	@Override
	public String toString() {
		return name+":"+marks;
	}
}