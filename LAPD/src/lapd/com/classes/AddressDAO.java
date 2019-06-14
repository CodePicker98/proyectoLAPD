package lapd.com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddressDAO {

	public static Address createAddress (int addressID) {
		
		Address ad = null;
		
		try {
		
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectolapd", "postgres", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM addresses WHERE id = ?");
			
			ps.setInt(1, addressID);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				int id = rs.getInt("id");
				String addressStreet = rs.getString("address_street");
				String crossStreest = rs.getString("cross_street");
				String geoLocation = rs.getString("geo_location");
				int reportingDistrict = rs.getInt("reporting_district");
				
				ad = new Address(id, addressStreet, crossStreest, geoLocation, reportingDistrict);
				
			}
		
			c.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ad;
		
	}
	
}