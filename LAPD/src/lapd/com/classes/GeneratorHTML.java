package lapd.com.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.mitchellbosecke.pebble.PebbleEngine;
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

}		