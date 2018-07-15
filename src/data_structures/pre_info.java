package data_structures;

import java.io.Serializable;

public class pre_info implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Astigm pre;
	Astigm TIA;
	String surgery;
	
	public Astigm getPre() {
		return pre;
	}
	
	public Astigm getTIA() {
		return TIA;
	}
	
	public String getSurgery() {
		return surgery;
	}
}
