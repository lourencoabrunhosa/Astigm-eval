package data_structures;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TableManager {
	
	public static Table connect(String directory) throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(directory);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Table table = (Table) ois.readObject();
			ois.close();
			fis.close();
			return table;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fis.close();
			return null;
		}
	}
	
	public static void create(String directory, Table table) {
		FileOutputStream fos = null;
		try {
			fos=new FileOutputStream(directory);
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
