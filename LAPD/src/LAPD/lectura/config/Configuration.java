package LAPD.lectura.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Configuration {
	private static String ip;
	private static String ports;
	private static String lines;

	public static void  load() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("configTest\\config.conf"));
			String dates;
			try {
				dates = br.readLine();
				String[] prueba = null;
				while(dates != null) {
					
					StringTokenizer tokens = new StringTokenizer(dates, "=");
					while(tokens.hasMoreTokens()) {
						if(tokens.nextToken().replace(" ", "").equals("ip")) {
							ip = tokens.nextToken();
						}else {
							if(tokens.nextToken().replace(" ", "").equals("puerto")) {
							   ports = tokens.nextToken();
							}
						}	
						
						
					}
					dates = br.readLine();
				}
				
				
				br.close();
				
				

			} catch (IOException e) {

				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}


	}

	public static String getIp() {
		return ip;
	}

	public static String getPorts() {
		return ports;
	}

	public static String getLines() {
		return lines;
	}




}
