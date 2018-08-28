package Graphics;

import java.awt.Dimension;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JPanel;

public class Graphics_panel extends JPanel {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("rawtypes")
	public Graphics_panel(String filename, Vector<Vector> filters) {
		
		Locale.setDefault(Locale.US);
		//setBackground(Color.WHITE);
		setPreferredSize(new Dimension(1000,300));
		setLayout(null);
		
		SiaVsTiaPlot svt = new SiaVsTiaPlot(TIAvsSIA.data(filename,filters));
		AstigmPlot ap = new AstigmPlot(GeneralPlot.data(filename, 1, filters));
		VerticalBars vb = new VerticalBars(PrevsPos.data(filename, filters));
		HorizontalBars hb = new HorizontalBars(axisError.data(filename, filters));
		
		
		
		ap.setBounds(503,1);
		svt.setBounds(1,1,500,300);
		vb.setBounds(1,303,500,300);
		hb.setBounds(503,303,500,300);
		
		
		add(ap);
		add(svt);
		add(vb);
		add(hb);

	}

}
