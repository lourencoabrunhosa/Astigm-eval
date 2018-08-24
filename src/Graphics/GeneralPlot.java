package Graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.Vector;

import data_structures.Table;

public class GeneralPlot {

	@SuppressWarnings("rawtypes")
	public static double[][] data(String filename,int var,Vector<Vector> filters) {

		LinkedList<Double> S=new LinkedList<Double>();
		LinkedList<Double> Cx=new LinkedList<Double>();
		LinkedList<Double> Cy=new LinkedList<Double>();

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fis);
			((Table)ois.readObject()).getGeneralPlot(var,S,Cx,Cy,filters);
			ois.close();
			fis.close();
			double[] Sarray=new double[S.size()];
			double[] Cxarray=new double[Cx.size()];
			double[] Cyarray=new double[Cy.size()];
			
			int i=0;
			for(double s:S) {
				Sarray[i]=s;
				i++;
			}
			
			i=0;
			for(double x:Cx) {
				Cxarray[i]=x;
				i++;
			}
			
			i=0;
			for(double y:Cy) {
				Cyarray[i]=y;
				i++;
			}
			
			double[][] res= {Sarray,Cxarray,Cyarray};
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
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return new double[3][0];
		} catch (Exception e) {
			return new double[3][0];
		}
	}
}
