package lapd.com.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

public class MainLuis {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		
		System.out.println("Welcome to Los Ángeles Police Department");
		System.out.println("What do you want?");
		
		int opt = 0;
		String confirmation = "";
		LocalDate date1 = null;
		LocalDate date2 = null;
		
		DataAccessObject dao = new DataAccessObject();
		
		do {
			
			System.out.println("1. List city areas");
			System.out.println("2. Crimes between dates");
			System.out.println("3. Generate HTML of a Crime");
			System.out.println("4. Generate HTML of an Area");
			System.out.println("5. Exit");
			opt = sc.nextInt();
			sc.nextLine();
			
			switch (opt) {
				case 1:
					
					
					System.out.println("Do you want to list the crimes of an especific area?(\"s\"/anything)");
					confirmation = sc.nextLine();
					
					Iterator <Area> it = dao.listAreas().iterator();
					
					while (it.hasNext()) {
						
						System.out.println(it);
						
					}
					
					if (confirmation.equals("s")) {
						
						System.out.println("Tell me the Area ID:");
						String areaID = sc.nextLine();
						
					}
					
					break;
				case 2:
					
					DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
					
					System.out.println("Tell me the first Date(whit the format dd/MM/yyyy)");
					String firstDate = sc.nextLine();
					date1 = LocalDate.parse(firstDate, dtf);
					
					System.out.println("Tell me the second Date(whit the format dd/MM/yyyy)");
					String secondDate = sc.nextLine();
					date2 = LocalDate.parse(secondDate, dtf);
					
					break;
				case 3:
					
					System.out.println("Tell me the Crime number(dr Number)");
					String drNumber = sc.nextLine();
					
					
					
					break;
				case 4:
					
					System.out.println("Tell me the Area ID");
					String idArea = sc.nextLine();
					
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