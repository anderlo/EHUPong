package db.hepler;


import java.sql.*;
import java.util.*;

import javax.xml.bind.*;

public class DBKud {

	private String url = "jdbc:mysql://localhost:3306/eg1db";
	private String user = "eg1adm";
	private String password = "eg1adm";
	private String driver = "com.mysql.jdbc.Driver";

	
	private Connection conn;

	public DBKud() {
		try {

			Class.forName(driver).newInstance();
			conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Database connection established");
			
			
			
		} catch (Exception e) {
			
			System.out.println("Error on 'dbHelper constructor': " + e);
			
		}

	}	
	
		
	
}
