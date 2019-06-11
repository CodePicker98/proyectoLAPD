package lapd.com.dbloader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class DBLoader {

	private static Connection c;
	private static PreparedStatement psAreas;
	private static PreparedStatement psCrime_Types;
	private static PreparedStatement psVictims;
	private static PreparedStatement psPremises;
	private static PreparedStatement psWeapons;
	private static PreparedStatement psStatuses;
	private static PreparedStatement psAddresses;
	private static PreparedStatement psCrimes;
	
	private static int contNoInsert = 0;;
	
	public static void main(String[] args) {
		try {
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pruebalapd", "postgres", "root");
			//Definicion inserts
			psAreas = c.prepareStatement("INSERT INTO areas VALUES(?,?)");
			psCrime_Types = c.prepareStatement("INSERT INTO crime_types VALUES(?,?,?)");
			psVictims = c.prepareStatement("INSERT INTO victims VALUES(DEFAULT,?,?,?) RETURNING id");
			psPremises = c.prepareStatement("INSERT INTO premises VALUES(?,?)");
			psWeapons = c.prepareStatement("INSERT INTO weapons VALUES(?,?)");
			psStatuses = c.prepareStatement("INSERT INTO statuses VALUES(?,?)");
			psAddresses = c.prepareStatement("INSERT INTO addresses VALUES(DEFAULT,?,?,?,?) RETURNING id");
			psCrimes = c.prepareStatement("INSERT INTO crimes VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
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
					//Llamadas a las funciones insert
					insertAreas(indexToData);
					insertCrime_Types(indexToData);
					insertVictims(indexToData);
					insertPremises(indexToData);
					insertWeapons(indexToData);
					insertStatuses(indexToData);
					insertAddresses(indexToData);
					insertCrimes(indexToData);
					
					line = br.readLine();
				}
				
				line = br.readLine();
			}
			br.close();
			c.close();
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
	
	//Funciones insert
	
	private static void insertAreas(Map<String, String> indexToData) {
		try {
			psAreas.setInt(1, Integer.parseInt(indexToData.get("Area ID")));
			psAreas.setString(2, indexToData.get("Area Name"));
			psAreas.executeUpdate();
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
	
	private static void insertCrime_Types(Map<String, String> indexToData) {
		try {
			psCrime_Types.setInt(1, Integer.parseInt(indexToData.get("Crime Code")));
			psCrime_Types.setString(2, indexToData.get("Crime Code Description"));
			String[] strings = indexToData.get("MO Codes").split(" ");
			Array arrayString = c.createArrayOf("text", strings);
			psCrime_Types.setArray(3, arrayString);
			psCrime_Types.executeUpdate();
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
	
	private static void insertVictims(Map<String, String> indexToData) {
		try {
			psVictims.setInt(1, Integer.parseInt(indexToData.get("Victim Age")));
			psVictims.setString(2, indexToData.get("Victim Sex"));
			psVictims.setString(3, indexToData.get("Victim Descent"));
			ResultSet rs = psVictims.executeQuery();
			rs.next();
			indexToData.put("VictimID", String.valueOf(rs.getInt(1)));
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
	
	private static void insertPremises(Map<String, String> indexToData) {
		try {
			psPremises.setInt(1, Integer.parseInt(indexToData.get("Premise Code")));
			psPremises.setString(2, indexToData.get("Premise Description"));
			psPremises.executeUpdate();
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
	
	private static void insertWeapons(Map<String, String> indexToData) {
		try {
			// ARREGLAR ESTO
			psWeapons.setInt(1, Integer.parseInt(indexToData.get("Weapon Used Code")));
			// ARREGLAR ESTO
			psWeapons.setString(2, indexToData.get("Weapon Description"));
			psWeapons.executeUpdate();
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
	
	private static void insertStatuses(Map<String, String> indexToData) {
		try {
			psStatuses.setString(1,indexToData.get("Status Code"));
			psStatuses.setString(2, indexToData.get("Status Description"));
			psStatuses.executeUpdate();
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
	
	private static void insertAddresses(Map<String, String> indexToData) {
		try {
			psAddresses.setString(1,indexToData.get("Address"));
			psAddresses.setString(2, indexToData.get("Cross Street"));
			psAddresses.setString(3, indexToData.get("Location"));
			psAddresses.setInt(4, Integer.parseInt(indexToData.get("Reporting District")));
			ResultSet rs = psAddresses.executeQuery();
			rs.next();
			indexToData.put("AddressID", String.valueOf(rs.getInt(1)));
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
	
	private static void insertCrimes(Map<String, String> indexToData) {
		try {
			psCrimes.setInt(1,Integer.parseInt(indexToData.get("DR Number")));
			psCrimes.setDate(2, Date.valueOf(indexToData.get("Date Reported")));
			psCrimes.setDate(3, Date.valueOf(indexToData.get("Date Occurred")));
			psCrimes.setTime(4, Time.valueOf(indexToData.get("Time Occurred")));
			psCrimes.setInt(5, Integer.parseInt(indexToData.get("Area ID")));
			psCrimes.setInt(6, Integer.parseInt(indexToData.get("Crime Code 1")));
			psCrimes.setInt(7, Integer.parseInt(indexToData.get("Crime Code 2")));
			psCrimes.setInt(8, Integer.parseInt(indexToData.get("Crime Code 3")));
			psCrimes.setInt(9, Integer.parseInt(indexToData.get("Crime Code 4")));
			psCrimes.setInt(10, Integer.parseInt(indexToData.get("VictimID")));
			psCrimes.setInt(11, Integer.parseInt(indexToData.get("Premise Code")));
			psCrimes.setInt(12, Integer.parseInt(indexToData.get("Weapon Used Code")));
			psCrimes.setString(13, indexToData.get("Status Code"));
			psCrimes.setInt(14, Integer.parseInt(indexToData.get("AddressID")));
			psCrimes.executeUpdate();
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
