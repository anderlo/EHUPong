package pong;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Pong implements ActionListener, KeyListener{


	public int width = 700, height = 700;

	public Renderer renderer;

	public Pala pala1;

	public Pala pala2;

	public Ball ball;

	public boolean bot = false, selectingDifficulty;

	public boolean w, s, up, down;

	public int gameStatus = 2, scoreLimit = 7, palaWon; //0 = Menu, 1 = Paused, 2 = Playing, 3 = Over

	public int botDifficulty, botMoves, botCooldown = 0;

	public Random random;

	public JFrame jframe;

	private static Pong instance;
	
	private Pong(){
		System.out.println("Entered Pong Constructor");
		Timer timer = new Timer(20, this);
		random = new Random();

		System.out.println("Before JFrame Creation");
		
		jframe = new JFrame("Pong");

		System.out.println("After JFrame Creation. Before Rendered Creation");
		
		renderer = new Renderer();

		System.out.println("After Renderer Creation");
		
		jframe.setSize(width + 15, height + 35);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(renderer);
		jframe.addKeyListener(this);

		start();
		
		timer.start();
		System.out.println("After Timer Start");
	}

	public static Pong getInstance() {
		if(instance==null) {
			instance = new Pong();
		}
		return instance;
	}
	
	
	public void start(){
		System.out.println("Entered Start");
		gameStatus = 2;
		pala1 = new Pala(this, 1);
		pala2 = new Pala(this, 2);
		ball = new Ball(this);
		
		System.out.println("Exited Start");
	}

	public void update(){
		System.out.println("Entered Update");
		if (pala1.score >= scoreLimit){
			palaWon = 1;
			gameStatus = 3;
		}

		if (pala2.score >= scoreLimit){
			gameStatus = 3;
			palaWon = 2;
		}

		if (w)	pala1.move(true);
		if (s)	pala1.move(false);

		if (!bot){
			if (up)		pala2.move(true);
			if (down)	pala2.move(false);
		}
		else{
			if (botCooldown > 0){
				botCooldown--;

				if (botCooldown == 0)	botMoves = 0;
			}

			if (botMoves < 10){
				if (pala2.y + pala2.height / 2 < ball.y){
					pala2.move(false);
					botMoves++;
				}

				if (pala2.y + pala2.height / 2 > ball.y){
					pala2.move(true);
					botMoves++;
				}

				if (botDifficulty == 0)	botCooldown = 30;
				else if (botDifficulty == 1)	botCooldown = 20;
				else if (botDifficulty == 2)	botCooldown = 10;
			}
		}
		ball.update(pala1, pala2);
	}

	public void render(Graphics2D g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (gameStatus == 1 || gameStatus == 2){
			g.setColor(Color.WHITE);

			g.setStroke(new BasicStroke(5f));

			g.drawLine(width / 2, 0, width / 2, height);

			g.setStroke(new BasicStroke(2f));

			g.drawOval(width / 2 - 150, height / 2 - 150, 300, 300);

			g.setFont(new Font("Arial", 1, 50));

			g.drawString(String.valueOf(pala1.score), width / 2 - 90, 50);
			g.drawString(String.valueOf(pala2.score), width / 2 + 65, 50);

			pala1.render(g);
			pala2.render(g);
			ball.render(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if (gameStatus == 2) {
			
			update();
		}
		renderer.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e){
		int id = e.getKeyCode();

		if (id == KeyEvent.VK_W) {
			w = true;
		}
		else if (id == KeyEvent.VK_S) {
			s = true;
		}
		else if (id == KeyEvent.VK_UP) {
			up = true;
		}
		else if (id == KeyEvent.VK_DOWN) {
			down = true;
		}
		else if (id == KeyEvent.VK_RIGHT){
			if (selectingDifficulty)
			{
				if (botDifficulty < 2) {
					botDifficulty++;
				}
				else {
					botDifficulty = 0;
				}
			}
			else if (gameStatus == 0) {
				scoreLimit++;
			}
		}
		else if (id == KeyEvent.VK_LEFT){
			if (selectingDifficulty){
				if (botDifficulty > 0)	botDifficulty--;
				else					botDifficulty = 2;
			}
			else if (gameStatus == 0 && scoreLimit > 1)	scoreLimit--;
		}
		else if (id == KeyEvent.VK_ESCAPE && (gameStatus == 2 || gameStatus == 3))	gameStatus = 0;
		else if (id == KeyEvent.VK_SHIFT && gameStatus == 0){
			bot = true;
			selectingDifficulty = true;
		}
		else if (id == KeyEvent.VK_SPACE){
			if (gameStatus == 0 || gameStatus == 3){
				if(selectingDifficulty) {
					selectingDifficulty = false;
				}
				start();
			}
			else if (gameStatus == 1) {
				gameStatus = 2;
			}
			else if (gameStatus == 2) {
				gameStatus = 1;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e){
		int id = e.getKeyCode();

		if (id == KeyEvent.VK_W)	w = false;

		else if (id == KeyEvent.VK_S)	s = false;
		else if (id == KeyEvent.VK_UP)	up = false;
		else if (id == KeyEvent.VK_DOWN)	down = false;
	}

	@Override
	public void keyTyped(KeyEvent e){

	}
	
	
	public static void main(String[] args){
		
	}

	
	
}
