package data_structures;

public class pre_info_REF extends pre_info {

	public pre_info_REF (double k1, double k2, double a1, double a2){
		super();
		if(k1>=k2) pre=new Astigm((k1+k2)/2,k1-k2,a1);
		else pre=new Astigm((k1+k2)/2,k2-k1,a2);
		TIA=pre.minus();
		surgery="Refractive";
	}
}
