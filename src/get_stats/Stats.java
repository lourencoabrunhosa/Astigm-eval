package get_stats;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import data_structures.Astigm;
import data_structures.Round;
import data_structures.Table;

public class Stats {
	public static String getStats(int var, double minBound, double maxBound, String filename) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			double[] results=((Table)ois.readObject()).stats(var,minBound,maxBound);
			ois.close();
			fis.close();
			double[] mean = {results[0]/results[6], results[1]/results[6], results[2]/results[6]};
			double[] desvmed = {Math.sqrt(results[3]-Math.pow(results[0], 2)/results[6])/results[6], 
								-(Math.sqrt(results[4]-Math.pow(results[1], 2)/results[6]))/results[6],
								-(Math.sqrt(results[5]-Math.pow(results[2], 2)/results[6]))/results[6]};
			mean=Astigm.convert(mean);
			desvmed=Astigm.convert(desvmed);
			return Round.round(mean[0],2)+" / "+Round.round(mean[1],2)+","+Round.round(mean[2],2)+" ± "+Round.round(Math.abs(desvmed[0]),2)+" / "+Round.round(desvmed[1],2)+","+Round.round(desvmed[2],2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return"";
	}
}
