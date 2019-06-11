package lapd.com.classes;

public class Premise {

	private int code;
	private String description;
	
	Premise (int code, String description) {
		
		this.code = code;
		this.description = description;
		
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
}