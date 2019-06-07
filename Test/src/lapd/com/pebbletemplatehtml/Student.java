package lapd.com.pebbletemplatehtml;

public class Student {
	
	private String name;
	private int age;
	private boolean legs;
	
	public Student(String name, int age, boolean legs) {
		this.name = name;
		this.age = age;
		this.legs = legs;
	}
	
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public boolean isLegs() {
		return legs;
	}
}
