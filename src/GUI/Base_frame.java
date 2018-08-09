package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data_structures.doctor;
import get_stats.Stats_Show;


public class Base_frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public doctor doc;
	public Features features;
	public Patient_panel patient_panel;
	public Stats_Show stats_show;
	
	int STATE;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Base_frame frame = new Base_frame(doc);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Base_frame(doctor doc) {
		
		this.doc=doc;
		
		STATE=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		setSize(700,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		
		
		features=new Features(this);
		patient_panel=new Patient_panel(this,doc);
		stats_show=new Stats_Show(this);
		
		contentPane.add(features);
		contentPane.add(patient_panel,BorderLayout.PAGE_START);
	}

}
