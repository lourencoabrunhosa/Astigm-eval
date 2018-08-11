package get_stats;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.Base_frame;


public class Stats_Panel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	Base_frame parent;
	
	Stats_Intro input;
	Stats_Show output;
	public Stats_Panel(Base_frame parent) {
		
		setPreferredSize(new Dimension(700,600));
		setBorder(new EmptyBorder(1, 1, 1, 1));
		setLayout(new BorderLayout(0, 0));
		
		this.parent=parent;
		
		input=new Stats_Intro(this);
		output=new Stats_Show(this);
		
		add(input,BorderLayout.LINE_START);
		add(output,BorderLayout.LINE_END);

	}

}
