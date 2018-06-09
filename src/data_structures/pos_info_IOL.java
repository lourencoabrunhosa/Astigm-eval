package data_structures;

public class pos_info_IOL extends pos_info {
	
	Astigm pos_cornea;
	Astigm SIA_cornea;
	Astigm diff_cornea;
	Astigm IOL;
	double CI_cornea;
	double IOL_axis;
	
	public pos_info_IOL(double k1, double k2, double a1, double a2,double S,double C, double A, double IOL_S, double IOL_C, double IOL_A,pre_info preinfo) {
		super();
		if(k1>=k2) pos_cornea=new Astigm((k1+k2)/2,k1-k2,a1);
		else pos_cornea=new Astigm((k1+k2)/2,k2-k1,a2);
		SIA_cornea=pos_cornea.add(((pre_info_IOL)preinfo).pre_cornea.minus());
		diff_cornea=((pre_info_IOL)preinfo).TIA_cornea.add(SIA_cornea.minus());
		CI_cornea=SIA_cornea.proj(((pre_info_IOL)preinfo).TIA_cornea);
		pos=new Astigm(S,C,A);
		SIA=pos.add(preinfo.pre.minus());
		diff=preinfo.TIA.add(SIA.minus());
		CI=SIA.proj(preinfo.TIA);
		IOL=new Astigm(IOL_S,IOL_C,IOL_A);
		IOL_axis=pos.add(pos_cornea.minus()).axis();
	}

	public Astigm getPosCornea() {
		return pos_cornea;
	}

	public Astigm getSIACornea() {
		return SIA_cornea;
	}

	public Astigm getDiffCornea() {
		return diff_cornea;
	}

	public Astigm getIOL() {
		return IOL;
	}

	public double getCICornea() {
		return CI_cornea;
	}

	public double getIOLAxis() {
		return IOL_axis;
	}
}
