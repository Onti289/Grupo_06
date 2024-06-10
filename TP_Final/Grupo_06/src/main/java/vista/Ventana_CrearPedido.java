package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import controladores.*;

public class Ventana_CrearPedido extends Ventana{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCantPasajeros;
	private JTextField txtCantidadDePasajeros;
	private JRadioButton rdbtn1;
	private JRadioButton rdbtn3;
	private JRadioButton rdbtn4;
	private JRadioButton rdbtn5;
	private JRadioButton rdbtn6;
	private JRadioButton rdbtn7;
	private JRadioButton rdbtn8;
	private JRadioButton rdbtn2;
	private JPanel panelElijaZona;
	private JTextField txtElijaLaZona;
	private JRadioButton rdbtnEstandar;
	private JRadioButton rdbtnSinAsfaltar;
	private JRadioButton rdbtnZonaPeligrosa;
	private JPanel panelDoble;
	private JPanel panelMascota;
	private JPanel panelBaul;
	private JTextField txtLlevaMascota;
	private JRadioButton rdbtnSiMascota;
	private JRadioButton rdbtnNoMascota;
	private JTextField txtLlevaEquipaje;
	private JRadioButton rdbtnSiBaul;
	private JRadioButton rdbtnNoBaul;
	private JPanel panelTitulo;
	private JTextField txtCompleteElFormulario;
	private JPanel panel;
	private JButton btnCrearPedidoHumano;
	private final ButtonGroup buttonGroupCantPax = new ButtonGroup();
	private final ButtonGroup buttonGroupZona = new ButtonGroup();
	private final ButtonGroup buttonGroupMascota = new ButtonGroup();
	private final ButtonGroup buttonGroupBaul = new ButtonGroup();
	private Object buttonGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_CrearPedido frame = new Ventana_CrearPedido();
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
	public Ventana_CrearPedido() {
		setTitle("Vista Cliente Humano");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		this.contentPane = new JPanel();
		this.contentPane.setToolTipText("");
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(5, 0, 0, 0));
		
		this.panelTitulo = new JPanel();
		this.contentPane.add(this.panelTitulo);
		
		this.txtCompleteElFormulario = new JTextField();
		this.txtCompleteElFormulario.setFont(new Font("Tahoma", Font.PLAIN, 28));
		this.txtCompleteElFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtCompleteElFormulario.setEditable(false);
		this.txtCompleteElFormulario.setText("Complete el formulario para realizar un pedido de viaje");
		this.panelTitulo.add(this.txtCompleteElFormulario);
		this.txtCompleteElFormulario.setColumns(33);
		
		this.panelCantPasajeros = new JPanel();
		this.contentPane.add(this.panelCantPasajeros);
		
		this.txtCantidadDePasajeros = new JTextField();
		this.txtCantidadDePasajeros.setHorizontalAlignment(SwingConstants.RIGHT);
		this.txtCantidadDePasajeros.setText("Cantidad de pasajeros:");
		this.txtCantidadDePasajeros.setEditable(false);
		this.panelCantPasajeros.add(this.txtCantidadDePasajeros);
		this.txtCantidadDePasajeros.setColumns(13);
		
		this.rdbtn1 = new JRadioButton("1");
		this.rdbtn1.setSelected(true);
		this.panelCantPasajeros.add(this.rdbtn1);
		this.buttonGroupCantPax.add(this.rdbtn1);
		
		this.rdbtn2 = new JRadioButton("2");
		this.panelCantPasajeros.add(this.rdbtn2);
		this.buttonGroupCantPax.add(this.rdbtn2);
		
		this.rdbtn3 = new JRadioButton("3");
		this.panelCantPasajeros.add(this.rdbtn3);
		this.buttonGroupCantPax.add(this.rdbtn3);
		
		this.rdbtn4 = new JRadioButton("4");
		this.panelCantPasajeros.add(this.rdbtn4);
		this.buttonGroupCantPax.add(this.rdbtn4);
		
		this.rdbtn5 = new JRadioButton("5");
		this.panelCantPasajeros.add(this.rdbtn5);
		this.buttonGroupCantPax.add(this.rdbtn5);
		
		this.rdbtn6 = new JRadioButton("6");
		this.panelCantPasajeros.add(this.rdbtn6);
		this.buttonGroupCantPax.add(this.rdbtn6);
		
		this.rdbtn7 = new JRadioButton("7");
		this.panelCantPasajeros.add(this.rdbtn7);
		this.buttonGroupCantPax.add(this.rdbtn7);
		
		this.rdbtn8 = new JRadioButton("8");
		this.panelCantPasajeros.add(this.rdbtn8);
		this.buttonGroupCantPax.add(this.rdbtn8);
		
		this.panelElijaZona = new JPanel();
		this.contentPane.add(this.panelElijaZona);
		
		this.txtElijaLaZona = new JTextField();
		this.txtElijaLaZona.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtElijaLaZona.setText("Elija la zona:");
		this.txtElijaLaZona.setEditable(false);
		this.panelElijaZona.add(this.txtElijaLaZona);
		this.txtElijaLaZona.setColumns(8);
		
