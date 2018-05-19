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
	int dif;
	private JTextField textField;
	
	public FrogaEndUI(boolean win, MatchInfo mI , boolean pBot, int pDif) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null); //Pantailaren erdian
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
		dif = pDif;
		
		String gifName = getGifName();
		ImageIcon irudiaIcon = new ImageIcon(gifName);
		
		lblI = new JLabel((Icon) null);
		lblI.setForeground(Color.BLACK);
		lblI.setBackground(Color.WHITE);
		lblI.setBounds(59, 5, 309, 160);
		lblI.setIcon(irudiaIcon);
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
		btnReturn.setBounds(133, 217, 149, 23);
		panel.add(btnReturn);
		
		textField = new JTextField(" ");
		textField.setBounds(147, 176, 120, 30);
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
		btnSubmit.setBounds(133,217,149,23);
		panel.add(btnSubmit);
		

		
		btnReturn.setVisible(!bot);
		textField.setVisible(bot);
		btnSubmit.setVisible(bot);
		
	}
	
	private String getGifName() {
		
		String result = "";
		
		if(bot) {
			if(w1) {
				if(dif==0) {
					result = "gifs/momoGif.gif";
				}
				else {
					result = "gifs/deadpool.gif";
				}
			}
			else {
				if(dif==0) {
					result = "gifs/tximino.gif";
				}
				else {
					result = "gift/cantWin.gif";
				}
			}
		}
		else {
			if(w1) {
				result = "gifs/dealWithIt.gif";
			}
			else {
				result = "gifs/ragePandaQuit.gif";
			}
		}
		
		return result;
	}
}
