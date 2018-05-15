package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Pala{

	public int palaZnbk;

	public int x, y, width = 50, height = 250;

	public int score;

	public Pala(Pong pong, int palaZnbk){
		this.palaZnbk = palaZnbk;

		score =0;
		System.out.println("Pala " + palaZnbk + " score: " + score);
		if (palaZnbk == 1)	this.x = 0;
		else if (palaZnbk == 2)		this.x = pong.width - width;
		this.y = pong.height / 2 - this.height / 2;
	}

	public void render(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

	public void move(boolean up){
		int speed = 15;

		if (up){
			if (y - speed > 0)	y -= speed;
			else	y = 0;
		}
		else{
			if (y + height + speed < Pong.getInstance().height)	y += speed;
			else	y = Pong.getInstance().height - height;
		}
	}
}
