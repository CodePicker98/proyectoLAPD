package lapd.com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PremiseDAO {
	
	public static Premise createPremise (double code) {
		Premise pre = null;
		
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectolapd" , "postgres", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM premises WHERE code = ?");
			
			ps.setDouble(1, code);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int cod = rs.getInt("code");
				String desc = rs.getString("description");
				
				pre = new Premise(cod, desc);
			}
			
			c.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pre;
		
	}

}
