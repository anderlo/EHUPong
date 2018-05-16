package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

public class FrogaEnd extends JFrame {

	private JPanel contentPane;

	int i =0;
	JLabel lblI;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrogaEnd frame = new FrogaEnd(true);
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
	public FrogaEnd(boolean win) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		
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
