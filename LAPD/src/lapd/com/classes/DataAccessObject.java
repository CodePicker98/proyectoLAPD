package lapd.com.classes;

import java.util.Map;
import java.util.ArrayList;
import java.time.LocalTime;
import java.sql.*;

public class DataAccessObject {

	private Map <Integer, ArrayList<Crime>> crimesList;
	
	public ArrayList <Area> listAreas () {
		
		ArrayList <Area> aa = new ArrayList<>();
		
		try {
			
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectoLAPD", "postgres", "root");
			
			Statement s = c.createStatement();
	
			ResultSet rs = s.executeQuery("SELECT DISTINCT * FROM areas;");
			
			while (rs.next()) {
				
				aa.add(new Area (rs.getInt("id"), rs.getString("name")));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return aa;
		
	}
	
	public ArrayList <Crime> listCrimesArea (int areaNumber) {
		
		ArrayList <Crime> ac = new ArrayList<>();
		
		try {
			
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectoLAPD", "postgres", "root");
			
			Statement s = c.createStatement();
	
			ResultSet rs = s.executeQuery("SELECT * FROM crimes WHERE area = " + areaNumber + ";");
			
			while (rs.next()) {
				
				//ac.add(new Crime(rs.getInt("dr_number"), rs.getDate("date_reported"), rs.getDate("date_ocurred"), rs.getTime("time_ocurred"), rs.getInt("area"), rs.getInt("crime_code_1"), rs.getInt("crime_code_2"), rs.getInt("crime_code_3"), rs.getInt("crime_code_4"), rs.getInt("victim"), rs.getInt("premise"), rs.getInt("weapon"), rs.getString("status"), rs.getInt("address")));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return ac;
		
	}
	
	public ArrayList <Crime> getCrimesDates (LocalTime date1, LocalTime date2) {
		
		ArrayList <Crime> a = new ArrayList<>();
		
		return a;
		
	}

	public Map<Integer, ArrayList<Crime>> getCrimesList() {
		return crimesList;
	}
	
}