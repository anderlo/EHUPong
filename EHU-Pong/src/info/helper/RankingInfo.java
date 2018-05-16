package info.helper;

import java.sql.*;
public class RankingInfo {
	private 	String 	username;
	private	String	score;
	private 	String 	winner;
	private 	Time		time;
	
	public RankingInfo(String pUsername, String pScore, String pWinner,Time pTime) {
		this.username 	= 	pUsername;
		this.score 		= 	pScore;
		this.winner		=	pWinner;
		this.time 		= 	pTime;
	}
	public Object getBalioa(int i) {
		if (i == 0) {
			return this.username;
		}else if (i == 1) {
			return this.score;
		}else if (i == 2) {
			return this.winner;
		}else if (i == 3) {
			return this.time;
		}else {
			return null;
		}
	}
	public void insertElementAt(Object value, int i) {
		if (i == 0) {
			this.username	= (String) value;
		} else if (i == 1) {
			this.score		= (String) value;
		} else if (i == 2) {
			this.winner		= (String) value;
		}else if (i == 3) {
			this.time		= (Time) value;
		}
	}
	public static Class<?> getColumnClass(int col) {
		
		switch (col) {
		case 3:
			return Time.class;
		default:
			return String.class;
		}
		
		
		
	}
}

