package lapd.com.classes;

import java.util.Map;
import java.util.ArrayList;
import java.time.LocalTime;

public class DataAccessObject {

	private Map <Integer, ArrayList<Crime>> crimesList;
	
	public ArrayList <Area> listAreas () {
		
		ArrayList <Area> a = new ArrayList<>();
		
		return a;
		
	}
	
	public ArrayList <Crime> listCrimesArea () {
		
		ArrayList <Crime> a = new ArrayList<>();
		
		return a;
		
	}
	
	public ArrayList <Crime> getCrimesDates (LocalTime date1, LocalTime date2) {
		
		ArrayList <Crime> a = new ArrayList<>();
		
		return a;
		
	}

	public Map<Integer, ArrayList<Crime>> getCrimesList() {
		return crimesList;
	}
	
}