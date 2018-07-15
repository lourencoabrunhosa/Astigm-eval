package data_structures;

public class pre_info_IOL extends pre_info {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Astigm pre_cornea;
	Astigm TIA_cornea;
	
	public pre_info_IOL(double k1, double k2, double a1, double a2, double S, double C, double A) {
		super();
		if(k1>=k2) pre_cornea=new Astigm((k1+k2)/2,k1-k2,a1);
		else pre_cornea=new Astigm((k1+k2)/2,k2-k1,a2);
		TIA_cornea=pre_cornea.minus();
		pre=new Astigm(S,C,A);
		TIA=pre.minus();
		surgery="IOL";
	}
	
	public Astigm getPreCornea() {
		return pre_cornea;
	}
	
	public Astigm getTIACornea() {
		return TIA_cornea;
	}
}
