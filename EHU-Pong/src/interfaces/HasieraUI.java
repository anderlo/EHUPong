package interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import languages.Textua;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class HasieraUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HasieraUI frame = new HasieraUI();
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
	public HasieraUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 520);
		setLocationRelativeTo(null); //Pantailaren erdian
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon image = new ImageIcon("Images/Pong.png");

		JButton btnPong = new JButton();
		btnPong.setBounds(0, 0, 1200, 520);
		btnPong.setIcon(image);
		btnPong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LanguageUI LanguageUi = new LanguageUI();
				dispose();
			}
		});
		contentPane.add(btnPong);
		/*
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1200, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnJokatu = new JButton("Play");
		btnJokatu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LanguageUI.main(null);
				dispose();
			}
		});
		btnJokatu.setBounds(540, 400, 120, 30);
		panel.add(btnJokatu);
		
		JLabel lblArgazkia = new JLabel(image);
		lblArgazkia.setBounds(0, 0, 1200, 520);
		panel.add(lblArgazkia);
		*/
	}
}
