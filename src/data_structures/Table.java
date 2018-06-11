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
	
}

public class Table {
	
}
