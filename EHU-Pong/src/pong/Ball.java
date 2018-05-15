package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball{

	public int x, y, width = 25, height = 25;

	public int motionX, motionY; // Direccion de la bola.

	private Pong pong;
	
	private int speed = 6;
	
	public Ball(Pong pong){
		this.pong = pong;
		spawn();
	}

	public void update(Pala paddle1, Pala paddle2){

		this.x += motionX * speed;
		//System.out.println("Motion: y = " + motionY + " ,  x = " + motionX);
		this.y += motionY * speed;

		if (this.y + height - motionY > pong.height || this.y + motionY < 0){
			if (this.motionY < 0){
				this.motionY = 1;
				this.y = 0;
				speed = 6;
			}
			else{
				this.motionY = -1;
				this.y = pong.height - height;
				speed = 6;
			}
		}

		if (checkCollision(paddle1) == 1){
			this.motionX = 1;
			speed = 6;
		}
		
		else if (checkCollision(paddle2) == 1){
			this.motionX = -1;
			speed = 6;
		}

		else if (checkCollision(paddle1) == 2){
			paddle2.score++;
			this.x = paddle1.x;
			motionX = 1;
			speed = 6;
		}
		else if (checkCollision(paddle2) == 2){
			paddle1.score++;
			this.x = paddle2.x;
			motionX = -1;
			speed = 6;
		}
	}

	public void spawn(){
		Random random = new Random();
		this.x = pong.width / 2 - this.width / 2;
		this.y = pong.height / 2 - this.height / 2;

		if (random.nextBoolean())	motionY = 1;
		else 						motionY = -1;

		if (random.nextBoolean())	motionX = 1;
		else						motionX = -1;
	}
	
	public int checkCollision(Pala paddle){
		if (this.x < paddle.x + paddle.width && this.x + width > paddle.x && this.y < paddle.y + paddle.height && this.y + height > paddle.y) {
			return 1; //bounce
		}
		else if ((paddle.x > x && paddle.palaZnbk == 1) || (paddle.x < x - width && paddle.palaZnbk == 2)) {
			return 2; //score
		}
		else {
			return 0; //nothing
		}
	}

	public void render(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval(x, y, width, height);
	}

}
