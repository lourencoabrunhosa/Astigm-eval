package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Locale;

import javax.swing.JPanel;

import data_structures.pos_info;
import data_structures.pre_info;

public class Output_REF extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	
	REF_case parent;
	
	pre_info preinfo;
	pos_info posinfo;
	public Output_REF(REF_case parent) {
		
		Locale.setDefault(Locale.US);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(370,400));
		setLayout(null);
		
		this.parent=parent;
	}
	
	public void Output_TIA(pre_info preinfo) {
		this.preinfo=preinfo;
	}
	
	public void Output_analisis(pre_info preinfo, pos_info posinfo) {
		this.preinfo=preinfo;
		this.posinfo=posinfo;
	}

}
