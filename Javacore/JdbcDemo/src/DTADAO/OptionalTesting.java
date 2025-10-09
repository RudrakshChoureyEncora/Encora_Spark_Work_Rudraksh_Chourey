package DTADAO;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class OptionalTesting {
	public static void main(String[] args) {
		String obj="hello";
		
		Optional s=Optional.ofNullable(obj);
		Optional s2=s.map(str->"hello world");
		String r=(String)s2.orElse("null value");
		
		String a=Optional.ofNullable(obj).filter(new myfil()).map(new myFunc()).orElse("0");	
		
//		Optional.ofNullable(obj).filter(new myfil()).
		System.out.println(a);
		
	}
	
	
}

class myfil implements Predicate<String>{
	@Override
	public boolean test(String t) {
		// TODO Auto-generated method stub
		return t.equals(t);
	}
}


class myFunc implements Function<String, String>{
	@Override
	public String apply(String t) {
		// TODO Auto-generated method stub
		return "t.length()";
	}
}
