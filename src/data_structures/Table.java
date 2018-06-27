package data_structures;

class lista{
	class Node{
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
	
	double[] stats(int var,double minBound, double maxBound ) {
		double[] results=new double[7];
		Node runner=first;
		while(runner!=null) {
			double[] parcel=runner.val.getstats(var, minBound, maxBound);
			for(int i=0;i<7;i++) {
				results[i]+=parcel[i];
			}
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
	
	Table(int m){
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
	
	public double[] stats(int var, double minBound,double maxBound) {
		double[] results=new double[7];
		for(int i=0; i<m;i++) {
			double [] temp=disp[i].stats(var, minBound, maxBound);
			for(int j=0;j<7;j++) results[i]+=temp[i];
		}
		return results;
	}
}
