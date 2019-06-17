package lapd.com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import lapd.com.config.Configuration;

public class AreaDAO {

	public static Area createArea (int areaID) {
		
		Area ar = null;
		
		try {
		
			Connection c = DriverManager.getConnection(Configuration.getURLDB(), "postgres", "root");
			
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
			Log.error(e.getMessage());
		}
		return ar;	
	}
	
	public static ArrayList<Area> getAreas () {
		
		ArrayList <Area> aa = new ArrayList<>();
		
		try {
			
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectolapd", "postgres", "root");
			
			Statement s = c.createStatement();
	
			ResultSet rs = s.executeQuery("SELECT DISTINCT * FROM areas;");
			
			while (rs.next()) {
				aa.add(new Area (rs.getInt("id"), rs.getString("name")));
			}
			
			c.close();
			
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		
		return aa;
	}
	
	
	
}