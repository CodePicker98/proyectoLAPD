package lapd.com.classes;

public class CrimeType {
	
	private int code;
	private String description;
	private String moCode;
	
	CrimeType(int code, String description, String moCode){
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
	
	

}
