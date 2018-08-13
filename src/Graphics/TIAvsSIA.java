package Graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.Vector;

import data_structures.Table;

public class TIAvsSIA {
	

	@SuppressWarnings("rawtypes")
	public static double[][] data(String filename, Vector<Vector> filters){
		LinkedList<Double> TIA =new LinkedList<Double>();
		LinkedList<Double> SIA =new LinkedList<Double>();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			((Table)ois.readObject()).getTIAvsSIA(TIA,SIA,filters);
			ois.close();
			fis.close();
			double[] TIAarray=new double[TIA.size()];
			double[] SIAarray =new double[SIA.size()];
			int i=0;
			for(double t:TIA) {
				TIAarray[i]=t;
				i++;
			}
			i=0;
			for(double s:SIA) {
				SIAarray[i]=s;
				i++;
			}
			double[][] res={TIAarray,SIAarray};
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
