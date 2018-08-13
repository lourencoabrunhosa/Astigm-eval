package data_structures;

import java.io.Serializable;

public class Astigm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected double M;
	protected double J0;
	protected double J45;
	
	public Astigm(double S,double C,double a) {
		M=S+(C/2);
		J0=(-C/2)*Math.cos(2*Math.toRadians(a));
		J45=(-C/2)*Math.sin(2*Math.toRadians(a));
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
	
	public Astigm minus() {
		Astigm result =new Astigm(0,0,0);
		result.M=-this.M;
		result.J0=-this.J0;
		result.J45=-this.J45;
		return result;
	}
	
	public double proj(Astigm other) {// internal product between two power vectors, normalized to other.
		return (this.M*other.M+this.J0*other.J0+this.J45*other.J45)/(other.M*other.M+other.J0*other.J0+other.J45*other.J45);
	}
	
	public double Mag() {
		return (this.M*this.M+this.J0*this.J0+this.J45*this.J45);
	}
	
	private static double angle(double J0, double J45) {
		double x= Math.toDegrees(Math.atan2(J45, J0))/2;
		return x+90;
	}
	
	public double axis() {
		return angle(J0,J45);
	}
	public double[] show() {
		double[] res=new double[3];
		if(J0==J45&&J0==0) res[2]=0;
		else res[2]=angle(J0,J45);
		res[1]=2*(Math.sqrt(Math.pow(J0,2)+Math.pow(J45, 2)));
		res[0]=M-(res[1]/2);
		return res;
	}
	
	public static double[] convert(double[] arg) {
		double[] res=new double[3];
		if(arg[1]==arg[2]&&arg[1]==0) res[2]=0;
		else res[2]=angle(arg[1],arg[2]);
		res[1]=2*(Math.sqrt(Math.pow(arg[1],2)+Math.pow(arg[2], 2)));
		res[0]=arg[0]-(res[1]/2);
		return res;
	}
}
