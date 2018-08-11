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

	/**
	 * Create the panel.
	 */
	
	Stats_Panel parent;
	
	public Stats_Show(Stats_Panel parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(418,600));
		setLayout(null);
		
		this.parent=parent;

	}

}
