package lapd.com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lapd.com.config.Configuration;

public class CrimeTypeDAO {

	public static CrimeType createCrimeType (int crimeTypeCode) {
		
		CrimeType ct = null;
		
		try {
		
			Connection c = DriverManager.getConnection(Configuration.getURLDB(), "postgres", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM crime_types WHERE code = ?");
			
			ps.setInt(1, crimeTypeCode);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				int code = rs.getInt("code");
				String description = rs.getString("description");
				String moCode = rs.getString("mo_code");				
				
				ct = new CrimeType (code, description, moCode);
				
			}
		
			c.close();
			
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		
		return ct;
		
	}
	
}