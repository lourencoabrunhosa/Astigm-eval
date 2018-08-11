package get_stats;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Locale;

import javax.swing.JPanel;

public class Stats_Show extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Stats_Panel parent;
	
	Stats_Out_REF refstats;
	
	Stats_Out_IOL_Sub subiolstats;
	Stats_Out_IOL_Cor coriolstats;

	public Stats_Show(Stats_Panel parent) {
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(418,600));
		setLayout(null);
		
		this.parent=parent;		
	}
	
	public void showREF() {
		removeAll();
		refstats=new Stats_Out_REF(parent);
		refstats.setBounds(0,0,418,600);
		add(refstats);
		revalidate();
		repaint();
	}
	
	public void showIOLSub() {
		removeAll();
		subiolstats=new Stats_Out_IOL_Sub(parent);
		subiolstats.setBounds(0,0,418,600);
		add(refstats);
		revalidate();
		repaint();
	}
	
	public void showIOLCor() {
		removeAll();
		coriolstats=new Stats_Out_IOL_Cor(parent);
		coriolstats.setBounds(0,0,418,600);
		add(refstats);
		revalidate();
		repaint();
	}
	

}
