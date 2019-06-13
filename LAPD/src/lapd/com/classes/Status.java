package lapd.com.classes;

public class Status {
	
	public enum TypeStatus {
		IC,
		AA,
		AO,
		JA,
		JO
	};
	
	private TypeStatus code;
	private String description;
	
	public Status(TypeStatus code, String description){
		this.code = code;
		this.description = description;
	}
	
	public TypeStatus getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
	

}