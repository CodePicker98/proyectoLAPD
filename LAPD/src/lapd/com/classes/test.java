package lapd.com.classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		
		DataAccessObject dao = new DataAccessObject();
		
		ArrayList<Crime> crimenes = dao.getCrimes(1);
		
		LocalDate ld1 = LocalDate.of(2010, 07, 01);
		LocalDate ld2 = LocalDate.of(2010, 10, 01);
		
		ArrayList<Crime> crimenes2 = dao.getCrimes(ld1,ld2);
		
		GeneratorHTML ghtm = new GeneratorHTML();
		
		Crime c = CrimeDAO.createCrime(70309629);
		ghtm.generateHTMLCrime(c);
	}

}
