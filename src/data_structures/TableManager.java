package data_structures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TableManager {
	
	Table table;
	String directory;
	
	public TableManager(String directory) throws Custum_Exception{
		this.directory=directory;
		try {
			FileInputStream fis = new FileInputStream(directory);
			ObjectInputStream ois=new ObjectInputStream(fis);
			table = (Table) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Custum_Exception();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Custum_Exception();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Custum_Exception();
		}
	}
	
	public TableManager(String directory, Table table) {
		this.directory=directory;
		this.table=table;
	}
	
	public void close() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(directory);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(table);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
