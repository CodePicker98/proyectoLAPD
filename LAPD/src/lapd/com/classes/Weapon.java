package lapd.com.classes;

public class Weapon {

	private int code;
	private String description;
	
	public Weapon (int code, String description) {
		
		this.code = code;
		this.description = description;
		
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString () {
		
		return code + " " + description;
		
	}
	
}