package data_structures;

public class Astigm {
	protected double M;
	protected double J0;
	protected double J45;
	
	public Astigm(double S,double C,double a) {
		M=(S+C)/2;
		J0=(C/2)*Math.cos(2*a);
		J45=(C/2)*Math.sin(2*a);
	}
	
	public double getM() {
		return M;
	}
	
	public double getJ0() {
		return J0;
	}
	
	public double getJ45() {
		return J45;
	}
	
	public Astigm add(Astigm other) {
		Astigm result =new Astigm(0,0,0);
		result.M=this.M+other.M;
		result.J0=this.J0+other.J0;
		result.J45=this.J45+other.J45;
		return result;
	}
	
	public double proj(Astigm other) {// internal product between two power vectors, normalized to other.
		return (this.M*other.M+this.J0*other.J0+this.J45*other.J45)/(other.M*other.M+other.J0*other.J0+other.J45*other.J45);
	}
	
	private static double angle(double J0, double J45) {
		return Math.toDegrees(Math.atan2(J45, J0))/2;
	}
	
	public double[] show() {
		double[] res=new double[3];
		res[2]=angle(J0,J45);
		res[1]=Math.sqrt(Math.pow(J0,2)+Math.pow(J45, 2));
		res[0]=2*M-res[1];
		return res;
	}
}