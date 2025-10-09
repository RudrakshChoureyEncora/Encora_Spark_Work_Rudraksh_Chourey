package CollectDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class MapCollections {
	public static void main(String[] args) {
		Map<String,String> hm=new HashMap<>();
		hm.put("a","one");
		hm.put("b","one");
		hm.put("c","one");
		hm.put("d","one");
		hm.keySet().forEach(c->{System.out.println(c+":"+hm.get(c));});
		System.out.println(hm);
		
		Map<abc,String> tm=new TreeMap<>();
		tm.put(new abc("Ram",1), "Sharma");
		System.out.println(tm);
	}
}

class abc implements Comparable<abc>{
	String name;
	int age;
	public abc(String name,int age) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.age=age;
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
		abc other = (abc) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	@Override
	public int compareTo(abc o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
