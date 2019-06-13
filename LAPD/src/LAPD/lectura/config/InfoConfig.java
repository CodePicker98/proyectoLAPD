package LAPD.lectura.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InfoConfig {
	private String ip;
	private String puerto;
	private String lineas;
	
	public InfoConfig(String ip , String puerto , String lineas ) {
		this.ip = ip;
		this.puerto = puerto;
		this.lineas = lineas;
	}

	public String getIp() {
		return ip;
	}

	public String getPuerto() {
		return puerto;
	}

	public String getLineas() {
		return lineas;
	}
	
}