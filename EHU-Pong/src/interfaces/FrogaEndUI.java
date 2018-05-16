package interfaces;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;

import pong.Pong;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.sql.*;

public class FrogaEndUI extends JFrame {

	private JPanel contentPane;

	JLabel lblI;
	double miliTime;
	
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrogaEndUI frame = new FrogaEndUI(true, 0D);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrogaEndUI(boolean win, double pMiliTime) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		
		miliTime=pMiliTime;
		
		URL path = getClass().getClassLoader().getResource("momoGif.gif");

		if(!win) {
			path = getClass().getClassLoader().getResource("ragePandaQuit.gif");
		}
		
		Image irudia = new ImageIcon(path).getImage();
		
		//ImageIcon irudiaIcon = new ImageIcon(irudia.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon irudiaIcon = new ImageIcon(path);
		
		
		lblI = new JLabel(irudiaIcon);
		lblI.setBackground(Color.WHITE);
		lblI.setBounds(139, 5, 114, 101);
		
		panel.add(lblI);
		
		JButton btnReturn = new JButton("New button");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("MiliTime: " + miliTime);
				long mTime = (long)  miliTime;
				int second =(int) (mTime/ 1000) % 60;
				int minute =(int) (mTime / (1000 * 60)) % 60;
				int hour =(int) (mTime/ (1000 * 60 * 60)) % 24;
				System.out.println("MiliTimeLong: " + mTime);
				Time time = new Time(hour,minute,second);
				System.out.println("Time: " + time);
				
				Pong.getInstance().resetPong();
				
			}
		});
		btnReturn.setBounds(164, 187, 89, 23);
		panel.add(btnReturn);
		
		textField = new JTextField();
		textField.setBounds(148, 146, 120, 30);
		panel.add(textField);
		textField.setColumns(10);
		
	}
}
