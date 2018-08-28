package Graphics;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Graphic_Show extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Graphic_Show frame = new Graphic_Show();
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
	@SuppressWarnings("rawtypes")
	public Graphic_Show() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String filename="olaadeus829513000ref";
		Vector<Vector> filters=new Vector<Vector>();
		
		contentPane.add(new Graphics_panel(filename,filters));
		
//		JFXPanel pvp = new JFXPanel();
//		Scene scenepvp=new Scene(barchart.barChartV(PrevsPos.data(filename, filters)),500,300);
//		System.out.println("print1");
//		pvp.setScene(scenepvp);	
//		System.out.println("print2");
//		JFXPanel ae = new JFXPanel();
//		Scene sceneae=new Scene(barchart.barChartH(axisError.data(filename, filters)),500,300);
//		ae.setScene(sceneae);
//		
//		contentPane.add(ae,BorderLayout.LINE_START);
//		contentPane.add(pvp,BorderLayout.LINE_END);
	}

}
