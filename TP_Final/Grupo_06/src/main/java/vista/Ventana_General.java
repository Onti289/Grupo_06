package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import controladores.*;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Ventana_General extends Ventana implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPaneGeneral;
	private JTextArea textAreaGeneral;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_General frame = new Ventana_General();
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
	public Ventana_General() {
		setTitle("Vista General");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 750, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.scrollPaneGeneral = new JScrollPane();
		this.contentPane.add(this.scrollPaneGeneral, BorderLayout.CENTER);
		
		this.textAreaGeneral = new JTextArea();
		this.scrollPaneGeneral.setViewportView(this.textAreaGeneral);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public void appendLog(String linea)
    {
        this.textAreaGeneral.append(linea+"\n");
    }
}
