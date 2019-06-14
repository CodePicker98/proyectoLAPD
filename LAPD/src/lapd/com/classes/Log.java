package lapd.com.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Log {
	
	public static void error(String message){
		try {
			BufferedWriter br =	new BufferedWriter(new FileWriter("log\\log.log", true));
			br.write(Log.formString('E', message));
			br.newLine();
			br.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en \\log\\log.log");
		}
	}
	
	public static void warning(String message){
		try {
			
			BufferedWriter br =	new BufferedWriter(new FileWriter("log\\log.log", true));
			br.write(Log.formString('W', message));
			br.newLine();
			br.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en \\log\\log.log");
		}
	}
	
	public static void info(String message){
		try {
			
			BufferedWriter br =	new BufferedWriter(new FileWriter("log\\log.log", true));
			br.write(Log.formString('I', message));
			br.newLine();
			br.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en \\log\\log.log");
		}
	}
	
	private static String formString(char type, String message) {
		String res = "";
		switch (type) {
		case'E':
			res = "[" + LocalDateTime.now() + "] Error message: " + message;
			break;
		case 'W':
			res = "[" + LocalDateTime.now() + "] Warning message: " + message;
			break;
		case 'I':
			res = "[" + LocalDateTime.now() + "] Info message: " + message;
			break;
		default:
			break;
		}
		return res;
	}

}
