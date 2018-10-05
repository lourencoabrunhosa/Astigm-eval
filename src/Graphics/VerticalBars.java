package Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import data_structures.Round;

public class VerticalBars extends Canvas {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double[][] data;
	double max;
	
	public VerticalBars(double[][] data) {
	 this.data=data;
	 for(int i=0;i<data[0].length;i++) {
		 if(data[1][i]>max)max=data[1][i];
		 if(data[2][i]>max)max=data[2][i];
	 }
	 max=Math.min(10.0*((int) max/10)+10, 100);
	 
	 setBackground(Color.WHITE);
	 
	}
	
	@Override
	public void paint(Graphics g) {
		double porpotion=(200/max);
			
		Font regular =g.getFont();
		
		g.setColor(Color.BLACK);
		
		g.drawLine(90,255,480,255);
		g.drawLine(90, 255, 90, 55);
		
		for(int i=1;i<=data[0].length;i++) {
			g.drawLine(90+i*30, 255, 90+i*30, 260);
		}
		
		for(int i=1;i<=10;i++) {
			g.setColor(Color.BLACK);
			g.drawLine(90, 255-i*20, 85, 255-i*20);
			g.setColor(Color.LIGHT_GRAY);
			g.drawLine(90,255-i*20,480,255-i*20);
		}
		
		for(int i=0;i<data[0].length;i++) {
			g.setColor(Color.ORANGE);
			try {
				g.fillRect(90+(i)*30+4, 255-((int) Round.round(data[1][i]*porpotion,0)), 11,((int) Round.round(data[1][i]*porpotion,0)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.setColor(Color.RED);
			try {
				g.fillRect(90+(i)*30+4+11, 255-((int) Round.round(data[2][i]*porpotion,0)), 11,((int) Round.round(data[2][i]*porpotion,0)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		g.setColor(Color.BLACK);
		double val=0;
		for(int i=0;i<=10;i++) {
			g.drawString(""+val,80-g.getFontMetrics().stringWidth(""+val),255-i*20+g.getFontMetrics().getHeight()/4);
			val+=max/10;
		}
		
		String[] xlabels1= {"0","0.25","0.5","0.75","1","1.25","1.5","1.75","2","2.25","2.5","2.75"};
		String[] xlabels2= {"0.25","0.5","0.75","1","1.25","1.5","1.75","2","2.25","2.5","2.75","3"};
 		
		g.setFont(new Font(getFont().getFontName(),getFont().getStyle(),9));
		for(int i=0;i<xlabels1.length;i++) {
			
			g.drawString(xlabels1[i], 90+i*30+15-g.getFontMetrics().stringWidth(xlabels1[i])/2, 270);
			g.drawString("-", 90+i*30+15-g.getFontMetrics().stringWidth("-")/2, 270+3*g.getFontMetrics().getHeight()/4);
			g.drawString(xlabels2[i], 90+i*30+15-g.getFontMetrics().stringWidth(xlabels2[i])/2, 270+3*(g.getFontMetrics().getHeight())/2);
		}
		
		g.drawString(">3",480-15-g.getFontMetrics().stringWidth(">3")/2,270+g.getFontMetrics().getHeight());
		
		g.setFont(new Font(regular.getFontName(),Font.BOLD,15));
		g.drawString("Distribution of pre-surgery astigmatism magnitude", 250-g.getFontMetrics().stringWidth("Distribution of pre-surgery astigmatism magnitude")/2, 20);
		
		g.setFont(regular);
		
		g.drawString("Cyl [D]", 470,295);
		
		Graphics2D g2d= (Graphics2D) g;
		g2d.rotate(-Math.PI/2,35,30);
		
		g2d.drawString("[%]", 35-g2d.getFontMetrics().stringWidth("Axial difference [°]")/2, 30);

	}
}
