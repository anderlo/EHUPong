package db.hepler;


import java.sql.*;
import java.util.*;

import javax.xml.bind.*;

import info.helper.*;

public class DBKud {

	private String url = "jdbc:mysql://localhost:3306/ehupong";
	private String user = "ehupongadm";
	private String password = "ehupongadm";
	private String driver = "com.mysql.jdbc.Driver";

	
	private Connection conn;

	public DBKud() {
		try {

			Class.forName(driver).newInstance();
			conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.println("Database connection established");
			Statement statement = conn.createStatement();
			statement.execute("use ehupong");
			
		} catch (Exception e) {
			
			System.out.println("Error on 'DBKud constructor': " + e);
			
		}

	}	
	
	public void insertMatchInfo(MatchInfo input) {
		
		try {
			Statement st = conn.createStatement();
			String insert = "Insert into ehupong.match values " + input.toQuery();
			System.out.println(insert);
			st.execute(insert);	
		}
		catch(Exception e) {
			
			System.out.println("Exception on 'DBKud.insertMatchInfo': " + e);
		}
		
	}
	
	public ArrayList<MatchInfo> getRanking (int rankLength){
		
		ArrayList<MatchInfo> result = new ArrayList<MatchInfo>();
		
		try {
			Statement st = conn.createStatement();
			String query = "Select * from ehupong.match order by time asc limit " + rankLength;
			
			ResultSet rs= st.executeQuery(query);
			
			while(rs.next()) {
				
				int matchId = rs.getInt(1);
				String playerName = rs.getString(2);
				String mResult = rs.getString(3);
				String winner = rs.getString(4);
				Time time = rs.getTime(5);
				
				MatchInfo mi = new MatchInfo(matchId, playerName, mResult, winner, time);
				
				result.add(mi);
				
			}
			
		}
		catch(Exception e) {
			
			System.out.println("Exception on 'DBKud.getRanking': " + e);
		}
		
		return result;
		
	}
	
	
}