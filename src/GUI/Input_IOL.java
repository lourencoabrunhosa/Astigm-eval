package GUI;

import javax.swing.JTabbedPane;

public class Input_IOL extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	IOL_case parent;
	
	Input_IOL_cornea cornea;
	Input_IOL_subjective subjective;
	
	public Input_IOL(IOL_case parent) {
		this.parent=parent;
		
		cornea=new Input_IOL_cornea(this);
		subjective = new Input_IOL_subjective(this);
		
		add("subjective",subjective);
		add("cornea",cornea);

	}

}
