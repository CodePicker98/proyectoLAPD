package lapd.com.classes;

public class Adress {

	private int id;
	private String adressStreet;
	private String crossStreet;
	private String geoLocation;
	private int reportingDistrict;
	
	Adress (int id, String adressStreet, String crossStreet, String geoLocation, int reportingDistrict) {
		
		this.id = id;
		this.adressStreet = adressStreet;
		this.crossStreet = crossStreet;
		this.geoLocation = geoLocation;
		this.reportingDistrict = reportingDistrict;
		
	}
	
	Adress (int id, String adressStreet, String geoLocation, int reportingDistrict) {
		
		this.id = id;
		this.adressStreet = adressStreet;
		this.geoLocation = geoLocation;
		this.reportingDistrict = reportingDistrict;
		
	}
	
	public int getId() {
		return id;
	}
	public String getAdressStreet() {
		return adressStreet;
	}
	public String getCrossStreet() {
		return crossStreet;
	}
	public String getGeoLocation() {
		return geoLocation;
	}
	public int getReportingDistrict() {
		return reportingDistrict;
	}
	
}