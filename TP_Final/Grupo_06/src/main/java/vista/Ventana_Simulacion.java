package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Ventana_Simulacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_simulacion;
	private JPanel panel_izq;
	private JPanel panel_central;
	private JPanel panel_der;
	private JTextField txtChoferes;
	private JTextField txtVehiculos;
	private JTextField txtClientes;
	private JTextField txtCantidadChoferes;
	private JTextField Var_CantChof;
	private JTextField txtCantviajes;
	private JTextField Var_CantViajesChof;
	private JTextField txtMotos;
	private JTextField Var_CantMotos;
	private JTextField txtAutos;
	private JTextField Var_CantAutos;
	private JTextField txtCombis;
	private JTextField Var_CantCombis;
	private JTextField txtCantidadClientes;
	private JTextField Var_CantClientes;
	private JTextField txtCantidadViajes;
	private JTextField Var_CantViajesClientes;
	private JPanel panel_der_abajo;
	private JButton btnIniciarSimulacro;
	private JPanel panel_aux1;
	private JPanel panel_aux2;
	private JPanel panel_aux3;
	private JPanel panel_aux4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Simulacion frame = new Ventana_Simulacion();
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
	public Ventana_Simulacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panel_simulacion = new JPanel();
		this.contentPane.add(this.panel_simulacion);
		this.panel_simulacion.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.panel_izq = new JPanel();
		this.panel_simulacion.add(this.panel_izq);
		this.panel_izq.setLayout(new GridLayout(5, 1, 0, 0));
		
		this.txtChoferes = new JTextField();
		this.txtChoferes.setEditable(false);
		this.txtChoferes.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtChoferes.setText("Choferes");
		this.panel_izq.add(this.txtChoferes);
		this.txtChoferes.setColumns(10);
		
		this.txtCantidadChoferes = new JTextField();
		this.txtCantidadChoferes.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCantidadChoferes.setEditable(false);
		this.txtCantidadChoferes.setText("Cantidad Choferes:");
		this.panel_izq.add(this.txtCantidadChoferes);
		this.txtCantidadChoferes.setColumns(10);
		
		this.Var_CantChof = new JTextField();
		this.Var_CantChof.setHorizontalAlignment(SwingConstants.CENTER);
		this.Var_CantChof.setText("0");
		this.panel_izq.add(this.Var_CantChof);
		this.Var_CantChof.setColumns(10);
		
		this.txtCantviajes = new JTextField();
		this.txtCantviajes.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCantviajes.setText("Cantidad Viajes:");
		this.txtCantviajes.setEditable(false);
		this.panel_izq.add(this.txtCantviajes);
		this.txtCantviajes.setColumns(10);
		
		this.Var_CantViajesChof = new JTextField();
		this.Var_CantViajesChof.setHorizontalAlignment(SwingConstants.CENTER);
		this.Var_CantViajesChof.setText("0");
		this.panel_izq.add(this.Var_CantViajesChof);
		this.Var_CantViajesChof.setColumns(10);
		
		this.panel_central = new JPanel();
		this.panel_simulacion.add(this.panel_central);
		this.panel_central.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.txtVehiculos = new JTextField();
		this.txtVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtVehiculos.setEditable(false);
		this.txtVehiculos.setText("Vehiculos");
		this.panel_central.add(this.txtVehiculos);
		this.txtVehiculos.setColumns(10);
		
		this.txtMotos = new JTextField();
		this.txtMotos.setEditable(false);
		this.txtMotos.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtMotos.setText("Motos:");
		this.panel_central.add(this.txtMotos);
		this.txtMotos.setColumns(10);
		
		this.Var_CantMotos = new JTextField();
		this.Var_CantMotos.setText("0");
		this.Var_CantMotos.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_central.add(this.Var_CantMotos);
		this.Var_CantMotos.setColumns(10);
		
		this.txtAutos = new JTextField();
		this.txtAutos.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtAutos.setEditable(false);
		this.txtAutos.setText("Autos:");
		this.panel_central.add(this.txtAutos);
		this.txtAutos.setColumns(10);
		
		this.Var_CantAutos = new JTextField();
		this.Var_CantAutos.setHorizontalAlignment(SwingConstants.CENTER);
		this.Var_CantAutos.setText("0");
		this.panel_central.add(this.Var_CantAutos);
		this.Var_CantAutos.setColumns(10);
		
		this.txtCombis = new JTextField();
		this.txtCombis.setText("Combis:");
		this.txtCombis.setEditable(false);
		this.txtCombis.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_central.add(this.txtCombis);
		this.txtCombis.setColumns(10);
		
		this.Var_CantCombis = new JTextField();
		this.Var_CantCombis.setHorizontalAlignment(SwingConstants.CENTER);
		this.Var_CantCombis.setText("0");
		this.panel_central.add(this.Var_CantCombis);
		this.Var_CantCombis.setColumns(10);
		
		this.panel_der = new JPanel();
		this.panel_simulacion.add(this.panel_der);
		this.panel_der.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.txtClientes = new JTextField();
		this.txtClientes.setEditable(false);
		this.txtClientes.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtClientes.setText("Clientes");
		this.panel_der.add(this.txtClientes);
		this.txtClientes.setColumns(10);
		
		this.txtCantidadClientes = new JTextField();
		this.txtCantidadClientes.setEditable(false);
		this.txtCantidadClientes.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCantidadClientes.setText("Cantidad Clientes:");
		this.panel_der.add(this.txtCantidadClientes);
		this.txtCantidadClientes.setColumns(10);
		
		this.Var_CantClientes = new JTextField();
		this.Var_CantClientes.setHorizontalAlignment(SwingConstants.CENTER);
		this.Var_CantClientes.setText("0");
		this.panel_der.add(this.Var_CantClientes);
		this.Var_CantClientes.setColumns(10);
		
		this.txtCantidadViajes = new JTextField();
		this.txtCantidadViajes.setText("Cantidad viajes:");
		this.txtCantidadViajes.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCantidadViajes.setEditable(false);
		this.panel_der.add(this.txtCantidadViajes);
		this.txtCantidadViajes.setColumns(10);
		
		this.Var_CantViajesClientes = new JTextField();
		this.Var_CantViajesClientes.setHorizontalAlignment(SwingConstants.CENTER);
		this.Var_CantViajesClientes.setText("0");
		this.panel_der.add(this.Var_CantViajesClientes);
		this.Var_CantViajesClientes.setColumns(10);
		
		this.panel_der_abajo = new JPanel();
		this.panel_der.add(this.panel_der_abajo);
		this.panel_der_abajo.setLayout(new BorderLayout(0, 0));
		
		this.btnIniciarSimulacro = new JButton("Inicia Simulacion");
		this.panel_der_abajo.add(this.btnIniciarSimulacro);
		
		this.panel_aux1 = new JPanel();
		this.panel_der_abajo.add(this.panel_aux1, BorderLayout.NORTH);
		
		this.panel_aux2 = new JPanel();
		this.panel_der_abajo.add(this.panel_aux2, BorderLayout.WEST);
		
		this.panel_aux3 = new JPanel();
		this.panel_der_abajo.add(this.panel_aux3, BorderLayout.SOUTH);
		
		this.panel_aux4 = new JPanel();
		this.panel_der_abajo.add(this.panel_aux4, BorderLayout.EAST);
	}

}
