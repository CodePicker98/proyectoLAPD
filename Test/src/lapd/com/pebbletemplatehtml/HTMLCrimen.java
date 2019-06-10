package lapd.com.pebbletemplatehtml;

import java.io.*;
import java.util.*;
import com.mitchellbosecke.pebble.*;
import com.mitchellbosecke.pebble.template.*;

public class HTMLCrimen {

	public static void main(String[] args) {

		PebbleEngine engine = new PebbleEngine.Builder().build();
		
		try {
			
			PebbleTemplate compiledTemplate = engine.getTemplate("templates\\HTMLCrimen.html");
			
			Writer writer = new StringWriter();
			
			Map <String, Object> contextForWrite = new HashMap<>();
			
			contextForWrite.put("drCode", "");
			contextForWrite.put("date1", "");
			contextForWrite.put("date2", "");
			contextForWrite.put("hour", "");
			contextForWrite.put("areaID", "");
			contextForWrite.put("areaName", "");
			contextForWrite.put("crimeCode1", "");
			contextForWrite.put("crimeDescription1", "");
			contextForWrite.put("crimeMO1", "");
			contextForWrite.put("crimeCode2", "");
			contextForWrite.put("crimeDescription2", "");
			contextForWrite.put("crimeMO2", "");
			contextForWrite.put("crimeCode3", "");
			contextForWrite.put("crimeDescription3", "");
			contextForWrite.put("crimeMO3", "");
			contextForWrite.put("crimeCode4", "");
			contextForWrite.put("crimeDescription4", "");
			contextForWrite.put("crimeMO4", "");
			contextForWrite.put("victimID", "");
			contextForWrite.put("victimAge", "");
			contextForWrite.put("victimSex", "");
			contextForWrite.put("victimDescent", "");
			contextForWrite.put("premiseCode", "");
			contextForWrite.put("premiseDescription", "");
			contextForWrite.put("weaponCode", "");
			contextForWrite.put("weaponDescription", "");
			contextForWrite.put("statusCode", "");
			contextForWrite.put("statusDescription", "");
			contextForWrite.put("adressID", "");
			contextForWrite.put("adressStreet", "");
			contextForWrite.put("adressCrossStreet", "");
			contextForWrite.put("adressGeoLocation", "");
			contextForWrite.put("adressReportingDistrict", "");
			
			compiledTemplate.evaluate(writer, contextForWrite);
			
			String outputBW = writer.toString();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("outputs\\pruebaHTMLCrimen.html"));
			bw.write(outputBW);
			bw.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}