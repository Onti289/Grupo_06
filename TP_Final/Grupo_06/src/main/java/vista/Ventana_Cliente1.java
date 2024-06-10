package vista;

import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JList;

public class Ventana_Cliente1 extends Ventana implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPaneCliente1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Cliente1 frame = new Ventana_Cliente1();
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
		
		JList Var_listaCliente1 = new JList();
		scrollPaneCliente1.setViewportView(Var_listaCliente1);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
