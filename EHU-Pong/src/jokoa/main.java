package jokoa;

import java.sql.Time;
import java.util.ArrayList;

import db.hepler.DBKud;
import info.helper.MatchInfo;
import pong.Pong;

public class main {

	
	public static void main(String[] args){
		Time time = new Time(0,2,3);
		System.out.println(time.toString());
		
		DBKud dbk = new DBKud();
		MatchInfo mI = new MatchInfo(0, "Me", "2-3", "AI", time);
		//dbk.insertMatchInfo(mI);
		
		ArrayList<MatchInfo> ranking = dbk.getRanking(3);
		int i=1;
		for(MatchInfo match : ranking) {
			
			//System.out.println("Match " + i + " info: " + match.toString());
			i++;
		}
		
		System.out.println("Main ");
		
		Pong pong = Pong.getInstance(1,-1);
		
	}
	
}
