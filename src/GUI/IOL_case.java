package GUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IOL_case extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * create panel
	 */
	
	Features parent;
	
	Input_IOL input;
	Output_IOL output;
	
	public IOL_case(Features parent) {
		this.parent=parent;
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		input=new Input_IOL(this);
		output=new Output_IOL(this);
		add(input,BorderLayout.LINE_START);
		add(output,BorderLayout.LINE_END);
	}
}
