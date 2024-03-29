package lapd.com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lapd.com.classes.Status.TypeStatus;
import lapd.com.config.Configuration;

public class StatusDAO {

	public static Status createStatus (String statusCode) {
		
		Status st = null;
		
		try {
		
			Connection c = DriverManager.getConnection(Configuration.getURLDB(), "postgres", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM statuses WHERE code = ?");
			
			ps.setString(1, statusCode);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				TypeStatus ts = null;
				String des = rs.getString("description");
				
				try {
					ts = TypeStatus.valueOf(rs.getString("code"));
				} catch (IllegalArgumentException iae) {
					ts = TypeStatus.INVALID;
				}
				
				st = new Status(ts, des);
				
			}
		
			c.close();
			
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		
		return st;
		
	}
	
}