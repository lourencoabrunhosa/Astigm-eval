package data_structures;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Vector;

class lista implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	class Node implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		patient val;
		Node next;
		
		Node(patient val,Node next){
			this.val=val;
			this.next=next;
		}
	}
	
	Node first;
	
	lista(){
		first=null;
	}
	
	void ins(patient x){
		Node aux=new Node(x,first);
		first=aux;
	}
	
	patient search(int id) {
		Node runner=first;
		while(runner!=null) {
			if(runner.val.id==id) return runner.val;
			runner=runner.next;
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	double[] stats(int var,Vector<Vector> filters) {
		double[] results=new double[7];
		Node runner=first;
		while(runner!=null) {
			double[] parcel=runner.val.getstats(var, filters);
			for(int i=0;i<7;i++) {
				results[i]+=parcel[i];
			}
			runner=runner.next;
		}
		return results;
	}
	
	@SuppressWarnings("rawtypes")
	void getTIAvsSIA(LinkedList<Double> TIA,LinkedList<Double> SIA,Vector<Vector> filters) {
		Node runner=first;
		while(runner!=null) {
			runner.val.getTIAvsSIA(TIA,SIA,filters);
			runner=runner.next;
		}
	}
	
	@SuppressWarnings("rawtypes")
	int[] getAxisError(double[] x,Vector<Vector> filters) {
		int[] results=new int[x.length+1];
		Node runner=first;
		while(runner!=null) {
			int[] parcel=runner.val.getAxisError(x, filters);
			for(int i=0;i<x.length+1;i++) {
				results[i]+=parcel[i];
			}
			runner=runner.next;
		}
		return results;
	}
	
	@SuppressWarnings("rawtypes")
	int[][] getPrevsPos(double[] x,Vector<Vector> filters) {
		int[][] results=new int[2][x.length+1];
		Node runner=first;
		while(runner!=null) {
			int[][] parcel=runner.val.getPrevsPos(x, filters);
			for(int i=0;i<7;i++) {
				results[0][i]+=parcel[0][i];
				results[1][i]+=parcel[1][i];
			}
			runner=runner.next;
		}
		return results;
	}
}

public class Table extends Tables {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	lista[] disp;
	int m;
	
	public Table(int m){
		this.m=m;
		disp=new lista[m];
		for(int i=0;i<m;i++) disp[i]=new lista();
	}
	
	private int h(int x) {
		return x%m;
	}
	
	public void add(patient p) {
		disp[h(p.id)].ins(p);
	}
	
	public patient search(int id) {
		return disp[h(id)].search(id);
	}
	
	@SuppressWarnings("rawtypes")
	public double[] stats(int var, Vector<Vector> filters) {
		double[] results=new double[7];
		for(int i=0; i<m;i++) {
			double [] temp=disp[i].stats(var, filters);
			for(int j=0;j<7;j++) results[j]+=temp[j];
		}
		return results;
	}
	
	@SuppressWarnings("rawtypes")
	public void getTIAvsSIA(LinkedList<Double> TIA,LinkedList<Double> SIA,Vector<Vector> filters) {
		for(int i=0; i<m;i++) {
			disp[i].getTIAvsSIA(TIA, SIA, filters);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public double[] getAxisError(double[] x, Vector<Vector> filters) {
		int[] results=new int[x.length+1];
		for(int i=0; i<m;i++) {
			int [] temp=disp[i].getAxisError(x, filters);
			for(int j=0;j<x.length+1;j++) results[j]+=temp[j];
		}
		double[] res=new double[x.length];
		for(int i=0;i<res.length;i++) {
			res[i]=(results[i]*100)/results[x.length-1];
		}
		return res;
	}
	
	@SuppressWarnings("rawtypes")
	public double[][] getPrevsPos(double[] x, Vector<Vector> filters) {
		int[][] results=new int[2][x.length+1];
		for(int i=0; i<m;i++) {
			int [][] temp=disp[i].getPrevsPos(x, filters);
			for(int j=0;j<x.length+1;j++) {
				results[0][j]+=temp[0][j];
				results[1][j]+=temp[1][j];
			}
		}
		double[][] res=new double[2][x.length];
		for(int i=0;i<res.length;i++) {
			res[0][i]=(results[0][i]*100)/results[0][x.length-1];
			res[1][i]=(results[1][i]*100)/results[1][x.length-1];
		}
		return res;
	}
}
