package lapd.com.classes;

public class CrimeType {
	
	private int code;
	private String description;
	private String moCode;
	
	public CrimeType(int code, String description, String moCode){
		this.code = code;
		this.description = description;
		this.moCode = moCode;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getMoCode() {
		return moCode;
	}
	
	@Override
	public String toString () {
		
		return code + " " + description + " " + moCode;
		
	}

}