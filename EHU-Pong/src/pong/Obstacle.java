package pong;


import java.awt.Color;
import java.awt.Graphics;

public class Obstacle {
	
	private int x;
	private int y;
	private String type; //wall, speedUp, slow
	public int width = 50, height = 50;
	
	public Obstacle(int pX, int pY, String pType){
		x = pX;
		y = pY;
		type=pType;
		if (type.equals("wall"))	height = 120;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public String getType(){
		return this.type;
	}
	
	public void render(Graphics g){
		if (type.equals("wall"))	g.setColor(Color.WHITE);
		else if (type.equals("speedUp"))	g.setColor(Color.yellow);
		else if (type.equals("slow"))	g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}	
	
}
