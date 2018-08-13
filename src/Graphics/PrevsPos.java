package Graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import data_structures.Table;

public class PrevsPos {

	@SuppressWarnings("rawtypes")
	public static double[][] data(String filename, Vector<Vector> filters){
		double[] x= {0.25,0.5,0.75,1,1.25,1.5,1.75,2,2.25,2.5,2.75,3,Double.POSITIVE_INFINITY};
		double[][] y=new double[3][x.length];
		
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			y=((Table)ois.readObject()).getPrevsPos(x,filters);
			ois.close();
			fis.close();
			double[][] res={x,y[0],y[1]};
			return res;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new double[3][0];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new double[3][0];
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				fis.close();
				return new double[3][0];
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return new double[3][0];
			}
		} catch (Exception e) {
			return new double[2][0];
		}
		

		
	}

}
