//BORRAR CUANDO SE TENGA LA CLASE
package lapd.com.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

import lapd.com.classes.Address;
import lapd.com.classes.Area;
import lapd.com.classes.Crime;
import lapd.com.classes.CrimeType;
import lapd.com.classes.Premise;
import lapd.com.classes.Status;
import lapd.com.classes.Victim;
import lapd.com.classes.Weapon;
import lapd.com.classes.Status.TypeStatus;
import lapd.com.classes.Victim.Gender;
import lapd.com.classes.Victim.TypeDescent;

public class PruebaFuncionHTMLCrimen {

	public static void main(String[] args) {
		
		ArrayList <CrimeType> alc = new ArrayList<>();
		
		//Los add del alc no hr�s falta ponerlos
		alc.add(new CrimeType(3, "No description", "748"));
		alc.add(new CrimeType(4, "Yes description", "859 743"));
		alc.add(new CrimeType(5, "NoYes description", "748 345 123"));
		alc.add(new CrimeType(6, "YesNo description", "859"));
		
		//El crimen se obtendr� de la base de datos, no lo pasaremos
		Crime c = new Crime(01, LocalDate.now(), LocalDate.now(), LocalTime.now(), new Address(1, "calle", "calle cruce", "location", 456), new Area (2, "Broadway"), alc, new Premise(56, "LaPremisa"), new Status (TypeStatus.JO, "Juv Other"), new Victim(78, -6, Gender.F, TypeDescent.B), new Weapon (34, "Knife"));
		
		Address ad = c.getAddress();
		Area ar = c.getArea();
		Premise p = c.getPremise();
		Status s = c.getStatus();
		Victim v = c.getVictim();
		Weapon w = c.getWeapon();

		PebbleEngine engine = new PebbleEngine.Builder().build();
		
		try {
			
			PebbleTemplate compiledTemplate = engine.getTemplate("templates\\HTMLCrime\\HTMLCrimen.html");
			
			Writer writer = new StringWriter();
			
			Map <String, Object> contextForWrite = new HashMap<>();
		
			contextForWrite.put("drCode", c.getDrNumber());
			contextForWrite.put("date1", c.getDateReported());
			contextForWrite.put("date2", c.getDateOcurred());
			contextForWrite.put("hour", c.getTimeOcurred());
			
			contextForWrite.put("address", ad);
			contextForWrite.put("area", ar);
			contextForWrite.put("premise", p);
			contextForWrite.put("status", s);
			contextForWrite.put("victim", v);
			contextForWrite.put("weapon", w);
			contextForWrite.put("crimeTypes", alc);
			
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

}