package report;

import java.io.IOException;
import java.util.Calendar;
import com.itextpdf.text.DocumentException;

import data_structures.doctor;

public class Report {
	
	protected doctor doc;
	protected Calendar today;
	
	public Report(doctor doc) {
		this.doc=doc;
		today= Calendar.getInstance();
		
		try {
			PDF_writer.createPdf("/reports/"+doc.Surname+Calendar.DAY_OF_MONTH+Calendar.MONTH+Calendar.YEAR+Calendar.HOUR_OF_DAY);
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
