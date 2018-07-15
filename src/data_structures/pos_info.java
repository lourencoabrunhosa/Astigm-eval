																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																														package data_structures;

import java.io.Serializable;

public class pos_info implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Astigm pos;
	Astigm SIA;
	Astigm diff;
	double CI;
	
	public Astigm getPos() {
		return pos;
	}
	
	public Astigm getSIA() {
		return SIA;
	}
	
	public Astigm getDiff() {
		return diff;
	}
	
	public double getCI() {
		return CI;
	}
}
