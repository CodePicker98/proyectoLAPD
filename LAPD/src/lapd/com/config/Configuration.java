package lapd.com.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Configuration {
	private static String ip;
	private static String port;
	private static String lines;

	public static void  load() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("config\\config.conf"));
			String dates;
			dates = br.readLine();
			while(dates != null) {
				
				StringTokenizer tokens = new StringTokenizer(dates, "=");
				while(tokens.hasMoreTokens()) {
					String identi = tokens.nextToken();
					if(identi.replace(" ", "").equals("ip")) {
						ip = tokens.nextToken().replace(" ", "");
					}
					if(identi.replace(" ", "").equals("port")) {
						port = tokens.nextToken().replace(" ", "");
					}
					if(identi.replace(" ", "").equals("lines")) {
						lines = tokens.nextToken().replace(" ", "");
					}
				}
				dates = br.readLine();
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public static String getIp() {
		return ip;
	}

	public static String getPort() {
		return port;
	}

	public static String getLines() {
		return lines;
	}




}
