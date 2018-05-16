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

import interfaces.*;
import info.helper.*;


public class Pong implements ActionListener, KeyListener{


	public int width = 700, height = 700;

	public Renderer renderer;

	public Pala pala1;

	public Pala pala2;

	public Ball ball;

	public boolean bot = true;

	public boolean w, s, up, down;

	public int gameStatus = 1, scoreLimit = 7, palaWon; //  1 = Playing, 2 = Over

	public int botDifficulty , botMoves, botCooldown = 0;

	public JFrame jframe;

	Timer timer1;
	Timer timer2;
	
	private Stopwatch sw;
	
	private static Pong instance;
	
	private Pong(int score, int dif){
		setScore(score);
		setDifficulty(dif);
		System.out.println("Entered Pong Constructor");
		
		sw = new Stopwatch();
		
		timer1 = new Timer(20, this);
		timer2 = new Timer(20000, ObstacleManager.getInstance());

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

		startClock();
		
		System.out.println("After Timer Start");
	}
	
	private void startClock() {
		
		sw.start();
		timer1.start();
		timer2.start();
		
		System.out.println("----\nClocks Started:\n-----");
		
	}
	
	private void stopClock() {
		
		sw.stop();
		timer1.stop();
		timer2.stop();
		
		System.out.println("----\nClocks Stopped:\n-----");
		
	}
	
	public static Pong getInstance() {
		if(instance==null) {
			instance = new Pong(7, -1);
			instance.start();
		}
		return instance;
	}
	
	public static Pong getInstance(int pScore, int difficulty) {
		if(instance==null) {
			instance = new Pong( pScore, difficulty);
			instance.start();
		}
		return instance;
	}
	
	private void setScore(int pScore) {
		scoreLimit = pScore;
	}
	
	private void setDifficulty(int difficulty) {
		if (difficulty<0) {
			bot = false;
		}
		botDifficulty = difficulty;
	}
	

	
	
	public void start(){
		
		System.out.println("Entered Start");
		gameStatus = 1;
		System.out.println("GetPala1");
		pala1 = new Pala(1);
		System.out.println("GetPala2");
		pala2 = new Pala(2);
		System.out.println("GetBall");
		ball = new Ball();
		
		System.out.println("Exited Start");
	}

	public void update(){
		
		if (pala1.score >= scoreLimit){
			palaWon = 1;
			gameStatus = 2;
			System.out.println(" 1 won");
			
			stopClock();
			
			double miliTime = sw.getElapsedTime();
			FrogaEndUI fe = new FrogaEndUI(true, miliTime);
			fe.setVisible(true);
		}

		if (pala2.score >= scoreLimit){
			gameStatus = 2;
			palaWon = 2;
			System.out.println(" 2 won");
			
			stopClock();
			
			double miliTime = sw.getElapsedTime();
			FrogaEndUI fe = new FrogaEndUI(false, miliTime);
			fe.setVisible(true);
		}

		if (w) {
			pala1.move(true);
		}
		if (s) {
			pala1.move(false);
		}

		if (!bot){
			if (up)	{
				pala2.move(true);
			}
			if (down) {
				pala2.move(false);
			}
		}
		else{
			if (botCooldown > 0){
				botCooldown--;

				if (botCooldown == 0) {	
					botMoves = 0;
				}
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

		if (gameStatus == 1){
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
		if (gameStatus == 1) {
			
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
	
	public void resetPong() {
		instance=null;
		jframe.dispose();
	}
	
	
}
