package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class REF_case extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	Base_frame parent;
	
	Input_REF input;
	Output_REF output;
	
	public REF_case(Base_frame parent) {
		this.parent=parent;
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		input=new Input_REF(this);
		output=new Output_REF(this);
		add(input,BorderLayout.LINE_START);
		add(output,BorderLayout.LINE_END);
	}

}
