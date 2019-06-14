package lapd.com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WeaponDAO {

	public Weapon createWeapon (int weaponCode) {
		
		Weapon we = null;
		
		try {
		
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectolapd", "postgres", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM weapons WHERE code = ?");
			
			ps.setInt(1, weaponCode);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				int code = rs.getInt("code");
				String des = rs.getString("description");
				
				we = new Weapon(code, des);
				
			}
		
			c.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return we;
		
	}
	
}