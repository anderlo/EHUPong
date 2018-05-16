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
			obstacleList.add(createObstacle());
			numObstacles++;
		}
		else {
			System.out.println("Obstacle not Added");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("10 seconds");
		addObstacle();
	}
	
	public int getNumObstacles(){
		return this.numObstacles;
	}
	
	public Obstacle getObstacle(int pAux){
		return this.obstacleList.get(pAux);
	}
	
	public void obstacleHitted(Obstacle obs){
		this.obstacleList.remove(obs);
		--this.numObstacles;
	}
	
	public Obstacle createObstacle(){
		Random rnd = new Random();
		int aux = rnd.nextInt(3);
		Obstacle obs;
		if (aux == 0)			obs = new Obstacle(rnd.nextInt(500) + 100, rnd.nextInt(500) + 100, "wall");
		else if (aux == 1) 		obs = new Obstacle(rnd.nextInt(500) + 100, rnd.nextInt(500) + 100, "speedUp");
		else 					obs = new Obstacle(rnd.nextInt(500) + 100, rnd.nextInt(500) + 100, "slow");
		return obs;

	}
	
}
