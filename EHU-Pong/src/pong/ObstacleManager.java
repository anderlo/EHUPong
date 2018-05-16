package pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.*;

public class ObstacleManager implements ActionListener{

	private int numObstacles;
	private static ObstacleManager instance;
	
	private ArrayList<Obstacle> obstacleList;
	
	private ObstacleManager() {
		numObstacles = 0;
		obstacleList = new ArrayList<Obstacle>();
	}
	
	public static ObstacleManager getInstance() {
		if(instance==null) {
			instance = new ObstacleManager();
		}
		return instance;
	}

	private void addObstacle() {
		if (numObstacles<3) {
			System.out.println("Obstacle Added");
			numObstacles++;
		}
		else {
			System.out.println("Obstacle not Added");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("20 seconds");
		addObstacle();
	}
	
	
	
}
