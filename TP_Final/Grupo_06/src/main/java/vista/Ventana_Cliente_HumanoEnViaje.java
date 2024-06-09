package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class Ventana_Cliente_HumanoEnViaje extends Ventana {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JPanel paneldepagar;
	private JPanel panel;
	private JPanel panel_boton;
	private JButton btnNewButton;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Cliente_HumanoEnViaje frame = new Ventana_Cliente_HumanoEnViaje();
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
	public Ventana_Cliente_HumanoEnViaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane);
		
		this.paneldepagar = new JPanel();
		this.contentPane.add(this.paneldepagar);
		this.paneldepagar.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panel = new JPanel();
		this.paneldepagar.add(this.panel);
		
		this.panel_boton = new JPanel();
		FlowLayout flowLayout = (FlowLayout) this.panel_boton.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		this.paneldepagar.add(this.panel_boton);
		
		this.panel_1 = new JPanel();
		this.panel_boton.add(this.panel_1);
		
		this.btnNewButton = new JButton("Pagar");
		this.panel_1.add(this.btnNewButton);
		this.btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
	}

}
