package data_structures;

import java.io.Serializable;
import java.time.LocalDateTime;

public class doctor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String FirstName;
	public String Surname;
	LocalDateTime LastLogin;
	LocalDateTime accountcreated;
	String databasename;
	
	public doctor(String FirstName,String Surname) {
		this.FirstName=FirstName;
		this.Surname=Surname;
		accountcreated=LocalDateTime.now();
		LastLogin=LocalDateTime.now();
		databasename="."+FirstName+Surname+accountcreated.getNano();
	}
	
	public void loged() {
		LastLogin=LocalDateTime.now();
	}
	
	public String getDataBaseName() { 
		return databasename;
	}
}
