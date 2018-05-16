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

import db.helper.DBKud;
import info.helper.MatchInfo;
import languages.Textua;

import java.sql.*;

public class FrogaEndUI extends JFrame {

	private JPanel contentPane;

	JLabel lblI;
	MatchInfo matchInfo;
	boolean bot;
	boolean w1;
	private JTextField textField;
	
	
	public FrogaEndUI(boolean win, MatchInfo mI , boolean pBot) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		
		matchInfo = mI;
		bot = pBot;
		w1 = win;
		
		URL path = getClass().getClassLoader().getResource("momoGif.gif");

		if(!win) {
			path = getClass().getClassLoader().getResource("ragePandaQuit.gif");
		}
		
		Image irudia = new ImageIcon(path).getImage();
		
		//ImageIcon irudiaIcon = new ImageIcon(irudia.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon irudiaIcon = new ImageIcon(path);
		
		
		lblI = new JLabel(irudiaIcon);
		lblI.setBackground(Color.WHITE);
		lblI.setBounds(71, 5, 268, 130);
		
		panel.add(lblI);
		

     	String texto1 = Textua.getT().textuaLortu("btnReturn");
     	String texto2 = Textua.getT().textuaLortu("btnSubmit");
     	
     	JButton btnReturn = new JButton(texto1);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Pong.getInstance().resetPong();
				MainUI mi = new MainUI();
				mi.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(135, 187, 145, 23);
		panel.add(btnReturn);
		
		textField = new JTextField(" ");
		textField.setBounds(148, 146, 120, 30);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton(texto2);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String userName = textField.getText();
				
				if(userName!=" ") {
					String winner = "AI";
					if(w1) {
						winner = userName;
					}
					
					matchInfo.setParams(userName, winner);
					new DBKud().insertMatchInfo(matchInfo);
					
					Pong.getInstance().resetPong();
					MainUI mi = new MainUI();
					mi.setVisible(true);
					dispose();
				}
				
				
			}
		});
		btnSubmit.setBounds(164,187,89,23);
		panel.add(btnSubmit);
		

		
		btnReturn.setVisible(!bot);
		textField.setVisible(bot);
		btnSubmit.setVisible(bot);
		
	}
}
