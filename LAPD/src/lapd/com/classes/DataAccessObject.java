package lapd.com.classes;

import java.util.ArrayList;
import java.time.LocalDate;
import java.sql.*;

public class DataAccessObject {
	
	private int limit = 5;
	private int startPoint;

	public ArrayList <Crime> getCrimes (int areaNumber) {
		
		ArrayList <Crime> crimes = new ArrayList<>();
		
		try {
			
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectolapd", "postgres", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM crimes WHERE area = ? LIMIT ? OFFSET ?");
			
			ps.setInt(1, areaNumber);
			
			//cambiaremos el limite por el getNumLineas de la clase de config.
			ps.setInt(2, limit);
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
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectolapd", "postgres", "root");
			
			PreparedStatement ps = c.prepareStatement("SELECT * FROM crimes WHERE date_ocurred BETWEEN ? AND ? LIMIT ? OFFSET ?");
			
			ps.setDate(1, Date.valueOf(dateInit));
			ps.setDate(2, Date.valueOf(dateFinal));
			
			//cambiaremos el limite por el getNumLineas de la clase de config.
			ps.setInt(3, limit);
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