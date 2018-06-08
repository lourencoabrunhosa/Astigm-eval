package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Locale;

import javax.swing.JPanel;

public class Output_IOL_cornea extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	Output_IOL parent;
	
	public Output_IOL_cornea(Output_IOL parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(390,600));
		setLayout(null);
		
		this.parent=parent;

	}

}
