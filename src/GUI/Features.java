package GUI;

import java.awt.Dimension;

import javax.swing.JTabbedPane;

public class Features extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	Base_frame parent;
	
	REF_case REF_patient;
	public Features(Base_frame parent) {
		this.parent=parent;
		
		setPreferredSize(new Dimension(600,400));
		
		REF_patient=new REF_case(this);
		
		add("Refractive Surgery",REF_patient);
		

	}

}
