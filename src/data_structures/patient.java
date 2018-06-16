package data_structures;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class patient {
	int id;
	String name;
	LocalDate birth;
	LocalDateTime regist;
	pre_info preinfo;
	pos_info posinfo;
	
	public patient(int id, String name,int year,Month month,int day, pre_info preinfo, pos_info posinfo) {
		this.id=id;
		this.name=name;
		this.regist=LocalDateTime.now();
		this.birth= LocalDate.of(year,month,day);
		this.preinfo=preinfo;
		this.posinfo=posinfo;
	}
	
	public double[] getstats(int var, double minBound, double maxBound) {
		double[] results=new double[7];
		if(var==1) {
			results[0]=preinfo.getPre().M;
			results[1]=preinfo.getPre().J0;
			results[2]=preinfo.getPre().J45;
			results[3]=preinfo.getPre().M*preinfo.getPre().M;
			results[4]=preinfo.getPre().J0*preinfo.getPre().J0;
			results[5]=preinfo.getPre().J45*preinfo.getPre().J45;
			results[6]=1;
		}
		if(var==2) {
			results[0]=preinfo.getTIA().M;
			results[1]=preinfo.getTIA().J0;
			results[2]=preinfo.getTIA().J45;
			results[3]=preinfo.getTIA().M*preinfo.getTIA().M;
			results[4]=preinfo.getTIA().J0*preinfo.getTIA().J0;
			results[5]=preinfo.getTIA().J45*preinfo.getTIA().J45;
			results[6]=1;
		}
		if(var==3) {
			results[0]=posinfo.getPos().M;
			results[1]=posinfo.getPos().J0;
			results[2]=posinfo.getPos().J45;
			results[3]=posinfo.getPos().M*posinfo.getPos().M;
			results[4]=posinfo.getPos().J0*posinfo.getPos().J0;
			results[5]=posinfo.getPos().J45*posinfo.getPos().J45;
			results[6]=1;
		}
		if(var==4) {
			results[0]=posinfo.getSIA().M;
			results[1]=posinfo.getSIA().J0;
			results[2]=posinfo.getSIA().J45;
			results[3]=posinfo.getSIA().M*posinfo.getSIA().M;
			results[4]=posinfo.getSIA().J0*posinfo.getSIA().J0;
			results[5]=posinfo.getSIA().J45*posinfo.getSIA().J45;
			results[6]=1;
		}
		if(var==5) {
			results[0]=posinfo.getDiff().M;
			results[1]=posinfo.getDiff().J0;
			results[2]=posinfo.getDiff().J45;
			results[3]=posinfo.getDiff().M*posinfo.getDiff().M;
			results[4]=posinfo.getDiff().J0*posinfo.getDiff().J0;
			results[5]=posinfo.getDiff().J45*posinfo.getDiff().J45;
			results[6]=1;
		}
		if(var==6) {
			results[0]=posinfo.getCI();
			results[3]=posinfo.getCI()*posinfo.getCI();
			results[6]=1;
		}
		if(var==7) {
			results[0]=((pre_info_IOL) preinfo).getPreCornea().M;
			results[1]=((pre_info_IOL) preinfo).getPreCornea().J0;
			results[2]=((pre_info_IOL) preinfo).getPreCornea().J45;
			results[3]=((pre_info_IOL) preinfo).getPreCornea().M*((pre_info_IOL) preinfo).getPreCornea().M;
			results[4]=((pre_info_IOL) preinfo).getPreCornea().J0*((pre_info_IOL) preinfo).getPreCornea().J0;
			results[5]=((pre_info_IOL) preinfo).getPreCornea().J45*((pre_info_IOL) preinfo).getPreCornea().J45;
			results[6]=1;
		}
		if(var==8) {
			results[0]=((pre_info_IOL) preinfo).getTIACornea().M;
			results[1]=((pre_info_IOL) preinfo).getTIACornea().J0;
			results[2]=((pre_info_IOL) preinfo).getTIACornea().J45;
			results[3]=((pre_info_IOL) preinfo).getTIACornea().M*((pre_info_IOL) preinfo).getTIACornea().M;
			results[4]=((pre_info_IOL) preinfo).getTIACornea().J0*((pre_info_IOL) preinfo).getTIACornea().J0;
			results[5]=((pre_info_IOL) preinfo).getTIACornea().J45*((pre_info_IOL) preinfo).getTIACornea().J45;
			results[6]=1;
		}
		if(var==9) {
			results[0]=((pos_info_IOL) posinfo).getPosCornea().M;
			results[1]=((pos_info_IOL) posinfo).getPosCornea().J0;
			results[2]=((pos_info_IOL) posinfo).getPosCornea().J45;
			results[3]=((pos_info_IOL) posinfo).getPosCornea().M*((pos_info_IOL) posinfo).getPosCornea().M;
			results[4]=((pos_info_IOL) posinfo).getPosCornea().J0*((pos_info_IOL) posinfo).getPosCornea().J0;
			results[5]=((pos_info_IOL) posinfo).getPosCornea().J45*((pos_info_IOL) posinfo).getPosCornea().J45;
			results[6]=1;
		}
		if(var==10) {
			results[0]=((pos_info_IOL) posinfo).getSIACornea().M;
			results[1]=((pos_info_IOL) posinfo).getSIACornea().J0;
			results[2]=((pos_info_IOL) posinfo).getSIACornea().J45;
			results[3]=((pos_info_IOL) posinfo).getSIACornea().M*((pos_info_IOL) posinfo).getSIACornea().M;
			results[4]=((pos_info_IOL) posinfo).getSIACornea().J0*((pos_info_IOL) posinfo).getSIACornea().J0;
			results[5]=((pos_info_IOL) posinfo).getSIACornea().J45*((pos_info_IOL) posinfo).getSIACornea().J45;
			results[6]=1;
		}
		if(var==11) {
			results[0]=((pos_info_IOL) posinfo).getDiffCornea().M;
			results[1]=((pos_info_IOL) posinfo).getDiffCornea().J0;
			results[2]=((pos_info_IOL) posinfo).getDiffCornea().J45;
			results[3]=((pos_info_IOL) posinfo).getDiffCornea().M*((pos_info_IOL) posinfo).getDiffCornea().M;
			results[4]=((pos_info_IOL) posinfo).getDiffCornea().J0*((pos_info_IOL) posinfo).getDiffCornea().J0;
			results[5]=((pos_info_IOL) posinfo).getDiffCornea().J45*((pos_info_IOL) posinfo).getDiffCornea().J45;
			results[6]=1;
		}
		if(var==12) {
			results[0]=((pos_info_IOL) posinfo).getCICornea();
			results[3]=((pos_info_IOL) posinfo).getCICornea()*((pos_info_IOL) posinfo).getCICornea();
			results[6]=1;
		}
		if(var==12) {
			results[0]=((pos_info_IOL) posinfo).getIOLAxis();
			results[3]=((pos_info_IOL) posinfo).getIOLAxis()*((pos_info_IOL) posinfo).getIOLAxis();
			results[6]=1;
		}
		return results;
	}
}
