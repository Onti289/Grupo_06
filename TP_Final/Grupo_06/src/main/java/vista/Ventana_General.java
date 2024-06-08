package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class Ventana_General extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_Vista_General;
	private JPanel panel_Vista_Chofer_Robot;
	private JPanel panel_Vista_Cliente_Robot;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.tabbedPane.setSelectedIndex(2);
		this.contentPane.add(this.tabbedPane, BorderLayout.NORTH);
		
		this.panel_Vista_General = new JPanel();
		this.tabbedPane.addTab("Vista General", null, this.panel_Vista_General, null);
		
		this.panel_Vista_Chofer_Robot = new JPanel();
		this.tabbedPane.addTab("Vista Chofer Robot", null, this.panel_Vista_Chofer_Robot, null);
		
		this.panel_Vista_Cliente_Robot = new JPanel();
		this.tabbedPane.addTab("Vista Cliente Robot", null, this.panel_Vista_Cliente_Robot, null);
	}

}
