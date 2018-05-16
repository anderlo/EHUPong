package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.helper.*;
import info.helper.RankingInfo;
import languages.Textua;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;


public class MainUI extends JFrame {

	private JPanel contentPane;

	public MainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		String texto1 = Textua.getT().textuaLortu("boton1MainUI");
		String texto2 = Textua.getT().textuaLortu("boton2MainUI");
		String texto3 = Textua.getT().textuaLortu("boton3MainUI");
		String texto4 = Textua.getT().textuaLortu("boton4MainUI");
		
		JButton btnRanking = new JButton(texto1);
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBKud kud = new DBKud();
				Vector<RankingInfo> aux = kud.getRanking(10);
				MyTableModel mtm = new MyTableModel(aux);
				RankingUI RankingUi = new RankingUI(mtm);
				dispose();
			}
		});
		btnRanking.setBounds(10, 10, 200, 100);
		panel.add(btnRanking);
		
		JButton btnPvp = new JButton(texto2);
		btnPvp.setBounds(980, 10, 200, 100);
		panel.add(btnPvp);
		
		JButton btnia1 = new JButton(texto3);
		btnia1.setBounds(10, 380, 200, 100);
		panel.add(btnia1);
		
		JButton btnia2 = new JButton(texto4);
		btnia2.setBounds(980, 380, 200, 100);
		panel.add(btnia2);
		//670 dibujo ancho ,  270 alto 
		
		ImageIcon image = new ImageIcon("images/panelCentral.gif");
		
		JLabel lblArgazkia = new JLabel(image);
		lblArgazkia.setBounds(260, 30, 670, 400);
		panel.add(lblArgazkia);
		
		setVisible(true);
	}
}