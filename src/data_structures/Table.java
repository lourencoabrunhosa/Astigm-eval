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

public class Table {
	
}
