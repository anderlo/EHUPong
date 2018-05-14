package info.helper;

import java.sql.Time;

public class MatchInfo {
	
	int matchId;
	String playerName;
	String result;
	String winner;
	Time time;
	
	public MatchInfo(int matchId, String playerName, String result, String winner, Time time) {
		super();
		this.matchId = matchId;
		this.playerName = playerName;
		this.result = result;
		this.winner = winner;
		this.time = time;
	}
	
	public String toQuery() {
		
		return "( 0,'" + playerName + "', '" + result + "', '" + winner + "', '" + time +"');";
		
	}

	@Override
	public String toString() {
		return "MatchInfo [matchId=" + matchId + ", playerName=" + playerName + ", result=" + result + ", winner="
				+ winner + ", time=" + time + "]";
	}
	
}
