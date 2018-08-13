package Graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import data_structures.Table;

public class axisError {
	
	@SuppressWarnings("rawtypes")
	public static double[][] data(String filename, Vector<Vector> filters){
		double[] x= {-75,-65,-55,-45,-35,-25,-15,-5,5,15,25,35,45,55,65,75,180};
		double[] y=new double[x.length];
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			y=((Table)ois.readObject()).getAxisError(x,filters);
			ois.close();
			fis.close();
			double[][] res={x,y};
			return res;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new double[2][0];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new double[2][0];
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				fis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return new double[2][0];
		} catch (Exception e) {
			return new double[2][0];
		}
		

		
	}

}
