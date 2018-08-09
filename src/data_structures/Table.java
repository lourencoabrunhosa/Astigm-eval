package data_structures;

import java.io.Serializable;
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
}
