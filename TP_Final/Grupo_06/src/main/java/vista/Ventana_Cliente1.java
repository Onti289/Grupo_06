package vista;

import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Cliente;
import modelo.ClienteAbstracto;
import modelo.IViaje;
import modelo.Sistema;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Ventana_Cliente1 extends Ventana implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPaneCliente1;
	private JTextArea textAreaCliente1;
	private ClienteAbstracto observado;
	private Sistema sistemaObservado;


	/**
	 * Create the frame.
	 */
	public Ventana_Cliente1() {
		setTitle("Vista Cliente 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.scrollPaneCliente1 = new JScrollPane();
		this.contentPane.add(this.scrollPaneCliente1);
		
		this.textAreaCliente1 = new JTextArea();
		this.scrollPaneCliente1.setViewportView(this.textAreaCliente1);
		
		this.observado = Sistema.getCliente1(Sistema.getAdmin());
		this.observado.addObserver(this);
		this.sistemaObservado = Sistema._getInstancia();
		this.sistemaObservado.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o != observado)
			throw new IllegalArgumentException();
		String cartel = (String) arg;
		this.appendLog(cartel);		
		
	}

	public void appendLog(String linea)
    {
        this.textAreaCliente1.append(linea + "\n");
    }
}
