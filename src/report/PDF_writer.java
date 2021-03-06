package report;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class PDF_writer {
	public static final String DEST
	= "report/teste.pdf";

	public static void createPdf(String dest)
			throws DocumentException, IOException {

		

		Font title = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 30);
		title.setColor(new BaseColor(39, 140, 153));

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(dest));
		document.open();
		
		Paragraph paragraph1= new Paragraph("automatic report",title);
		
		

		PdfPTable clientTable = new PdfPTable(6);
		clientTable.setWidthPercentage(100.0f);

		
		document.add(paragraph1);
		document.add(clientTable);
		
		document.close();
	      
	    Desktop.getDesktop().open(new File(dest));
		

	}
	
	public static void main(String[] args) {
		try {
			createPdf("teste.pdf");
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
