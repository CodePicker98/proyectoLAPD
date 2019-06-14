package lapd.com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CrimeTypeDAO {

	public static CrimeType createCrimeType (int crimeTypeCode) {
		
		CrimeType ct = null;
		
		try {
		
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectolapd", "postgres", "root");
			
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
			
			e.printStackTrace();
			
		}
		
		return ct;
		
	}
	
}