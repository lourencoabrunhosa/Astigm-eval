package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Locale;

import javax.swing.JPanel;

public class Input_IOL_subjective extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	Input_IOL parent;
	
	public Input_IOL_subjective(Input_IOL parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(225,400));
		setLayout(null);
		
		this.parent=parent;

	}

}
