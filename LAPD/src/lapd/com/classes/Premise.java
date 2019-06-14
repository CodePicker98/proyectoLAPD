package lapd.com.classes;

public class Premise {

	private int code;
	private String description;
	
	public Premise (int code, String description) {
		
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
		
		return code + ";" + description;
		
	}
	
}