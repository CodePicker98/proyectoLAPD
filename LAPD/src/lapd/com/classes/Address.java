package lapd.com.classes;

public class Address {

	private int id;
	private String adressStreet;
	private String crossStreet;
	private String geoLocation;
	private int reportingDistrict;
	
	Address (int id, String adressStreet, String geoLocation, int reportingDistrict) {
		
		this.id = id;
		this.adressStreet = adressStreet;
		this.geoLocation = geoLocation;
		this.reportingDistrict = reportingDistrict;
		
	}
	
	Address (int id, String adressStreet, String crossStreet, String geoLocation, int reportingDistrict) {
	
		this(id, adressStreet, geoLocation, reportingDistrict);
		this.crossStreet = crossStreet;
		
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