package data_structures;

import java.time.LocalDateTime;

public class doctor {
	String FirstName;
	String Surname;
	LocalDateTime LastLogin;
	LocalDateTime accountcreated;
	String databasename;
	
	public doctor(String FirstName,String Surname) {
		this.FirstName=FirstName;
		this.Surname=Surname;
		accountcreated=LocalDateTime.now();
		LastLogin=LocalDateTime.now();
		databasename=FirstName+Surname+accountcreated.getNano();
	}
	
	public void loged() {
		LastLogin=LocalDateTime.now();
	}
	
	public String getDataBaseName() { 
		return databasename;
	}
}
