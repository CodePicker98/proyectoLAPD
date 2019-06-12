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
	
	public ArrayList <Crime> showCrimesDates (LocalTime date1, LocalTime date2) {
		
		ArrayList <Crime> a = new ArrayList<>();
		
		return a;
		
	}
	
	public void generateHTMLCrime (int crimeNumber) {
		
	}
	
	public void generateHTMLArea (int areaNumber) {
		
	}

	public Map<Integer, ArrayList<Crime>> getCrimesList() {
		return crimesList;
	}
	
}