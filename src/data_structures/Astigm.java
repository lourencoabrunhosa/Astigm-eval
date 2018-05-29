package data_structures;

public class Astigm {
	double M;
	double J0;
	double J45;
	
	public Astigm(double S,double C,double a) {
		M=(S+C)/2;
		J0=(C/2)*Math.cos(2*a);
		J45=(C/2)*Math.sin(2*a);
	}
}
