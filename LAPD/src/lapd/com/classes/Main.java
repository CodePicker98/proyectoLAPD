package lapd.com.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		
		System.out.println("Welcome to Los Ángeles Police Department");
		System.out.println("What do you want?");
		
		int opt = 0;
		String confirmation = "";
		LocalDate date1 = null;
		LocalDate date2 = null;
		
		DataAccessObject dao = new DataAccessObject();
		
		GeneratorHTML gHTML = new GeneratorHTML();
		
		do {
			
			System.out.println("\n1. List city areas");
			System.out.println("2. Crimes between dates");
			System.out.println("3. Generate HTML of a Crime");
			System.out.println("4. Generate HTML of an Area");
			System.out.println("5. Exit");
			opt = Integer.parseInt(sc.nextLine());
			
			switch (opt) {
			
				case 1:
					
					Iterator <Area> itA= AreaDAO.getAreas().iterator();
					
					while (itA.hasNext()) {
						
						System.out.println(itA.next().toString());
						
					}
					
					System.out.println("Do you want to list the crimes of an especific area?(\"s\"/anything)");
					confirmation = sc.nextLine();
					
					if (confirmation.equals("s")) {
						
						System.out.println("Tell me the Area ID:");
						int areaID = Integer.parseInt(sc.nextLine());
						
						Iterator <Crime> itCA = dao.getCrimes(areaID).iterator();
					
						while (itCA.hasNext()) {
							
							System.out.println(itCA.next().toString());
							
						}
						
					}
					
					Log.info("The areas have been listed.");
					
					System.out.println("\nReturning to the menu...");					
					break;
					
				case 2:
					
					DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
					
					System.out.println("Tell me the first Date(with the format dd/MM/yyyy)");
					String firstDate = sc.nextLine();
					date1 = LocalDate.parse(firstDate, dtf);
					
					System.out.println("Tell me the second Date(with the format dd/MM/yyyy)");
					String secondDate = sc.nextLine();
					date2 = LocalDate.parse(secondDate, dtf);
									
					do {
						
						Iterator <Crime> itCD = dao.getCrimes(date1, date2).iterator();
						
						while (itCD.hasNext()) {
							
							System.out.println(itCD.next().toString());
							
						}
					
						System.out.println("Show the following crimes?(\"s\"/anything)");
						confirmation = sc.nextLine();
						
					} while (confirmation.equals("s"));	
					
					Log.info("The crimes have been listed.");
					
					System.out.println("\nReturning to the menu...");
					break;
					
				case 3:
					
					System.out.println("Tell me the Crime number(dr Number)");
					int drNumber = Integer.parseInt(sc.nextLine());
					
					Crime c = CrimeDAO.createCrime(drNumber); 
					
					gHTML.generateHTML(c);
					
					System.out.println("HTML correctly created.");
					
					Log.info("The HTML has been created correctly.");
					
					System.out.println("\nReturning to the menu...");
					break;
					
				case 4:
					
					System.out.println("Tell me the Area ID");
					int idArea = Integer.parseInt(sc.nextLine());
					
					gHTML.generateHTML(idArea);
					
					System.out.println("HTML correctly created.");
					
					Log.info("The HTML has been created correctly.");
					
					System.out.println("\nReturning to the menu...");
					break;
					
				case 5:
					
					System.out.println("Goodbye Agent.");
					break;
					
				default:
					
					System.out.println("Invalid Option");
					System.out.println("Returning to the menu...");
					break;
					
			}
			
		} while (opt != 5);
		
		sc.close();
		
	}

}