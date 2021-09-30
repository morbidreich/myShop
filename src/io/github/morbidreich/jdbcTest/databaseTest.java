package io.github.morbidreich.jdbcTest;

import java.sql.*;

public class databaseTest {
	
	public static void main (String[] args) {
	
		String connString = "jdbc:h2:file:./allegrodb";
		String user = "sa";
		String pass = "";
	
		try {
			Connection conn = DriverManager.getConnection(connString, user, pass);
			System.out.println("connection to database successful");
			conn.close();
	
		}
		catch (Exception ex) {
			System.out.println("connection to database failed!");
			ex.printStackTrace();
		}
	}
}
