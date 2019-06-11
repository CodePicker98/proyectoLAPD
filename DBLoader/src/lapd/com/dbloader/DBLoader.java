package lapd.com.dbloader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DBLoader {

	private static PreparedStatement ps;
	private static int contNoInsert = 0;;
	
	public static void main(String[] args) {
		try {
			Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pruebalapd", "postgres", "root");
			ps = c.prepareStatement("INSERT INTO crime_types VALUES(?,?)");
			
			ArrayList<String> index = new ArrayList<>();
			Map<String, String> indexToData = new HashMap<>();
			BufferedReader br = new BufferedReader(new FileReader("files\\Crime_Data_from_2010_to_Present.csv"));
			String line = br.readLine();
			
			if (line != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens()) {
					index.add(st.nextToken());
				}
				line = br.readLine();
				while (line != null) {
					st = new StringTokenizer(line, ",", true);
					for (int i = 0; st.hasMoreTokens(); i++) {
						String token = st.nextToken();
						
						//Aqui corregimos los campos sin valor
						boolean tokenIsComma = false;
						if (token.equals(",")) {
							token = "";
							tokenIsComma = true;
						}
						
						//Aqui evitamos el error que surje al leer un campo que tiene comas que no hay que tener en cuenta
						if (token.startsWith("\"")) {
							token = token.substring(1);
							token = token + st.nextToken("\"");
							st.nextToken(",");
						}
						
						//Aqui quitamos el exceso de espacios en algunos campos
						token = token.replaceAll(" +", " ");
						indexToData.put(index.get(i), token);
						if (!tokenIsComma && st.hasMoreTokens()) {
							st.nextToken();
						}
						
						//System.out.println(index.get(i) + " " + indexToData.get(index.get(i)));
					}
					insert(indexToData);
					line = br.readLine();
				}
				
				line = br.readLine();
			}
			br.close();
			System.out.println("No se han insertado " + contNoInsert + " filas.");
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void insert(Map<String, String> indexToData) {
		try {
			ps.setInt(1, Integer.parseInt(indexToData.get("Crime Code")));
			ps.setString(2, indexToData.get("Crime Code Description"));
			ps.executeUpdate();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			if(e.getSQLState().equals("23505")) {
				contNoInsert++;
			} else {
				e.printStackTrace();
			}
		}
		
	}

}
