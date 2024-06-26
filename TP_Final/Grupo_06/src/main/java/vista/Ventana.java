package vista;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.Controlador;

public abstract class Ventana extends JFrame implements IVista{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}
	@Override
	public void setControlador(Controlador c) {}
	
	@Override
	public void arranca() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	@Override
	public void noHumano() {}

	@Override
	public void hayHumano() {}
	
	@Override
	public int getCantPax() {
		return 0;
	}
	
	@Override
	public String getZona() {
		return null;
	}
	
	@Override
	public boolean isBaul() {
		return false;
	}
	
	@Override
	public boolean isMascota() {
		return false;
	}
	@Override
	public String getNombreReal()
	{
    	return null;
    }
	@Override
    public String getNuevoNomUsua()
    {
    	return null;
    }
	@Override
    public String getNuevaContr()
    {
    	return null;
    }
	@Override
    public String getNomUsua()
    {
    	return null;
    }
	@Override
    public String getContr()
    {
    	return null;
    }
	@Override
	public void setTextMsjInicSes(String string) {}
	@Override
	public void setTextMsjCrea(String string) {}
	@Override
	public void borraRegistrarse() {}
	
	public int getVar_CantPermanentes() {return 0;}

	public int getVar_CantMotos() {return 0;}

	public int getVar_CantAutos() {return 0;}

	public int getVar_CantCombis() {return 0;}

	public int getVar_CantViajesXCliente() {return 0;}

	public int getVar_CantClientes() {return 0;}

	public int getVar_CantViajesXChofer() {return 0;}

	public int getVar_CantTemporarios() {return 0;}

	public int getVar_CantContratados() {return 0;}

	@Override
	public void addWindowListener(WindowAdapter windowAdapter) {
		// TODO Auto-generated method stub
		
	}
	
}
