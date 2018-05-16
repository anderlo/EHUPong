package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import languages.Textua;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class MainUI extends JFrame {

	private JPanel contentPane;

	public MainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 400, 450, 300);
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
		
		JButton btnTransacciones = new JButton(texto1);
		btnTransacciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTransacciones.setBounds(10, 11, 179, 23);
		panel.add(btnTransacciones);
		
		JButton btnDatos = new JButton(texto2);
		btnDatos.setBounds(240, 11, 174, 23);
		panel.add(btnDatos);
		
		JPanel PANELGRAFICOS = new JPanel();
		PANELGRAFICOS.setBounds(10, 45, 404, 129);
		panel.add(PANELGRAFICOS);
		PANELGRAFICOS.setLayout(new BoxLayout(PANELGRAFICOS, BoxLayout.X_AXIS));
		
		JButton btnCompra = new JButton(texto3);
		btnCompra.setBounds(10, 217, 179, 23);
		panel.add(btnCompra);
		
		JButton btnVenta = new JButton(texto4);
		btnVenta.setBounds(240, 217, 174, 23);
		panel.add(btnVenta);
		
		setVisible(true);
	}
}