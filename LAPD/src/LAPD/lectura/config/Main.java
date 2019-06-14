package LAPD.lectura.config;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

import com.google.common.io.FileWriteMode;

public class Main {

	public static void main(String[] args) {
	
		Configuration.load();
		
		Configuration cf = new Configuration();
		
		
		
		System.out.println(Configuration.getIp()+" "+Configuration.getPorts()+" "+Configuration.getLines());
	}

}
