package lapd.com.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

public class PruebaFuncionHTMLCrimen {

	public static void main(String[] args) {
		
		DataAccessObject dao = new DataAccessObject();
		
		dao.generateHTMLCrime(011401303);

PebbleEngine engine = new PebbleEngine.Builder().build();
		
		try {
			
			PebbleTemplate compiledTemplate = engine.getTemplate("templates\\HTMLCrime\\HTMLCrimen.html");
			
			Writer writer = new StringWriter();
			
			Map <String, Object> contextForWrite = new HashMap<>();
			
			contextForWrite.put("drCode", "1");
			contextForWrite.put("date1", "2");
			contextForWrite.put("date2", "3");
			contextForWrite.put("hour", "4");
			contextForWrite.put("areaID", "5");
			contextForWrite.put("areaName", "6");
			contextForWrite.put("crimeCode1", "7");
			contextForWrite.put("crimeDescription1", "8");
			contextForWrite.put("crimeMO1", "9");
			contextForWrite.put("crimeCode2", "10");
			contextForWrite.put("crimeDescription2", "11");
			contextForWrite.put("crimeMO2", "12");
			contextForWrite.put("crimeCode3", "13");
			contextForWrite.put("crimeDescription3", "14");
			contextForWrite.put("crimeMO3", "15");
			contextForWrite.put("crimeCode4", "16");
			contextForWrite.put("crimeDescription4", "17");
			contextForWrite.put("crimeMO4", "18");
			contextForWrite.put("victimID", "19");
			contextForWrite.put("victimAge", "20");
			contextForWrite.put("victimSex", "21");
			contextForWrite.put("victimDescent", "22");
			contextForWrite.put("premiseCode", "23");
			contextForWrite.put("premiseDescription", "24");
			contextForWrite.put("weaponCode", "25");
			contextForWrite.put("weaponDescription", "26");
			contextForWrite.put("statusCode", "27");
			contextForWrite.put("statusDescription", "28");
			contextForWrite.put("adressID", "29");
			contextForWrite.put("adressStreet", "30");
			contextForWrite.put("adressCrossStreet", "31");
			contextForWrite.put("adressGeoLocation", "32");
			contextForWrite.put("adressReportingDistrict", "33");
			
			compiledTemplate.evaluate(writer, contextForWrite);
			
			String outputBW = writer.toString();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("templates\\HTMLCrime\\pruebaHTMLCrimen.html"));
			bw.write(outputBW);
			bw.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}	
		
	}

}