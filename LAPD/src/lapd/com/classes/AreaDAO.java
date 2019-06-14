package lapd.com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AreaDAO {

	public Area createArea (int areaID) {
		
		Area ar = null;
		
		try {
		
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectolapd", "postgres", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM areas WHERE id = ?");
			
			ps.setInt(1, areaID);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				int id = rs.getInt("id");
				String name = rs.getString("name");	
				
				ar = new Area (id, name);
				
			}
		
			c.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return ar;
		
	}
	
}