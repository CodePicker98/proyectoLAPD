package lapd.com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lapd.com.config.Configuration;

public class WeaponDAO {

	public static Weapon createWeapon (int weaponCode) {
		
		Weapon we = null;
		
		try {
		
			Connection c = DriverManager.getConnection(Configuration.getURLDB(), "postgres", "root");
			
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
			Log.error(e.getMessage());
		}
		
		return we;
		
	}
	
}