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
import java.awt.Font;
import controladores.*;

public class Ventana_Simulacion extends JFrame {//implements IVista{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_simulacion;
	private JPanel panel_izq;
	private JPanel panel_central;
	private JPanel panel_der;
	private JTextField txtVehiculos;
	private JPanel panel_titulo_chofer;
	private JTextField textField;
	private JPanel panel_cantchofereeees;
	private JPanel panel_choferbajo;
	private JPanel panel;
	private JPanel panel_choferinterno1;
	private JPanel panel_choferinterno2;
	private JTextField txtPermanentes;
	private JTextField Var_CantPermanentes;
	private JPanel panel_tituloVehiculoss;
	private JPanel panel_centralinterno;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JPanel panel_sinuso2;
	private JPanel panel_tituloclientes;
	private JPanel panel_intermedioDER;
	private JTextField textField_11;
	private JPanel panel_4;
	private JPanel panel_5;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JPanel panel_botoninicia;
	private JButton btnIniciaSimulacin;
	private JPanel panel_6;
	private JPanel panel_bajoo;
	private JPanel panel_bajoobajo;
	private JTextField textField_1;
	private JTextField Var_CantViajesXChofer;
	private JTextField txtCantTemporarios;
	private JTextField Var_CantTemporarios;
	private JTextField txtCantContratados;
	private JTextField Var_CantContratados;

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
		this.panel_izq.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.panel_titulo_chofer = new JPanel();
		this.panel_izq.add(this.panel_titulo_chofer);
		
		this.panel = new JPanel();
		this.panel_titulo_chofer.add(this.panel);
		
		this.textField = new JTextField();
		this.panel.add(this.textField);
		this.textField.setToolTipText("");
		this.textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		this.textField.setText("Choferes");
		this.textField.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField.setEditable(false);
		this.textField.setColumns(10);
		
		this.panel_cantchofereeees = new JPanel();
		this.panel_izq.add(this.panel_cantchofereeees);
		this.panel_cantchofereeees.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_choferinterno1 = new JPanel();
		this.panel_cantchofereeees.add(this.panel_choferinterno1);
		
		this.txtPermanentes = new JTextField();
		this.txtPermanentes.setText("Cant. Permanentes:");
		this.txtPermanentes.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtPermanentes.setEditable(false);
		this.txtPermanentes.setColumns(12);
		this.panel_choferinterno1.add(this.txtPermanentes);
		
		this.Var_CantPermanentes = new JTextField();
		this.Var_CantPermanentes.setText("0");
		this.Var_CantPermanentes.setHorizontalAlignment(SwingConstants.CENTER);
		this.Var_CantPermanentes.setColumns(10);
		this.panel_choferinterno1.add(this.Var_CantPermanentes);
		
		this.panel_choferinterno2 = new JPanel();
		this.panel_cantchofereeees.add(this.panel_choferinterno2);
		
		this.txtCantTemporarios = new JTextField();
		this.txtCantTemporarios.setText("Cant. Temporarios:");
		this.txtCantTemporarios.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCantTemporarios.setEditable(false);
		this.txtCantTemporarios.setColumns(12);
		this.panel_choferinterno2.add(this.txtCantTemporarios);
		
		this.Var_CantTemporarios = new JTextField();
		this.Var_CantTemporarios.setText("0");
		this.Var_CantTemporarios.setHorizontalAlignment(SwingConstants.CENTER);
		this.Var_CantTemporarios.setColumns(10);
		this.panel_choferinterno2.add(this.Var_CantTemporarios);
		
		this.panel_choferbajo = new JPanel();
		this.panel_izq.add(this.panel_choferbajo);
		this.panel_choferbajo.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panel_bajoo = new JPanel();
		this.panel_choferbajo.add(this.panel_bajoo);
		
		this.txtCantContratados = new JTextField();
		this.txtCantContratados.setText("Cant. Contratados:");
		this.txtCantContratados.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCantContratados.setEditable(false);
		this.txtCantContratados.setColumns(12);
		this.panel_bajoo.add(this.txtCantContratados);
		
		this.Var_CantContratados = new JTextField();
		this.Var_CantContratados.setText("0");
		this.Var_CantContratados.setHorizontalAlignment(SwingConstants.CENTER);
		this.Var_CantContratados.setColumns(10);
		this.panel_bajoo.add(this.Var_CantContratados);
		
		this.panel_bajoobajo = new JPanel();
		this.panel_choferbajo.add(this.panel_bajoobajo);
		
		this.textField_1 = new JTextField();
		this.textField_1.setText("Cantidad Viajes:");
		this.textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_1.setEditable(false);
		this.textField_1.setColumns(12);
		this.panel_bajoobajo.add(this.textField_1);
		
