package vista;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Sistema;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Ventana_Chofer1 extends Ventana implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPaneChofer1;
	private JTextArea textAreaChofer1;
	private Observable observado;


	/**
	 * Create the frame.
	 */
	public Ventana_Chofer1() {
		setTitle("Vista Chofer 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.scrollPaneChofer1 = new JScrollPane();
		this.contentPane.add(this.scrollPaneChofer1);
		
		this.textAreaChofer1 = new JTextArea();
		this.scrollPaneChofer1.setViewportView(this.textAreaChofer1);
		this.observado = Sistema.getChofer1(Sistema.getAdmin());
		this.observado.addObserver(this);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o != observado)
		{
			throw new IllegalArgumentException();
		}
		String cartel = (String) arg;
		this.appendLog(cartel);
		
	}

	public void appendLog(String linea)
    {
        this.textAreaChofer1.append(linea + "\n");
    }
}
