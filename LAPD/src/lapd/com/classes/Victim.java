package lapd.com.classes;

public class Victim {
	
	public enum Gender {F, M};
	public enum TypeDescent {W, B, H, X, O};

	private int id;
	private int age;
	private Gender sex;
	private TypeDescent descent;
	
	public Victim (int id, int age, Gender sex, TypeDescent descent) {
		
		this.id = id;
		this.age = age;
		this.sex = sex;
		this.descent = descent;
		
	}
	
	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public Gender getSex() {
		return sex;
	}
	public TypeDescent getDescent() {
		return descent;
	}
	
}