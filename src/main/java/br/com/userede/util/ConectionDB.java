package br.com.userede.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionDB {
	

	private static String PASSWORD ="yaman";
	
	private static String USERNAME = "root";
	
	private static String URL = "jdbc:mysql://localhost/teste";
	
	
	public static Connection conectar(){
		Connection con = null;
        try {
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			return con;
		} catch (Exception e) {
		   System.out.println(e.getMessage());
		}
		return null;
		
	}

}