		this.rdbtnEstandar = new JRadioButton(ESTANDAR);
		this.rdbtnEstandar.setSelected(true);
		this.panelElijaZona.add(this.rdbtnEstandar);
		this.buttonGroupZona.add(this.rdbtnEstandar);
		
		this.rdbtnSinAsfaltar = new JRadioButton(SINASFALTAR);
		this.panelElijaZona.add(this.rdbtnSinAsfaltar);
		this.buttonGroupZona.add(this.rdbtnSinAsfaltar);
		
		this.rdbtnZonaPeligrosa = new JRadioButton(PELIGROSA);
		this.panelElijaZona.add(this.rdbtnZonaPeligrosa);
		this.buttonGroupZona.add(this.rdbtnZonaPeligrosa);
		
		this.panelDoble = new JPanel();
		this.contentPane.add(this.panelDoble);
		this.panelDoble.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panelMascota = new JPanel();
		this.panelDoble.add(this.panelMascota);
		
		this.txtLlevaMascota = new JTextField();
		this.txtLlevaMascota.setEditable(false);
		this.txtLlevaMascota.setText("Lleva mascota:");
		this.txtLlevaMascota.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelMascota.add(this.txtLlevaMascota);
		this.txtLlevaMascota.setColumns(9);
		
		this.rdbtnSiMascota = new JRadioButton(SI);
		this.panelMascota.add(this.rdbtnSiMascota);
		this.buttonGroupMascota.add(this.rdbtnSiMascota);
		
		this.rdbtnNoMascota = new JRadioButton(NO);
		this.rdbtnNoMascota.setSelected(true);
		this.panelMascota.add(this.rdbtnNoMascota);
		this.buttonGroupMascota.add(this.rdbtnNoMascota);
		
		this.panelBaul = new JPanel();
		this.panelDoble.add(this.panelBaul);
		this.panelBaul.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		this.txtLlevaEquipaje = new JTextField();
		this.txtLlevaEquipaje.setEditable(false);
		this.txtLlevaEquipaje.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtLlevaEquipaje.setText("Necesitas usar el baúl:");
		this.panelBaul.add(this.txtLlevaEquipaje);
		this.txtLlevaEquipaje.setColumns(14);
		
		this.rdbtnSiBaul = new JRadioButton(SI);
		this.panelBaul.add(this.rdbtnSiBaul);
		this.buttonGroupBaul.add(this.rdbtnSiBaul);
		
		this.rdbtnNoBaul = new JRadioButton(NO);
		this.rdbtnNoBaul.setSelected(true);
		this.panelBaul.add(this.rdbtnNoBaul);
		this.buttonGroupBaul.add(this.rdbtnNoBaul);
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel);
		
		this.btnCrearPedidoHumano = new JButton(ACEPTAR);
		this.btnCrearPedidoHumano.setFont(new Font("Tahoma", Font.PLAIN, 19));
		this.panel.add(this.btnCrearPedidoHumano);
	}

	public void setControlador(Controlador c) {
		this.btnCrearPedidoHumano.addActionListener(c);
		this.rdbtn1.addActionListener(c);
		this.rdbtn2.addActionListener(c);
		this.rdbtn3.addActionListener(c);
		this.rdbtn4.addActionListener(c);
		this.rdbtn5.addActionListener(c);
		this.rdbtn6.addActionListener(c);
		this.rdbtn7.addActionListener(c);
		this.rdbtn8.addActionListener(c);
		this.rdbtnEstandar.addActionListener(c);
		this.rdbtnSinAsfaltar.addActionListener(c);
		this.rdbtnNoBaul.addActionListener(c);
		this.rdbtnNoMascota.addActionListener(c);
		this.rdbtnSiBaul.addActionListener(c);
		this.rdbtnSiMascota.addActionListener(c);
		this.rdbtnZonaPeligrosa.addActionListener(c);
		
		
	}
	
	@Override
	public int getCantPax()
	{
		if (this.rdbtn1.isSelected())
			return 1;
		if (this.rdbtn2.isSelected())
			return 2;
		if (this.rdbtn3.isSelected())
			return 3;
		if (this.rdbtn4.isSelected())
			return 4;
		if (this.rdbtn5.isSelected())
			return 5;
		if (this.rdbtn6.isSelected())
			return 6;
		if (this.rdbtn7.isSelected())
			return 7;
		else
		    return 8;
	}
	
	@Override
	public String getZona()
	{
		if (this.rdbtnEstandar.isSelected())
		  return IVista.ESTANDAR;
		if (this.rdbtnSinAsfaltar.isSelected())
		  return IVista.SINASFALTAR;
		else
		  return IVista.PELIGROSA;
	}
	
	@Override
	public boolean isBaul(){
		return this.rdbtnSiBaul.isSelected();
	}
	
	@Override
	public boolean isMascota() {
		return this.rdbtnSiMascota.isSelected();
	}
}
