package LAPD.lectura.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

public class LectorArchivo {

	{
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("configTest\\config.conf"));
			String datos;
			try {
				datos = br.readLine();
				
				while(datos != null) {
					System.out.println(datos);
					datos = br.readLine();
				}
				
				br.close();
				
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		
		
	}
		
}
