package lapd.com.pebbletemplatehtml;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

public class TestLoopPebbleTemplate {

	public static void main(String[] args) {
		
		//En este caso usaremos un ArrayList de Integers:
		ArrayList<Integer> numbers = new ArrayList<>();
		
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		
		//Construimos el "PebbleEngine" con la siguiente sentencia.
		PebbleEngine engine = new PebbleEngine.Builder().build();
		
		try {
			//Construimos el "PebbleTemplate" y cargamos la plantilla que queramos usar como modelo(.html).
			PebbleTemplate compiledTemplate = engine.getTemplate("templates\\TemplateLoopHTML.html");
			
			//Construimos el "Writer" que es necesario para construir el output y hacer el "evaluate".
			Writer writer = new StringWriter();
			
			//Necesitamos un "mapa<String, Object>" en el que la clave va a ser la variable a substituir en la plantilla y el objeto
			//el String que vamos a pasar y que ocupará el sitio de la variable.
			Map<String, Object> context = new HashMap<>();
			
			//Usamos el ".put" siendo "(nombreVariable, textoQueLaVaASustituir/ArrayList).
			context.put("titulo", "Hola mundo");
			context.put("contenido", "Esto es una prueba");
			context.put("numbers", numbers);
			
			//Usamos el "compiledTemplate.evaluate" para substituir la/s variable/s y guardarlo en el writer.
			compiledTemplate.evaluate(writer, context);
			
			//Transformamos el "writer" en un String y lo guardamos
			String output = writer.toString();
			
			//Por último escribimos el resultado(output) en el archivo que queramos.
			BufferedWriter bw = new BufferedWriter(new FileWriter("outputs\\LoopHTML1.html"));
			bw.write(output);
			bw.close();
			
		} catch (PebbleException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
