package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import controladores.*;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Ventana_Inicial extends Ventana{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_izq;
	private JPanel panel_centro;
	private JPanel panel_der;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewSimulacion;
	private JPanel panel_2;
	private JButton btnUltimaSimulacion;
	private JPanel panel_3;
	private JPanel panel_4;
	private JRadioButton rdbtnHayHumano;
	private JRadioButton rdbtnNoHayHumano;
	private JTextField txthayClienteHumano;
	private JLabel lblNewLabel;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Inicial frame = new Ventana_Inicial();
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
	public Ventana_Inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.panel_izq = new JPanel();
		this.contentPane.add(this.panel_izq);
		
		this.panel_centro = new JPanel();
		this.contentPane.add(this.panel_centro);
		this.panel_centro.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panel = new JPanel();
		this.panel_centro.add(this.panel);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.lblNewLabel = new JLabel("");
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		this.lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 5));
		this.lblNewLabel.setIcon(new ImageIcon("SANDRITO.jpg"));
		this.panel.add(this.lblNewLabel, BorderLayout.CENTER);
		
		this.panel_1 = new JPanel();
		this.panel_centro.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(3, 0, 0, 0));
		
		this.panel_2 = new JPanel();
		this.panel_1.add(this.panel_2);
		this.panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.txthayClienteHumano = new JTextField();
		this.txthayClienteHumano.setHorizontalAlignment(SwingConstants.CENTER);
		this.txthayClienteHumano.setText("¿Hay cliente humano?");
		this.txthayClienteHumano.setEditable(false);
		this.panel_2.add(this.txthayClienteHumano);
		this.txthayClienteHumano.setColumns(10);
		
		this.rdbtnHayHumano = new JRadioButton(SI);
		this.rdbtnHayHumano.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_2.add(this.rdbtnHayHumano);
		
		this.rdbtnNoHayHumano = new JRadioButton(NO);
		this.rdbtnNoHayHumano.setSelected(true);
		this.rdbtnNoHayHumano.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_2.add(this.rdbtnNoHayHumano);
		
		this.panel_3 = new JPanel();
		this.panel_1.add(this.panel_3);
		
		this.btnNewSimulacion = new JButton(NUEVASIM);
		this.panel_3.add(this.btnNewSimulacion);
		
		this.panel_4 = new JPanel();
		this.panel_1.add(this.panel_4);
		
		this.btnUltimaSimulacion = new JButton(CARGAULT);
		this.panel_4.add(this.btnUltimaSimulacion);
		
		this.panel_der = new JPanel();
		this.contentPane.add(this.panel_der);
	}
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void setControlador(Controlador c) {
		this.btnNewSimulacion.addActionListener(c);
		this.btnUltimaSimulacion.addActionListener(c);
		this.rdbtnHayHumano.addActionListener(c);
		this.rdbtnNoHayHumano.addActionListener(c);
		
	}

	
	public void noHumano()
	{
		this.rdbtnNoHayHumano.setSelected(true);
		this.rdbtnHayHumano.setSelected(false);
	}
	
	public void hayHumano()
	{
		this.rdbtnNoHayHumano.setSelected(false);
		this.rdbtnHayHumano.setSelected(true);
	}
}