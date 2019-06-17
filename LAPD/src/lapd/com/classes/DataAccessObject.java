package lapd.com.classes;

import java.util.ArrayList;

import lapd.com.config.Configuration;

import java.time.LocalDate;
import java.sql.*;

public class DataAccessObject {
	
	private int limit = 5;
	private int startPoint;

	public ArrayList <Crime> getCrimes (int areaNumber) {
		
		ArrayList <Crime> crimes = new ArrayList<>();
		
		try {
			
			Connection c = DriverManager.getConnection(Configuration.getURLDB(), "postgres", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM crimes WHERE area = ? LIMIT ? OFFSET ?");
			
			ps.setInt(1, areaNumber);
			
			ps.setInt(2, Integer.parseInt(Configuration.getLines()));
			ps.setInt(3, startPoint);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Crime crime = CrimeDAO.createCrime(rs.getInt("dr_number"));
				crimes.add(crime);				
			}
			
			startPoint += limit;
			
			c.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return crimes;
		
	}
	
	public ArrayList <Crime> getCrimes (LocalDate dateInit, LocalDate dateFinal) {
		
		ArrayList <Crime> crimes = new ArrayList<>();
		
		try {
			Connection c = DriverManager.getConnection(Configuration.getURLDB(), "postgres", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM crimes WHERE date_ocurred BETWEEN ? AND ? LIMIT ? OFFSET ?");
			
			ps.setDate(1, Date.valueOf(dateInit));
			ps.setDate(2, Date.valueOf(dateFinal));
			ps.setInt(3, Integer.parseInt(Configuration.getLines()));
			ps.setInt(4, startPoint);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Crime crime = CrimeDAO.createCrime(rs.getInt("dr_number"));
				crimes.add(crime);	
			}
			
			startPoint += limit;
			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return crimes;
		
	}
	
	public void resetStartPoint() {
		startPoint = 0;
	}
	
}