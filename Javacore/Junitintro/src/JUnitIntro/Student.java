package JUnitIntro;

public class Student {
	String name;int age;boolean enrolled;

	
	public Student(String name, int age, boolean enrolled) {
		
		setAge(age);
		setName(name);
		setEnrolled(enrolled);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isEnrolled() {
		return enrolled;
	}

	public void setEnrolled(boolean enrolled) {
		this.enrolled = enrolled;
	}
}
