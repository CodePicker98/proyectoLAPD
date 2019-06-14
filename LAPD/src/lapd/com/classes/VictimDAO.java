package lapd.com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lapd.com.classes.Victim.Gender;
import lapd.com.classes.Victim.TypeDescent;

public class VictimDAO {

	public static Victim createVictim (int victimID) {
		
		Victim vi = null;
		
		try {
		
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectolapd", "postgres", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM victims WHERE id = ?");
			
			ps.setInt(1, victimID);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				Gender g = null;
				TypeDescent td = null;
				int id = rs.getInt("id");
				int age = rs.getInt("age");
				
				try {
					g = Gender.valueOf(rs.getString("sex"));
				} catch (IllegalArgumentException iae) {
					g = Gender.INVALID;
				}
				
				try {
					td = TypeDescent.valueOf(rs.getString("descent"));
				} catch (IllegalArgumentException iae) {
					td = TypeDescent.INVALID;
				}
				
				vi = new Victim(id, age, g, td);
			
			}
		
			c.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vi;
		
	}
	
}