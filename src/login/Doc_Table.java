package login;

import data_structures.Tables;
import data_structures.doctor;

class lista{
	class Node{
		doctor val;
		Node next;
		
		Node(doctor val,Node next){
			this.val=val;
			this.next=next;
		}
	}
	
	Node first;
	
	lista(){
		first=null;
	}
	
	void ins(doctor x){
		Node aux=new Node(x,first);
		first=aux;
	}
	
	Boolean search(String Name, String Surname) {
		Node runner=first;
		while(runner!=null) {
			if(runner.val.FirstName==Name&&runner.val.Surname==Surname) return true;
			runner=runner.next;
		}
		return false;
	}
}


public class Doc_Table extends Tables{
	lista disp;

	
	Doc_Table(){
		disp=new lista();
	}
	
	public void add(doctor d) {
		disp.ins(d);
	}
	
	public boolean search(String Name, String Surname) {
		return disp.search(Name, Surname);
	}
	
}
