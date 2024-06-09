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

public class Ventana_Inicial extends Ventana implements IVista{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_izq;
	private JPanel panel_centro;
	private JPanel panel_der;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewSimulacion;
	private JPanel panel_2;
	private JButton btnSimulacionAleatoria;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextField titulo;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JRadioButton rdbtnHayHumano;
	private JRadioButton rdbtnNoHayHumano;
	private JTextField txthayClienteHumano;
	
	
	

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
		
		this.titulo = new JTextField();
		this.titulo.setText("SUBÍ QUE TE LLEVO");
		this.titulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.titulo.setEditable(false);
		this.panel.add(this.titulo, BorderLayout.CENTER);
		this.titulo.setColumns(10);
		
		this.panel_5 = new JPanel();
		this.panel.add(this.panel_5, BorderLayout.WEST);
		
		this.panel_6 = new JPanel();
		this.panel.add(this.panel_6, BorderLayout.NORTH);
		
		this.panel_7 = new JPanel();
		this.panel.add(this.panel_7, BorderLayout.EAST);
		
		this.panel_8 = new JPanel();
		this.panel.add(this.panel_8, BorderLayout.SOUTH);
		
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
		
		this.btnSimulacionAleatoria = new JButton(SIMALEAT);
		this.panel_4.add(this.btnSimulacionAleatoria);
		
		this.panel_der = new JPanel();
		this.contentPane.add(this.panel_der);
	}
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void setControlador(Controlador c) {
		this.btnNewSimulacion.addActionListener(c);
		this.btnSimulacionAleatoria.addActionListener(c);
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