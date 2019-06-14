package lapd.com.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

public class GeneratorHTML {
	
	public void generateHTML (Crime c) {
	
		PebbleEngine engine = new PebbleEngine.Builder().build();
		
		try {
			
			PebbleTemplate compiledTemplate = engine.getTemplate("templates\\HTMLCrime\\HTMLCrimen.html");
			
			Writer writer = new StringWriter();
			
			Map <String, Object> contextForWrite = new HashMap<>();
		
			contextForWrite.put("drCode", c.getDrNumber());
			contextForWrite.put("date1", c.getDateReported());
			contextForWrite.put("date2", c.getDateOcurred());
			contextForWrite.put("hour", c.getTimeOcurred());
			
			contextForWrite.put("address", c.getAddress());
			contextForWrite.put("area", c.getArea());
			contextForWrite.put("premise", c.getPremise());
			contextForWrite.put("status", c.getStatus());
			contextForWrite.put("victim", c.getVictim());
			contextForWrite.put("weapon", c.getWeapon());
			contextForWrite.put("crimeTypes", c.getCrimeTypes());
			
			compiledTemplate.evaluate(writer, contextForWrite);
			
			String outputBW = writer.toString();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("outputs\\pruebaHTMLCrimen.html"));
			bw.write(outputBW);
			bw.close();
			
			System.out.println("HTML del Crimen generado correctamente...");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

	}
		
	public void generateHTML (int areaNumber) {}
		
		Connection c;
		PebbleEngine engine = new PebbleEngine.Builder().build();
		
		try {
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectolapd", "postgres", "root");
			PebbleTemplate compiledTemplate = engine.getTemplate("templates\\HTMLCrimeArea\\AreaCrime.html");
			
			Writer writer = new StringWriter();
			
			Map <String, Object> contextForWrite = new HashMap<>();
			
			PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM crimes WHERE area = ?");
			ps.setInt(1, areaNumber);
			ResultSet numCrimes = ps.executeQuery();
			numCrimes.next();
			contextForWrite.put("num_crimes", numCrimes.getInt("count"));
			
			PreparedStatement ps2 = c.prepareStatement("SELECT count(*) FROM crimes WHERE area = ?");
			ps2.setInt(1, areaNumber);
			ResultSet numVictims = ps2.executeQuery();
			numVictims.next();
			contextForWrite.put("victim_num", numVictims.getInt("count"));
			
			PreparedStatement ps3 = c.prepareStatement("SELECT count(*) FROM crimes cr INNER JOIN victims vi ON cr.victim = vi.id WHERE area = ? AND sex = ?");
			
			ps3.setInt(1, areaNumber);
			ps3.setString(2, "F");
			ResultSet numWomans = ps3.executeQuery();
			numWomans.next();
			contextForWrite.put("female_times", numWomans.getInt("count"));
			
			ps3.setInt(1, areaNumber);
			ps3.setString(2, "M");
			ResultSet numMans = ps3.executeQuery();
			numMans.next();
			contextForWrite.put("male_times", numMans.getInt("count"));
			
			PreparedStatement ps4 = c.prepareStatement ("SELECT count(*) FROM crimes cr INNER JOIN victims vi ON cr.victim = vi.id WHERE area = ? AND descent = ?");
			
			ps4.setInt(1, areaNumber);
			ps4.setString(2, "W");
			ResultSet white = ps4.executeQuery();
			white.next();
			contextForWrite.put("while_times", white.getInt("count"));
			
			ps4.setInt(1, areaNumber);
			ps4.setString(2, "B");
			ResultSet black = ps4.executeQuery();
			black.next();
			contextForWrite.put("black_times", black.getInt("count"));
			
			ps4.setInt(1, areaNumber);
			ps4.setString(2, "H");
			ResultSet hispanic = ps4.executeQuery();
			hispanic.next();
			contextForWrite.put("hispanic_times", hispanic.getInt("count"));
			
			ps4.setInt(1, areaNumber);
			ps4.setString(2, "A");
			ResultSet asian = ps4.executeQuery();
			asian.next();
			contextForWrite.put("asian_times", asian.getInt("count"));
			
			ps4.setInt(1, areaNumber);
			ps4.setString(2, "O");
			ResultSet other = ps4.executeQuery();
			other.next();
			contextForWrite.put("other_times", other.getInt("count"));
			
			ps4.setInt(1, areaNumber);
			ps4.setString(2, "X");
			ResultSet unknown = ps4.executeQuery();
			unknown.next();
			contextForWrite.put("unknown_times", unknown.getInt("count"));
			
			PreparedStatement ps5 = c.prepareStatement("SELECT ROUND(AVG(age),2) FROM crimes cr INNER JOIN victims vi ON cr.victim = vi.id WHERE cr.area = ? AND vi.age > 0");
			
			ps5.setInt(1, areaNumber);
			ResultSet avgAge = ps5.executeQuery();
			avgAge.next();
			contextForWrite.put("avg_age", avgAge.getInt("round"));
			
			
			compiledTemplate.evaluate(writer, contextForWrite);
			
			String outputBW = writer.toString();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("outputs\\AreaCrimen.html"));
			bw.write(outputBW);
			bw.close();
			
			System.out.println("HTML del Area generado correctamente...");
			
			c.close();
			
		} catch (PebbleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}		