package lapd.com.pebbletemplatehtml;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

public class TestClassPebbleTemplate {

	public static void main(String[] args) {
		
		Student s1 = new Student("Stuarcito", 9, false);
		
		//Construimos el "PebbleEngine" con la siguiente sentencia.
		PebbleEngine engine = new PebbleEngine.Builder().build();
				
		try {
			//Construimos el "PebbleTemplate" y cargamos la plantilla que queramos usar como modelo(.html).
			PebbleTemplate compiledTemplate = engine.getTemplate("templates\\TemplateClassHTML.html");
			
			//Construimos el "Writer" que es necesario para construir el output y hacer el "evaluate".
			Writer writer = new StringWriter();
			
			//Necesitamos un "mapa<String, Object>" en el que la clave va a ser la variable a substituir en la plantilla y el objeto
			//el String que vamos a pasar y que ocupará el sitio de la variable.
			Map<String, Object> context = new HashMap<>();
			
			//Usamos el ".put" siendo "(nombreVariable, textoQueLaVaASustituir).
			context.put("titulo", "Student INFO");
			context.put("contenido", "Student Data");
			
			//Podemos pasar directamente una clase como variable, y el html cargará los atributos con los getters.
			context.put("student", s1);
			
			//Usamos el "compiledTemplate.evaluate" para substituir la/s variable/s y guardarlo en el writer.
			compiledTemplate.evaluate(writer, context);
			
			//Transformamos el "writer" en un String y lo guardamos
			String output = writer.toString();
			
			//Por último escribimos el resultado(output) en el archivo que queramos.
			BufferedWriter bw = new BufferedWriter(new FileWriter("outputs\\ClassHTML3.html"));
			bw.write(output);
			bw.close();
			
		} catch (PebbleException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
