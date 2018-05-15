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

public class FrogaEnd extends JFrame  implements ActionListener {

	private JPanel contentPane;

	int i =0;
	JLabel lblI;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrogaEnd frame = new FrogaEnd();
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
	public FrogaEnd() {

		Timer timer = new Timer(1000, this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		panel.setLayout(null);
		
		URL path = getClass().getClassLoader().getResource("Thresh_Iddle_Down.gif");
		System.out.println("Path: "+path); //para comprobaciones

		Image irudia = new ImageIcon(path).getImage();
		
		System.out.println("Irudia: " + irudia.toString());
		
		//ImageIcon irudiaIcon = new ImageIcon(irudia.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		
		ImageIcon irudiaIcon = new ImageIcon(path);
		
		System.out.println("Irudia Icon: " + irudiaIcon);
		
		
		lblI = new JLabel(irudiaIcon);
		lblI.setBounds(139, 5, 114, 101);
		
		//lblI.setIcon(irudiaIcon);
		
		panel.add(lblI);
		
		
		timer.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		i++;
		//lblI.setText(""+i);
		repaint();
	}

}
