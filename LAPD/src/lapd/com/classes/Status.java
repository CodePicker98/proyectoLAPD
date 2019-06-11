package lapd.com.classes;

public class Status {
	
	enum TypeStatus {
		IC,
		AA,
		AO,
		JA,
		JO
	};
	
	private TypeStatus code;
	private String description;
	
	Status(TypeStatus code, String description){
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
