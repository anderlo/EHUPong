package interfaces;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import languages.Textua;
import languages.language;

public class LanguageUI extends JFrame {
	private JPanel panel;

	public LanguageUI() {
		setBounds(100, 100, 1200, 520);
		setResizable(false);
		this.languageUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Image	 	irudia 	= new ImageIcon("images/ESP.png").getImage();
		ImageIcon 	Icon 	= new ImageIcon(irudia.getScaledInstance(90, 55, java.awt.Image.SCALE_SMOOTH));
		Image 		irudia2 = new ImageIcon("images/EUS.png").getImage();
		ImageIcon 	Icon2 	= new ImageIcon(irudia2.getScaledInstance(90, 55, java.awt.Image.SCALE_SMOOTH));
		Image 		irudia3	= new ImageIcon("images/ENG.png").getImage();
		ImageIcon 	Icon3	= new ImageIcon(irudia3.getScaledInstance(90, 55, java.awt.Image.SCALE_SMOOTH));
		

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblSelectLanguage = new JLabel("Selecciona idioma");
		lblSelectLanguage.setBounds(200, 150, 200, 50);
		panel.add(lblSelectLanguage);

		JLabel label = new JLabel("Hautatu hizkuntza");
		label.setBounds(550, 150, 200, 50);
		panel.add(label);

		JLabel label2 = new JLabel("Select language");
		label2.setBounds(900, 150, 200, 50);
		panel.add(label2);

		JButton ESP = new JButton();
		ESP.setIcon(Icon);
		ESP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Textua.getT().lengHas("ESP");
				MainUI mainUi = new MainUI();
				dispose();
			}
		});
		ESP.setBounds(150,300,200, 100);
		panel.add(ESP);

		JButton EUS = new JButton();
		EUS.setIcon(Icon2);
		EUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Textua.getT().lengHas("EUS");
				MainUI mainUi = new MainUI();
				dispose();
			}
		});
		EUS.setBounds(500, 300, 200, 100);
		panel.add(EUS);

		JButton ENG = new JButton();
		ENG.setIcon(Icon3);
		ENG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Textua.getT().lengHas("ENG");
				MainUI mainUi = new MainUI();
				dispose();
			}
		});
		ENG.setBounds(850, 300, 200, 100);
		panel.add(ENG);

		setVisible(true);
		// setResizable(false);
		this.akzioa();
	}

	private void akzioa() {
	}

	private void languageUI() {

		Image leng1 = new ImageIcon("images/ESP.png").getImage();
		ImageIcon irudiaIcon = new ImageIcon(leng1.getScaledInstance(-5, 50, java.awt.Image.SCALE_SMOOTH));

		Image leng2 = new ImageIcon("images/EUS.png").getImage();
		ImageIcon irudiaIcon2 = new ImageIcon(leng2.getScaledInstance(-5, 50, java.awt.Image.SCALE_SMOOTH));

		Image leng3 = new ImageIcon("images/ENG.png").getImage();
		ImageIcon irudiaIcon3 = new ImageIcon(leng3.getScaledInstance(-5, 50, java.awt.Image.SCALE_SMOOTH));

	}

	public static void main(String[] args) {
		new LanguageUI();
	}
}
