package data_structures;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.LinkedList;
import java.util.Vector;

public class patient implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	LocalDate birth;
	LocalDateTime regist;
	pre_info preinfo;
	pos_info posinfo;
	
	protected final int PRE_SURGERY=1;
	protected final int TIA_SURGERY=2;
	protected final int POS_SURGERY=3;
	protected final int SIA_SURGERY=4;
	protected final int DIFF_SURGERY=5;
	protected final int CI_SURGERY=6;
	
	protected final int PRE_CORNEA=7;
	protected final int TIA_CORNEA=8;
	protected final int POS_CORNEA=9;
	protected final int SIA_CORNEA=10;
	protected final int DIFF_CORNEA=11;
	protected final int CI_CORNEA=12;
	
	protected final int REAL_IOL_AXIS=13;
	protected final int IOL_LENS=14;
	protected final int IOL_AXIS_DESV=15;
	
	public patient(int id, String name,int year,Month month,int day, pre_info preinfo, pos_info posinfo) {
		this.id=id;
		this.name=name;
		this.regist=LocalDateTime.now();
		this.birth= LocalDate.of(year,month,day);
		this.preinfo=preinfo;
		this.posinfo=posinfo;
	}
	
	@SuppressWarnings("rawtypes")
	public double[] getstats(int var, Vector<Vector> filters) {
		double[] results=new double[7];
		if(checkFilters(filters)) {
			if(var==PRE_SURGERY) {
				results[0]=preinfo.getPre().M;
				results[1]=preinfo.getPre().J0;
				results[2]=preinfo.getPre().J45;
				results[3]=preinfo.getPre().M*preinfo.getPre().M;
				results[4]=preinfo.getPre().J0*preinfo.getPre().J0;
				results[5]=preinfo.getPre().J45*preinfo.getPre().J45;
				results[6]=1;
			}
			if(var==TIA_SURGERY) {
				results[0]=preinfo.getTIA().M;
				results[1]=preinfo.getTIA().J0;
				results[2]=preinfo.getTIA().J45;
				results[3]=preinfo.getTIA().M*preinfo.getTIA().M;
				results[4]=preinfo.getTIA().J0*preinfo.getTIA().J0;
				results[5]=preinfo.getTIA().J45*preinfo.getTIA().J45;
				results[6]=1;
			}
			if(var==POS_SURGERY) {
				results[0]=posinfo.getPos().M;
				results[1]=posinfo.getPos().J0;
				results[2]=posinfo.getPos().J45;
				results[3]=posinfo.getPos().M*posinfo.getPos().M;
				results[4]=posinfo.getPos().J0*posinfo.getPos().J0;
				results[5]=posinfo.getPos().J45*posinfo.getPos().J45;
				results[6]=1;
			}
			if(var==SIA_SURGERY) {
				results[0]=posinfo.getSIA().M;
				results[1]=posinfo.getSIA().J0;
				results[2]=posinfo.getSIA().J45;
				results[3]=posinfo.getSIA().M*posinfo.getSIA().M;
				results[4]=posinfo.getSIA().J0*posinfo.getSIA().J0;
				results[5]=posinfo.getSIA().J45*posinfo.getSIA().J45;
				results[6]=1;
			}
			if(var==DIFF_SURGERY) {
				results[0]=posinfo.getDiff().M;
				results[1]=posinfo.getDiff().J0;
				results[2]=posinfo.getDiff().J45;
				results[3]=posinfo.getDiff().M*posinfo.getDiff().M;
				results[4]=posinfo.getDiff().J0*posinfo.getDiff().J0;
				results[5]=posinfo.getDiff().J45*posinfo.getDiff().J45;
				results[6]=1;
			}
			if(var==CI_SURGERY) {
				results[0]=posinfo.getCI();
				results[3]=posinfo.getCI()*posinfo.getCI();
				results[6]=1;
			}
			if(var==PRE_CORNEA) {
				results[0]=((pre_info_IOL) preinfo).getPreCornea().M;
				results[1]=((pre_info_IOL) preinfo).getPreCornea().J0;
				results[2]=((pre_info_IOL) preinfo).getPreCornea().J45;
				results[3]=((pre_info_IOL) preinfo).getPreCornea().M*((pre_info_IOL) preinfo).getPreCornea().M;
				results[4]=((pre_info_IOL) preinfo).getPreCornea().J0*((pre_info_IOL) preinfo).getPreCornea().J0;
				results[5]=((pre_info_IOL) preinfo).getPreCornea().J45*((pre_info_IOL) preinfo).getPreCornea().J45;
				results[6]=1;
			}
			if(var==TIA_CORNEA) {
				results[0]=((pre_info_IOL) preinfo).getTIACornea().M;
				results[1]=((pre_info_IOL) preinfo).getTIACornea().J0;
				results[2]=((pre_info_IOL) preinfo).getTIACornea().J45;
				results[3]=((pre_info_IOL) preinfo).getTIACornea().M*((pre_info_IOL) preinfo).getTIACornea().M;
				results[4]=((pre_info_IOL) preinfo).getTIACornea().J0*((pre_info_IOL) preinfo).getTIACornea().J0;
				results[5]=((pre_info_IOL) preinfo).getTIACornea().J45*((pre_info_IOL) preinfo).getTIACornea().J45;
				results[6]=1;
			}
			if(var==POS_CORNEA) {
				results[0]=((pos_info_IOL) posinfo).getPosCornea().M;
				results[1]=((pos_info_IOL) posinfo).getPosCornea().J0;
				results[2]=((pos_info_IOL) posinfo).getPosCornea().J45;
				results[3]=((pos_info_IOL) posinfo).getPosCornea().M*((pos_info_IOL) posinfo).getPosCornea().M;
				results[4]=((pos_info_IOL) posinfo).getPosCornea().J0*((pos_info_IOL) posinfo).getPosCornea().J0;
				results[5]=((pos_info_IOL) posinfo).getPosCornea().J45*((pos_info_IOL) posinfo).getPosCornea().J45;
				results[6]=1;
			}
			if(var==SIA_CORNEA) {
				results[0]=((pos_info_IOL) posinfo).getSIACornea().M;
				results[1]=((pos_info_IOL) posinfo).getSIACornea().J0;
				results[2]=((pos_info_IOL) posinfo).getSIACornea().J45;
				results[3]=((pos_info_IOL) posinfo).getSIACornea().M*((pos_info_IOL) posinfo).getSIACornea().M;
				results[4]=((pos_info_IOL) posinfo).getSIACornea().J0*((pos_info_IOL) posinfo).getSIACornea().J0;
				results[5]=((pos_info_IOL) posinfo).getSIACornea().J45*((pos_info_IOL) posinfo).getSIACornea().J45;
				results[6]=1;
			}
			if(var==DIFF_CORNEA) {
				results[0]=((pos_info_IOL) posinfo).getDiffCornea().M;
				results[1]=((pos_info_IOL) posinfo).getDiffCornea().J0;
				results[2]=((pos_info_IOL) posinfo).getDiffCornea().J45;
				results[3]=((pos_info_IOL) posinfo).getDiffCornea().M*((pos_info_IOL) posinfo).getDiffCornea().M;
				results[4]=((pos_info_IOL) posinfo).getDiffCornea().J0*((pos_info_IOL) posinfo).getDiffCornea().J0;
				results[5]=((pos_info_IOL) posinfo).getDiffCornea().J45*((pos_info_IOL) posinfo).getDiffCornea().J45;
				results[6]=1;
			}
			if(var==CI_CORNEA) {
				results[0]=((pos_info_IOL) posinfo).getCICornea();
				results[3]=((pos_info_IOL) posinfo).getCICornea()*((pos_info_IOL) posinfo).getCICornea();
				results[6]=1;
			}
			if(var==REAL_IOL_AXIS) {
				results[0]=((pos_info_IOL) posinfo).getIOLAxis();
				results[3]=((pos_info_IOL) posinfo).getIOLAxis()*((pos_info_IOL) posinfo).getIOLAxis();
				results[6]=1;
			}
			if(var==IOL_LENS) {
				results[0]=((pos_info_IOL) posinfo).getIOL().M;
				results[1]=((pos_info_IOL) posinfo).getIOL().J0;
				results[2]=((pos_info_IOL) posinfo).getIOL().J45;
				results[3]=((pos_info_IOL) posinfo).getIOL().M*((pos_info_IOL) posinfo).getIOL().M;
				results[4]=((pos_info_IOL) posinfo).getIOL().J0*((pos_info_IOL) posinfo).getIOL().J0;
				results[5]=((pos_info_IOL) posinfo).getIOL().J45*((pos_info_IOL) posinfo).getIOL().J45;
				results[6]=1;
			}
			if(var==IOL_AXIS_DESV) {
				results[0]=((pos_info_IOL) posinfo).getIOLAxis()-((pos_info_IOL) posinfo).getIOL().axis();
				results[3]=(((pos_info_IOL) posinfo).getIOLAxis()-((pos_info_IOL) posinfo).getIOL().axis())*(((pos_info_IOL) posinfo).getIOLAxis()-((pos_info_IOL) posinfo).getIOL().axis());
				results[6]=1;
			}
		}
		return results;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean checkFilters(Vector<Vector> filters) {
		boolean res= true;
		for(Vector row:filters) {
			if(preinfo.getSurgery().equals("Refractive")) {
				if(row.get(0).equals("Pre Cornea Sphere")) {
					double S=preinfo.getPre().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pre Cornea Cylinder")) {
					double S=preinfo.getPre().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pre Cornea Axis")) {
					double S=preinfo.getPre().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("TIA Cornea Sphere")) {
					double S=preinfo.getTIA().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("TIA Cornea Cylinder")) {
					double S=preinfo.getTIA().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("TIA Cornea Axis")) {
					double S=preinfo.getTIA().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("SIA Cornea Sphere")) {
					double S=posinfo.getSIA().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("SIA Cornea Cylinder")) {
					double S=posinfo.getSIA().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("SIA Cornea Axis")) {
					double S=posinfo.getSIA().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Diff Cornea Sphere")) {
					double S=posinfo.getDiff().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Diff Cornea Cylinder")) {
					double S=posinfo.getDiff().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Diff Cornea Axis")) {
					double S=posinfo.getDiff().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pos Cornea Sphere")) {
					double S=posinfo.getPos().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pos Cornea Cylinder")) {
					double S=posinfo.getPos().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pos Cornea Axis")) {
					double S=posinfo.getPos().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Cornea Correction Index")) {
					double S=posinfo.getCI();
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}
			}else if(preinfo.getSurgery().equals("IOL")) {
				if(row.get(0).equals("Pre Cornea Sphere")) {
					double S=((pre_info_IOL) preinfo).getPreCornea().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pre Cornea Cylinder")) {
					double S=((pre_info_IOL) preinfo).getPreCornea().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pre Cornea Axis")) {
					double S=((pre_info_IOL) preinfo).getPreCornea().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("TIA Cornea Sphere")) {
					double S=((pre_info_IOL) preinfo).getTIACornea().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("TIA Cornea Cylinder")) {
					double S=((pre_info_IOL) preinfo).getTIACornea().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("TIA Cornea Axis")) {
					double S=((pre_info_IOL) preinfo).getTIACornea().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("SIA Cornea Sphere")) {
					double S=((pos_info_IOL) posinfo).getSIACornea().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("SIA Cornea Cylinder")) {
					double S=((pos_info_IOL) posinfo).getSIACornea().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("SIA Cornea Axis")) {
					double S=((pos_info_IOL) posinfo).getSIACornea().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Diff Cornea Sphere")) {
					double S=((pos_info_IOL) posinfo).getDiffCornea().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Diff Cornea Cylinder")) {
					double S=((pos_info_IOL) posinfo).getDiffCornea().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Diff Cornea Axis")) {
					double S=((pos_info_IOL) posinfo).getDiffCornea().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pos Cornea Sphere")) {
					double S=((pos_info_IOL) posinfo).getPosCornea().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pos Cornea Cylinder")) {
					double S=((pos_info_IOL) posinfo).getPosCornea().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pos Cornea Axis")) {
					double S=((pos_info_IOL) posinfo).getPosCornea().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Cornea Correction Index")) {
					double S=((pos_info_IOL) posinfo).getCICornea();
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pre Subjective Sphere")) {
					double S=preinfo.getPre().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pre Subjective Cylinder")) {
					double S=preinfo.getPre().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pre Subjective Axis")) {
					double S=preinfo.getPre().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("TIA Subjective Sphere")) {
					double S=preinfo.getTIA().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("TIA Subjective Cylinder")) {
					double S=preinfo.getTIA().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("TIA Subjective Axis")) {
					double S=preinfo.getTIA().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("SIA Subjective Sphere")) {
					double S=posinfo.getSIA().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("SIA Subjective Cylinder")) {
					double S=posinfo.getSIA().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("SIA Subjective Axis")) {
					double S=posinfo.getSIA().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Diff Subjective Sphere")) {
					double S=posinfo.getDiff().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Diff Subjective Cylinder")) {
					double S=posinfo.getDiff().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Diff Subjective Axis")) {
					double S=posinfo.getDiff().show()[2];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pos Subjective Sphere")) {
					double S=posinfo.getPos().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pos Subjective Cylinder")) {
					double S=posinfo.getPos().show()[1];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Pos Subjective Axis")) {
					double S=posinfo.getPos().show()[0];
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}if(row.get(0).equals("Subjective Correction Index")) {
					double S=posinfo.getCI();
					res&=(S>=(double) row.get(1))&(S<=(double)row.get(2));
				}
			}
		}
		return res;
	}
	
	@SuppressWarnings("rawtypes")
	public void getTIAvsSIA(LinkedList<Double> TIA,LinkedList<Double> SIA,Vector<Vector> filters) {
		if(checkFilters(filters)) {
			double t=preinfo.getTIA().Mag();
			double proj=posinfo.getCI();
			TIA.add(t);
			SIA.add(proj*t);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public int[] getAxisError(double[] x,Vector<Vector> filters) {
		int[] y=new int[x.length+1];
		if(checkFilters(filters)) {
			for(int i=0;i<x.length;i++) {
				if(posinfo.getSIA().axis()-preinfo.getTIA().axis()<x[i]) {
					y[i]=1;
					break;
				}
			}
			y[x.length]=1;
		}
		return y;
	}
	
	@SuppressWarnings("rawtypes")
	public int[][] getPrevsPos(double[] x,Vector<Vector> filters) {
		int[][] y=new int[2][x.length+1];
		if(checkFilters(filters)) {
			for(int i=0;i<x.length;i++) {
				if(preinfo.getPre().Mag()<x[i]) {
					y[0][i]=1;
					break;
				}
			}
			for(int i=0;i<x.length;i++) {
				if(posinfo.getPos().Mag()<x[i]) {
					y[1][i]=1;
					
				}
			}
			y[0][x.length]=1;
			y[1][x.length]=1;
		}
		return y;
	}
	
	
}
