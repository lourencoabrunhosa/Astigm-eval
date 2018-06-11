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
}
