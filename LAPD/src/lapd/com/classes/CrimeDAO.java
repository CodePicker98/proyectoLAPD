package lapd.com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CrimeDAO {
	
	public static Crime createCrime (int drNumber) {
		Crime cri = null;
		
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectolapd","postgres","root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM Crimes WHERE dr_number = ?");
			
			ps.setInt(1, drNumber);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int drNum = rs.getInt("dr_number");
				LocalDate reported = rs.getDate("date_reported").toLocalDate();
				LocalDate ocurred = rs.getDate("date_ocurred").toLocalDate();
				LocalTime timeOcurred = rs.getTime("time_ocurred").toLocalTime();
				 Area a = AreaDAO.createArea(rs.getInt("area"));
				 Victim vi = VictimDAO.createVictim(rs.getInt("victim"));
				 Premise pre = PremiseDAO.createPremise(rs.getDouble("premise"));
				 Status stat = StatusDAO.createStatus(rs.getString("status"));
				 Address ad = AddressDAO.createAddress(rs.getInt("Address"));
				 
				 ArrayList<CrimeType> crimeTypes = new ArrayList<>();
				 
				 for(int i = 1; i <= 4 ; i++) {
					 CrimeType ct1 = CrimeTypeDAO.createCrimeType(rs.getInt("crime_code_"+i));
					 if(!rs.wasNull()) {
						 crimeTypes.add(ct1);
					 }
				 }
				 
				 
				 Weapon weap = WeaponDAO.createWeapon(rs.getInt("weapon"));
				 
				 if(rs.wasNull()) {
					 cri = new Crime(drNum, reported, ocurred, timeOcurred, ad, a, crimeTypes, pre, stat, vi);
				 } else {
					 cri = new Crime(drNum, reported, ocurred, timeOcurred, ad, a, crimeTypes, pre, stat, vi, weap);
				 }
				 
			}
			
			c.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cri;
	}

}
