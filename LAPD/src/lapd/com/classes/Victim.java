package lapd.com.classes;

public class Victim {
	
	public enum Gender {F, M, H, X, INVALID};
	public enum TypeDescent {W, B, H, X, O, V, J, Z, D, I, K, P, G, S, U, A, C, L, F, INVALID};

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
	
	@Override
	public String toString () {
		
		return id + ";" + age + ";" + sex + ";" + descent;
		
	}
}