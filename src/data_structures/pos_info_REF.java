package data_structures;

public class pos_info_REF extends pos_info {
	
	public pos_info_REF(double k1, double k2, double a1, double a2,pre_info preinfo) {
		super();
		if(a1>=a2) pos=new Astigm((k1+k2)/2,k1,a1);
		else pos=new Astigm((k1+k2)/2,k2,a2);
		SIA=pos.add(preinfo.getPre().minus());
		diff=preinfo.getTIA().add(SIA.minus());
		CI=SIA.proj(preinfo.getTIA());
	}
}
