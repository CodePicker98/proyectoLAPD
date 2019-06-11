package lapd.com.classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Crime {

	private int drNumber;
	private LocalDate dateReported;
	private LocalDate dateOcurred;
	private LocalTime timeOcurred;
	
	private Address address;
	private Area area;
	private ArrayList<CrimeType> crimeTypes;
	private Premise premise;
	private Status status;
	private Victim victim;
	private Weapon weapon;
	
	Crime (int drNumber, LocalDate dateReported, LocalDate dateOcurred, LocalTime timeOcurred, Address address, Area area, ArrayList<CrimeType> crimeTypes, Premise premise, Status status, Victim victim) {
		
		this.drNumber = drNumber;
		this.dateReported = dateReported;
		this.dateOcurred = dateOcurred;
		this.timeOcurred = timeOcurred;
		this.address = address;
		this.area = area;
		this.crimeTypes = crimeTypes;
		this.premise = premise;
		this.status = status;
		this.victim = victim;
		
	}
	
	Crime (int drNumber, LocalDate dateReported, LocalDate dateOcurred, LocalTime timeOcurred, Address address, Area area, ArrayList<CrimeType> crimeTypes, Premise premise, Status status, Victim victim, Weapon weapon) {
		
		this(drNumber, dateReported, dateOcurred, timeOcurred, address, area, crimeTypes, premise, status, victim);
		this.weapon = weapon;
		
	}

	public int getDrNumber() {
		return drNumber;
	}

	public LocalDate getDateReported() {
		return dateReported;
	}

	public LocalDate getDateOcurred() {
		return dateOcurred;
	}

	public LocalTime getTimeOcurred() {
		return timeOcurred;
	}

	public Address getAddress() {
		return address;
	}

	public Area getArea() {
		return area;
	}

	public ArrayList<CrimeType> getCrimeTypes() {
		return crimeTypes;
	}

	public Premise getPremise() {
		return premise;
	}

	public Status getStatus() {
		return status;
	}

	public Victim getVictim() {
		return victim;
	}

	public Weapon getWeapon() {
		return weapon;
	}
	
}