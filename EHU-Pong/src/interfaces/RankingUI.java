package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import db.helper.MyTableModel;
import info.helper.MatchInfo;
import languages.Textua;
import pong.Pong;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RankingUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;


	public RankingUI(MyTableModel a){
		super("Ranking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTable table = new JTable(a);
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(table);
     	setContentPane(panel);
     	panel.setLayout(new BorderLayout(0, 0));
     	
     	panel.add(scrollPane, BorderLayout.NORTH);
     	
     	String texto1 = Textua.getT().textuaLortu("btnReturn");
     	
     	JButton btnReturn = new JButton(texto1);
     	btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainUI mi = new MainUI();
				mi.setVisible(true);
				dispose();
			}
		});
     	
     	panel.add(btnReturn, BorderLayout.SOUTH);
     	
	    	pack();
	    	setVisible(true);
	}
}