		this.Var_CantViajesXChofer = new JTextField();
		this.Var_CantViajesXChofer.setText("0");
		this.Var_CantViajesXChofer.setHorizontalAlignment(SwingConstants.CENTER);
		this.Var_CantViajesXChofer.setColumns(10);
		this.panel_bajoobajo.add(this.Var_CantViajesXChofer);
		
		this.panel_central = new JPanel();
		this.panel_simulacion.add(this.panel_central);
		this.panel_central.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_tituloVehiculoss = new JPanel();
		this.panel_central.add(this.panel_tituloVehiculoss);
		
		this.txtVehiculos = new JTextField();
		this.panel_tituloVehiculoss.add(this.txtVehiculos);
		this.txtVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		this.txtVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtVehiculos.setEditable(false);
		this.txtVehiculos.setText("Vehiculos");
		this.txtVehiculos.setColumns(10);
		
		this.panel_centralinterno = new JPanel();
		this.panel_central.add(this.panel_centralinterno);
		this.panel_centralinterno.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.panel_1 = new JPanel();
		this.panel_centralinterno.add(this.panel_1);
		
		this.textField_5 = new JTextField();
		this.textField_5.setText("Motos:");
		this.textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_5.setEditable(false);
		this.textField_5.setColumns(10);
		this.panel_1.add(this.textField_5);
		
		this.textField_6 = new JTextField();
		this.textField_6.setText("0");
		this.textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_6.setColumns(10);
		this.panel_1.add(this.textField_6);
		
		this.panel_2 = new JPanel();
		this.panel_centralinterno.add(this.panel_2);
		
		this.textField_7 = new JTextField();
		this.textField_7.setText("Autos:");
		this.textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_7.setEditable(false);
		this.textField_7.setColumns(10);
		this.panel_2.add(this.textField_7);
		
		this.textField_8 = new JTextField();
		this.textField_8.setText("0");
		this.textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_8.setColumns(10);
		this.panel_2.add(this.textField_8);
		
		this.panel_3 = new JPanel();
		this.panel_centralinterno.add(this.panel_3);
		
		this.textField_9 = new JTextField();
		this.textField_9.setText("Combis:");
		this.textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_9.setEditable(false);
		this.textField_9.setColumns(10);
		this.panel_3.add(this.textField_9);
		
		this.textField_10 = new JTextField();
		this.textField_10.setText("0");
		this.textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_10.setColumns(10);
		this.panel_3.add(this.textField_10);
		
		this.panel_sinuso2 = new JPanel();
		this.panel_central.add(this.panel_sinuso2);
		
		this.panel_der = new JPanel();
		this.panel_simulacion.add(this.panel_der);
		this.panel_der.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_tituloclientes = new JPanel();
		this.panel_der.add(this.panel_tituloclientes);
		
		this.textField_11 = new JTextField();
		this.textField_11.setFont(new Font("Tahoma", Font.PLAIN, 25));
		this.textField_11.setText("Clientes");
		this.textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_11.setEditable(false);
		this.textField_11.setColumns(10);
		this.panel_tituloclientes.add(this.textField_11);
		
		this.panel_intermedioDER = new JPanel();
		this.panel_der.add(this.panel_intermedioDER);
		this.panel_intermedioDER.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_4 = new JPanel();
		this.panel_intermedioDER.add(this.panel_4);
		
		this.textField_14 = new JTextField();
		this.textField_14.setText("Cantidad Clientes:");
		this.textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_14.setEditable(false);
		this.textField_14.setColumns(12);
		this.panel_4.add(this.textField_14);
		
		this.textField_15 = new JTextField();
		this.textField_15.setText("0");
		this.textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_15.setColumns(10);
		this.panel_4.add(this.textField_15);
		
		this.panel_5 = new JPanel();
		this.panel_intermedioDER.add(this.panel_5);
		
		this.textField_12 = new JTextField();
		this.textField_12.setText("Cantidad viajes:");
		this.textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_12.setEditable(false);
		this.textField_12.setColumns(12);
		this.panel_5.add(this.textField_12);
		
		this.textField_13 = new JTextField();
		this.textField_13.setText("0");
		this.textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_13.setColumns(10);
		this.panel_5.add(this.textField_13);
		
		this.panel_botoninicia = new JPanel();
		this.panel_der.add(this.panel_botoninicia);
		
		this.panel_6 = new JPanel();
		this.panel_botoninicia.add(this.panel_6);
		
		this.btnIniciaSimulacin = new JButton("Iniciar Simulación");
		this.btnIniciaSimulacin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.panel_6.add(this.btnIniciaSimulacin);
	}

}
