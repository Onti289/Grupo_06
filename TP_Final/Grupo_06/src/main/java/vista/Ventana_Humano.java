package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import controladores.*;

public class Ventana_Humano extends Ventana implements KeyListener, IVista{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelLoguea;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextField txtRegistrarse;
	private JPanel panel_3;
	private JTextField txtNombreDeUsuario;
	private JTextField Var_NuevoNombreUsuario;
	private JTextField txtContrasea;
	private JPasswordField Var_NuevapasswordField;
	private JButton btnCrearUsuario;
	private JPanel panel_4;
	private JPanel panel_5;
	private JTextField Info_CrearUsuario;
	private JPanel panelIniciaUsuario;
	private JPanel panel_tituloIniciaUsuar;
	private JPanel panel_7;
	private JTextField textField;
	private JTextField Var_NombreUsuarioInicia;
	private JPanel panel_8;
	private JTextField textField_2;
	private JPasswordField Var_passwordField;
	private JPanel panel_9;
	private JPanel panel_10;
	private JButton btnIngresarUsuario;
	private JPanel panel_11;
	private JTextField textField_3;
	private JTextField txtIniciarSecin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Humano frame = new Ventana_Humano();
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
	public Ventana_Humano() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.panelLoguea = new JPanel();
		this.contentPane.add(this.panelLoguea);
		this.panelLoguea.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.panel = new JPanel();
		this.panelLoguea.add(this.panel);
		this.panel.setLayout(new BorderLayout(0, 0));
		
		this.txtRegistrarse = new JTextField();
		this.txtRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtRegistrarse.setText("Registrarse:");
		this.txtRegistrarse.setEditable(false);
		this.panel.add(this.txtRegistrarse, BorderLayout.CENTER);
		this.txtRegistrarse.setColumns(10);
		
		this.panel_1 = new JPanel();
		this.panelLoguea.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.txtNombreDeUsuario = new JTextField();
		this.txtNombreDeUsuario.setText("Nombre de usuario:");
		this.txtNombreDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtNombreDeUsuario.setEditable(false);
		this.panel_1.add(this.txtNombreDeUsuario);
		this.txtNombreDeUsuario.setColumns(10);
		
		this.Var_NuevoNombreUsuario = new JTextField();
		this.Var_NuevoNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_1.add(this.Var_NuevoNombreUsuario);
		this.Var_NuevoNombreUsuario.setColumns(10);
		
		this.panel_2 = new JPanel();
		this.panelLoguea.add(this.panel_2);
		this.panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.txtContrasea = new JTextField();
		this.txtContrasea.setText("Contraseña:");
		this.txtContrasea.setEditable(false);
		this.txtContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_2.add(this.txtContrasea);
		this.txtContrasea.setColumns(10);
		
		this.Var_NuevapasswordField = new JPasswordField();
		this.Var_NuevapasswordField.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_2.add(this.Var_NuevapasswordField);
		
		this.panel_3 = new JPanel();
		this.panelLoguea.add(this.panel_3);
		this.panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_4 = new JPanel();
		this.panel_3.add(this.panel_4);
		
		this.btnCrearUsuario = new JButton(CREARUSUARIO);
		this.panel_4.add(this.btnCrearUsuario);
		this.btnCrearUsuario.setEnabled(false);
		
		this.panel_5 = new JPanel();
		this.panel_3.add(this.panel_5);
		this.panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.Info_CrearUsuario = new JTextField();
		this.Info_CrearUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		this.Info_CrearUsuario.setEditable(false);
		this.panel_5.add(this.Info_CrearUsuario);
		this.Info_CrearUsuario.setColumns(10);
		
		this.panelIniciaUsuario = new JPanel();
		this.contentPane.add(this.panelIniciaUsuario);
		this.panelIniciaUsuario.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.panel_tituloIniciaUsuar = new JPanel();
		this.panelIniciaUsuario.add(this.panel_tituloIniciaUsuar);
		this.panel_tituloIniciaUsuar.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.txtIniciarSecin = new JTextField();
		this.txtIniciarSecin.setText("Iniciar Seción:");
		this.txtIniciarSecin.setEditable(false);
		this.txtIniciarSecin.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_tituloIniciaUsuar.add(this.txtIniciarSecin);
		this.txtIniciarSecin.setColumns(10);
		
		this.panel_7 = new JPanel();
		this.panelIniciaUsuario.add(this.panel_7);
		this.panel_7.setLayout(new GridLayout(1, 0, 0, 0));
		
		this.textField = new JTextField();
		this.textField.setText("Nombre de usuario:");
		this.textField.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField.setEditable(false);
		this.textField.setColumns(10);
		this.panel_7.add(this.textField);
		
		this.Var_NombreUsuarioInicia = new JTextField();
		this.Var_NombreUsuarioInicia.setHorizontalAlignment(SwingConstants.CENTER);
		this.Var_NombreUsuarioInicia.setColumns(10);
		this.panel_7.add(this.Var_NombreUsuarioInicia);
		
		this.panel_8 = new JPanel();
		this.panelIniciaUsuario.add(this.panel_8);
		this.panel_8.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.textField_2 = new JTextField();
		this.textField_2.setText("Contraseña:");
		this.textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_2.setEditable(false);
		this.textField_2.setColumns(10);
		this.panel_8.add(this.textField_2);
		
		this.Var_passwordField = new JPasswordField();
		this.Var_passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		this.panel_8.add(this.Var_passwordField);
		
		this.panel_9 = new JPanel();
		this.panelIniciaUsuario.add(this.panel_9);
		this.panel_9.setLayout(new GridLayout(2, 1, 0, 0));
		
		this.panel_10 = new JPanel();
		this.panel_9.add(this.panel_10);
		
		this.btnIngresarUsuario = new JButton(INICIARSESION);
		this.panel_10.add(this.btnIngresarUsuario);
		this.btnIngresarUsuario.setEnabled(false);
		
		this.panel_11 = new JPanel();
		this.panel_9.add(this.panel_11);
		this.panel_11.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.textField_3 = new JTextField();
		this.textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		this.textField_3.setEditable(false);
		this.textField_3.setColumns(10);
		this.panel_11.add(this.textField_3);
		
		this.Var_NuevoNombreUsuario.addKeyListener(this);
		this.Var_NuevapasswordField.addKeyListener(this);
		this.Var_NombreUsuarioInicia.addKeyListener(this);
		this.Var_passwordField.addKeyListener(this);
	}

	@Override
	public void setControlador(Controlador c) {
		this.btnCrearUsuario.addActionListener(c);
		this.btnIngresarUsuario.addActionListener(c);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent arg0)
    {
	  String nuevoNomUsua = null;
      String nuevaContr = null;
      String NomUsua = null;
      String Contr = null;
      
    	  nuevoNomUsua = this.Var_NuevoNombreUsuario.getText();
    	  nuevaContr = this.Var_NuevapasswordField.getText();
    	  NomUsua = this.Var_NombreUsuarioInicia.getText();
          Contr = this.Var_passwordField.getText();

      boolean condicionCreaUsuario = !nuevoNomUsua.isEmpty() && !nuevoNomUsua.isBlank() && !nuevaContr.isEmpty() && !nuevaContr.isBlank();
      boolean condicionIngresaUsuario = !NomUsua.isEmpty() && !NomUsua.isBlank() && !Contr.isEmpty() && !Contr.isBlank();
      this.btnCrearUsuario.setEnabled(condicionCreaUsuario);
      this.btnIngresarUsuario.setEnabled(condicionIngresaUsuario);
  
    }


}
