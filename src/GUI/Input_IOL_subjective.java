package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Locale;

import javax.swing.JButton;
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
		setPreferredSize(new Dimension(244,600));
		setLayout(null);
		
		this.parent=parent;
		
		
		JButton TIA = new JButton("Get TIA");
		TIA.setBounds(100,250,85,25);
		add(TIA);
		
		JButton outcomes = new JButton("Analyse Surgery");
		outcomes.setBounds(55,290,130,25);
		add(outcomes);

	}

}
