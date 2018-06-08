package GUI;

import javax.swing.JTabbedPane;

public class Output_IOL extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	IOL_case parent;
	
	Output_IOL_cornea cornea;
	Output_IOL_subjective subjective;
	
	public Output_IOL(IOL_case parent) {
		
		this.parent=parent;
		
		cornea = new Output_IOL_cornea(this);
		subjective = new Output_IOL_subjective(this);
		
		add("Subjective", subjective);
		add("Cornea", cornea);

	}

}
