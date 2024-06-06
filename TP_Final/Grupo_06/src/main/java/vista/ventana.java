package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;

public class ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelcentrl;
	private JPanel panelizq1;
	private JPanel panelder2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana frame = new ventana();
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
	public ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelcentrl = new JPanel();
		this.contentPane.add(this.panelcentrl, BorderLayout.CENTER);
		GridBagLayout gbl_panelcentrl = new GridBagLayout();
		gbl_panelcentrl.columnWidths = new int[]{50};
		gbl_panelcentrl.rowHeights = new int[]{50};
		gbl_panelcentrl.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelcentrl.rowWeights = new double[]{Double.MIN_VALUE};
		this.panelcentrl.setLayout(gbl_panelcentrl);
		
		this.panelizq1 = new JPanel();
		this.contentPane.add(this.panelizq1, BorderLayout.WEST);
		GridBagLayout gbl_panelizq1 = new GridBagLayout();
		gbl_panelizq1.columnWidths = new int[]{0};
		gbl_panelizq1.rowHeights = new int[]{0};
		gbl_panelizq1.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelizq1.rowWeights = new double[]{Double.MIN_VALUE};
		this.panelizq1.setLayout(gbl_panelizq1);
		
		this.panelder2 = new JPanel();
		this.contentPane.add(this.panelder2, BorderLayout.EAST);
		GridBagLayout gbl_panelder2 = new GridBagLayout();
		gbl_panelder2.columnWidths = new int[]{0};
		gbl_panelder2.rowHeights = new int[]{0};
		gbl_panelder2.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelder2.rowWeights = new double[]{Double.MIN_VALUE};
		this.panelder2.setLayout(gbl_panelder2);
	}

}
