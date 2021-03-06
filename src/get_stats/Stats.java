package get_stats;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import data_structures.Astigm;
import data_structures.Table;

public class Stats {
	@SuppressWarnings({ "rawtypes", "resource" })
	public static double[][] getStats(int var, Vector<Vector> filters, String filename) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			double[] results=((Table)ois.readObject()).stats(var,filters);
			ois.close();
			fis.close();
			double[] mean = {results[0]/results[6], results[1]/results[6], results[2]/results[6]};
			double[] desvmed = {Math.sqrt(results[3]-Math.pow(results[0], 2)/results[6])/results[6], 
								-(Math.sqrt(results[4]-Math.pow(results[1], 2)/results[6]))/results[6],
								-(Math.sqrt(results[5]-Math.pow(results[2], 2)/results[6]))/results[6]};
			mean=Astigm.convert(mean);
			desvmed=Astigm.convert(desvmed);
			//return Round.round(mean[0],2)+" / "+Round.round(mean[1],2)+","+Round.round(mean[2],2)+" ± "+Round.round(Math.abs(desvmed[0]),2)+" / "+Round.round(desvmed[1],2)+","+Round.round(desvmed[2],2);
			double[][] res={mean,desvmed};
			return res;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new double[2][3];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new double[2][3];
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new double[2][3];
		} catch (Exception e) {
			return new double[2][3];
		}
		
	}
}
